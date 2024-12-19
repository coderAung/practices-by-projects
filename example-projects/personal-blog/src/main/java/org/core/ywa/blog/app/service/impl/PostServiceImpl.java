package org.core.ywa.blog.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.core.ywa.blog.app.model.entity.Post;
import org.core.ywa.blog.app.model.repo.CategoryRepo;
import org.core.ywa.blog.app.model.repo.PostRepo;
import org.core.ywa.blog.app.model.repo.UserRepo;
import org.core.ywa.blog.app.service.PostService;
import org.core.ywa.blog.app.service.dto.CategoryDto;
import org.core.ywa.blog.app.service.dto.PostDto;
import org.core.ywa.blog.app.service.dto.input.PostForm;
import org.core.ywa.blog.app.service.dto.output.CommentView;
import org.core.ywa.blog.app.service.dto.output.PostDetailView;
import org.core.ywa.blog.app.service.dto.output.PostView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private UserRepo userRepo;
		
	@Override
	public List<PostView> findAll() {
		return postRepo.findAll().stream().map(PostView::from).toList();
	}

	@Override
	public List<PostView> findByCategory(CategoryDto dto) {
		return postRepo.findByCategoryId(dto.getId()).stream().map(PostView::from).toList();
	}

	@Override
	@Transactional
	public int add(PostForm form) {
		var entity = Post.builder()
				.title(form.getTitle())
				.content(form.getContent())
				.postAt(form.getPostAt())
				.category(categoryRepo.findById(form.getCategoryId()).get())
				.user(userRepo.findById(form.getUserId()).get())
				.build();
		entity = postRepo.save(entity);
		return entity.getId();
	}

	@Override
	@Transactional
	public int update(PostForm form) {
		var entity = postRepo.findById(form.getId()).orElseThrow(() -> new IllegalArgumentException());
		entity.setTitle(form.getTitle());
		entity.setContent(form.getContent());
		entity.setCategory(categoryRepo.findById(form.getCategoryId()).get());
		return postRepo.save(entity).getId();
	}

	@Override
	@Transactional
	public Optional<PostDetailView> findById(int id) {
		return postRepo.findById(id).map(post -> {
			var dto = PostDetailView.from(post);
			dto.setComments(post.getComments().stream().map(CommentView::from).toList());
			return dto;
		});
	}

	@Override
	public Optional<PostDto> findPostDtoById(int id) {
		return postRepo.findById(id).map(PostDto::from);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		var post = postRepo.findById(id).orElseThrow();
		postRepo.delete(post);
	}
}
