package org.core.ywa.blog.app.model.repo;

import org.core.ywa.blog.app.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
	void deleteAllByPostId(int postId);
}
