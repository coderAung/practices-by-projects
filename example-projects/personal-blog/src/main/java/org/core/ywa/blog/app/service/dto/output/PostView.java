package org.core.ywa.blog.app.service.dto.output;

import java.time.LocalDate;

import org.core.ywa.blog.app.model.entity.Post;
import org.core.ywa.blog.app.service.dto.CategoryDto;
import org.core.ywa.blog.app.service.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostView {

	private int id;
	private String title;
	private String content;
	private LocalDate postAt;
	
	private UserDto user;
	private CategoryDto category;
	
	public static PostView from(Post post) {
		return PostView.builder()
				.id(post.getId())
				.title(post.getTitle())
				.content(post.getContent())
				.postAt(post.getPostAt())
				.user(UserDto.from(post.getUser()))
				.category(CategoryDto.from(post.getCategory()))
				.build();
	}
}
