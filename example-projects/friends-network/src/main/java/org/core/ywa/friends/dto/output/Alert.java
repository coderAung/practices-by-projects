package org.core.ywa.friends.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alert implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	private AlertType type;
	
	public String getType() {
		return "alert-%s".formatted(type.name().toLowerCase());
	}
	
	public enum AlertType {
		Danger, Info, Warning, Success, Primary
	}

}
