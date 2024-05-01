package com.kodnest.music.service;

import org.springframework.stereotype.Service;

import com.kodnest.music.entity.PlayList;

@Service
public interface PlayListService {

	void addPlaylist(PlayList playlist);

	boolean getPlaylistName(PlayList playlist);

}
