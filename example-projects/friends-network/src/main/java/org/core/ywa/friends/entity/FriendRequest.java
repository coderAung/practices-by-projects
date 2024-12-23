package org.core.ywa.friends.entity;

import java.time.LocalDate;

import org.core.ywa.friends.entity.pk.FriendRequestPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "friend_request")
public class FriendRequest {

	@EmbeddedId
	private FriendRequestPK id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="from_user")
	private User fromUser;

	@ManyToOne(optional = false)
	@JoinColumn(name="to_user")
	private User toUser;

	private LocalDate requestedAt;
	private FriendRequestStatus status;
	
	public enum FriendRequestStatus {
		Inbox, Request
	}
	
}
