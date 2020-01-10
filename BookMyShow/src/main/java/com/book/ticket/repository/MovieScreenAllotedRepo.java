package com.book.ticket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.ticket.model.MovieScreenAlloted;

@Repository
public interface MovieScreenAllotedRepo extends CrudRepository<MovieScreenAlloted, Integer> {

	MovieScreenAlloted findByMovieId(Long string);

}
