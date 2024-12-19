package org.core.ywa.blog.app.service.impl;

import org.core.ywa.blog.app.model.entity.Comment;
import org.core.ywa.blog.app.model.repo.CommentRepo;
import org.core.ywa.blog.app.model.repo.PostRepo;
import org.core.ywa.blog.app.service.CommentService;
import org.core.ywa.blog.app.service.dto.input.CommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Override
	public void deleteById(int id) {
		commentRepo.deleteById(id);
	}

	@Override
	@Transactional
	public int add(CommentForm form) {
		var post = postRepo.findById(form.getPostId()).orElseThrow();
		var comment = new Comment();
		comment.setText(form.getText());
		comment.setPost(post);
		commentRepo.save(comment);
		return post.getId();
	}

}
