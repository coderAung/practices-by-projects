package org.core.ywa.friends.entity;

import java.time.LocalDate;

import org.core.ywa.friends.entity.pk.FriendPK;

import jakarta.persistence.Column;
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
	@JoinColumn(name = "owner_id", insertable = false, updatable = false)
	private User owner;

	@ManyToOne(optional = false)
	@JoinColumn(name = "friend_id", insertable = false, updatable = false)
	private User friend;
	
	private LocalDate createdAt;
	
	@Column(nullable = false)
	private Status status;
	
	public enum Status {
		Accepted, Confirm
	}
}
