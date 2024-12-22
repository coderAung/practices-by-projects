package org.core.ywa.friends.repo;

import java.util.Optional;

import org.core.ywa.friends.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByEmailAndPassword(String email, String password);
}
