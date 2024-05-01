package com.kodnest.music.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.music.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	User findByEmail(String email);
}
