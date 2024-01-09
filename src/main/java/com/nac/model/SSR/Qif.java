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
	private String effectiveCurriculumPlanning_CA;
    private String template_CA;
    private String documents_CA;
    private String link_CA;
//    Academic Flexibility KI
    private String numCertCourseComplLast5Y_AF;
    private String CertCourseCompY1_AF;
    private String CertCourseCompY2_AF;
    private String CertCourseCompY3_AF;
    private String CertCourseCompY4_AF;
    private String CertCourseCompY5_AF;
    private String institutionalDataFormatDocs_AF;
    private String programBrochureDoc_AF;
    private String studentAttendanceList_AF;
    private String courseCompletionEvidenceDoc_AF;
    private String supportingLinks_AF;
    private String enrollNComplCoursPercentLast5Y_AF;
    private String enrollCompPercentY1_AF;
    private String enrollCompPercentY2_AF;
    private String enrollCompPercentY3_AF;
    private String enrollCompPercentY4_AF;
    private String enrollCompPercentY5_AF;
    private String institutionalDataFormatDoc_AF;
    private String supportingDoc_AF;
//    Curriculum Enrichment KI
    private String integratesCrosscuttingIssues_CE;
    private String supportingDoc_CE;
    private String numStudUndertakingProj_CE;
    private String stdUndertakingProjY1_CE;
    private String stdUndertakingProjY2_CE;
    private String stdUndertakingProjY3_CE;
    private String stdUndertakingProjY4_CE;
    private String stdUndertakingProjY5_CE;
    private String institutionalDataFormatDoc_CE;
    private String additionalInfoLink;
	private String supportingDocs_CE;
//    Feedback System KI
	private String feedbackProcesses;
    private String instiDataFormatDoc_FS;
    private String feedbackFormsFromStakeholdersDoc_FS;
    private String feedbackAnalysisReprtSubmDoc_FS;
    private String feedbackActionReportDoc_FS;
    private String feedbackWebsiteLink_FS;
	private String completed;
	private String verified;
    
