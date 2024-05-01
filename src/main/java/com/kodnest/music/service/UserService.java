package com.kodnest.music.service;

import org.springframework.stereotype.Service;

import com.kodnest.music.entity.User;
@Service
public interface UserService {
	public void saveUser(User user);

	public User emailExists(User user);

	public boolean validUser(String email, String password);

	public String getRole(String email);

}
  