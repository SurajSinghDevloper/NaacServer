package com.nac.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "new_college_registration")
public class NewCollegeRegistration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long collegId;

	@Column(name = "collegeName", nullable = false)
	private String collegeName;

	private String MHRDAisheId;

	@Column(name = "collegeEmailID", nullable = false)

	private String collegeEmailID;

	@Column(name = "collegemobileNo", nullable = false)

	private Long collegeMobileNo;

	@Column(name = "accreditedcollege", nullable = false)

	private String accreditedcollege;
	
	private LocalDateTime lastLoginTime;

	private String password;

	private long prepareIIQA_id;
	
	private String role;

	public long getPrepareIIQA_id() {
		return prepareIIQA_id;
	}

	public void setPrepareIIQA_id(long prepareIIQA_id) {
		this.prepareIIQA_id = prepareIIQA_id;
	}

	public Long getCollegId() {
		return collegId;
	}

	public void setCollegId(Long collegId) {
		this.collegId = collegId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getMHRDAisheId() {
		return MHRDAisheId;
	}

	public void setMHRDAisheId(String mHRDAisheId) {
		MHRDAisheId = mHRDAisheId;
	}

	public String getCollegeEmailID() {
		return collegeEmailID;
	}

	public void setCollegeEmailID(String collegeEmailID) {
		this.collegeEmailID = collegeEmailID;
	}

	public Long getCollegeMobileNo() {
		return collegeMobileNo;
	}

	public void setCollegemobileNo(Long collegemobileNo) {
		this.collegeMobileNo = collegemobileNo;
	}

	public String getAccreditedcollege() {
		return accreditedcollege;
	}

	public void setAccreditedcollege(String accreditedcollege) {
		this.accreditedcollege = accreditedcollege;
	}

	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(LocalDateTime lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCollegeMobileNo(Long collegeMobileNo) {
		this.collegeMobileNo = collegeMobileNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
