package com.otsi.model;

import java.util.concurrent.Callable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Callable<Employee> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String name;

	private long age;

	private String address;
	
	private String status;
	
	private long rest_id;
	

	public Employee() {
		super();
	}

	public Employee(long id, String name, long age, String address, String status, long rest_id) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.status = status;
		this.rest_id = rest_id;
	}

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

	@Override
	public Employee call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
