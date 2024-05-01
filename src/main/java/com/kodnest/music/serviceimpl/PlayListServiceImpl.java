package com.kodnest.music.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.music.entity.PlayList;
import com.kodnest.music.repositorty.PlaylistRepository;
import com.kodnest.music.service.PlayListService;
@Service
public class PlayListServiceImpl implements PlayListService {

	@Autowired
	PlaylistRepository pr;
	
	
	@Override
	public void addPlaylist(PlayList playlist) {
		// TODO Auto-generated method stub
		pr.save(playlist);
	}


	@Override
	public boolean getPlaylistName(PlayList playlist) {
	PlayList getPlaylistName=pr.findByName(playlist.getName());
	if(getPlaylistName==null) {
		return true;
	}
		return false;
	}

}
