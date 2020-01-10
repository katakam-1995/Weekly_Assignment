package com.example.demo.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.Model.AvailableSeatsDTO;

@Repository
public interface AvailableSeats extends BaseRepository<AvailableSeatsDTO, Serializable>{

	Optional<AvailableSeatsDTO> findByScreenNameAndScreenTiming(String screenName, String screenTiming);


}
