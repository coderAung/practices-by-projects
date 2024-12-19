package org.core.ywa.blog.app.model.repo;

import java.util.List;

import org.core.ywa.blog.app.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByCategoryId(int categoryId);

}
