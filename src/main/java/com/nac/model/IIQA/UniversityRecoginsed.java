package com.nac.model.IIQA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UniversityRecoginsed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long UniversityRecoginsedId;
	
	private long prepareIIQA_ID;
	private String campusType;
	private String state;
	private String city;
	private String  address;
	private String campusApprovalDoc;
	
	
	public Long getUniversityRecoginsedId() {
		return UniversityRecoginsedId;
	}
	public void setUniversityRecoginsedId(Long universityRecoginsedId) {
		UniversityRecoginsedId = universityRecoginsedId;
	}
	public long getPrepareIIQA_ID() {
		return prepareIIQA_ID;
	}
	public void setPrepareIIQA_ID(long prepareIIQA_ID) {
		this.prepareIIQA_ID = prepareIIQA_ID;
	}
	public String getCampusType() {
		return campusType;
	}
	public void setCampusType(String campusType) {
		this.campusType = campusType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCampusApprovalDoc() {
		return campusApprovalDoc;
	}
	public void setCampusApprovalDoc(String campusApprovalDoc) {
		this.campusApprovalDoc = campusApprovalDoc;
	}
	
	
	
	
	
	
}
