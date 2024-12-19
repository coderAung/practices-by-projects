package org.core.ywa.blog.app.service;

import java.util.List;
import java.util.Optional;

import org.core.ywa.blog.app.service.dto.CategoryDto;

public interface CategoryService {

	List<CategoryDto> findAll();

	Optional<CategoryDto> findByName(String name);

	CategoryDto add(String category);

}
