package com.kodnest.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.music.entity.User;
import com.kodnest.music.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/register")

//	public void userdata(@ModelAttribute User user) {
	//	userService.saveUser(user);
		
//	}

//
	public String addUser(@ModelAttribute User user) {
		
		//to check email is 
		User userExists=userService.emailExists(user);
		if(userExists==null) {
			userService.saveUser(user);
			System.out.println("User added successfully");
			
		}
		else {
			System.out.println("Duplicate user");
		}
		return "login";
		
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,@RequestParam("password") String password) {

		System.out.println(email+"   "+ password+"  login");
		
		if(userService.validUser(email, password)==true) {
		String role = userService.getRole(email);
		if(role.equals( "admin")) {
			return"adminhome";
		}else {
			return "customerhome";
		}
		}
		else {
			return "login";
			
		}
	}
	
	}
