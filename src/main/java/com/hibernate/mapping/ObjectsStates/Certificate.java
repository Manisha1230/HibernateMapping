package com.hibernate.mapping.ObjectsStates;

import javax.persistence.Embeddable;


@Embeddable
public class Certificate {

	private String coursename;
	private String duration;

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}



	public Certificate() {

	}

	@Override
	public String toString() {
		return "Certificate [coursename=" + coursename + ", duration=" + duration + "]";
	}

}
