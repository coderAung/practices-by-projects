package org.core.ywa.friends.service;

import java.util.ArrayList;
import java.util.List;

import org.core.ywa.friends.dto.LoginUser;
import org.core.ywa.friends.dto.input.LoginForm;
import org.core.ywa.friends.dto.output.MutualFriendThumbnail;
import org.core.ywa.friends.dto.output.UserDto;
import org.core.ywa.friends.entity.Friend;
import org.core.ywa.friends.repo.FriendRepo;
import org.core.ywa.friends.repo.UserRepo;
import org.core.ywa.friends.util.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private FriendRepo friendRepo;

	public LoginUser login(LoginForm form) {
		return userRepo.findByEmailAndPassword(form.getEmail(), form.getPassword())
				.map(LoginUser::from).orElseThrow(() -> new ApplicationException("Email or Password is incorrect!"));
	}

	@Transactional
	public List<UserDto> findByKeyword(String keyword, LoginUser loginUser) {
		return userRepo.findByNameStartsWith(keyword).stream()
				.map(user -> {
					var dto = new UserDto();
					dto.setId(user.getId());
					dto.setName(user.getName());
					dto.setProfile(user.getProfile());
					
					friendRepo.findByOwnerIdAndFriendId(dto.getId(), loginUser.getId()).ifPresent(f -> dto.setStatus(true));
										
					var mutualFriends = new ArrayList<Friend>();
					user.getFriends().forEach(friend -> {
						var friendId = friend.getFriend().getId();
						friendRepo.findByOwnerIdAndFriendId(friendId, loginUser.getId())
							.ifPresent(f -> mutualFriends.add(f));
					});
					
					dto.setThumbnails(mutualFriends.stream()
							.map(mf -> new MutualFriendThumbnail(mf.getOwner().getId(), mf.getOwner().getProfile())).toList());
					
					return dto;
				}).toList();
	}

}
