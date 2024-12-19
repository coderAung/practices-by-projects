package org.core.ywa.blog.app.service;

import org.core.ywa.blog.app.service.dto.input.CommentForm;

public interface CommentService {

	void deleteById(int id);

	int add(CommentForm form);

}
