package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProgramOfferedBYCollegeSSR {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pobc;
	private long ssrID;
	private String levelOfProgram;
	private String nameOfProgramAndCourse;
	private String qualifying;
	private String mediumOfInstruction;
	private String sanctionedStrength;
	private String noOfStudentAdmitted;

	public long getPobc() {
		return pobc;
	}

	public void setPobc(long pobc) {
		this.pobc = pobc;
	}

	public long getSsrID() {
		return ssrID;
	}

	public void setSsrID(long ssrID) {
		this.ssrID = ssrID;
	}

	public String getLevelOfProgram() {
		return levelOfProgram;
	}

	public void setLevelOfProgram(String levelOfProgram) {
		this.levelOfProgram = levelOfProgram;
	}

	public String getNameOfProgramAndCourse() {
		return nameOfProgramAndCourse;
	}

	public void setNameOfProgramAndCourse(String nameOfProgramAndCourse) {
		this.nameOfProgramAndCourse = nameOfProgramAndCourse;
	}

	public String getQualifying() {
		return qualifying;
	}

	public void setQualifying(String qualifying) {
		this.qualifying = qualifying;
	}

	public String getMediumOfInstruction() {
		return mediumOfInstruction;
	}

	public void setMediumOfInstruction(String mediumOfInstruction) {
		this.mediumOfInstruction = mediumOfInstruction;
	}

	public String getSanctionedStrength() {
		return sanctionedStrength;
	}

	public void setSanctionedStrength(String sanctionedStrength) {
		this.sanctionedStrength = sanctionedStrength;
	}

	public String getNoOfStudentAdmitted() {
		return noOfStudentAdmitted;
	}

	public void setNoOfStudentAdmitted(String noOfStudentAdmitted) {
		this.noOfStudentAdmitted = noOfStudentAdmitted;
	}

}
