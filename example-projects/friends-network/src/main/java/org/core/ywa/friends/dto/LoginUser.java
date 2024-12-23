package org.core.ywa.friends.dto;

import java.io.Serializable;

import org.core.ywa.friends.entity.User;

import lombok.Data;

@Data
public class LoginUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String email;
	private String profile;
	
	public static LoginUser from(User user) {
		var dto = new LoginUser();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setProfile(user.getProfile());
		return dto;
	}
}
