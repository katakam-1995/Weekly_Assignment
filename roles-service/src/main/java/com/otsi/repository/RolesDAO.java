package com.otsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.model.Roles;
@Repository
public interface RolesDAO extends JpaRepository<Roles, Integer>{

}
