package org.core.ywa.friends.dto.input;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FriendRequestForm {
	private int fromUser;
	private int toUser;
	private LocalDate requestedAt;
}
