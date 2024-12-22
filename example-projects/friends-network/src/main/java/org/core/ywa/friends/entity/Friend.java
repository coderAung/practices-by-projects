package org.core.ywa.friends.entity;

import org.core.ywa.friends.entity.pk.FriendPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Friend {
	@EmbeddedId
	private FriendPK id;

	@ManyToOne(optional = false)
	@JoinColumn(insertable = false, updatable = false)
	private User friend;

	@ManyToOne(optional = false)
	@JoinColumn(insertable = false, updatable = false)
	private User owner;

}