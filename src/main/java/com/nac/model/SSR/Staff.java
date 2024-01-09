package com.nac.model.SSR;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long staffId;
	private long ssrId;
    @Enumerated(EnumType.STRING)
    private StaffType staffType;
    
    @Enumerated(EnumType.STRING)
    private FacultyType facultyType;
    
    @Enumerated(EnumType.STRING)
    private SanctionedBy sanctionedBy;
	private int totalStaff;
	private int recruitedMale;
	private int recruitedFemale;
	private int recruitedOther;
	private int yetToRecruited;
	private int guestFacultiesMale;
	private int guestFacultiesFemale;
	private int guestFacultiesOther;
	private int guestFacultiesTotal;
	
	
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	
	public long getSsrId() {
		return ssrId;
	}
	public void setSsrId(long ssrId) {
		this.ssrId = ssrId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	
	public StaffType getStaffType() {
		return staffType;
	}
	public void setStaffType(StaffType staffType) {
		this.staffType = staffType;
	}
	public FacultyType getFacultyType() {
		return facultyType;
	}
	public void setFacultyType(FacultyType facultyType) {
		this.facultyType = facultyType;
	}
	public SanctionedBy getSanctionedBy() {
		return sanctionedBy;
	}
	public void setSanctionedBy(SanctionedBy sanctionedBy) {
		this.sanctionedBy = sanctionedBy;
	}
	public int getTotalStaff() {
		return totalStaff;
	}
	public void setTotalStaff(int totalStaff) {
		this.totalStaff = totalStaff;
	}
	public int getRecruitedMale() {
		return recruitedMale;
	}
	public void setRecruitedMale(int recruitedMale) {
		this.recruitedMale = recruitedMale;
	}
	public int getRecruitedFemale() {
		return recruitedFemale;
	}
	public void setRecruitedFemale(int recruitedFemale) {
		this.recruitedFemale = recruitedFemale;
	}
	public int getRecruitedOther() {
		return recruitedOther;
	}
	public void setRecruitedOther(int recruitedOther) {
		this.recruitedOther = recruitedOther;
	}
	public int getYetToRecruited() {
		return yetToRecruited;
	}
	public void setYetToRecruited(int yetToRecruited) {
		this.yetToRecruited = yetToRecruited;
	}
	
	public int getGuestFacultiesMale() {
		return guestFacultiesMale;
	}
	public void setGuestFacultiesMale(int guestFacultiesMale) {
		this.guestFacultiesMale = guestFacultiesMale;
	}
	public int getGuestFacultiesFemale() {
		return guestFacultiesFemale;
	}
	public void setGuestFacultiesFemale(int guestFacultiesFemale) {
		this.guestFacultiesFemale = guestFacultiesFemale;
	}
	public int getGuestFacultiesOther() {
		return guestFacultiesOther;
	}
	public void setGuestFacultiesOther(int guestFacultiesOther) {
		this.guestFacultiesOther = guestFacultiesOther;
	}
	public int getGuestFacultiesTotal() {
		return guestFacultiesTotal;
	}
	public void setGuestFacultiesTotal(int guestFacultiesTotal) {
		this.guestFacultiesTotal = guestFacultiesTotal;
	}


	public enum StaffType {
	    TEACHING_STAFF,
	    NON_TEACHING_STAFF,
	    TECHNICAL_STAFF,
	    GUEST_STAFF
	}
	
	public enum FacultyType {
	    PROFESSOR,
	    ASSOCIATE_PROFESSOR,
	    ASSISTANT_PROFESSOR
	    
	}
	
	public enum SanctionedBy {
	    UGC,
	    MANAGEMENT,
	}

}
