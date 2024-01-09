package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StaffDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long staffDetailsId;
	private long ssrId;
	@Enumerated(EnumType.STRING)
	private Qualifiaction qualifications;
	@Enumerated(EnumType.STRING)
	private TeacherType teacherType;
	@Enumerated(EnumType.STRING)
	private FacultyType facultyType;
	private int maleTeacher;
	private int femaleTeacher;
	private int otherTeacher;
	private int totalTeacher;
	
	
	public long getStaffDetailsId() {
		return staffDetailsId;
	}
	public void setStaffDetailsId(long staffDetailsId) {
		this.staffDetailsId = staffDetailsId;
	}
	public long getSsrId() {
		return ssrId;
	}
	public void setSsrId(long ssrId) {
		this.ssrId = ssrId;
	}
	
	public Qualifiaction getQualifications() {
		return qualifications;
	}
	public void setQualifications(Qualifiaction qualifications) {
		this.qualifications = qualifications;
	}
	public TeacherType getTeacherType() {
		return teacherType;
	}
	public void setTeacherType(TeacherType teacherType) {
		this.teacherType = teacherType;
	}
	
	public FacultyType getFacultyType() {
		return facultyType;
	}
	public void setFacultyType(FacultyType facultyType) {
		this.facultyType = facultyType;
	}
	public int getMaleTeacher() {
		return maleTeacher;
	}
	public void setMaleTeacher(int maleTeacher) {
		this.maleTeacher = maleTeacher;
	}
	public int getFemaleTeacher() {
		return femaleTeacher;
	}
	public void setFemaleTeacher(int femaleTeacher) {
		this.femaleTeacher = femaleTeacher;
	}
	public int getOtherTeacher() {
		return otherTeacher;
	}
	public void setOtherTeacher(int otherTeacher) {
		this.otherTeacher = otherTeacher;
	}
	public int getTotalTeacher() {
		return totalTeacher;
	}
	public void setTotalTeacher(int totalTeacher) {
		this.totalTeacher = totalTeacher;
	}
	
	public enum TeacherType {
		PERMANENT_TEACHER,
		TEMPORARY_TEACHER,
		PART_TIME_TEACHER
	}
	
	public enum Qualifiaction {
	    DSC_DLITT,
	    PHD,
	    MPHIL,
	    PG
	}
	
	public enum FacultyType {
	    PROFESSOR,
	    ASSOCIATE_PROFESSOR,
	    ASSISTANT_PROFESSOR
	}
}
