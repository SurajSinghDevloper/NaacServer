package com.nac.configuration;

import com.nac.model.NewCollegeRegistration;
import com.nac.model.StudentFeedback;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
	private String token;
	private NewCollegeRegistration college;
	private StudentFeedback student;
	private Object user;
	
    public LoginResponse(String token, Object user) {
        this.token = token;
        this.user = user;
    }


	public LoginResponse(String token, NewCollegeRegistration college) {
		this.token = token;
		this.college = college;

	}
	
	public LoginResponse(String token, StudentFeedback student) {
		this.token = token;
		this.student = student;

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public NewCollegeRegistration getCollege() {
		return college;
	}

	public void setCollege(NewCollegeRegistration college) {
		this.college = college;
	}

	public StudentFeedback getStudent() {
		return student;
	}

	public void setStudent(StudentFeedback student) {
		this.student = student;
	}


	public Object getUser() {
		return user;
	}


	public void setUser(Object user) {
		this.user = user;
	}

	

}
