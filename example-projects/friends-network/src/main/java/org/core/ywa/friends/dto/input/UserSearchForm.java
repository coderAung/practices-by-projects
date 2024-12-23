package org.core.ywa.friends.dto.input;

import org.core.ywa.friends.dto.LoginUser;

import lombok.Data;

@Data
public class UserSearchForm {
	private LoginUser loginUser;
	private String keyword;
}
