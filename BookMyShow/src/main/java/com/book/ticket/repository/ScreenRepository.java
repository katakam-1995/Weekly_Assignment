package com.book.ticket.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.ticket.model.Screens;

@Repository
public interface ScreenRepository extends CrudRepository<Screens, Serializable> {

	List<Screens> findByScreenStatus(String string);

	Screens findByScreenName(String screenName);

}
