package org.core.ywa.friends.entity.pk;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class FriendPK {
	
	private int ownerId;
	private int friendId;
	private LocalDate createdAt;

}
