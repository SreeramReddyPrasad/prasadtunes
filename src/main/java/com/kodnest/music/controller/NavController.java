package com.kodnest.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping(value="/registration")
	public String registration() {
		return "registration";
	}
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	@GetMapping(value="/addsong")
	public String addSong() {
		return "Song";
	}

}
