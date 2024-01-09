package com.nac.configuration;

import com.nac.model.NewCollegeRegistration;

public class LoginResponse {
	private String token;
	private NewCollegeRegistration college;
	
//	private List<PrepareIIQA> latestPrepareIIQAList;
//	private PrepareIIQA iiqa;

	public LoginResponse(String token, NewCollegeRegistration college) {
		this.token = token;
		this.college = college;

	}

//	public LoginResponse(String token, NewCollegeRegistration college, PrepareIIQA iiqa) {
//		this.token = token;
//		this.college = college;
//		this.iiqa = iiqa;
//	}

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

//	public List<PrepareIIQA> getLatestPrepareIIQAList() {
//		return latestPrepareIIQAList;
//	}
//
//	public void setLatestPrepareIIQAList(List<PrepareIIQA> latestPrepareIIQAList) {
//		this.latestPrepareIIQAList = latestPrepareIIQAList;
//	}

//	public PrepareIIQA getIiqa() {
//		return iiqa;
//	}
//
//	public void setIiqa(PrepareIIQA iiqa) {
//		this.iiqa = iiqa;
//	}

}
