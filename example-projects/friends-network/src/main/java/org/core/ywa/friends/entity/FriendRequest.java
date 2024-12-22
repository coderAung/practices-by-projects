package org.core.ywa.friends.entity;

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
	@JoinColumn(insertable = false, updatable = false)
	private User fromUser;

	@ManyToOne(optional = false)
	@JoinColumn(insertable = false, updatable = false)
	private User toUser;

}
