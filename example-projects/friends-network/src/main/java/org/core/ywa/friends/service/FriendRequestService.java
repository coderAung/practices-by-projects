package org.core.ywa.friends.service;

import org.core.ywa.friends.dto.input.FriendRequestForm;
import org.core.ywa.friends.entity.FriendRequest;
import org.core.ywa.friends.entity.FriendRequest.FriendRequestStatus;
import org.core.ywa.friends.entity.pk.FriendRequestPK;
import org.core.ywa.friends.repo.FriendRequestRepo;
import org.core.ywa.friends.repo.UserRepo;
import org.core.ywa.friends.util.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendRequestService {

	@Autowired
	private FriendRequestRepo friendRequestRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Transactional
	public int add(FriendRequestForm form) {
		
		if(form.getFromUser() == form.getToUser()) {
			throw new ApplicationException("Invalid operation");
		}
		
		var fromUser = userRepo.findById(form.getFromUser()).orElseThrow();
		var toUser = userRepo.findById(form.getToUser()).orElseThrow();
		
		var requestPk = new FriendRequestPK(fromUser.getId(), toUser.getId());
		
		var request = new FriendRequest();
		request.setId(requestPk);
		request.setFromUser(fromUser);
		request.setToUser(toUser);
		request.setRequestedAt(form.getRequestedAt());
		request.setStatus(FriendRequestStatus.Request);
		friendRequestRepo.save(request);
		
		var inboxPk = new FriendRequestPK(toUser.getId(), fromUser.getId());

		var inbox = new FriendRequest();
		inbox.setId(inboxPk);
		inbox.setFromUser(toUser);
		inbox.setToUser(fromUser);
		inbox.setRequestedAt(form.getRequestedAt());
		inbox.setStatus(FriendRequestStatus.Inbox);
		
		friendRequestRepo.save(inbox);
		return toUser.getId();
	}
}
