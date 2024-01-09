package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDetailsCurrentYear {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentCurrentYearId;
	private long ssrId;
	@Enumerated(EnumType.STRING)
	private Program program;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private int fromState;
	private int fromOther;
	private int nriStudent;
	private int foreignStudent;
	private int total;
	
	
	public long getStudentCurrentYearId() {
		return studentCurrentYearId;
	}
	public void setStudentCurrentYearId(long studentCurrentYearId) {
		this.studentCurrentYearId = studentCurrentYearId;
	}
	public long getSsrId() {
		return ssrId;
	}
	public void setSsrId(long ssrId) {
		this.ssrId = ssrId;
	}
	
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getFromState() {
		return fromState;
	}
	public void setFromState(int fromState) {
		this.fromState = fromState;
	}
	public int getFromOther() {
		return fromOther;
	}
	public void setFromOther(int fromOther) {
		this.fromOther = fromOther;
	}
	public int getNriStudent() {
		return nriStudent;
	}
	public void setNriStudent(int nriStudent) {
		this.nriStudent = nriStudent;
	}
	public int getForeignStudent() {
		return foreignStudent;
	}
	public void setForeignStudent(int foreignStudent) {
		this.foreignStudent = foreignStudent;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public enum Gender{
		Male,
		Female,
		Others
	}
	public enum Program{
		UG,
		PG
	}
}
