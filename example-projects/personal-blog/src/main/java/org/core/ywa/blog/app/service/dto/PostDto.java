package org.core.ywa.blog.app.service.dto;

import org.core.ywa.blog.app.model.entity.Post;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {

	private Integer id;
	private String title;
	private String content;
	private String category;
	
	public static PostDto from(Post post) {
		return PostDto.builder()
				.id(post.getId())
				.title(post.getTitle())
				.content(post.getContent())
				.category(post.getCategory().getName())
				.build();
	}
}
