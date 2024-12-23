package org.core.ywa.friends.dto.output;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {

	private int id;
	private String name;
	private String profile;
	private boolean status;
	
	private List<MutualFriendThumbnail> thumbnails;
	
	public int getMutuals() {
		return thumbnails.size();
	}
	
}
