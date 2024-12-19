package org.core.ywa.blog.app.service.dto.output;

import org.core.ywa.blog.app.model.entity.Comment;

import lombok.Data;

@Data
public class CommentView {
	private int id;
	private String text;
	
	public static CommentView from(Comment comment) {
		var dto = new CommentView();
		dto.setId(comment.getId());
		dto.setText(comment.getText());
		return dto;
	}
}
