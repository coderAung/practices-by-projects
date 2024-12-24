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
public class FriendRequestPK {
	
	@Column(name = "from_id")
	private int fromUserId;
	@Column(name = "to_id")
	private int toUserId;
}
