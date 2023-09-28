package com.hoaxify.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hoaxify.ws.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	boolean existsByEmail(String email);
}
