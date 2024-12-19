package org.core.ywa.blog.app.service;

import java.util.List;
import java.util.Optional;

import org.core.ywa.blog.app.service.dto.CategoryDto;
import org.core.ywa.blog.app.service.dto.PostDto;
import org.core.ywa.blog.app.service.dto.input.PostForm;
import org.core.ywa.blog.app.service.dto.output.PostDetailView;
import org.core.ywa.blog.app.service.dto.output.PostView;

public interface PostService {

	List<PostView> findAll();

	List<PostView> findByCategory(CategoryDto dto);

	int add(PostForm form);

	int update(PostForm form);

	Optional<PostDetailView> findById(int id);
	
	Optional<PostDto> findPostDtoById(int id);

	void deleteById(int id);
}
