package com.hibernate.mapping.Many2many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee 
{
	@Id
	private int empid;
	private String name;
	
	@ManyToMany
	@JoinTable(name ="emp_learn" ,joinColumns = {@JoinColumn(name ="eid")},inverseJoinColumns = {@JoinColumn(name ="pid")})
	private List<Project> project;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public Employee(int empid, String name, List<Project> project) {
		super();
		this.empid = empid;
		this.name = name;
		this.project = project;
	}

	public Employee() {
		
	}
	
}