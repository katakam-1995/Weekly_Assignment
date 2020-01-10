package com.book.ticket.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>
		extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {

	/*
	 * @Override <S extends T> List<S> save(Iterable<S> entites);
	 */
	@Override
	default <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
		return entities;
	}

	@Override
	default <S extends T> S save(S entity) {
		return entity;
	}

	@Override
	List<T> findAll();

	@Override
	List<T> findAll(Sort sort);

	<S extends T> S insert(S entity);

	<S extends T> List<S> insert(Iterable<S> entities);

	@Override
	<S extends T> List<S> findAll(Example<S> example);

	@Override
	<S extends T> List<S> findAll(Example<S> example, Sort sort);

}