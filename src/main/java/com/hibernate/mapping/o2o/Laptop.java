package com.hibernate.mapping.o2o;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="Laptop1")
public class Laptop
{
	@Id
	private int laptopid;
	private String laptopname;
	@OneToOne
	private Student stud;
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	public int getLaptopid() {
		return laptopid;
	}
	public void setLaptopid(int laptopid) {
		this.laptopid = laptopid;
	}
	public String getLaptopname() {
		return laptopname;
	}
	public void setLaptopname(String laptopname) {
		this.laptopname = laptopname;
	}
	
	

}
