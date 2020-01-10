package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.UserDTO;

@Repository
public interface UserRepository extends CrudRepository<UserDTO, Integer> {

	Optional<UserDTO> findByUserName(String userName);

}
