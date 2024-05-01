package com.kodnest.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.music.entity.Song;
import com.kodnest.music.service.SongService;



@Controller
public class SongController {
	@Autowired
	
	SongService songService;
	@PostMapping(value="/addsong")
	public String addsong(@ModelAttribute Song song) {
		System.out.println(song);
		boolean existSong=songService.getSongName(song);
		if(existSong) {
			songService.addSong(song);
		}else {
			System.out.println("duplicate song");
		}
		
		return "Song";
	}
	@GetMapping("/viewsong")
	public String viewSongs(Model model){
		boolean paymentStatus=true;
		if(paymentStatus) {						
				List<Song> songsList=songService.getSongs();
				model.addAttribute("songs",songsList);				
				return "viewsongs";
		
		}
		else {
			return "paymentform";
		}
		
	}
//	@GetMapping("/addplaylist")
//	public String viewSongs1(Model model){							
//				List<Song> songsList=songService.getSongs();
//				model.addAttribute("songs",songsList);				
//				return "addplaylist";
//		
//	}
		

}

