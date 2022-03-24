package com.mafideju.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mafideju.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	User findByName(String name);
	
}
