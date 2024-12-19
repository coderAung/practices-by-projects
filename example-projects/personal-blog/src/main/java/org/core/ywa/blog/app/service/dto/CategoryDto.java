package org.core.ywa.blog.app.service.dto;

import org.core.ywa.blog.app.model.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDto {

	private int id;
	private String name;
	public static CategoryDto from(Category category) {
		var dto = new CategoryDto(category.getId(), category.getName());
		return dto;
	}
}
