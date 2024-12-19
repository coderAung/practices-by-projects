package org.core.ywa.blog.app.service.dto.input;

import java.time.LocalDate;

import org.core.ywa.blog.app.model.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostForm {
	private Integer id;
	private String title;
	private String content;
	private Integer userId;
	private Integer categoryId;
	private LocalDate postAt;
	
	public static PostForm from(Post post) {
		var dto = PostForm.builder()
				.id(post.getId())
				.title(post.getTitle())
				.content(post.getContent())
				.userId(post.getUser().getId())
				.categoryId(post.getCategory().getId())
				.postAt(post.getPostAt())
				.build();
		return dto;
	}
}
