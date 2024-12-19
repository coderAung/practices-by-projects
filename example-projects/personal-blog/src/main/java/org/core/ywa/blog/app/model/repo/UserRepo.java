package org.core.ywa.blog.app.model.repo;

import org.core.ywa.blog.app.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
