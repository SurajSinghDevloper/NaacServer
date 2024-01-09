package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDetailsLastFourYears {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentDeatailId;
	private long ssrId;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private int year1;
	private int year2;
	private int year3;
	private int year4;
	private int total1;
	private int total2;
	private int total3;
	private int total4;
	private int selfFinancedPrograms;
	private int newProgramsIntroduced;
	private int unitCostofEducation;
	private int includingSalary;
	private int excludingSalary;
	
	
	public long getStudentDeatailId() {
		return studentDeatailId;
	}
	public void setStudentDeatailId(long studentDeatailId) {
		this.studentDeatailId = studentDeatailId;
	}
	
	
	public long getSsrId() {
		return ssrId;
	}
	public void setSsrId(long ssrId) {
		this.ssrId = ssrId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getYear1() {
		return year1;
	}
	public void setYear1(int year1) {
		this.year1 = year1;
	}
	public int getYear2() {
		return year2;
	}
	public void setYear2(int year2) {
		this.year2 = year2;
	}
	public int getYear3() {
		return year3;
	}
	public void setYear3(int year3) {
		this.year3 = year3;
	}
	public int getYear4() {
		return year4;
	}
	public void setYear4(int year4) {
		this.year4 = year4;
	}
	public int getTotal1() {
		return total1;
	}
	public void setTotal1(int total1) {
		this.total1 = total1;
	}
	public int getTotal2() {
		return total2;
	}
	public void setTotal2(int total2) {
		this.total2 = total2;
	}
	public int getTotal3() {
		return total3;
	}
	public void setTotal3(int total3) {
		this.total3 = total3;
	}
	public int getTotal4() {
		return total4;
	}
	public void setTotal4(int total4) {
		this.total4 = total4;
	}	
	public int getSelfFinancedPrograms() {
		return selfFinancedPrograms;
	}
	public void setSelfFinancedPrograms(int selfFinancedPrograms) {
		this.selfFinancedPrograms = selfFinancedPrograms;
	}
	public int getNewProgramsIntroduced() {
		return newProgramsIntroduced;
	}
	public void setNewProgramsIntroduced(int newProgramsIntroduced) {
		this.newProgramsIntroduced = newProgramsIntroduced;
	}
	public int getUnitCostofEducation() {
		return unitCostofEducation;
	}
	public void setUnitCostofEducation(int unitCostofEducation) {
		this.unitCostofEducation = unitCostofEducation;
	}
	public int getIncludingSalary() {
		return includingSalary;
	}
	public void setIncludingSalary(int includingSalary) {
		this.includingSalary = includingSalary;
	}
	public int getExcludingSalary() {
		return excludingSalary;
	}
	public void setExcludingSalary(int excludingSalary) {
		this.excludingSalary = excludingSalary;
	}


	public enum Category{
		SC,
		ST,
		OBC,
		Others,
	}
	public enum Gender{
		Male,
		Female,
		Others
	}
}
