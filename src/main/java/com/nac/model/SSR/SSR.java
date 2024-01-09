package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SSR {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ssrID;
	private long collegeID;
	private long prepareIIQAID;
	private String byGender;
	private String byShift;
	private String recognizedMinorityInstitution;
	private String documentOFMinorityInstitution;
	private String minorityByReligious;
	private String minorityByLinguistic;
	private String minorityByOther;
	private String remarks;
	private String isAutonomyGranted;
	private String isAutonomyGrantedDocumnet;
	private String collegeAutonomousApplicationStatus;
	private String isCollegeRecognizedByGovtAgency;
	private String recognizedAgencyName;
	private String dateOfRecognisation;
	private String campusLocation;
	private String campusAreaInAcres;
	private String builtUpAreaInSqMt;
	private String completed;
	private String verified;

	public long getSsrID() {
		return ssrID;
	}

	public void setSsrID(long ssrID) {
		this.ssrID = ssrID;
	}

	public long getCollegeID() {
		return collegeID;
	}

	public void setCollegeID(long collegeID) {
		this.collegeID = collegeID;
	}

	public long getPrepareIIQAID() {
		return prepareIIQAID;
	}

	public void setPrepareIIQAID(long prepareIIQAID) {
		this.prepareIIQAID = prepareIIQAID;
	}

	public String getByGender() {
		return byGender;
	}

	public void setByGender(String byGender) {
		this.byGender = byGender;
	}

	public String getByShift() {
		return byShift;
	}

	public void setByShift(String byShift) {
		this.byShift = byShift;
	}
	
	
	
	public String getDocumentOFMinorityInstitution() {
		return documentOFMinorityInstitution;
	}

	public void setDocumentOFMinorityInstitution(String documentOFMinorityInstitution) {
		this.documentOFMinorityInstitution = documentOFMinorityInstitution;
	}

	public String getRecognizedMinorityInstitution() {
		return recognizedMinorityInstitution;
	}

	public void setRecognizedMinorityInstitution(String recognizedMinorityInstitution) {
		this.recognizedMinorityInstitution = recognizedMinorityInstitution;
	}

	public String getMinorityByReligious() {
		return minorityByReligious;
	}

	public void setMinorityByReligious(String minorityByReligious) {
		this.minorityByReligious = minorityByReligious;
	}

	public String getMinorityByLinguistic() {
		return minorityByLinguistic;
	}

	public void setMinorityByLinguistic(String minorityByLinguistic) {
		this.minorityByLinguistic = minorityByLinguistic;
	}

	public String getMinorityByOther() {
		return minorityByOther;
	}

	public void setMinorityByOther(String minorityByOther) {
		this.minorityByOther = minorityByOther;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getIsAutonomyGranted() {
		return isAutonomyGranted;
	}

	public void setIsAutonomyGranted(String isAutonomyGranted) {
		this.isAutonomyGranted = isAutonomyGranted;
	}

	public String getIsAutonomyGrantedDocumnet() {
		return isAutonomyGrantedDocumnet;
	}

	public void setIsAutonomyGrantedDocumnet(String isAutonomyGrantedDocumnet) {
		this.isAutonomyGrantedDocumnet = isAutonomyGrantedDocumnet;
	}

	public String getCollegeAutonomousApplicationStatus() {
		return collegeAutonomousApplicationStatus;
	}

	public void setCollegeAutonomousApplicationStatus(String collegeAutonomousApplicationStatus) {
		this.collegeAutonomousApplicationStatus = collegeAutonomousApplicationStatus;
	}

	public String getIsCollegeRecognizedByGovtAgency() {
		return isCollegeRecognizedByGovtAgency;
	}

	public void setIsCollegeRecognizedByGovtAgency(String isCollegeRecognizedByGovtAgency) {
		this.isCollegeRecognizedByGovtAgency = isCollegeRecognizedByGovtAgency;
	}
	
	public String getRecognizedAgencyName() {
		return recognizedAgencyName;
	}

	public void setRecognizedAgencyName(String recognizedAgencyName) {
		this.recognizedAgencyName = recognizedAgencyName;
	}

	public String getDateOfRecognisation() {
		return dateOfRecognisation;
	}

	public void setDateOfRecognisation(String dateOfRecognisation) {
		this.dateOfRecognisation = dateOfRecognisation;
	}

	public String getCampusLocation() {
		return campusLocation;
	}

	public void setCampusLocation(String campusLocation) {
		this.campusLocation = campusLocation;
	}

	public String getCampusAreaInAcres() {
		return campusAreaInAcres;
	}

	public void setCampusAreaInAcres(String campusAreaInAcres) {
		this.campusAreaInAcres = campusAreaInAcres;
	}

	public String getBuiltUpAreaInSqMt() {
		return builtUpAreaInSqMt;
	}

	public void setBuiltUpAreaInSqMt(String builtUpAreaInSqMt) {
		this.builtUpAreaInSqMt = builtUpAreaInSqMt;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}
	
}
