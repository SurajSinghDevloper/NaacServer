package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jetbrains.annotations.NotNull;

@Entity
public class ExtendedProfileSSR {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ExtendedProfileSSRId;
	
	private long ssrID;
	private long collegeId;
	private int programCourseYear1;
	private int programCourseYear2;
	private int programCourseYear3;
	private int programCourseYear4;
	private int programCourseYear5;
	private int programYear1;
	private int programYear2;
	private int programYear3;
	private int programYear4;
	private int programYear5;
	private String programCourseInstDataDoc;
	private int studentYear1;
	private int studentYear2;
	private int studentYear3;
	private int studentYear4;
	private int studentYear5;
	private String studentInstDataDoc;
	private int stuAppearedYear1;
	private int stuAppearedYear2;
	private int stuAppearedYear3;
	private int stuAppearedYear4;
	private int stuAppearedYear5;
	private String stuAppearedInstDataDoc;
	private int stuRevalApplicationsYear1;
	private int stuRevalApplicationsYear2;
	private int stuRevalApplicationsYear3;
	private int stuRevalApplicationsYear4;
	private int stuRevalApplicationsYear5;
	private String stuRevalApplicationsInstDataDoc;
	private int  stuOutgoingYear1;
	private int stuOutgoingYear2;
	private int stuOutgoingYear3;
	private int stuOutgoingYear4;
	private int stuOutgoingYear5;
	private String stuOutgoingInstDataDoc;
	private int acadCoursesInAllProgsYear1;
	private int acadCoursesInAllProgsYear2;
	private int acadCoursesInAllProgsYear3;
	private int acadCoursesInAllProgsYear4;
	private int acadCoursesInAllProgsYear5;
	private String acadCoursesInAllProgsInstDataDoc;
	private int acadFullTimeTeachYear1;
	private int acadFullTimeTeachYear2;
	private int acadFullTimeTeachYear3;
	private int acadFullTimeTeachYear4;
	private int acadFullTimeTeachYear5;
	private String acadFullTimeTeachInstDataDoc;
	private int acadSanctionedPostsYear1;
	private int acadSanctionedPostsYear2;
	private int acadSanctionedPostsYear3;
	private int acadSanctionedPostsYear4;
	private int acadSanctionedPostsYear5;
	private String acadSanctionedPostsInstDataDoc;
	private int addmAppliReceviedYear1;
	private int addmAppliReceviedYear2;
	private int addmAppliReceviedYear3;
	private int addmAppliReceviedYear4;
	private int addmAppliReceviedYear5;
	private String addmAppliReceviedInstDataDoc;
	private int addmReservedSeatsYear1;
	private int addmReservedSeatsYear2;
	private int addmReservedSeatsYear3;
	private int addmReservedSeatsYear4;
	private int addmReservedSeatsYear5;
	private String addmReservedSeatsInstDataDoc;
	private int addmNumOfClassrooms;
	private int addmNumOfSeminarHall;
	private int addmNumOfComputer;
	private int expenditureWithoutSalaryYear1;
	private int expenditureWithoutSalaryYear2;
	private int expenditureWithoutSalaryYear3;
	private int expenditureWithoutSalaryYear4;
	private int expenditureWithoutSalaryYear5;
	private String expenditureWithoutSalaryInstDataDoc;
	
//	getter and Setter
	public long getExtendedProfileSSRId() {
		return ExtendedProfileSSRId;
	}
	public void setExtendedProfileSSRId(long extendedProfileSSRId) {
		ExtendedProfileSSRId = extendedProfileSSRId;
	}
	public long getSsrID() {
		return ssrID;
	}
	public void setSsrID(long ssrID) {
		this.ssrID = ssrID;
	}
	public long getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}
	public int getProgramCourseYear1() {
		return programCourseYear1;
	}
	public void setProgramCourseYear1(int programCourseYear1) {
		this.programCourseYear1 = programCourseYear1;
	}
	public int getProgramCourseYear2() {
		return programCourseYear2;
	}
	public void setProgramCourseYear2(int programCourseYear2) {
		this.programCourseYear2 = programCourseYear2;
	}
	public int getProgramCourseYear3() {
		return programCourseYear3;
	}
	public void setProgramCourseYear3(int programCourseYear3) {
		this.programCourseYear3 = programCourseYear3;
	}
	public int getProgramCourseYear4() {
		return programCourseYear4;
	}
	public void setProgramCourseYear4(int programCourseYear4) {
		this.programCourseYear4 = programCourseYear4;
	}
	public int getProgramCourseYear5() {
		return programCourseYear5;
	}
	public void setProgramCourseYear5(int programCourseYear5) {
		this.programCourseYear5 = programCourseYear5;
	}
	public int getProgramYear1() {
		return programYear1;
	}
	public void setProgramYear1(int programYear1) {
		this.programYear1 = programYear1;
	}
	public int getProgramYear2() {
		return programYear2;
	}
	public void setProgramYear2(int programYear2) {
		this.programYear2 = programYear2;
	}
	public int getProgramYear3() {
		return programYear3;
	}
	public void setProgramYear3(int programYear3) {
		this.programYear3 = programYear3;
	}
	public int getProgramYear4() {
		return programYear4;
	}
	public void setProgramYear4(int programYear4) {
		this.programYear4 = programYear4;
	}
	public int getProgramYear5() {
		return programYear5;
	}
	public void setProgramYear5(int programYear5) {
		this.programYear5 = programYear5;
	}
	public String getProgramCourseInstDataDoc() {
		return programCourseInstDataDoc;
	}
	public void setProgramCourseInstDataDoc(String programCourseInstDataDoc) {
		this.programCourseInstDataDoc = programCourseInstDataDoc;
	}
	public int getStudentYear1() {
		return studentYear1;
	}
	public void setStudentYear1(int studentYear1) {
		this.studentYear1 = studentYear1;
	}
	public int getStudentYear2() {
		return studentYear2;
	}
	public void setStudentYear2(int studentYear2) {
		this.studentYear2 = studentYear2;
	}
	public int getStudentYear3() {
		return studentYear3;
	}
	public void setStudentYear3(int studentYear3) {
		this.studentYear3 = studentYear3;
	}
	public int getStudentYear4() {
		return studentYear4;
	}
	public void setStudentYear4(int studentYear4) {
		this.studentYear4 = studentYear4;
	}
	public int getStudentYear5() {
		return studentYear5;
	}
	public void setStudentYear5(int studentYear5) {
		this.studentYear5 = studentYear5;
	}
	public String getStudentInstDataDoc() {
		return studentInstDataDoc;
	}
	public void setStudentInstDataDoc(String studentInstDataDoc) {
		this.studentInstDataDoc = studentInstDataDoc;
	}
	public int getStuAppearedYear1() {
		return stuAppearedYear1;
	}
	public void setStuAppearedYear1(int stuAppearedYear1) {
		this.stuAppearedYear1 = stuAppearedYear1;
	}
	public int getStuAppearedYear2() {
		return stuAppearedYear2;
	}
	public void setStuAppearedYear2(int stuAppearedYear2) {
		this.stuAppearedYear2 = stuAppearedYear2;
	}
	public int getStuAppearedYear3() {
		return stuAppearedYear3;
	}
	public void setStuAppearedYear3(int stuAppearedYear3) {
		this.stuAppearedYear3 = stuAppearedYear3;
	}
	public int getStuAppearedYear4() {
		return stuAppearedYear4;
	}
	public void setStuAppearedYear4(int stuAppearedYear4) {
		this.stuAppearedYear4 = stuAppearedYear4;
	}
	public int getStuAppearedYear5() {
		return stuAppearedYear5;
	}
	public void setStuAppearedYear5(int stuAppearedYear5) {
		this.stuAppearedYear5 = stuAppearedYear5;
	}
	public String getStuAppearedInstDataDoc() {
		return stuAppearedInstDataDoc;
	}
	public void setStuAppearedInstDataDoc(String stuAppearedInstDataDoc) {
		this.stuAppearedInstDataDoc = stuAppearedInstDataDoc;
	}
	public int getStuRevalApplicationsYear1() {
		return stuRevalApplicationsYear1;
	}
	public void setStuRevalApplicationsYear1(int stuRevalApplicationsYear1) {
		this.stuRevalApplicationsYear1 = stuRevalApplicationsYear1;
	}
	public int getStuRevalApplicationsYear2() {
		return stuRevalApplicationsYear2;
	}
	public void setStuRevalApplicationsYear2(int stuRevalApplicationsYear2) {
		this.stuRevalApplicationsYear2 = stuRevalApplicationsYear2;
	}
	public int getStuRevalApplicationsYear3() {
		return stuRevalApplicationsYear3;
	}
	public void setStuRevalApplicationsYear3(int stuRevalApplicationsYear3) {
		this.stuRevalApplicationsYear3 = stuRevalApplicationsYear3;
	}
	public int getStuRevalApplicationsYear4() {
		return stuRevalApplicationsYear4;
	}
	public void setStuRevalApplicationsYear4(int stuRevalApplicationsYear4) {
		this.stuRevalApplicationsYear4 = stuRevalApplicationsYear4;
	}
	public int getStuRevalApplicationsYear5() {
		return stuRevalApplicationsYear5;
	}
	public void setStuRevalApplicationsYear5(int stuRevalApplicationsYear5) {
		this.stuRevalApplicationsYear5 = stuRevalApplicationsYear5;
	}
	public String getStuRevalApplicationsInstDataDoc() {
		return stuRevalApplicationsInstDataDoc;
	}
	public void setStuRevalApplicationsInstDataDoc(String stuRevAppInstDataDoc) {
		this.stuRevalApplicationsInstDataDoc = stuRevAppInstDataDoc;
	}
	public int getStuOutgoingYear1() {
		return stuOutgoingYear1;
	}
	public void setStuOutgoingYear1(int stuOutgoingYear1) {
		this.stuOutgoingYear1 = stuOutgoingYear1;
	}
	public int getStuOutgoingYear2() {
		return stuOutgoingYear2;
	}
	public void setStuOutgoingYear2(int stuOutgoingYear2) {
		this.stuOutgoingYear2 = stuOutgoingYear2;
	}
	public int getStuOutgoingYear3() {
		return stuOutgoingYear3;
	}
	public void setStuOutgoingYear3(int stuOutgoingYear3) {
		this.stuOutgoingYear3 = stuOutgoingYear3;
	}
	public int getStuOutgoingYear4() {
		return stuOutgoingYear4;
	}
	public void setStuOutgoingYear4(int stuOutgoingYear4) {
		this.stuOutgoingYear4 = stuOutgoingYear4;
	}
	public int getStuOutgoingYear5() {
		return stuOutgoingYear5;
	}
	public void setStuOutgoingYear5(int stuoOutgoingYear5) {
		this.stuOutgoingYear5 = stuoOutgoingYear5;
	}
	public String getStuOutgoingInstDataDoc() {
		return stuOutgoingInstDataDoc;
	}
	public void setStuOutgoingInstDataDoc(String stuOutgoingInstDataDoc) {
		this.stuOutgoingInstDataDoc = stuOutgoingInstDataDoc;
	}
	public int getAcadCoursesInAllProgsYear1() {
		return acadCoursesInAllProgsYear1;
	}
	public void setAcadCoursesInAllProgsYear1(int acadCoursesInAllProgsYear1) {
		this.acadCoursesInAllProgsYear1 = acadCoursesInAllProgsYear1;
	}
	public int getAcadCoursesInAllProgsYear2() {
		return acadCoursesInAllProgsYear2;
	}
	public void setAcadCoursesInAllProgsYear2(int acadCoursesInAllProgsYear2) {
		this.acadCoursesInAllProgsYear2 = acadCoursesInAllProgsYear2;
	}
	public int getAcadCoursesInAllProgsYear3() {
		return acadCoursesInAllProgsYear3;
	}
	public void setAcadCoursesInAllProgsYear3(int acadCoursesInAllProgsYear3) {
		this.acadCoursesInAllProgsYear3 = acadCoursesInAllProgsYear3;
	}
	public int getAcadCoursesInAllProgsYear4() {
		return acadCoursesInAllProgsYear4;
	}
	public void setAcadCoursesInAllProgsYear4(int acadCoursesInAllProgsYear4) {
		this.acadCoursesInAllProgsYear4 = acadCoursesInAllProgsYear4;
	}
	public int getAcadCoursesInAllProgsYear5() {
		return acadCoursesInAllProgsYear5;
	}
	public void setAcadCoursesInAllProgsYear5(int acadCoursesInAllProgsYear5) {
		this.acadCoursesInAllProgsYear5 = acadCoursesInAllProgsYear5;
	}
	public String getAcadCoursesInAllProgsInstDataDoc() {
		return acadCoursesInAllProgsInstDataDoc;
	}
	public void setAcadCoursesInAllProgsInstDataDoc(String acadCoursesInAllProgsInstDataDoc) {
		this.acadCoursesInAllProgsInstDataDoc = acadCoursesInAllProgsInstDataDoc;
	}
	public int getAcadFullTimeTeachYear1() {
		return acadFullTimeTeachYear1;
	}
	public void setAcadFullTimeTeachYear1(int acadFullTimeTeachYear1) {
		this.acadFullTimeTeachYear1 = acadFullTimeTeachYear1;
	}
	public int getAcadFullTimeTeachYear2() {
		return acadFullTimeTeachYear2;
	}
	public void setAcadFullTimeTeachYear2(int acadFullTimeTeachYear2) {
		this.acadFullTimeTeachYear2 = acadFullTimeTeachYear2;
	}
	public int getAcadFullTimeTeachYear3() {
		return acadFullTimeTeachYear3;
	}
	public void setAcadFullTimeTeachYear3(int acadFullTimeTeachYear3) {
		this.acadFullTimeTeachYear3 = acadFullTimeTeachYear3;
	}
	public int getAcadFullTimeTeachYear4() {
		return acadFullTimeTeachYear4;
	}
	public void setAcadFullTimeTeachYear4(int acadFullTimeTeachYear4) {
		this.acadFullTimeTeachYear4 = acadFullTimeTeachYear4;
	}
	public int getAcadFullTimeTeachYear5() {
		return acadFullTimeTeachYear5;
	}
	public void setAcadFullTimeTeachYear5(int acadFullTimeTeachYear5) {
		this.acadFullTimeTeachYear5 = acadFullTimeTeachYear5;
	}
	public String getAcadFullTimeTeachInstDataDoc() {
		return acadFullTimeTeachInstDataDoc;
	}
	public void setAcadFullTimeTeachInstDataDoc(String acadFullTimeTeachInstDataDoc) {
		this.acadFullTimeTeachInstDataDoc = acadFullTimeTeachInstDataDoc;
	}
	public int getAcadSanctionedPostsYear1() {
		return acadSanctionedPostsYear1;
	}
	public void setAcadSanctionedPostsYear1(int acadSanctionedPostsYear1) {
		this.acadSanctionedPostsYear1 = acadSanctionedPostsYear1;
	}
	public int getAcadSanctionedPostsYear2() {
		return acadSanctionedPostsYear2;
	}
	public void setAcadSanctionedPostsYear2(int acadSanctionedPostsYear2) {
		this.acadSanctionedPostsYear2 = acadSanctionedPostsYear2;
	}
	public int getAcadSanctionedPostsYear3() {
		return acadSanctionedPostsYear3;
	}
	public void setAcadSanctionedPostsYear3(int acadSanctionedPostsYear3) {
		this.acadSanctionedPostsYear3 = acadSanctionedPostsYear3;
	}
	public int getAcadSanctionedPostsYear4() {
		return acadSanctionedPostsYear4;
	}
	public void setAcadSanctionedPostsYear4(int acadSanctionedPostsYear4) {
		this.acadSanctionedPostsYear4 = acadSanctionedPostsYear4;
	}
	public int getAcadSanctionedPostsYear5() {
		return acadSanctionedPostsYear5;
	}
	public void setAcadSanctionedPostsYear5(int acadSanctionedPostsYear5) {
		this.acadSanctionedPostsYear5 = acadSanctionedPostsYear5;
	}
	public String getAcadSanctionedPostsInstDataDoc() {
		return acadSanctionedPostsInstDataDoc;
	}
	public void setAcadSanctionedPostsInstDataDoc(String acadSanctionedPostsInstDataDoc) {
		this.acadSanctionedPostsInstDataDoc = acadSanctionedPostsInstDataDoc;
	}
	public int getAddmAppliReceviedYear1() {
		return addmAppliReceviedYear1;
	}
	public void setAddmAppliReceviedYear1(int addmAppliReceviedYear1) {
		this.addmAppliReceviedYear1 = addmAppliReceviedYear1;
	}
	public int getAddmAppliReceviedYear2() {
		return addmAppliReceviedYear2;
	}
	public void setAddmAppliReceviedYear2(int addmAppliReceviedYear2) {
		this.addmAppliReceviedYear2 = addmAppliReceviedYear2;
	}
	public int getAddmAppliReceviedYear3() {
		return addmAppliReceviedYear3;
	}
	public void setAddmAppliReceviedYear3(int addmAppliReceviedYear3) {
		this.addmAppliReceviedYear3 = addmAppliReceviedYear3;
	}
	public int getAddmAppliReceviedYear4() {
		return addmAppliReceviedYear4;
	}
	public void setAddmAppliReceviedYear4(int addmAppliReceviedYear4) {
		this.addmAppliReceviedYear4 = addmAppliReceviedYear4;
	}
	public int getAddmAppliReceviedYear5() {
		return addmAppliReceviedYear5;
	}
	public void setAddmAppliReceviedYear5(int addmAppliReceviedYear5) {
		this.addmAppliReceviedYear5 = addmAppliReceviedYear5;
	}
	public String getAddmAppliReceviedInstDataDoc() {
		return addmAppliReceviedInstDataDoc;
	}
	public void setAddmAppliReceviedInstDataDoc(String addmAppliReceviedInstDataDoc) {
		this.addmAppliReceviedInstDataDoc = addmAppliReceviedInstDataDoc;
	}
	public int getAddmReservedSeatsYear1() {
		return addmReservedSeatsYear1;
	}
	public void setAddmReservedSeatsYear1(int addmReservedSeatsYear1) {
		this.addmReservedSeatsYear1 = addmReservedSeatsYear1;
	}
	public int getAddmReservedSeatsYear2() {
		return addmReservedSeatsYear2;
	}
	public void setAddmReservedSeatsYear2(int addmReservedSeatsYear2) {
		this.addmReservedSeatsYear2 = addmReservedSeatsYear2;
	}
	public int getAddmReservedSeatsYear3() {
		return addmReservedSeatsYear3;
	}
	public void setAddmReservedSeatsYear3(int addmReservedSeatsYear3) {
		this.addmReservedSeatsYear3 = addmReservedSeatsYear3;
	}
	public int getAddmReservedSeatsYear4() {
		return addmReservedSeatsYear4;
	}
	public void setAddmReservedSeatsYear4(int addmReservedSeatsYear4) {
		this.addmReservedSeatsYear4 = addmReservedSeatsYear4;
	}
	public int getAddmReservedSeatsYear5() {
		return addmReservedSeatsYear5;
	}
	public void setAddmReservedSeatsYear5(int addmReservedSeatsYear5) {
		this.addmReservedSeatsYear5 = addmReservedSeatsYear5;
	}
	public String getAddmReservedSeatsInstDataDoc() {
		return addmReservedSeatsInstDataDoc;
	}
	public void setAddmReservedSeatsInstDataDoc(String addmReservedSeatsInstDataDoc) {
		this.addmReservedSeatsInstDataDoc = addmReservedSeatsInstDataDoc;
	}
	public int getAddmNumOfClassrooms() {
		return addmNumOfClassrooms;
	}
	public void setAddmNumOfClassrooms(int addmNumOfClassrooms) {
		this.addmNumOfClassrooms = addmNumOfClassrooms;
	}
	public int getAddmNumOfSeminarHall() {
		return addmNumOfSeminarHall;
	}
	public void setAddmNumOfSeminarHall(int addmNumOfSeminarHall) {
		this.addmNumOfSeminarHall = addmNumOfSeminarHall;
	}
	public int getAddmNumOfComputer() {
		return addmNumOfComputer;
	}
	public void setAddmNumOfComputer(int addmNumOfComputer) {
		this.addmNumOfComputer = addmNumOfComputer;
	}
	public int getExpenditureWithoutSalaryYear1() {
		return expenditureWithoutSalaryYear1;
	}
	public void setExpenditureWithoutSalaryYear1(int expenditureWithoutSalaryYear1) {
		this.expenditureWithoutSalaryYear1 = expenditureWithoutSalaryYear1;
	}
	public int getExpenditureWithoutSalaryYear2() {
		return expenditureWithoutSalaryYear2;
	}
	public void setExpenditureWithoutSalaryYear2(int expenditureWithoutSalaryYear2) {
		this.expenditureWithoutSalaryYear2 = expenditureWithoutSalaryYear2;
	}
	public int getExpenditureWithoutSalaryYear3() {
		return expenditureWithoutSalaryYear3;
	}
	public void setExpenditureWithoutSalaryYear3(int expenditureWithoutSalaryYear3) {
		this.expenditureWithoutSalaryYear3 = expenditureWithoutSalaryYear3;
	}
	public int getExpenditureWithoutSalaryYear4() {
		return expenditureWithoutSalaryYear4;
	}
	public void setExpenditureWithoutSalaryYear4(int expenditureWithoutSalaryYear4) {
		this.expenditureWithoutSalaryYear4 = expenditureWithoutSalaryYear4;
	}
	public int getExpenditureWithoutSalaryYear5() {
		return expenditureWithoutSalaryYear5;
	}
	public void setExpenditureWithoutSalaryYear5(int expenditureWithoutSalaryYear5) {
		this.expenditureWithoutSalaryYear5 = expenditureWithoutSalaryYear5;
	}
	public String getExpenditureWithoutSalaryInstDataDoc() {
		return expenditureWithoutSalaryInstDataDoc;
	}
	public void setExpenditureWithoutSalaryInstDataDoc(String expenditureWithoutSalaryInstDataDoc) {
		this.expenditureWithoutSalaryInstDataDoc = expenditureWithoutSalaryInstDataDoc;
	}
	

	
	

}
