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
	
	private String instiPresDataTemplate_doc;//
	
	private String instDataTemplate_doc;//
	private String intakeSanctionApproval_doc;//
	private String finalAdmissionList_doc;//
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
	
	private String instDataTemplate_doc2;//
	private String govtLetter_doc;//
	private String finalAdmiList_Doc60;//change
	private String relevantDocLink;//
	
//	2.2.1
	private String studentAssessmentAndPrograms;//change
	private String additionalInfo_doc;//
	private String additionalInfoLink;
	private String fullTimeTeachRation;//change

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
	private String additionalInfo_Doc80;//change
	private String additionalInfoLink9;//change

	
//	2.3.1
	private String stdCentricMethods;
	private String additionalInfo_doc86;//
	private String additionalInfoLink2;
	private String mentorMenteeScheme;//changed
	private String additionalInfo_Doc2;//changed
	private String listOfActvMentor_Doc;//changed
	
//	2.4.1	
	private String FTPTRatioLast5Years;
	private String ftTeachersByY1;
	private String ftTeachersByY2;
	private String ftTeachersByY3;
	private String ftTeachersByY4;
	private String ftTeachersByY5;
	private String sanctionedPostsMap_doc;//
	private String additionalInfoLink3;
	private String numPostsByY1;
	private String numPostsByY2;
	private String numPostsByY3;
	private String numPostsByY4;
	private String numPostsByY5;

	
 
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
	
	private String instDataTemplate_doc3;//
	private String additionalInfoLink4;
//	2.5.1	
	private String avgDaysFromExamToResults;//changed
	private String avgDaysFromExamToResultsY1;//changed
	private String avgDaysFromExamToResultsY2;//changed
	private String avgDaysFromExamToResultsY3;//changed
	private String avgDaysFromExamToResultsY4;//changed
	private String avgDaysFromExamToResultsY5;//changed
	private String additionalInfo_doc3;//
	private String additionalInfoLink5;
	private String evalComplaintsPercentage;//changed
	private String complaintsPerYear1;//changed
	private String complaintsPerYear2;//changed
	private String complaintsPerYear3;//changed
	private String complaintsPerYear4;//changed
	private String complaintsPerYear5;//changed
	private String stuAppearedInExamLastY1;//changed
	private String stuAppearedInExamLastY2;//changed
	private String stuAppearedInExamLastY3;//changed
	private String stuAppearedInExamLastY4;//changed
	private String stuAppearedInExamLastY5;//changed
	private String instDataTemplate_doc5;//changed
	private String relevantDocLink3;//changed
	private String automExamStatus;// changed 
	private String automationType;//changed
	private String dataTemp_Doc;//changed
	private String addItionalInfoLinks;//changed



//	2.6.1
	private String POsCOsListOutcome;
	private String additionalInfo_doc4;//
	private String additionalInfoLink6;
	private String cosForAllCoursesDoc;//changed
