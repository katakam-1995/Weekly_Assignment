package com.book.ticket.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.ticket.model.UserDTO;

@Repository
public interface UserRepository extends CrudRepository<UserDTO, Serializable> {

	Optional<UserDTO> findByUserName(String userName);

}