//    getter and setter
    
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
	public String getEffectiveCurriculumPlanning_CA() {
		return effectiveCurriculumPlanning_CA;
	}
	public void setEffectiveCurriculumPlanning_CA(String effectiveCurriculumPlanning_CA) {
		this.effectiveCurriculumPlanning_CA = effectiveCurriculumPlanning_CA;
	}
	public String getTemplate_CA() {
		return template_CA;
	}
	public void setTemplate_CA(String template_CA) {
		this.template_CA = template_CA;
	}
	public String getDocuments_CA() {
		return documents_CA;
	}
	public void setDocuments_CA(String documents_CA) {
		this.documents_CA = documents_CA;
	}
	public String getLink_CA() {
		return link_CA;
	}
	public void setLink_CA(String link_CA) {
		this.link_CA = link_CA;
	}
	public String getNumCertCourseComplLast5Y_AF() {
		return numCertCourseComplLast5Y_AF;
	}
	public void setNumCertCourseComplLast5Y_AF(String numCertCourseComplLast5Y_AF) {
		this.numCertCourseComplLast5Y_AF = numCertCourseComplLast5Y_AF;
	}
	public String getCertCourseCompY1_AF() {
		return CertCourseCompY1_AF;
	}
	public void setCertCourseCompY1_AF(String certCourseCompY1_AF) {
		CertCourseCompY1_AF = certCourseCompY1_AF;
	}
	public String getCertCourseCompY2_AF() {
		return CertCourseCompY2_AF;
	}
	public void setCertCourseCompY2_AF(String certCourseCompY2_AF) {
		CertCourseCompY2_AF = certCourseCompY2_AF;
	}
	public String getCertCourseCompY3_AF() {
		return CertCourseCompY3_AF;
	}
	public void setCertCourseCompY3_AF(String certCourseCompY3_AF) {
		CertCourseCompY3_AF = certCourseCompY3_AF;
	}
	public String getCertCourseCompY4_AF() {
		return CertCourseCompY4_AF;
	}
	public void setCertCourseCompY4_AF(String certCourseCompY4_AF) {
		CertCourseCompY4_AF = certCourseCompY4_AF;
	}
	public String getCertCourseCompY5_AF() {
		return CertCourseCompY5_AF;
	}
	public void setCertCourseCompY5_AF(String certCourseCompY5_AF) {
		CertCourseCompY5_AF = certCourseCompY5_AF;
	}
	public String getInstitutionalDataFormatDocs_AF() {
		return institutionalDataFormatDocs_AF;
	}
	public void setInstitutionalDataFormatDocs_AF(String institutionalDataFormatDocs_AF) {
		this.institutionalDataFormatDocs_AF = institutionalDataFormatDocs_AF;
	}
	public String getProgramBrochureDoc_AF() {
		return programBrochureDoc_AF;
	}
	public void setProgramBrochureDoc_AF(String programBrochureDoc_AF) {
		this.programBrochureDoc_AF = programBrochureDoc_AF;
	}
	public String getStudentAttendanceList_AF() {
		return studentAttendanceList_AF;
	}
	public void setStudentAttendanceList_AF(String studentAttendanceList_AF) {
		this.studentAttendanceList_AF = studentAttendanceList_AF;
	}
	public String getCourseCompletionEvidenceDoc_AF() {
		return courseCompletionEvidenceDoc_AF;
	}
	public void setCourseCompletionEvidenceDoc_AF(String courseCompletionEvidenceDoc_AF) {
		this.courseCompletionEvidenceDoc_AF = courseCompletionEvidenceDoc_AF;
	}
	public String getSupportingLinks_AF() {
		return supportingLinks_AF;
	}
	public void setSupportingLinks_AF(String supportingLinks_AF) {
		this.supportingLinks_AF = supportingLinks_AF;
	}
	public String getEnrollNComplCoursPercentLast5Y_AF() {
		return enrollNComplCoursPercentLast5Y_AF;
	}
	public void setEnrollNComplCoursPercentLast5Y_AF(String enrollNComplCoursPercentLast5Y_AF) {
		this.enrollNComplCoursPercentLast5Y_AF = enrollNComplCoursPercentLast5Y_AF;
	}
	public String getEnrollCompPercentY1_AF() {
		return enrollCompPercentY1_AF;
	}
	public void setEnrollCompPercentY1_AF(String enrollCompPercentY1_AF) {
		this.enrollCompPercentY1_AF = enrollCompPercentY1_AF;
	}
	public String getEnrollCompPercentY2_AF() {
		return enrollCompPercentY2_AF;
	}
	public void setEnrollCompPercentY2_AF(String enrollCompPercentY2_AF) {
		this.enrollCompPercentY2_AF = enrollCompPercentY2_AF;
	}
	public String getEnrollCompPercentY3_AF() {
		return enrollCompPercentY3_AF;
	}
	public void setEnrollCompPercentY3_AF(String enrollCompPercentY3_AF) {
		this.enrollCompPercentY3_AF = enrollCompPercentY3_AF;
	}
	public String getEnrollCompPercentY4_AF() {
		return enrollCompPercentY4_AF;
	}
	public void setEnrollCompPercentY4_AF(String enrollCompPercentY4_AF) {
		this.enrollCompPercentY4_AF = enrollCompPercentY4_AF;
	}
	public String getEnrollCompPercentY5_AF() {
		return enrollCompPercentY5_AF;
	}
	public void setEnrollCompPercentY5_AF(String enrollCompPercentY5_AF) {
		this.enrollCompPercentY5_AF = enrollCompPercentY5_AF;
	}
	public String getInstitutionalDataFormatDoc_AF() {
		return institutionalDataFormatDoc_AF;
	}
	public void setInstitutionalDataFormatDoc_AF(String institutionalDataFormatDoc_AF) {
		this.institutionalDataFormatDoc_AF = institutionalDataFormatDoc_AF;
	}
	public String getSupportingDoc_AF() {
		return supportingDoc_AF;
	}
	public void setSupportingDoc_AF(String supportingDoc_AF) {
		this.supportingDoc_AF = supportingDoc_AF;
	}
	public String getIntegratesCrosscuttingIssues_CE() {
		return integratesCrosscuttingIssues_CE;
	}
	public void setIntegratesCrosscuttingIssues_CE(String integratesCrosscuttingIssues_CE) {
		this.integratesCrosscuttingIssues_CE = integratesCrosscuttingIssues_CE;
	}
	public String getSupportingDoc_CE() {
		return supportingDoc_CE;
	}
	public void setSupportingDoc_CE(String supportingDoc_CE) {
		this.supportingDoc_CE = supportingDoc_CE;
	}
	public String getNumStudUndertakingProj_CE() {
		return numStudUndertakingProj_CE;
	}
	public void setNumStudUndertakingProj_CE(String numStudUndertakingProj_CE) {
		this.numStudUndertakingProj_CE = numStudUndertakingProj_CE;
	}
	public String getStdUndertakingProjY1_CE() {
		return stdUndertakingProjY1_CE;
	}
	public void setStdUndertakingProjY1_CE(String stdUndertakingProjY1_CE) {
		this.stdUndertakingProjY1_CE = stdUndertakingProjY1_CE;
	}
	public String getStdUndertakingProjY2_CE() {
		return stdUndertakingProjY2_CE;
	}
	public void setStdUndertakingProjY2_CE(String stdUndertakingProjY2_CE) {
		this.stdUndertakingProjY2_CE = stdUndertakingProjY2_CE;
	}
	public String getStdUndertakingProjY3_CE() {
		return stdUndertakingProjY3_CE;
	}
	public void setStdUndertakingProjY3_CE(String stdUndertakingProjY3_CE) {
		this.stdUndertakingProjY3_CE = stdUndertakingProjY3_CE;
	}
	public String getStdUndertakingProjY4_CE() {
		return stdUndertakingProjY4_CE;
	}
	public void setStdUndertakingProjY4_CE(String stdUndertakingProjY4_CE) {
		this.stdUndertakingProjY4_CE = stdUndertakingProjY4_CE;
	}
	public String getStdUndertakingProjY5_CE() {
		return stdUndertakingProjY5_CE;
	}
	public void setStdUndertakingProjY5_CE(String stdUndertakingProjY5_CE) {
		this.stdUndertakingProjY5_CE = stdUndertakingProjY5_CE;
	}
	public String getInstitutionalDataFormatDoc_CE() {
		return institutionalDataFormatDoc_CE;
	}
	public void setInstitutionalDataFormatDoc_CE(String institutionalDataFormatDoc_CE) {
		this.institutionalDataFormatDoc_CE = institutionalDataFormatDoc_CE;
	}
    public String getAdditionalInfoLink() {
		return additionalInfoLink;
	}
	public void setAdditionalInfoLink(String additionalInfoLink) {
		this.additionalInfoLink = additionalInfoLink;
	}
	public String getSupportingDocs_CE() {
		return supportingDocs_CE;
	}
	public void setSupportingDocs_CE(String supportingDocs_CE) {
		this.supportingDocs_CE = supportingDocs_CE;
	}
	
	public String getFeedbackProcesses() {
		return feedbackProcesses;
	}
	public void setFeedbackProcesses(String feedbackProcesses) {
		this.feedbackProcesses = feedbackProcesses;
	}
	public String getInstiDataFormatDoc_FS() {
		return instiDataFormatDoc_FS;
	}
	public void setInstiDataFormatDoc_FS(String instiDataFormatDoc_FS) {
		this.instiDataFormatDoc_FS = instiDataFormatDoc_FS;
	}
	public String getFeedbackFormsFromStakeholdersDoc_FS() {
		return feedbackFormsFromStakeholdersDoc_FS;
	}
	public void setFeedbackFormsFromStakeholdersDoc_FS(String feedbackFormsFromStakeholdersDoc_FS) {
		this.feedbackFormsFromStakeholdersDoc_FS = feedbackFormsFromStakeholdersDoc_FS;
	}
	public String getFeedbackAnalysisReprtSubmDoc_FS() {
		return feedbackAnalysisReprtSubmDoc_FS;
	}
	public void setFeedbackAnalysisReprtSubmDoc_FS(String feedbackAnalysisReprtSubmDoc_FS) {
		this.feedbackAnalysisReprtSubmDoc_FS = feedbackAnalysisReprtSubmDoc_FS;
	}
	public String getFeedbackActionReportDoc_FS() {
		return feedbackActionReportDoc_FS;
	}
	public void setFeedbackActionReportDoc_FS(String feedbackActionReportDoc_FS) {
		this.feedbackActionReportDoc_FS = feedbackActionReportDoc_FS;
	}
	public String getFeedbackWebsiteLink_FS() {
		return feedbackWebsiteLink_FS;
	}
	public void setFeedbackWebsiteLink_FS(String feedbackWebsiteLink_FS) {
		this.feedbackWebsiteLink_FS = feedbackWebsiteLink_FS;
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