//	2.6.2
	public String passPercentExcludBack;//changed
	public String passedFinalYearStudentsY1;//changed
	public String passedFinalYearStudentsY2;//changed
	public String passedFinalYearStudentsY3;//changed
	public String passedFinalYearStudentsY4;//changed
	public String passedFinalYearStudentsY5;//changed
	public String yearWiseOutgoingStudentsY1;//chnaged
	public String yearWiseOutgoingStudentsY2;//chnaged
	public String yearWiseOutgoingStudentsY3;//chnaged
	public String yearWiseOutgoingStudentsY4;//chnaged
	public String yearWiseOutgoingStudentsY5;//chnaged
	private String additionalInfo_doc5;//
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
	
	private String dataTemplate_doc;//
	private String coeReportPassPercentage_doc;//
	private String coePassPercentReport_doc;//
	private String additionalInfoLink8;
	// 2.7
	private String onlineStudentSurveyTL;//chnaged
	private String additionalIfoDoc;//changed
	private String currentlyEnrolledStudDoc;//chnaged


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
	

	public String getInstiPresDataTemplate_doc() {
		return instiPresDataTemplate_doc;
	}
	public void setInstiPresDataTemplate_doc(String instiPresDataTemplate_doc) {
		this.instiPresDataTemplate_doc = instiPresDataTemplate_doc;
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
	public String getFinalAdmissionList_doc2() {
		return finalAdmissionList_doc2;
	}
	public void setFinalAdmissionList_doc2(String finalAdmissionList_doc2) {
		this.finalAdmissionList_doc2 = finalAdmissionList_doc2;
	}
	public String getLinksForAnyOtherRelevant() {
		return linksForAnyOtherRelevant;
	}
	public void setLinksForAnyOtherRelevant(String linksForAnyOtherRelevant) {
		this.linksForAnyOtherRelevant = linksForAnyOtherRelevant;
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
	
	public String getFinalAdmiList_Doc60() {
		return finalAdmiList_Doc60;
	}
	public void setFinalAdmiList_Doc60(String finalAdmiList_Doc60) {
		this.finalAdmiList_Doc60 = finalAdmiList_Doc60;
	}
	public String getRelevantDocLink() {
		return relevantDocLink;
	}
	public void setRelevantDocLink(String relevantDocLink) {
		this.relevantDocLink = relevantDocLink;
	}
	public String getStudentAssessmentAndPrograms() {
		return studentAssessmentAndPrograms;
	}
	public void setStudentAssessmentAndPrograms(String studentAssessmentAndPrograms) {
		this.studentAssessmentAndPrograms = studentAssessmentAndPrograms;
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
	public String getFullTimeTeachRation() {
		return fullTimeTeachRation;
	}
	public void setFullTimeTeachRation(String fullTimeTeachRation) {
		this.fullTimeTeachRation = fullTimeTeachRation;
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
	public String getAdditionalInfo_Doc80() {
		return additionalInfo_Doc80;
	}
	public void setAdditionalInfo_Doc80(String additionalInfo_Doc80) {
		this.additionalInfo_Doc80 = additionalInfo_Doc80;
	}
	public String getAdditionalInfoLink9() {
		return additionalInfoLink9;
	}
	public void setAdditionalInfoLink9(String additionalInfoLink9) {
		this.additionalInfoLink9 = additionalInfoLink9;
	}
	public String getStdCentricMethods() {
		return stdCentricMethods;
	}
	public void setStdCentricMethods(String stdCentricMethods) {
		this.stdCentricMethods = stdCentricMethods;
	}
	public String getAdditionalInfo_doc86() {
		return additionalInfo_doc86;
	}
	public void setAdditionalInfo_doc86(String additionalInfo_doc86) {
		this.additionalInfo_doc86 = additionalInfo_doc86;
	}
	public String getAdditionalInfoLink2() {
		return additionalInfoLink2;
	}
	public void setAdditionalInfoLink2(String additionalInfoLink2) {
		this.additionalInfoLink2 = additionalInfoLink2;
	}
	public String getMentorMenteeScheme() {
		return mentorMenteeScheme;
	}
	public void setMentorMenteeScheme(String mentorMenteeScheme) {
		this.mentorMenteeScheme = mentorMenteeScheme;
	}
	public String getAdditionalInfo_Doc2() {
		return additionalInfo_Doc2;
	}
	public void setAdditionalInfo_Doc2(String additionalInfo_Doc2) {
		this.additionalInfo_Doc2 = additionalInfo_Doc2;
	}
	public String getListOfActvMentor_Doc() {
		return listOfActvMentor_Doc;
	}
	public void setListOfActvMentor_Doc(String listOfActvMentor_Doc) {
		this.listOfActvMentor_Doc = listOfActvMentor_Doc;
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
	public String getAdditionalInfoLink4() {
		return additionalInfoLink4;
	}
	public void setAdditionalInfoLink4(String additionalInfoLink4) {
		this.additionalInfoLink4 = additionalInfoLink4;
	}
	public String getAvgDaysFromExamToResults() {
		return avgDaysFromExamToResults;
	}
	public void setAvgDaysFromExamToResults(String avgDaysFromExamToResults) {
		this.avgDaysFromExamToResults = avgDaysFromExamToResults;
	}
	public String getAvgDaysFromExamToResultsY1() {
		return avgDaysFromExamToResultsY1;
	}
	public void setAvgDaysFromExamToResultsY1(String avgDaysFromExamToResultsY1) {
		this.avgDaysFromExamToResultsY1 = avgDaysFromExamToResultsY1;
	}
	public String getAvgDaysFromExamToResultsY2() {
		return avgDaysFromExamToResultsY2;
	}
	public void setAvgDaysFromExamToResultsY2(String avgDaysFromExamToResultsY2) {
		this.avgDaysFromExamToResultsY2 = avgDaysFromExamToResultsY2;
	}
	public String getAvgDaysFromExamToResultsY3() {
		return avgDaysFromExamToResultsY3;
	}
	public void setAvgDaysFromExamToResultsY3(String avgDaysFromExamToResultsY3) {
		this.avgDaysFromExamToResultsY3 = avgDaysFromExamToResultsY3;
	}
	public String getAvgDaysFromExamToResultsY4() {
		return avgDaysFromExamToResultsY4;
	}
	public void setAvgDaysFromExamToResultsY4(String avgDaysFromExamToResultsY4) {
		this.avgDaysFromExamToResultsY4 = avgDaysFromExamToResultsY4;
	}
	public String getAvgDaysFromExamToResultsY5() {
		return avgDaysFromExamToResultsY5;
	}
	public void setAvgDaysFromExamToResultsY5(String avgDaysFromExamToResultsY5) {
		this.avgDaysFromExamToResultsY5 = avgDaysFromExamToResultsY5;
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
	public String getEvalComplaintsPercentage() {
		return evalComplaintsPercentage;
	}
	public void setEvalComplaintsPercentage(String evalComplaintsPercentage) {
		this.evalComplaintsPercentage = evalComplaintsPercentage;
	}
	public String getComplaintsPerYear1() {
		return complaintsPerYear1;
	}
	public void setComplaintsPerYear1(String complaintsPerYear1) {
		this.complaintsPerYear1 = complaintsPerYear1;
	}
	public String getComplaintsPerYear2() {
		return complaintsPerYear2;
	}
	public void setComplaintsPerYear2(String complaintsPerYear2) {
		this.complaintsPerYear2 = complaintsPerYear2;
	}
	public String getComplaintsPerYear3() {
		return complaintsPerYear3;
	}
	public void setComplaintsPerYear3(String complaintsPerYear3) {
		this.complaintsPerYear3 = complaintsPerYear3;
	}
	public String getComplaintsPerYear4() {
		return complaintsPerYear4;
	}
	public void setComplaintsPerYear4(String complaintsPerYear4) {
		this.complaintsPerYear4 = complaintsPerYear4;
	}
	public String getComplaintsPerYear5() {
		return complaintsPerYear5;
	}
	public void setComplaintsPerYear5(String complaintsPerYear5) {
		this.complaintsPerYear5 = complaintsPerYear5;
	}
	public String getStuAppearedInExamLastY1() {
		return stuAppearedInExamLastY1;
	}
	public void setStuAppearedInExamLastY1(String stuAppearedInExamLastY1) {
		this.stuAppearedInExamLastY1 = stuAppearedInExamLastY1;
	}
	public String getStuAppearedInExamLastY2() {
		return stuAppearedInExamLastY2;
	}
	public void setStuAppearedInExamLastY2(String stuAppearedInExamLastY2) {
		this.stuAppearedInExamLastY2 = stuAppearedInExamLastY2;
	}
	public String getStuAppearedInExamLastY3() {
		return stuAppearedInExamLastY3;
	}
	public void setStuAppearedInExamLastY3(String stuAppearedInExamLastY3) {
		this.stuAppearedInExamLastY3 = stuAppearedInExamLastY3;
	}
	public String getStuAppearedInExamLastY4() {
		return stuAppearedInExamLastY4;
	}
	public void setStuAppearedInExamLastY4(String stuAppearedInExamLastY4) {
		this.stuAppearedInExamLastY4 = stuAppearedInExamLastY4;
	}
	public String getStuAppearedInExamLastY5() {
		return stuAppearedInExamLastY5;
	}
	public void setStuAppearedInExamLastY5(String stuAppearedInExamLastY5) {
		this.stuAppearedInExamLastY5 = stuAppearedInExamLastY5;
	}
	public String getInstDataTemplate_doc5() {
		return instDataTemplate_doc5;
	}
	public void setInstDataTemplate_doc5(String instDataTemplate_doc5) {
		this.instDataTemplate_doc5 = instDataTemplate_doc5;
	}
	public String getRelevantDocLink3() {
		return relevantDocLink3;
	}
	public void setRelevantDocLink3(String relevantDocLink3) {
		this.relevantDocLink3 = relevantDocLink3;
	}
	public String getAutomExamStatus() {
		return automExamStatus;
	}
	public void setAutomExamStatus(String automExamStatus) {
		this.automExamStatus = automExamStatus;
	}
	public String getAutomationType() {
		return automationType;
	}
	public void setAutomationType(String automationType) {
		this.automationType = automationType;
	}
	

	public String getDataTemp_Doc() {
		return dataTemp_Doc;
	}
	public void setDataTemp_Doc(String dataTemp_Doc) {
		this.dataTemp_Doc = dataTemp_Doc;
	}
	public String getAddItionalInfoLinks() {
		return addItionalInfoLinks;
	}
	public void setAddItionalInfoLinks(String addItionalInfoLinks) {
		this.addItionalInfoLinks = addItionalInfoLinks;
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
	public String getCosForAllCoursesDoc() {
		return cosForAllCoursesDoc;
	}
	public void setCosForAllCoursesDoc(String cosForAllCoursesDoc) {
		this.cosForAllCoursesDoc = cosForAllCoursesDoc;
	}
	public String getPassPercentExcludBack() {
		return passPercentExcludBack;
	}
	public void setPassPercentExcludBack(String passPercentExcludBack) {
		this.passPercentExcludBack = passPercentExcludBack;
	}
	public String getPassedFinalYearStudentsY1() {
		return passedFinalYearStudentsY1;
	}
	public void setPassedFinalYearStudentsY1(String passedFinalYearStudentsY1) {
		this.passedFinalYearStudentsY1 = passedFinalYearStudentsY1;
	}
	public String getPassedFinalYearStudentsY2() {
		return passedFinalYearStudentsY2;
	}
	public void setPassedFinalYearStudentsY2(String passedFinalYearStudentsY2) {
		this.passedFinalYearStudentsY2 = passedFinalYearStudentsY2;
	}
	public String getPassedFinalYearStudentsY3() {
		return passedFinalYearStudentsY3;
	}
	public void setPassedFinalYearStudentsY3(String passedFinalYearStudentsY3) {
		this.passedFinalYearStudentsY3 = passedFinalYearStudentsY3;
	}
	public String getPassedFinalYearStudentsY4() {
		return passedFinalYearStudentsY4;
	}
	public void setPassedFinalYearStudentsY4(String passedFinalYearStudentsY4) {
		this.passedFinalYearStudentsY4 = passedFinalYearStudentsY4;
	}
	public String getPassedFinalYearStudentsY5() {
		return passedFinalYearStudentsY5;
	}
	public void setPassedFinalYearStudentsY5(String passedFinalYearStudentsY5) {
		this.passedFinalYearStudentsY5 = passedFinalYearStudentsY5;
	}
	public String getYearWiseOutgoingStudentsY1() {
		return yearWiseOutgoingStudentsY1;
	}
	public void setYearWiseOutgoingStudentsY1(String yearWiseOutgoingStudentsY1) {
		this.yearWiseOutgoingStudentsY1 = yearWiseOutgoingStudentsY1;
	}
	public String getYearWiseOutgoingStudentsY2() {
		return yearWiseOutgoingStudentsY2;
	}
	public void setYearWiseOutgoingStudentsY2(String yearWiseOutgoingStudentsY2) {
		this.yearWiseOutgoingStudentsY2 = yearWiseOutgoingStudentsY2;
	}
	public String getYearWiseOutgoingStudentsY3() {
		return yearWiseOutgoingStudentsY3;
	}
	public void setYearWiseOutgoingStudentsY3(String yearWiseOutgoingStudentsY3) {
		this.yearWiseOutgoingStudentsY3 = yearWiseOutgoingStudentsY3;
	}
	public String getYearWiseOutgoingStudentsY4() {
		return yearWiseOutgoingStudentsY4;
	}
	public void setYearWiseOutgoingStudentsY4(String yearWiseOutgoingStudentsY4) {
		this.yearWiseOutgoingStudentsY4 = yearWiseOutgoingStudentsY4;
	}
	public String getYearWiseOutgoingStudentsY5() {
		return yearWiseOutgoingStudentsY5;
	}
	public void setYearWiseOutgoingStudentsY5(String yearWiseOutgoingStudentsY5) {
		this.yearWiseOutgoingStudentsY5 = yearWiseOutgoingStudentsY5;
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
	
	public String getDataTemplate_doc() {
		return dataTemplate_doc;
	}
	public void setDataTemplate_doc(String dataTemplate_doc) {
		this.dataTemplate_doc = dataTemplate_doc;
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
	public String getOnlineStudentSurveyTL() {
		return onlineStudentSurveyTL;
	}
	public void setOnlineStudentSurveyTL(String onlineStudentSurveyTL) {
		this.onlineStudentSurveyTL = onlineStudentSurveyTL;
	}
	public String getAdditionalIfoDoc() {
		return additionalIfoDoc;
	}
	public void setAdditionalIfoDoc(String additionalIfoDoc) {
		this.additionalIfoDoc = additionalIfoDoc;
	}
	public String getCurrentlyEnrolledStudDoc() {
		return currentlyEnrolledStudDoc;
	}
	public void setCurrentlyEnrolledStudDoc(String currentlyEnrolledStudDoc) {
		this.currentlyEnrolledStudDoc = currentlyEnrolledStudDoc;
	}
	
	
	
	
	
}
