package org.core.ywa.friends.service;

import org.core.ywa.friends.dto.input.FriendForm;
import org.core.ywa.friends.entity.Friend;
import org.core.ywa.friends.entity.Friend.Status;
import org.core.ywa.friends.entity.pk.FriendPK;
import org.core.ywa.friends.entity.pk.FriendRequestPK;
import org.core.ywa.friends.repo.FriendRepo;
import org.core.ywa.friends.repo.FriendRequestRepo;
import org.core.ywa.friends.repo.UserRepo;
import org.core.ywa.friends.util.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendService {

	@Autowired
	private FriendRepo friendRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private FriendRequestRepo friendRequestRepo;
	
	@Transactional
	public int add(FriendForm form) {
		var confirmUser = userRepo.findById(form.getOwnerId()).orElseThrow();
		var acceptedUser = userRepo.findById(form.getFriendId()).orElseThrow();
		
		var confirmPK = new FriendPK(form.getOwnerId(), form.getFriendId());
		var confirmFriend = new Friend();
		confirmFriend.setId(confirmPK);
		confirmFriend.setOwner(confirmUser);
		confirmFriend.setFriend(acceptedUser);
		confirmFriend.setCreatedAt(form.getCreatedAt());
		confirmFriend.setStatus(Status.Confirm);
		friendRepo.save(confirmFriend);
		
		var acceptedPK = new FriendPK(form.getFriendId(), form.getOwnerId());
		var acceptedFriend = new Friend();
		acceptedFriend.setId(acceptedPK);
		acceptedFriend.setOwner(acceptedUser);
		acceptedFriend.setFriend(confirmUser);
		acceptedFriend.setCreatedAt(form.getCreatedAt());
		acceptedFriend.setStatus(Status.Accepted);
		friendRepo.save(acceptedFriend);
		
		// deleting inbox
		friendRequestRepo.deleteById(new FriendRequestPK(form.getOwnerId(), form.getFriendId()));
		// deleting request
		friendRequestRepo.deleteById(new FriendRequestPK(form.getFriendId(), form.getOwnerId()));

		return form.getFriendId();
	}

	public void delete(FriendForm form) {
		var ownerSidePK = new FriendPK(form.getOwnerId(), form.getFriendId());
		var ownerSide = friendRepo.findById(ownerSidePK).orElseThrow(() -> new ApplicationException("Invalid operation!"));
		friendRepo.delete(ownerSide);
		
		var friendSidePK = new FriendPK(form.getFriendId(), form.getOwnerId());
		var friendSide = friendRepo.findById(friendSidePK).orElseThrow(() -> new ApplicationException("Invalid operation!"));
		friendRepo.delete(friendSide);
	}
	

}
