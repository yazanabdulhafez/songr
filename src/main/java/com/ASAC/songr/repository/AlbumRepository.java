package com.ASAC.songr.repository;


import com.ASAC.songr.Models.Albums;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Albums,Integer> {

}
