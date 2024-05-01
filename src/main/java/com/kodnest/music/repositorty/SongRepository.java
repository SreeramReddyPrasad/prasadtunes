package com.kodnest.music.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.music.entity.Song;

public interface SongRepository extends JpaRepository<Song,Integer>{

	Song findByName(String name);

}
