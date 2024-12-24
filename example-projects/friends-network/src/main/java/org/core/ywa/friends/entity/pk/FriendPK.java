package org.core.ywa.friends.entity.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class FriendPK {
	
	@Column(name = "owner_id")
	private int ownerId;
	@Column(name = "friend_id")
	private int friendId;
}
