package org.core.ywa.blog.app.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.core.ywa.blog.app.model.entity.Category;
import org.core.ywa.blog.app.model.repo.CategoryRepo;
import org.core.ywa.blog.app.service.CategoryService;
import org.core.ywa.blog.app.service.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo repo;

	@Override
	public List<CategoryDto> findAll() {
		return repo.findAll().stream().map(CategoryDto::from).toList();
	}

	@Override
	public Optional<CategoryDto> findByName(String name) {
		return repo.findByName(name).map(CategoryDto::from);
	}

	@Override
	public CategoryDto add(String category) {
		var entity = new Category();
		entity.setName(category);
		entity.setCreatedAt(LocalDate.now());
		entity = repo.save(entity);
		return CategoryDto.from(entity);
	}
	
	
}
