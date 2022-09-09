package com.hibernate.mapping.CacheableEx;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class EmployeeCache
{
	@Id
	private int id;
	private String name;
	private float salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public EmployeeCache( String name, float salary) {
		super();
		
		this.name = name;
		this.salary = salary;
	}
	public EmployeeCache() {
		
	}
	@Override
	public String toString() {
		return "EmployeeCache [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	

}
