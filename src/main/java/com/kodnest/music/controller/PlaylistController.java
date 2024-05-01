package com.kodnest.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.music.entity.PlayList;
import com.kodnest.music.entity.Song;
import com.kodnest.music.service.PlayListService;
import com.kodnest.music.service.SongService;

@Controller
public class PlaylistController {
 @Autowired
 SongService songService;
	@Autowired
	PlayListService playlistService;
	@GetMapping(value="/createplaylist")
	public String addPlaylist(Model model) {
		List<Song>songList=songService.getSongs();
		model.addAttribute("songs", songList);
		return "createplaylist";
	}
	@PostMapping(value="/addplaylist")
	public String addPlaylist(@ModelAttribute PlayList playlist) {
		
		
		boolean playlistName=playlistService.getPlaylistName(playlist);
		if(playlistName) {
			playlistService.addPlaylist(playlist);	
			List<Song> songs=songService.getSongs();
			for(Song song:songs) {
				song.getPlaylists().add(playlist);
				songService.updateSong(song);
			}
		}
		
		return "createplaylist";
	}
}
