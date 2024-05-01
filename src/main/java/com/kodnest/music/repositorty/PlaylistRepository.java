package com.kodnest.music.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.music.entity.PlayList;

public interface PlaylistRepository extends JpaRepository<PlayList,Integer> {

	PlayList findByName(String name);

}
