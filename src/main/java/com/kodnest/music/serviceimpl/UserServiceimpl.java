package com.kodnest.music.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.music.entity.User;
import com.kodnest.music.repositorty.UserRepository;
import com.kodnest.music.service.UserService;
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		
		userRepository.save(user);
		
	}

	@Override
	public User emailExists(User user) {
		
		if(userRepository.findByEmail(user.getEmail())!=null) {
			System.out.println("present");
			return user;
		}
		else {
			userRepository.save(user);
		return null;
		}
		
		
	}

	@Override
	public boolean validUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		String dbpwd = user.getPassword();
		if(password.equals(dbpwd)) {
			return true;
		}else {
			
		
		return false;
		}
	}

	@Override
	public String getRole(String email) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		return user.getRole();
	}

}
