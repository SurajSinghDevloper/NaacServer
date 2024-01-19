package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Qif {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long qifID;
	private long ssrID;
	private long collegeID;
	private String relevantDevNeedsPOsCOs;
	private String uploadAdditionalInfoDoc;
	private String additionalInfoLink;
	private String skillDevInstitProgram;
	private String uploadAdditionalInfoDoc2;
	private String additionalInfoLink2;
	private String newCoursesPercentage;
	private String numNewCoursesY1;
	private String numNewCoursesY2;
	private String numNewCoursesY3;
	private String numNewCoursesY4;
	private String numNewCoursesY5;
	private String uniqueCourseCountY1;
	private String uniqueCourseCountY2;
	private String uniqueCourseCountY3;
	private String uniqueCourseCountY4;
	private String uniqueCourseCountY5;
	private String instDataFormatDoc;
	private String instWebDisclosureDoc;
	private String bosMeetingMinutesDoc;
	private String academicCouncilEndorDoc;
	private String linkForAnyReleventDoc;
	private String curriculumIntegration;
	private String additionalInfoDoc;
	private String linkForAdditionalInfo;
	// bacha hua hai
	private String numCertCoursesCompleted;
	private String numCertCoursesCompletedY1;
	private String numCertCoursesCompletedY2;
	private String numCertCoursesCompletedY3;
	private String numCertCoursesCompletedY4;
	private String numCertCoursesCompletedY5;
	private String institutionalWebsiteInfoDoc;
	private String programBrochureNoticeDoc;
	private String studentsAttendanceListDOC;
	private String courseCompletionEvidenceDOC;
	private String institutionalDataFormatDOC;
	private String supportingDocumentLink;

	private String projInternPercent;
	private String totProgWithFieldProjY1;
	private String totProgWithFieldProjY2;
	private String totProgWithFieldProjY3;
	private String totProgWithFieldProjY4;
	private String totProgWithFieldProjY5;

	private String totalUniqueProgramsY1;
	private String totalUniqueProgramsY2;
	private String totalUniqueProgramsY3;
	private String totalUniqueProgramsY4;
	private String totalUniqueProgramsY5;
	private String institutionalDataFormatDoc2;
	private String progContWithBOSProjDoc;
	private String InternCompleLetterDoc;
	private String EvaluatedProjReportDoc;
	private String relevantDocLink;
	// 1.4. Feedback System
	private String feedbackForCurriculum;
	private String feedbackAnalysisActionComm;
	private String institutionalDataFormatDoc3;
	private String feedFormDiffStakeHoldersDoc;
	private String feedbackAnalysisReportDoc;
	private String actionTakenReportDoc;
	private String linkOfInstitutionWebsite;
	private String linkForRelevant;
	private String completed;
	private String verified;

	// getter and setter

	public long getQifID() {
		return qifID;
	}

	public void setQifID(long qifID) {
		this.qifID = qifID;
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

	public String getRelevantDevNeedsPOsCOs() {
		return relevantDevNeedsPOsCOs;
	}

	public void setRelevantDevNeedsPOsCOs(String relevantDevNeedsPOsCOs) {
		this.relevantDevNeedsPOsCOs = relevantDevNeedsPOsCOs;
	}

	public String getUploadAdditionalInfoDoc() {
		return uploadAdditionalInfoDoc;
	}

	public void setUploadAdditionalInfoDoc(String uploadAdditionalInfoDoc) {
		this.uploadAdditionalInfoDoc = uploadAdditionalInfoDoc;
	}

	public String getAdditionalInfoLink() {
		return additionalInfoLink;
	}

	public void setAdditionalInfoLink(String additionalInfoLink) {
		this.additionalInfoLink = additionalInfoLink;
	}

	public String getSkillDevInstitProgram() {
		return skillDevInstitProgram;
	}

	public void setSkillDevInstitProgram(String skillDevInstitProgram) {
		this.skillDevInstitProgram = skillDevInstitProgram;
	}

	public String getUploadAdditionalInfoDoc2() {
		return uploadAdditionalInfoDoc2;
	}

	public void setUploadAdditionalInfoDoc2(String uploadAdditionalInfoDoc2) {
		this.uploadAdditionalInfoDoc2 = uploadAdditionalInfoDoc2;
	}

	public String getAdditionalInfoLink2() {
		return additionalInfoLink2;
	}

	public void setAdditionalInfoLink2(String additionalInfoLink2) {
		this.additionalInfoLink2 = additionalInfoLink2;
	}

	public String getNewCoursesPercentage() {
		return newCoursesPercentage;
	}

	public void setNewCoursesPercentage(String newCoursesPercentage) {
		this.newCoursesPercentage = newCoursesPercentage;
	}

	public String getNumNewCoursesY1() {
		return numNewCoursesY1;
	}

	public void setNumNewCoursesY1(String numNewCoursesY1) {
		this.numNewCoursesY1 = numNewCoursesY1;
	}

	public String getNumNewCoursesY2() {
		return numNewCoursesY2;
	}

	public void setNumNewCoursesY2(String numNewCoursesY2) {
		this.numNewCoursesY2 = numNewCoursesY2;
	}

	public String getNumNewCoursesY3() {
		return numNewCoursesY3;
	}

	public void setNumNewCoursesY3(String numNewCoursesY3) {
		this.numNewCoursesY3 = numNewCoursesY3;
	}

	public String getNumNewCoursesY4() {
		return numNewCoursesY4;
	}

	public void setNumNewCoursesY4(String numNewCoursesY4) {
		this.numNewCoursesY4 = numNewCoursesY4;
	}

	public String getNumNewCoursesY5() {
		return numNewCoursesY5;
	}

	public void setNumNewCoursesY5(String numNewCoursesY5) {
		this.numNewCoursesY5 = numNewCoursesY5;
	}

	public String getUniqueCourseCountY1() {
		return uniqueCourseCountY1;
	}

	public void setUniqueCourseCountY1(String uniqueCourseCountY1) {
		this.uniqueCourseCountY1 = uniqueCourseCountY1;
	}

	public String getUniqueCourseCountY2() {
		return uniqueCourseCountY2;
	}

	public void setUniqueCourseCountY2(String uniqueCourseCountY2) {
		this.uniqueCourseCountY2 = uniqueCourseCountY2;
	}

	public String getUniqueCourseCountY3() {
		return uniqueCourseCountY3;
	}

	public void setUniqueCourseCountY3(String uniqueCourseCountY3) {
		this.uniqueCourseCountY3 = uniqueCourseCountY3;
	}

	public String getUniqueCourseCountY4() {
		return uniqueCourseCountY4;
	}

	public void setUniqueCourseCountY4(String uniqueCourseCountY4) {
		this.uniqueCourseCountY4 = uniqueCourseCountY4;
	}

	public String getUniqueCourseCountY5() {
		return uniqueCourseCountY5;
	}

	public void setUniqueCourseCountY5(String uniqueCourseCountY5) {
		this.uniqueCourseCountY5 = uniqueCourseCountY5;
	}

	

	public String getInstDataFormatDoc() {
		return instDataFormatDoc;
	}

	public void setInstDataFormatDoc(String instDataFormatDoc) {
		this.instDataFormatDoc = instDataFormatDoc;
	}

	public String getInstWebDisclosureDoc() {
		return instWebDisclosureDoc;
	}

	public void setInstWebDisclosureDoc(String instWebDisclosureDoc) {
		this.instWebDisclosureDoc = instWebDisclosureDoc;
	}

	public String getBosMeetingMinutesDoc() {
		return bosMeetingMinutesDoc;
	}

	public void setBosMeetingMinutesDoc(String bosMeetingMinutesDoc) {
		this.bosMeetingMinutesDoc = bosMeetingMinutesDoc;
	}

	public String getAcademicCouncilEndorDoc() {
		return academicCouncilEndorDoc;
	}

	public void setAcademicCouncilEndorDoc(String academicCouncilEndorDoc) {
		this.academicCouncilEndorDoc = academicCouncilEndorDoc;
	}

	public String getLinkForAnyReleventDoc() {
		return linkForAnyReleventDoc;
	}

	public void setLinkForAnyReleventDoc(String linkForAnyReleventDoc) {
		this.linkForAnyReleventDoc = linkForAnyReleventDoc;
	}

	public String getCurriculumIntegration() {
		return curriculumIntegration;
	}

	public void setCurriculumIntegration(String curriculumIntegration) {
		this.curriculumIntegration = curriculumIntegration;
	}

	public String getAdditionalInfoDoc() {
		return additionalInfoDoc;
	}

	public void setAdditionalInfoDoc(String additionalInfoDoc) {
		this.additionalInfoDoc = additionalInfoDoc;
	}

	public String getLinkForAdditionalInfo() {
		return linkForAdditionalInfo;
	}

	public void setLinkForAdditionalInfo(String linkForAdditionalInfo) {
		this.linkForAdditionalInfo = linkForAdditionalInfo;
	}

	public String getNumCertCoursesCompleted() {
		return numCertCoursesCompleted;
	}

	public void setNumCertCoursesCompleted(String numCertCoursesCompleted) {
		this.numCertCoursesCompleted = numCertCoursesCompleted;
	}

	public String getNumCertCoursesCompletedY1() {
		return numCertCoursesCompletedY1;
	}

	public void setNumCertCoursesCompletedY1(String numCertCoursesCompletedY1) {
		this.numCertCoursesCompletedY1 = numCertCoursesCompletedY1;
	}

	public String getNumCertCoursesCompletedY2() {
		return numCertCoursesCompletedY2;
	}

	public void setNumCertCoursesCompletedY2(String numCertCoursesCompletedY2) {
		this.numCertCoursesCompletedY2 = numCertCoursesCompletedY2;
	}

	public String getNumCertCoursesCompletedY3() {
		return numCertCoursesCompletedY3;
	}

	public void setNumCertCoursesCompletedY3(String numCertCoursesCompletedY3) {
		this.numCertCoursesCompletedY3 = numCertCoursesCompletedY3;
	}

	public String getNumCertCoursesCompletedY4() {
		return numCertCoursesCompletedY4;
	}

	public void setNumCertCoursesCompletedY4(String numCertCoursesCompletedY4) {
		this.numCertCoursesCompletedY4 = numCertCoursesCompletedY4;
	}

	public String getNumCertCoursesCompletedY5() {
		return numCertCoursesCompletedY5;
	}

	public void setNumCertCoursesCompletedY5(String numCertCoursesCompletedY5) {
		this.numCertCoursesCompletedY5 = numCertCoursesCompletedY5;
	}

	public String getInstitutionalWebsiteInfoDoc() {
		return institutionalWebsiteInfoDoc;
	}

	public void setInstitutionalWebsiteInfoDoc(String institutionalWebsiteInfoDoc) {
		this.institutionalWebsiteInfoDoc = institutionalWebsiteInfoDoc;
	}

	public String getProgramBrochureNoticeDoc() {
		return programBrochureNoticeDoc;
	}

	public void setProgramBrochureNoticeDoc(String programBrochureNoticeDoc) {
		this.programBrochureNoticeDoc = programBrochureNoticeDoc;
	}

	public String getStudentsAttendanceListDOC() {
		return studentsAttendanceListDOC;
	}

	public void setStudentsAttendanceListDOC(String studentsAttendanceListDOC) {
		this.studentsAttendanceListDOC = studentsAttendanceListDOC;
	}

	public String getCourseCompletionEvidenceDOC() {
		return courseCompletionEvidenceDOC;
	}

	public void setCourseCompletionEvidenceDOC(String courseCompletionEvidenceDOC) {
		this.courseCompletionEvidenceDOC = courseCompletionEvidenceDOC;
	}

	public String getInstitutionalDataFormatDOC() {
		return institutionalDataFormatDOC;
	}

	public void setInstitutionalDataFormatDOC(String institutionalDataFormatDOC) {
		this.institutionalDataFormatDOC = institutionalDataFormatDOC;
	}

	public String getSupportingDocumentLink() {
		return supportingDocumentLink;
	}

	public void setSupportingDocumentLink(String supportingDocumentLink) {
		this.supportingDocumentLink = supportingDocumentLink;
	}

	public String getProjInternPercent() {
		return projInternPercent;
	}

	public void setProjInternPercent(String projInternPercent) {
		this.projInternPercent = projInternPercent;
	}

	public String getTotProgWithFieldProjY1() {
		return totProgWithFieldProjY1;
	}

	public void setTotProgWithFieldProjY1(String totProgWithFieldProjY1) {
		this.totProgWithFieldProjY1 = totProgWithFieldProjY1;
	}

	public String getTotProgWithFieldProjY2() {
		return totProgWithFieldProjY2;
	}

	public void setTotProgWithFieldProjY2(String totProgWithFieldProjY2) {
		this.totProgWithFieldProjY2 = totProgWithFieldProjY2;
	}

	public String getTotProgWithFieldProjY3() {
		return totProgWithFieldProjY3;
	}

	public void setTotProgWithFieldProjY3(String totProgWithFieldProjY3) {
		this.totProgWithFieldProjY3 = totProgWithFieldProjY3;
	}

	public String getTotProgWithFieldProjY4() {
		return totProgWithFieldProjY4;
	}

	public void setTotProgWithFieldProjY4(String totProgWithFieldProjY4) {
		this.totProgWithFieldProjY4 = totProgWithFieldProjY4;
	}

	public String getTotProgWithFieldProjY5() {
		return totProgWithFieldProjY5;
	}

	public void setTotProgWithFieldProjY5(String totProgWithFieldProjY5) {
		this.totProgWithFieldProjY5 = totProgWithFieldProjY5;
	}

	public String getTotalUniqueProgramsY1() {
		return totalUniqueProgramsY1;
	}

	public void setTotalUniqueProgramsY1(String totalUniqueProgramsY1) {
		this.totalUniqueProgramsY1 = totalUniqueProgramsY1;
	}

	public String getTotalUniqueProgramsY2() {
		return totalUniqueProgramsY2;
	}

	public void setTotalUniqueProgramsY2(String totalUniqueProgramsY2) {
		this.totalUniqueProgramsY2 = totalUniqueProgramsY2;
	}

	public String getTotalUniqueProgramsY3() {
		return totalUniqueProgramsY3;
	}

	public void setTotalUniqueProgramsY3(String totalUniqueProgramsY3) {
		this.totalUniqueProgramsY3 = totalUniqueProgramsY3;
	}

	public String getTotalUniqueProgramsY4() {
		return totalUniqueProgramsY4;
	}

	public void setTotalUniqueProgramsY4(String totalUniqueProgramsY4) {
		this.totalUniqueProgramsY4 = totalUniqueProgramsY4;
	}

	public String getTotalUniqueProgramsY5() {
		return totalUniqueProgramsY5;
	}

	public void setTotalUniqueProgramsY5(String totalUniqueProgramsY5) {
		this.totalUniqueProgramsY5 = totalUniqueProgramsY5;
	}

	public String getInstitutionalDataFormatDoc2() {
		return institutionalDataFormatDoc2;
	}

	public void setInstitutionalDataFormatDoc2(String institutionalDataFormatDoc2) {
		this.institutionalDataFormatDoc2 = institutionalDataFormatDoc2;
	}

	public String getProgContWithBOSProjDoc() {
		return progContWithBOSProjDoc;
	}

	public void setProgContWithBOSProjDoc(String progContWithBOSProjDoc) {
		this.progContWithBOSProjDoc = progContWithBOSProjDoc;
	}

	public String getInternCompleLetterDoc() {
		return InternCompleLetterDoc;
	}

	public void setInternCompleLetterDoc(String internCompleLetterDoc) {
		InternCompleLetterDoc = internCompleLetterDoc;
	}

	public String getEvaluatedProjReportDoc() {
		return EvaluatedProjReportDoc;
	}

	public void setEvaluatedProjReportDoc(String evaluatedProjReportDoc) {
		EvaluatedProjReportDoc = evaluatedProjReportDoc;
	}

	

	public String getFeedbackForCurriculum() {
		return feedbackForCurriculum;
	}

	public void setFeedbackForCurriculum(String feedbackForCurriculum) {
		this.feedbackForCurriculum = feedbackForCurriculum;
	}

	public String getFeedbackAnalysisActionComm() {
		return feedbackAnalysisActionComm;
	}

	public void setFeedbackAnalysisActionComm(String feedbackAnalysisActionComm) {
		this.feedbackAnalysisActionComm = feedbackAnalysisActionComm;
	}

	public String getInstitutionalDataFormatDoc3() {
		return institutionalDataFormatDoc3;
	}

	public void setInstitutionalDataFormatDoc3(String institutionalDataFormatDoc3) {
		this.institutionalDataFormatDoc3 = institutionalDataFormatDoc3;
	}

	public String getFeedFormDiffStakeHoldersDoc() {
		return feedFormDiffStakeHoldersDoc;
	}

	public void setFeedFormDiffStakeHoldersDoc(String feedFormDiffStakeHoldersDoc) {
		this.feedFormDiffStakeHoldersDoc = feedFormDiffStakeHoldersDoc;
	}

	public String getFeedbackAnalysisReportDoc() {
		return feedbackAnalysisReportDoc;
	}

	public void setFeedbackAnalysisReportDoc(String feedbackAnalysisReportDoc) {
		this.feedbackAnalysisReportDoc = feedbackAnalysisReportDoc;
	}

	public String getActionTakenReportDoc() {
		return actionTakenReportDoc;
	}

	public void setActionTakenReportDoc(String actionTakenReportDoc) {
		this.actionTakenReportDoc = actionTakenReportDoc;
	}

	public String getLinkOfInstitutionWebsite() {
		return linkOfInstitutionWebsite;
	}

	public void setLinkOfInstitutionWebsite(String linkOfInstitutionWebsite) {
		this.linkOfInstitutionWebsite = linkOfInstitutionWebsite;
	}

	public String getLinkForRelevant() {
		return linkForRelevant;
	}

	public void setLinkForRelevant(String linkForRelevant) {
		this.linkForRelevant = linkForRelevant;
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

	public String getRelevantDocLink() {
		return relevantDocLink;
	}

	public void setRelevantDocLink(String relevantDocLink) {
		this.relevantDocLink = relevantDocLink;
	}

}
