package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.example.demo.Model.UserDetails;

@Repository
public interface UserDetailsRepository extends BaseRepository<UserDetails, Serializable>{

}
