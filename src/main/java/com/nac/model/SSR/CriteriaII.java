package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class CriteriaII {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long CriteriaII_Id;
	private long ssrID;
	private long collegeID;
	private long qifId;
	
	

	//	2.1.1
	private String enrolmentPercent;
//	2.1.1.1
	private String noSeatsFilledY1;
	private String noSeatsFilledY2;
	private String noSeatsFilledY3;
	private String noSeatsFilledY4;
	private String noSeatsFilledY5;
//	2.1.1.2
	private String noSanctionedSeatsY1;
	private String noSanctionedSeatsY2;
	private String noSanctionedSeatsY3;
	private String noSanctionedSeatsY4;
	private String noSanctionedSeatsY5;
	
	private String institutionalDataTemplate_doc;//
	
	private String instDataTemplate_doc;
	private String intakeSanctionApproval_doc;
	private String finalAdmissionList_doc;
	
	private String finalAdmissionList_doc2;//
	
	private String linksForAnyOtherRelevant;
	
//	2.1.2
	private String reservedSeatsPercentageLast5Years;
	private String numAdmittedReservedY1;
	private String numAdmittedReservedY2;
	private String numAdmittedReservedY3;
	private String numAdmittedReservedY4;
	private String numAdmittedReservedY5;
	
//	2.1.2.1.
	private String reservedSeatsByY1;
	private String reservedSeatsByY2;
	private String reservedSeatsByY3;
	private String reservedSeatsByY4;
	private String reservedSeatsByY5;
	
	private String instDataTemplate_doc2;
	private String govtLetter_doc;
	private String finalAdmissionList;
	private String linkForOtherRelivantDoc;
	
//	2.2.1
	private String stuFTRatio;
	private String numStudentsByY1;
	private String numStudentsByY2;
	private String numStudentsByY3;
	private String numStudentsByY4;
	private String numStudentsByY5;
	
	private String numFTTeachersY1;
	private String numFTTeachersY2;
	private String numFTTeachersY3;
	private String numFTTeachersY4;
	private String numFTTeachersY5;
	private String additionalInfo_doc;
	private String additionalInfoLink;
	
//	2.3.1
	private String stdCentricMethods;
	private String additionalInfo_doc2;
	private String additionalInfoLink2;
	
//	2.4.1	
	private String FTPTRatioLast5Years;
	private String ftTeachersByY1;
	private String ftTeachersByY2;
	private String ftTeachersByY3;
	private String ftTeachersByY4;
	private String ftTeachersByY5;

	private String numPostsByY1;
	private String numPostsByY2;
	private String numPostsByY3;
	private String numPostsByY4;
	private String numPostsByY5;
	private String sanctionedPostsMap_doc;
	private String additionalInfoLink3;
	
 
//	2.4.2 
	private String percFTTeachersLast5Years;
//	2.4.2.1
	private String noFTTeachersWithDegreeY1;
	private String noFTTeachersWithDegreeY2;
	private String noFTTeachersWithDegreeY3;
	private String noFTTeachersWithDegreeY4;
	private String noFTTeachersWithDegreeY5;
	
	private String noFTTY1;
	private String noFTTY2;
	private String noFTTY3;
	private String noFTTY4;
	private String noFTTY5;
	
	private String instDataTemplate_doc3;
	private String facultyPhDList_doc;
	private String ugcRecognizedPhdDegrees_doc;
	private String additionalInfoLink4;
//	2.5.1	
	private String transAssessGrievSys;
	private String additionalInfo_doc3;
	private String additionalInfoLink5;
//	2.6.1
	private String POsCOsListOutcome;
	private String additionalInfo_doc4;
	private String additionalInfoLink6;
//	2.6.2
	public String evaluatedPOsCOs;
	private String additionalInfo_doc5;
	private String additionalInfoLink7;
//	2.6.3
	private String passPercentageLast5Years;
//	2.6.3.1
	private String numPassedStudentsByY1;
	private String numPassedStudentsByY2;
	private String numPassedStudentsByY3;
	private String numPassedStudentsByY4;
	private String numPassedStudentsByY5;
//	2.6.3.2
	private String numFinalYearStudentsByY1;
	private String numFinalYearStudentsByY2;
	private String numFinalYearStudentsByY3;
	private String numFinalYearStudentsByY4;
	private String numFinalYearStudentsByY5;
	
	private String instDataTemplate_doc4;
	private String coeReportPassPercentage_doc;
	private String coePassPercentReport_doc;
	private String additionalInfoLink8;

	
	public long getCriteriaII_Id() {
		return CriteriaII_Id;
	}
	public void setCriteriaII_Id(long criteriaII_Id) {
		CriteriaII_Id = criteriaII_Id;
	}
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
	public long getQifId() {
		return qifId;
	}
	public void setQifId(long qifId) {
		this.qifId = qifId;
	}
	public String getEnrolmentPercent() {
		return enrolmentPercent;
	}
	public void setEnrolmentPercent(String enrolmentPercent) {
		this.enrolmentPercent = enrolmentPercent;
	}
	public String getNoSeatsFilledY1() {
		return noSeatsFilledY1;
	}
	public void setNoSeatsFilledY1(String noSeatsFilledY1) {
		this.noSeatsFilledY1 = noSeatsFilledY1;
	}
	public String getNoSeatsFilledY2() {
		return noSeatsFilledY2;
	}
	public void setNoSeatsFilledY2(String noSeatsFilledY2) {
		this.noSeatsFilledY2 = noSeatsFilledY2;
	}
	public String getNoSeatsFilledY3() {
		return noSeatsFilledY3;
	}
	public void setNoSeatsFilledY3(String noSeatsFilledY3) {
		this.noSeatsFilledY3 = noSeatsFilledY3;
	}
	public String getNoSeatsFilledY4() {
		return noSeatsFilledY4;
	}
	public void setNoSeatsFilledY4(String noSeatsFilledY4) {
		this.noSeatsFilledY4 = noSeatsFilledY4;
	}
	public String getNoSeatsFilledY5() {
		return noSeatsFilledY5;
	}
	public void setNoSeatsFilledY5(String noSeatsFilledY5) {
		this.noSeatsFilledY5 = noSeatsFilledY5;
	}
	public String getNoSanctionedSeatsY1() {
		return noSanctionedSeatsY1;
	}
	public void setNoSanctionedSeatsY1(String noSanctionedSeatsY1) {
		this.noSanctionedSeatsY1 = noSanctionedSeatsY1;
	}
	public String getNoSanctionedSeatsY2() {
		return noSanctionedSeatsY2;
	}
	public void setNoSanctionedSeatsY2(String noSanctionedSeatsY2) {
		this.noSanctionedSeatsY2 = noSanctionedSeatsY2;
	}
	public String getNoSanctionedSeatsY3() {
		return noSanctionedSeatsY3;
	}
	public void setNoSanctionedSeatsY3(String noSanctionedSeatsY3) {
		this.noSanctionedSeatsY3 = noSanctionedSeatsY3;
	}
	public String getNoSanctionedSeatsY4() {
		return noSanctionedSeatsY4;
	}
	public void setNoSanctionedSeatsY4(String noSanctionedSeatsY4) {
		this.noSanctionedSeatsY4 = noSanctionedSeatsY4;
	}
	public String getNoSanctionedSeatsY5() {
		return noSanctionedSeatsY5;
	}
	public void setNoSanctionedSeatsY5(String noSanctionedSeatsY5) {
		this.noSanctionedSeatsY5 = noSanctionedSeatsY5;
	}
	public String getInstDataTemplate_doc() {
		return instDataTemplate_doc;
	}
	public void setInstDataTemplate_doc(String instDataTemplate_doc) {
		this.instDataTemplate_doc = instDataTemplate_doc;
	}
	public String getIntakeSanctionApproval_doc() {
		return intakeSanctionApproval_doc;
	}
	public void setIntakeSanctionApproval_doc(String intakeSanctionApproval_doc) {
		this.intakeSanctionApproval_doc = intakeSanctionApproval_doc;
	}
	public String getFinalAdmissionList_doc() {
		return finalAdmissionList_doc;
	}
	public void setFinalAdmissionList_doc(String finalAdmissionList_doc) {
		this.finalAdmissionList_doc = finalAdmissionList_doc;
	}
	public String getLinksForAnyOtherRelevant() {
		return linksForAnyOtherRelevant;
	}
	public void setLinksForAnyOtherRelevant(String linksForAnyOtherRelevant) {
		this.linksForAnyOtherRelevant = linksForAnyOtherRelevant;
	}
	
	public String getInstitutionalDataTemplate_doc() {
		return institutionalDataTemplate_doc;
	}
	public void setInstitutionalDataTemplate_doc(String institutionalDataTemplate_doc) {
		this.institutionalDataTemplate_doc = institutionalDataTemplate_doc;
	}
	public String getFinalAdmissionList_doc2() {
		return finalAdmissionList_doc2;
	}
	public void setFinalAdmissionList_doc2(String finalAdmissionList_doc2) {
		this.finalAdmissionList_doc2 = finalAdmissionList_doc2;
	}
	public String getReservedSeatsPercentageLast5Years() {
		return reservedSeatsPercentageLast5Years;
	}
	public void setReservedSeatsPercentageLast5Years(String reservedSeatsPercentageLast5Years) {
		this.reservedSeatsPercentageLast5Years = reservedSeatsPercentageLast5Years;
	}
	public String getNumAdmittedReservedY1() {
		return numAdmittedReservedY1;
	}
	public void setNumAdmittedReservedY1(String numAdmittedReservedY1) {
		this.numAdmittedReservedY1 = numAdmittedReservedY1;
	}
	public String getNumAdmittedReservedY2() {
		return numAdmittedReservedY2;
	}
	public void setNumAdmittedReservedY2(String numAdmittedReservedY2) {
		this.numAdmittedReservedY2 = numAdmittedReservedY2;
	}
	public String getNumAdmittedReservedY3() {
		return numAdmittedReservedY3;
	}
	public void setNumAdmittedReservedY3(String numAdmittedReservedY3) {
		this.numAdmittedReservedY3 = numAdmittedReservedY3;
	}
	public String getNumAdmittedReservedY4() {
		return numAdmittedReservedY4;
	}
	public void setNumAdmittedReservedY4(String numAdmittedReservedY4) {
		this.numAdmittedReservedY4 = numAdmittedReservedY4;
	}
	public String getNumAdmittedReservedY5() {
		return numAdmittedReservedY5;
	}
	public void setNumAdmittedReservedY5(String numAdmittedReservedY5) {
		this.numAdmittedReservedY5 = numAdmittedReservedY5;
	}
	public String getReservedSeatsByY1() {
		return reservedSeatsByY1;
	}
	public void setReservedSeatsByY1(String reservedSeatsByY1) {
		this.reservedSeatsByY1 = reservedSeatsByY1;
	}
	public String getReservedSeatsByY2() {
		return reservedSeatsByY2;
	}
	public void setReservedSeatsByY2(String reservedSeatsByY2) {
		this.reservedSeatsByY2 = reservedSeatsByY2;
	}
	public String getReservedSeatsByY3() {
		return reservedSeatsByY3;
	}
	public void setReservedSeatsByY3(String reservedSeatsByY3) {
		this.reservedSeatsByY3 = reservedSeatsByY3;
	}
	public String getReservedSeatsByY4() {
		return reservedSeatsByY4;
	}
	public void setReservedSeatsByY4(String reservedSeatsByY4) {
		this.reservedSeatsByY4 = reservedSeatsByY4;
	}
	public String getReservedSeatsByY5() {
		return reservedSeatsByY5;
	}
	public void setReservedSeatsByY5(String reservedSeatsByY5) {
		this.reservedSeatsByY5 = reservedSeatsByY5;
	}
	public String getInstDataTemplate_doc2() {
		return instDataTemplate_doc2;
	}
	public void setInstDataTemplate_doc2(String instDataTemplate_doc2) {
		this.instDataTemplate_doc2 = instDataTemplate_doc2;
	}
	public String getGovtLetter_doc() {
		return govtLetter_doc;
	}
	public void setGovtLetter_doc(String govtLetter_doc) {
		this.govtLetter_doc = govtLetter_doc;
	}
	public String getFinalAdmissionList() {
		return finalAdmissionList;
	}
	public void setFinalAdmissionList(String finalAdmissionList) {
		this.finalAdmissionList = finalAdmissionList;
	}
	public String getLinkForOtherRelivantDoc() {
		return linkForOtherRelivantDoc;
	}
	public void setLinkForOtherRelivantDoc(String linkForOtherRelivantDoc) {
		this.linkForOtherRelivantDoc = linkForOtherRelivantDoc;
	}
	public String getStuFTRatio() {
		return stuFTRatio;
	}
	public void setStuFTRatio(String stuFTRatio) {
		this.stuFTRatio = stuFTRatio;
	}
	public String getNumStudentsByY1() {
		return numStudentsByY1;
	}
	public void setNumStudentsByY1(String numStudentsByY1) {
		this.numStudentsByY1 = numStudentsByY1;
	}
	public String getNumStudentsByY2() {
		return numStudentsByY2;
	}
	public void setNumStudentsByY2(String numStudentsByY2) {
		this.numStudentsByY2 = numStudentsByY2;
	}
	public String getNumStudentsByY3() {
		return numStudentsByY3;
	}
	public void setNumStudentsByY3(String numStudentsByY3) {
		this.numStudentsByY3 = numStudentsByY3;
	}
	public String getNumStudentsByY4() {
		return numStudentsByY4;
	}
	public void setNumStudentsByY4(String numStudentsByY4) {
		this.numStudentsByY4 = numStudentsByY4;
	}
	public String getNumStudentsByY5() {
		return numStudentsByY5;
	}
	public void setNumStudentsByY5(String numStudentsByY5) {
		this.numStudentsByY5 = numStudentsByY5;
	}
	public String getNumFTTeachersY1() {
		return numFTTeachersY1;
	}
	public void setNumFTTeachersY1(String numFTTeachersY1) {
		this.numFTTeachersY1 = numFTTeachersY1;
	}
	public String getNumFTTeachersY2() {
		return numFTTeachersY2;
	}
	public void setNumFTTeachersY2(String numFTTeachersY2) {
		this.numFTTeachersY2 = numFTTeachersY2;
	}
	public String getNumFTTeachersY3() {
		return numFTTeachersY3;
	}
	public void setNumFTTeachersY3(String numFTTeachersY3) {
		this.numFTTeachersY3 = numFTTeachersY3;
	}
	public String getNumFTTeachersY4() {
		return numFTTeachersY4;
	}
	public void setNumFTTeachersY4(String numFTTeachersY4) {
		this.numFTTeachersY4 = numFTTeachersY4;
	}
	public String getNumFTTeachersY5() {
		return numFTTeachersY5;
	}
	public void setNumFTTeachersY5(String numFTTeachersY5) {
		this.numFTTeachersY5 = numFTTeachersY5;
	}
	public String getAdditionalInfo_doc() {
		return additionalInfo_doc;
	}
	public void setAdditionalInfo_doc(String additionalInfo_doc) {
		this.additionalInfo_doc = additionalInfo_doc;
	}
	public String getAdditionalInfoLink() {
		return additionalInfoLink;
	}
	public void setAdditionalInfoLink(String additionalInfoLink) {
		this.additionalInfoLink = additionalInfoLink;
	}
	public String getStdCentricMethods() {
		return stdCentricMethods;
	}
	public void setStdCentricMethods(String stdCentricMethods) {
		this.stdCentricMethods = stdCentricMethods;
	}
	public String getAdditionalInfo_doc2() {
		return additionalInfo_doc2;
	}
	public void setAdditionalInfo_doc2(String additionalInfo_doc2) {
		this.additionalInfo_doc2 = additionalInfo_doc2;
	}
	public String getAdditionalInfoLink2() {
		return additionalInfoLink2;
	}
	public void setAdditionalInfoLink2(String additionalInfoLink2) {
		this.additionalInfoLink2 = additionalInfoLink2;
	}
	public String getFTPTRatioLast5Years() {
		return FTPTRatioLast5Years;
	}
	public void setFTPTRatioLast5Years(String fTPTRatioLast5Years) {
		FTPTRatioLast5Years = fTPTRatioLast5Years;
	}
	public String getFtTeachersByY1() {
		return ftTeachersByY1;
	}
	public void setFtTeachersByY1(String ftTeachersByY1) {
		this.ftTeachersByY1 = ftTeachersByY1;
	}
	public String getFtTeachersByY2() {
		return ftTeachersByY2;
	}
	public void setFtTeachersByY2(String ftTeachersByY2) {
		this.ftTeachersByY2 = ftTeachersByY2;
	}
	public String getFtTeachersByY3() {
		return ftTeachersByY3;
	}
	public void setFtTeachersByY3(String ftTeachersByY3) {
		this.ftTeachersByY3 = ftTeachersByY3;
	}
	public String getFtTeachersByY4() {
		return ftTeachersByY4;
	}
	public void setFtTeachersByY4(String ftTeachersByY4) {
		this.ftTeachersByY4 = ftTeachersByY4;
	}
	public String getFtTeachersByY5() {
		return ftTeachersByY5;
	}
	public void setFtTeachersByY5(String ftTeachersByY5) {
		this.ftTeachersByY5 = ftTeachersByY5;
	}
	public String getNumPostsByY1() {
		return numPostsByY1;
	}
	public void setNumPostsByY1(String numPostsByY1) {
		this.numPostsByY1 = numPostsByY1;
	}
	public String getNumPostsByY2() {
		return numPostsByY2;
	}
	public void setNumPostsByY2(String numPostsByY2) {
		this.numPostsByY2 = numPostsByY2;
	}
	public String getNumPostsByY3() {
		return numPostsByY3;
	}
	public void setNumPostsByY3(String numPostsByY3) {
		this.numPostsByY3 = numPostsByY3;
	}
	public String getNumPostsByY4() {
		return numPostsByY4;
	}
	public void setNumPostsByY4(String numPostsByY4) {
		this.numPostsByY4 = numPostsByY4;
	}
	public String getNumPostsByY5() {
		return numPostsByY5;
	}
	public void setNumPostsByY5(String numPostsByY5) {
		this.numPostsByY5 = numPostsByY5;
	}
	public String getSanctionedPostsMap_doc() {
		return sanctionedPostsMap_doc;
	}
	public void setSanctionedPostsMap_doc(String sanctionedPostsMap_doc) {
		this.sanctionedPostsMap_doc = sanctionedPostsMap_doc;
	}
	public String getAdditionalInfoLink3() {
		return additionalInfoLink3;
	}
	public void setAdditionalInfoLink3(String additionalInfoLink3) {
		this.additionalInfoLink3 = additionalInfoLink3;
	}
	public String getPercFTTeachersLast5Years() {
		return percFTTeachersLast5Years;
	}
	public void setPercFTTeachersLast5Years(String percFTTeachersLast5Years) {
		this.percFTTeachersLast5Years = percFTTeachersLast5Years;
	}
	public String getNoFTTeachersWithDegreeY1() {
		return noFTTeachersWithDegreeY1;
	}
	public void setNoFTTeachersWithDegreeY1(String noFTTeachersWithDegreeY1) {
		this.noFTTeachersWithDegreeY1 = noFTTeachersWithDegreeY1;
	}
	public String getNoFTTeachersWithDegreeY2() {
		return noFTTeachersWithDegreeY2;
	}
	public void setNoFTTeachersWithDegreeY2(String noFTTeachersWithDegreeY2) {
		this.noFTTeachersWithDegreeY2 = noFTTeachersWithDegreeY2;
	}
	public String getNoFTTeachersWithDegreeY3() {
		return noFTTeachersWithDegreeY3;
	}
	public void setNoFTTeachersWithDegreeY3(String noFTTeachersWithDegreeY3) {
		this.noFTTeachersWithDegreeY3 = noFTTeachersWithDegreeY3;
	}
	public String getNoFTTeachersWithDegreeY4() {
		return noFTTeachersWithDegreeY4;
	}
	public void setNoFTTeachersWithDegreeY4(String noFTTeachersWithDegreeY4) {
		this.noFTTeachersWithDegreeY4 = noFTTeachersWithDegreeY4;
	}
	public String getNoFTTeachersWithDegreeY5() {
		return noFTTeachersWithDegreeY5;
	}
	public void setNoFTTeachersWithDegreeY5(String noFTTeachersWithDegreeY5) {
		this.noFTTeachersWithDegreeY5 = noFTTeachersWithDegreeY5;
	}
	public String getNoFTTY1() {
		return noFTTY1;
	}
	public void setNoFTTY1(String noFTTY1) {
		this.noFTTY1 = noFTTY1;
	}
	public String getNoFTTY2() {
		return noFTTY2;
	}
	public void setNoFTTY2(String noFTTY2) {
		this.noFTTY2 = noFTTY2;
	}
	public String getNoFTTY3() {
		return noFTTY3;
	}
	public void setNoFTTY3(String noFTTY3) {
		this.noFTTY3 = noFTTY3;
	}
	public String getNoFTTY4() {
		return noFTTY4;
	}
	public void setNoFTTY4(String noFTTY4) {
		this.noFTTY4 = noFTTY4;
	}
	public String getNoFTTY5() {
		return noFTTY5;
	}
	public void setNoFTTY5(String noFTTY5) {
		this.noFTTY5 = noFTTY5;
	}
	public String getInstDataTemplate_doc3() {
		return instDataTemplate_doc3;
	}
	public void setInstDataTemplate_doc3(String instDataTemplate_doc3) {
		this.instDataTemplate_doc3 = instDataTemplate_doc3;
	}
	public String getFacultyPhDList_doc() {
		return facultyPhDList_doc;
	}
	public void setFacultyPhDList_doc(String facultyPhDList_doc) {
		this.facultyPhDList_doc = facultyPhDList_doc;
	}
	public String getUgcRecognizedPhdDegrees_doc() {
		return ugcRecognizedPhdDegrees_doc;
	}
	public void setUgcRecognizedPhdDegrees_doc(String ugcRecognizedPhdDegrees_doc) {
		this.ugcRecognizedPhdDegrees_doc = ugcRecognizedPhdDegrees_doc;
	}
	public String getAdditionalInfoLink4() {
		return additionalInfoLink4;
	}
	public void setAdditionalInfoLink4(String additionalInfoLink4) {
		this.additionalInfoLink4 = additionalInfoLink4;
	}
	public String getTransAssessGrievSys() {
		return transAssessGrievSys;
	}
	public void setTransAssessGrievSys(String transAssessGrievSys) {
		this.transAssessGrievSys = transAssessGrievSys;
	}
	public String getAdditionalInfo_doc3() {
		return additionalInfo_doc3;
	}
	public void setAdditionalInfo_doc3(String additionalInfo_doc3) {
		this.additionalInfo_doc3 = additionalInfo_doc3;
	}
	public String getAdditionalInfoLink5() {
		return additionalInfoLink5;
	}
	public void setAdditionalInfoLink5(String additionalInfoLink5) {
		this.additionalInfoLink5 = additionalInfoLink5;
	}
	public String getPOsCOsListOutcome() {
		return POsCOsListOutcome;
	}
	public void setPOsCOsListOutcome(String pOsCOsListOutcome) {
		POsCOsListOutcome = pOsCOsListOutcome;
	}
	public String getAdditionalInfo_doc4() {
		return additionalInfo_doc4;
	}
	public void setAdditionalInfo_doc4(String additionalInfo_doc4) {
		this.additionalInfo_doc4 = additionalInfo_doc4;
	}
	public String getAdditionalInfoLink6() {
		return additionalInfoLink6;
	}
	public void setAdditionalInfoLink6(String additionalInfoLink6) {
		this.additionalInfoLink6 = additionalInfoLink6;
	}
	public String getEvaluatedPOsCOs() {
		return evaluatedPOsCOs;
	}
	public void setEvaluatedPOsCOs(String evaluatedPOsCOs) {
		this.evaluatedPOsCOs = evaluatedPOsCOs;
	}
	public String getAdditionalInfo_doc5() {
		return additionalInfo_doc5;
	}
	public void setAdditionalInfo_doc5(String additionalInfo_doc5) {
		this.additionalInfo_doc5 = additionalInfo_doc5;
	}
	public String getAdditionalInfoLink7() {
		return additionalInfoLink7;
	}
	public void setAdditionalInfoLink7(String additionalInfoLink7) {
		this.additionalInfoLink7 = additionalInfoLink7;
	}
	public String getPassPercentageLast5Years() {
		return passPercentageLast5Years;
	}
	public void setPassPercentageLast5Years(String passPercentageLast5Years) {
		this.passPercentageLast5Years = passPercentageLast5Years;
	}
	public String getNumPassedStudentsByY1() {
		return numPassedStudentsByY1;
	}
	public void setNumPassedStudentsByY1(String numPassedStudentsByY1) {
		this.numPassedStudentsByY1 = numPassedStudentsByY1;
	}
	public String getNumPassedStudentsByY2() {
		return numPassedStudentsByY2;
	}
	public void setNumPassedStudentsByY2(String numPassedStudentsByY2) {
		this.numPassedStudentsByY2 = numPassedStudentsByY2;
	}
	public String getNumPassedStudentsByY3() {
		return numPassedStudentsByY3;
	}
	public void setNumPassedStudentsByY3(String numPassedStudentsByY3) {
		this.numPassedStudentsByY3 = numPassedStudentsByY3;
	}
	public String getNumPassedStudentsByY4() {
		return numPassedStudentsByY4;
	}
	public void setNumPassedStudentsByY4(String numPassedStudentsByY4) {
		this.numPassedStudentsByY4 = numPassedStudentsByY4;
	}
	public String getNumPassedStudentsByY5() {
		return numPassedStudentsByY5;
	}
	public void setNumPassedStudentsByY5(String numPassedStudentsByY5) {
		this.numPassedStudentsByY5 = numPassedStudentsByY5;
	}
	public String getNumFinalYearStudentsByY1() {
		return numFinalYearStudentsByY1;
	}
	public void setNumFinalYearStudentsByY1(String numFinalYearStudentsByY1) {
		this.numFinalYearStudentsByY1 = numFinalYearStudentsByY1;
	}
	public String getNumFinalYearStudentsByY2() {
		return numFinalYearStudentsByY2;
	}
	public void setNumFinalYearStudentsByY2(String numFinalYearStudentsByY2) {
		this.numFinalYearStudentsByY2 = numFinalYearStudentsByY2;
	}
	public String getNumFinalYearStudentsByY3() {
		return numFinalYearStudentsByY3;
	}
	public void setNumFinalYearStudentsByY3(String numFinalYearStudentsByY3) {
		this.numFinalYearStudentsByY3 = numFinalYearStudentsByY3;
	}
	public String getNumFinalYearStudentsByY4() {
		return numFinalYearStudentsByY4;
	}
	public void setNumFinalYearStudentsByY4(String numFinalYearStudentsByY4) {
		this.numFinalYearStudentsByY4 = numFinalYearStudentsByY4;
	}
	public String getNumFinalYearStudentsByY5() {
		return numFinalYearStudentsByY5;
	}
	public void setNumFinalYearStudentsByY5(String numFinalYearStudentsByY5) {
		this.numFinalYearStudentsByY5 = numFinalYearStudentsByY5;
	}
	public String getInstDataTemplate_doc4() {
		return instDataTemplate_doc4;
	}
	public void setInstDataTemplate_doc4(String instDataTemplate_doc4) {
		this.instDataTemplate_doc4 = instDataTemplate_doc4;
	}
	public String getCoeReportPassPercentage_doc() {
		return coeReportPassPercentage_doc;
	}
	public void setCoeReportPassPercentage_doc(String coeReportPassPercentage_doc) {
		this.coeReportPassPercentage_doc = coeReportPassPercentage_doc;
	}
	public String getCoePassPercentReport_doc() {
		return coePassPercentReport_doc;
	}
	public void setCoePassPercentReport_doc(String coePassPercentReport_doc) {
		this.coePassPercentReport_doc = coePassPercentReport_doc;
	}
	public String getAdditionalInfoLink8() {
		return additionalInfoLink8;
	}
	public void setAdditionalInfoLink8(String additionalInfoLink8) {
		this.additionalInfoLink8 = additionalInfoLink8;
	}
	
	
}
