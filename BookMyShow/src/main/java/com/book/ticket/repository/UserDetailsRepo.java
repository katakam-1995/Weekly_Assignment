package com.book.ticket.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.ticket.model.UserDetails;

@Repository
public interface UserDetailsRepo extends CrudRepository<UserDetails, Serializable> {

}
