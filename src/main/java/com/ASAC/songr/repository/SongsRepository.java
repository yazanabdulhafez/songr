package com.ASAC.songr.repository;

import com.ASAC.songr.Models.Album;
import com.ASAC.songr.Models.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongsRepository extends CrudRepository<Song,Integer> {
    List<Song> findAllByAlbum(Album album);
}
