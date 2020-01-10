package com.book.ticket.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.ticket.model.Movies;

@Repository
public interface MovieRepository extends CrudRepository<Movies, Serializable> {

	List<Movies> findByStatus(String string);

	Movies findByMovieId(Long movieId);

}
