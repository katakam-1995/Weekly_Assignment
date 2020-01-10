package com.book.ticket.repository;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.book.ticket.model.UserDetails;

@Repository
public interface UserDetailsRepository extends BaseRepository<UserDetails, Serializable> {

}
