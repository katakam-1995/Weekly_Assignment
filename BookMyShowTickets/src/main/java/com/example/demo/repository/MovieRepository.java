package com.example.demo.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.Model.Movies;

@Repository
public interface MovieRepository extends BaseRepository<Movies, Serializable>{

	Optional<Movies> findByMovieName(String movieName);

	//UserDTO findByUserName(String userName);

}
