package com.otsi.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.otsi.model.CouchbaseEmployee;
import com.otsi.model.Employee;

@Repository
public interface CouchBaseRepository extends CouchbaseRepository<CouchbaseEmployee, Long> {

	void save(Employee emp);



	

}
