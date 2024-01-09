package com.nac.model.IIQA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AffiliatingUniversity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AffiliatingUniversityId;
	private String state;
	private String universityName;
	private String documentName;
	private long prepareIIQA_ID;
	
	
	
	public Long getAffiliatingUniversityId() {
		return AffiliatingUniversityId;
	}
	public void setAffiliatingUniversityId(Long affiliatingUniversityId) {
		AffiliatingUniversityId = affiliatingUniversityId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public long getPrepareIIQA_ID() {
		return prepareIIQA_ID;
	}
	public void setPrepareIIQA_ID(long prepareIIQA_ID) {
		this.prepareIIQA_ID = prepareIIQA_ID;
	}
	
	
}
