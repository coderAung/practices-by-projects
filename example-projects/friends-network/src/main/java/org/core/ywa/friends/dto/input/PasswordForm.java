package org.core.ywa.friends.dto.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordForm {
	private int loginUserId;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
}
