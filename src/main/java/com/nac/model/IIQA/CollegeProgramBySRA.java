package com.nac.model.IIQA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CollegeProgramBySRA {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long clgPrgBySRAID;
	
	private String collegeProgramBySRA_Type;
	private String collegeProgramBySRA_Document;
	private long prepareIIQA;
	
	
	public Long getClgPrgBySRAID() {
		return clgPrgBySRAID;
	}
	public void setClgPrgBySRAID(Long clgPrgBySRAID) {
		this.clgPrgBySRAID = clgPrgBySRAID;
	}
	public long getPrepareIIQA_ID() {
		return prepareIIQA;
	}
	public void setPrepareIIQA_ID(long prepareIIQA) {
		this.prepareIIQA = prepareIIQA;
	}
	public String getCollegeProgramBySRA_Type() {
		return collegeProgramBySRA_Type;
	}
	public void setCollegeProgramBySRA_Type(String collegeProgramBySRA_Type) {
		this.collegeProgramBySRA_Type = collegeProgramBySRA_Type;
	}
	public String getCollegeProgramBySRA_Document() {
		return collegeProgramBySRA_Document;
	}
	public void setCollegeProgramBySRA_Document(String collegeProgramBySRA_Document) {
		this.collegeProgramBySRA_Document = collegeProgramBySRA_Document;
	}
	
	
}
