package org.core.ywa.friends.dto.output;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {

	private int id;
	private String name;
	private String profile;
	private UserStatus status = UserStatus.Stranger;
	
	private List<MutualFriendThumbnail> thumbnails;
	
	public int getMutuals() {
		return thumbnails.size();
	}

	public enum UserStatus {
		Friend, Requested, Inbox, Stranger
	}
	
	public String getStatus() {
		return status.name();
	}
}
