package com.nac.dtos;

import com.nac.model.NewCollegeRegistration;

public class CollegeInfo {
	private Long id;
	private String collegeName;
	private String collegeEmailID;

	// Constructors, getters, and setters

	public CollegeInfo(NewCollegeRegistration collegeRegistration) {
		this.id = collegeRegistration.getCollegId();
		this.collegeName = collegeRegistration.getCollegeName();
		this.collegeEmailID = collegeRegistration.getCollegeEmailID();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeEmailID() {
		return collegeEmailID;
	}

	public void setCollegeEmailID(String collegeEmailID) {
		this.collegeEmailID = collegeEmailID;
	}

}
