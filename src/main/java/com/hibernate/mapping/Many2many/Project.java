package com.hibernate.mapping.Many2many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project 
{
	@Id
	private int projectid;
	private String projectName;
	
	@ManyToMany
	private List<Employee> employee;

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Project(int projectid, String projectName, List<Employee> employee) {
		
		this.projectid = projectid;
		this.projectName = projectName;
		this.employee = employee;
	}

	public Project() {
		
	}
	
	}
