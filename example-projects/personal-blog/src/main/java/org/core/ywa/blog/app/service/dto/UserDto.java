package org.core.ywa.blog.app.service.dto;

import org.core.ywa.blog.app.model.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	
	private int id;
	private String name;
	private String profileImage;
	
	public static UserDto from(User user) {
		return UserDto.builder()
				.id(user.getId())
				.name(user.getName())
				.profileImage(user.getProfileImage())
				.build();
	}
}
