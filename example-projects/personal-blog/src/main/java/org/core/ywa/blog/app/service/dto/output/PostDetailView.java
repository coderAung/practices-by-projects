package org.core.ywa.blog.app.service.dto.output;

import java.time.LocalDate;
import java.util.List;

import org.core.ywa.blog.app.model.entity.Post;
import org.core.ywa.blog.app.service.dto.CategoryDto;
import org.core.ywa.blog.app.service.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostDetailView extends PostView {

	PostDetailView(int id, String title, String content, LocalDate postAt, UserDto user, CategoryDto category) {
		super(id, title, content, postAt, user, category);
	}
	
	public static PostDetailView from(Post post) {
		var dto = new PostDetailView();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setContent(post.getContent());
		dto.setPostAt(post.getPostAt());
		dto.setUser(UserDto.from(post.getUser()));
		dto.setCategory(CategoryDto.from(post.getCategory()));
		return dto;
	}
	
	private List<CommentView> comments;
}
