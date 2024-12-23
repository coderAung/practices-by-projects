package org.core.ywa.friends.dto.input;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FriendForm {
	
	private int ownerId;
	private int friendId;
	private LocalDate createdAt;

}
