package org.core.ywa.friends.entity.pk;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class FriendRequestPK {
	private int fromUser;
	private int toUser;
	private LocalDate requestedAt;
}
