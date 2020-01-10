package com.otsi.model;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class CouchbaseEmployee {

	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	public long id;

	@Field
	private String name;

	@Field
	private long age;

	@Field
	private String address;

	@Field
	private String status;

	@Field
	private long rest_id;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getRest_id() {
		return rest_id;
	}

	public void setRest_id(long rest_id) {
		this.rest_id = rest_id;
	}

}
