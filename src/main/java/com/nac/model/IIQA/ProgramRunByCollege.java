package com.nac.model.IIQA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProgramRunByCollege {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="programID")
	private Long Id;
	private String departmentName;
	private String program;
	private String sra;
	private String specialization;
	private String selfDeclaration;
	private long prepareIIQA_ID;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getSra() {
		return sra;
	}
	public void setSra(String sra) {
		this.sra = sra;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getSelfDeclaration() {
		return selfDeclaration;
	}
	public void setSelfDeclaration(String selfDeclaration) {
		this.selfDeclaration = selfDeclaration;
	}
	public long getPrepareIIQA_ID() {
		return prepareIIQA_ID;
	}
	public void setPrepareIIQA_ID(long prepareIIQA_ID) {
		this.prepareIIQA_ID = prepareIIQA_ID;
	}
	
	
	
}
