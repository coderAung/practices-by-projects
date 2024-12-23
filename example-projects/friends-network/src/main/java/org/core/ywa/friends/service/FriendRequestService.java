package org.core.ywa.friends.service;

import org.core.ywa.friends.dto.input.FriendRequestForm;
import org.core.ywa.friends.entity.FriendRequest;
import org.core.ywa.friends.entity.FriendRequest.Status;
import org.core.ywa.friends.entity.pk.FriendRequestPK;
import org.core.ywa.friends.repo.FriendRequestRepo;
import org.core.ywa.friends.repo.UserRepo;
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
		var requestPk = new FriendRequestPK();
		requestPk.setFromUser(form.getFromUser());
		requestPk.setToUser(form.getToUser());
		
		var request = new FriendRequest();
		request.setId(requestPk);
		request.setFromUser(userRepo.findById(form.getFromUser()).orElseThrow());
		request.setToUser(userRepo.findById(form.getToUser()).orElseThrow());
		request.setRequestedAt(form.getRequestedAt());
		request.setStatus(Status.Request);
		
		var inboxPk = new FriendRequestPK();
		inboxPk.setFromUser(form.getToUser());
		inboxPk.setToUser(form.getFromUser());

		var inbox = new FriendRequest();
		inbox.setId(inboxPk);
		inbox.setFromUser(userRepo.findById(form.getToUser()).orElseThrow());
		inbox.setToUser(userRepo.findById(form.getFromUser()).orElseThrow());
		inbox.setRequestedAt(form.getRequestedAt());
		inbox.setStatus(Status.Inbox);
		
		friendRequestRepo.save(inbox);
		return friendRequestRepo.save(request).getFromUser().getId();
	}
}
