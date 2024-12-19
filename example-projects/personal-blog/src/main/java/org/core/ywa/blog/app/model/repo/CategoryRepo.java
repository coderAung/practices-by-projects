package org.core.ywa.blog.app.model.repo;

import java.util.Optional;

import org.core.ywa.blog.app.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	Optional<Category> findByName(String name);
}
