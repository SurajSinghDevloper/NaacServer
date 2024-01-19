package com.nac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class StudentFeedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentID;
	private String stdName;
	@Column(unique = true)
	private String stdRegNo;
	@Column(unique = true)
	private String stdEmail;
	@Column(unique = true)
	private String stdMobile;
	private String stdDep;
	private String password;
	private String role;
	
	
	public long getStudentID() {
		return studentID;
	}
	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdRegNo() {
		return stdRegNo;
	}
	public void setStdRegNo(String stdRegNo) {
		this.stdRegNo = stdRegNo;
	}
	public String getStdEmail() {
		return stdEmail;
	}
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}
	public String getStdMobile() {
		return stdMobile;
	}
	public void setStdMobile(String stdMobile) {
		this.stdMobile = stdMobile;
	}
	public String getStdDep() {
		return stdDep;
	}
	public void setStdDep(String stdDep) {
		this.stdDep = stdDep;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
