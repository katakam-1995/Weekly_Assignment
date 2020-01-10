package com.book.ticket.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.ticket.model.AvailableSeats;

@Repository
public interface AvailableSeatsRepo extends CrudRepository<AvailableSeats, Integer> {

	Optional<AvailableSeats> findByScreenNameAndScreenTiming(String screenName, String selectedTiming);

}
