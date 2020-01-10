package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.exception.ResourceNotFoundException;


public interface SequenceDao {

	long getNextSequenceId(String key) throws ResourceNotFoundException;

}