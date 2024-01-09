package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CriteriaVI {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long CriteriaVI_Id;
	private long ssrID;
	private long collegeID;
	private long qifId;
	
//	6.1. Institutional Vision and Leadership
	private String instGovPractices;
	private String addInfo_doc;
	private String addInfo_link;
//	6.2. Strategy Development and Deployment
	private String instPerspPlanEff;
	private String webDocsPlan_doc;
	private String addInfo_doc2;
	private String addInfo_link2;
	private String totEgovInstitution;
	private String eGovInstitutionTyp1;
	private String eGovInstitutionTyp2;
	private String eGovInstitutionTyp3;
	private String eGovInstitutionTyp4;
	private String egovImplementation_doc;
	private String iegErpExpStatements_doc;
	private String egovReportApprovalPolicy_doc;
	private String relivantDoc_link;
	
//	5.3. Faculty Empowerment Strategies
	private String InstitutionAppraisalSystem;
	private String addInfo_doc3;
	private String addInfo_link3;
	private String totTeachSupPercentFiveY;
	private String numTeachSupFinanForConfOrWorkY1;
	private String numTeachSupFinanForConfOrWorkY2;
	private String numTeachSupFinanForConfOrWorkY3;
	private String numTeachSupFinanForConfOrWorkY4;
	private String numTeachSupFinanForConfOrWorkY5;
	private String instDataTemplate_doc;
	private String teacherSupportPolicy_doc;
	private String financialAssistanceHead_doc;
	private String auditStatementTeacherSupport;
	private String relivantDoc_link2;
	private String totStaffTrainingPercent; 
	private String staffTrainingPercentY1;
	private String staffTrainingPercentY2;
	private String staffTrainingPercentY3;
	private String staffTrainingPercentY4;
	private String staffTrainingPercentY5;
	private String instDataTemplate_doc2;
	private String facultyTrainingEvents_doc;
	private String certificatesList_doc;
	private String teacherProgramReports_doc;
	private String relivantDoc_link3;
	
//	5.4. Financial Management and Resource Mobilization
	private String resourceUtilizationStrategy;
	private String addInfo_doc4;
	private String addInfo_link4;
	private String IQACQualityAssurance;
	private String addInfo_doc5;
	private String addInfo_link5;
	private String totQualityInitiatives;
	private String qualityInitiativesTyp1;
	private String qualityInitiativesTyp2;
	private String qualityInitiativesTyp3;
	private String qualityInitiativesTyp4;
	private String qualityInitiativesTyp5;
	private String followUpActions_doc;
	private String qaReportCertValid_doc;
	private String CollabQualityInitData_doc;
	private String iqacMeetingMinutesURL;
	private String relivantDoc_link4;
	
	public long getCriteriaVI_Id() {
		return CriteriaVI_Id;
	}
	public void setCriteriaVI_Id(long criteriaVI_Id) {
		CriteriaVI_Id = criteriaVI_Id;
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
	public String getInstGovPractices() {
		return instGovPractices;
	}
	public void setInstGovPractices(String instGovPractices) {
		this.instGovPractices = instGovPractices;
	}
	public String getAddInfo_doc() {
		return addInfo_doc;
	}
	public void setAddInfo_doc(String addInfo_doc) {
		this.addInfo_doc = addInfo_doc;
	}
	public String getAddInfo_link() {
		return addInfo_link;
	}
	public void setAddInfo_link(String addInfo_link) {
		this.addInfo_link = addInfo_link;
	}
	public String getInstPerspPlanEff() {
		return instPerspPlanEff;
	}
	public void setInstPerspPlanEff(String instPerspPlanEff) {
		this.instPerspPlanEff = instPerspPlanEff;
	}
	public String getWebDocsPlan_doc() {
		return webDocsPlan_doc;
	}
	public void setWebDocsPlan_doc(String webDocsPlan_doc) {
		this.webDocsPlan_doc = webDocsPlan_doc;
	}
	public String getAddInfo_doc2() {
		return addInfo_doc2;
	}
	public void setAddInfo_doc2(String addInfo_doc2) {
		this.addInfo_doc2 = addInfo_doc2;
	}
	public String getAddInfo_link2() {
		return addInfo_link2;
	}
	public void setAddInfo_link2(String addInfo_link2) {
		this.addInfo_link2 = addInfo_link2;
	}
	public String getTotEgovInstitution() {
		return totEgovInstitution;
	}
	public void setTotEgovInstitution(String totEgovInstitution) {
		this.totEgovInstitution = totEgovInstitution;
	}
	public String geteGovInstitutionTyp1() {
		return eGovInstitutionTyp1;
	}
	public void seteGovInstitutionTyp1(String eGovInstitutionTyp1) {
		this.eGovInstitutionTyp1 = eGovInstitutionTyp1;
	}
	public String geteGovInstitutionTyp2() {
		return eGovInstitutionTyp2;
	}
	public void seteGovInstitutionTyp2(String eGovInstitutionTyp2) {
		this.eGovInstitutionTyp2 = eGovInstitutionTyp2;
	}
	public String geteGovInstitutionTyp3() {
		return eGovInstitutionTyp3;
	}
	public void seteGovInstitutionTyp3(String eGovInstitutionTyp3) {
		this.eGovInstitutionTyp3 = eGovInstitutionTyp3;
	}
	public String geteGovInstitutionTyp4() {
		return eGovInstitutionTyp4;
	}
	public void seteGovInstitutionTyp4(String eGovInstitutionTyp4) {
		this.eGovInstitutionTyp4 = eGovInstitutionTyp4;
	}
	public String getEgovImplementation_doc() {
		return egovImplementation_doc;
	}
	public void setEgovImplementation_doc(String egovImplementation_doc) {
		this.egovImplementation_doc = egovImplementation_doc;
	}
	public String getIegErpExpStatements_doc() {
		return iegErpExpStatements_doc;
	}
	public void setIegErpExpStatements_doc(String iegErpExpStatements_doc) {
		this.iegErpExpStatements_doc = iegErpExpStatements_doc;
	}
	public String getEgovReportApprovalPolicy_doc() {
		return egovReportApprovalPolicy_doc;
	}
	public void setEgovReportApprovalPolicy_doc(String egovReportApprovalPolicy_doc) {
		this.egovReportApprovalPolicy_doc = egovReportApprovalPolicy_doc;
	}
	public String getRelivantDoc_link() {
		return relivantDoc_link;
	}
	public void setRelivantDoc_link(String relivantDoc_link) {
		this.relivantDoc_link = relivantDoc_link;
	}
	public String getInstitutionAppraisalSystem() {
		return InstitutionAppraisalSystem;
	}
	public void setInstitutionAppraisalSystem(String institutionAppraisalSystem) {
		InstitutionAppraisalSystem = institutionAppraisalSystem;
	}
	public String getAddInfo_doc3() {
		return addInfo_doc3;
	}
	public void setAddInfo_doc3(String addInfo_doc3) {
		this.addInfo_doc3 = addInfo_doc3;
	}
	public String getAddInfo_link3() {
		return addInfo_link3;
	}
	public void setAddInfo_link3(String addInfo_link3) {
		this.addInfo_link3 = addInfo_link3;
	}
	public String getTotTeachSupPercentFiveY() {
		return totTeachSupPercentFiveY;
	}
	public void setTotTeachSupPercentFiveY(String totTeachSupPercentFiveY) {
		this.totTeachSupPercentFiveY = totTeachSupPercentFiveY;
	}
	public String getNumTeachSupFinanForConfOrWorkY1() {
		return numTeachSupFinanForConfOrWorkY1;
	}
	public void setNumTeachSupFinanForConfOrWorkY1(String numTeachSupFinanForConfOrWorkY1) {
		this.numTeachSupFinanForConfOrWorkY1 = numTeachSupFinanForConfOrWorkY1;
	}
	public String getNumTeachSupFinanForConfOrWorkY2() {
		return numTeachSupFinanForConfOrWorkY2;
	}
	public void setNumTeachSupFinanForConfOrWorkY2(String numTeachSupFinanForConfOrWorkY2) {
		this.numTeachSupFinanForConfOrWorkY2 = numTeachSupFinanForConfOrWorkY2;
	}
	public String getNumTeachSupFinanForConfOrWorkY3() {
		return numTeachSupFinanForConfOrWorkY3;
	}
	public void setNumTeachSupFinanForConfOrWorkY3(String numTeachSupFinanForConfOrWorkY3) {
		this.numTeachSupFinanForConfOrWorkY3 = numTeachSupFinanForConfOrWorkY3;
	}
	public String getNumTeachSupFinanForConfOrWorkY4() {
		return numTeachSupFinanForConfOrWorkY4;
	}
	public void setNumTeachSupFinanForConfOrWorkY4(String numTeachSupFinanForConfOrWorkY4) {
		this.numTeachSupFinanForConfOrWorkY4 = numTeachSupFinanForConfOrWorkY4;
	}
	public String getNumTeachSupFinanForConfOrWorkY5() {
		return numTeachSupFinanForConfOrWorkY5;
	}
	public void setNumTeachSupFinanForConfOrWorkY5(String numTeachSupFinanForConfOrWorkY5) {
		this.numTeachSupFinanForConfOrWorkY5 = numTeachSupFinanForConfOrWorkY5;
	}
	public String getInstDataTemplate_doc() {
		return instDataTemplate_doc;
	}
	public void setInstDataTemplate_doc(String instDataTemplate_doc) {
		this.instDataTemplate_doc = instDataTemplate_doc;
	}
	public String getTeacherSupportPolicy_doc() {
		return teacherSupportPolicy_doc;
	}
	public void setTeacherSupportPolicy_doc(String teacherSupportPolicy_doc) {
		this.teacherSupportPolicy_doc = teacherSupportPolicy_doc;
	}
	public String getFinancialAssistanceHead_doc() {
		return financialAssistanceHead_doc;
	}
	public void setFinancialAssistanceHead_doc(String financialAssistanceHead_doc) {
		this.financialAssistanceHead_doc = financialAssistanceHead_doc;
	}
	public String getAuditStatementTeacherSupport() {
		return auditStatementTeacherSupport;
	}
	public void setAuditStatementTeacherSupport(String auditStatementTeacherSupport) {
		this.auditStatementTeacherSupport = auditStatementTeacherSupport;
	}
	public String getRelivantDoc_link2() {
		return relivantDoc_link2;
	}
	public void setRelivantDoc_link2(String relivantDoc_link2) {
		this.relivantDoc_link2 = relivantDoc_link2;
	}
	public String getTotStaffTrainingPercent() {
		return totStaffTrainingPercent;
	}
	public void setTotStaffTrainingPercent(String totStaffTrainingPercent) {
		this.totStaffTrainingPercent = totStaffTrainingPercent;
	}
	public String getStaffTrainingPercentY1() {
		return staffTrainingPercentY1;
	}
	public void setStaffTrainingPercentY1(String staffTrainingPercentY1) {
		this.staffTrainingPercentY1 = staffTrainingPercentY1;
	}
	public String getStaffTrainingPercentY2() {
		return staffTrainingPercentY2;
	}
	public void setStaffTrainingPercentY2(String staffTrainingPercentY2) {
		this.staffTrainingPercentY2 = staffTrainingPercentY2;
	}
	public String getStaffTrainingPercentY3() {
		return staffTrainingPercentY3;
	}
	public void setStaffTrainingPercentY3(String staffTrainingPercentY3) {
		this.staffTrainingPercentY3 = staffTrainingPercentY3;
	}
	public String getStaffTrainingPercentY4() {
		return staffTrainingPercentY4;
	}
	public void setStaffTrainingPercentY4(String staffTrainingPercentY4) {
		this.staffTrainingPercentY4 = staffTrainingPercentY4;
	}
	public String getStaffTrainingPercentY5() {
		return staffTrainingPercentY5;
	}
	public void setStaffTrainingPercentY5(String staffTrainingPercentY5) {
		this.staffTrainingPercentY5 = staffTrainingPercentY5;
	}
	public String getInstDataTemplate_doc2() {
		return instDataTemplate_doc2;
	}
	public void setInstDataTemplate_doc2(String instDataTemplate_doc2) {
		this.instDataTemplate_doc2 = instDataTemplate_doc2;
	}
	public String getFacultyTrainingEvents_doc() {
		return facultyTrainingEvents_doc;
	}
	public void setFacultyTrainingEvents_doc(String facultyTrainingEvents_doc) {
		this.facultyTrainingEvents_doc = facultyTrainingEvents_doc;
	}
	public String getCertificatesList_doc() {
		return certificatesList_doc;
	}
	public void setCertificatesList_doc(String certificatesList_doc) {
		this.certificatesList_doc = certificatesList_doc;
	}
	public String getTeacherProgramReports_doc() {
		return teacherProgramReports_doc;
	}
	public void setTeacherProgramReports_doc(String teacherProgramReports_doc) {
		this.teacherProgramReports_doc = teacherProgramReports_doc;
	}
	public String getRelivantDoc_link3() {
		return relivantDoc_link3;
	}
	public void setRelivantDoc_link3(String relivantDoc_link3) {
		this.relivantDoc_link3 = relivantDoc_link3;
	}
	public String getResourceUtilizationStrategy() {
		return resourceUtilizationStrategy;
	}
	public void setResourceUtilizationStrategy(String resourceUtilizationStrategy) {
		this.resourceUtilizationStrategy = resourceUtilizationStrategy;
	}
	public String getAddInfo_doc4() {
		return addInfo_doc4;
	}
	public void setAddInfo_doc4(String addInfo_doc4) {
		this.addInfo_doc4 = addInfo_doc4;
	}
	public String getAddInfo_link4() {
		return addInfo_link4;
	}
	public void setAddInfo_link4(String addInfo_link4) {
		this.addInfo_link4 = addInfo_link4;
	}
	public String getIQACQualityAssurance() {
		return IQACQualityAssurance;
	}
	public void setIQACQualityAssurance(String iQACQualityAssurance) {
		IQACQualityAssurance = iQACQualityAssurance;
	}
	public String getAddInfo_doc5() {
		return addInfo_doc5;
	}
	public void setAddInfo_doc5(String addInfo_doc5) {
		this.addInfo_doc5 = addInfo_doc5;
	}
	public String getAddInfo_link5() {
		return addInfo_link5;
	}
	public void setAddInfo_link5(String addInfo_link5) {
		this.addInfo_link5 = addInfo_link5;
	}
	public String getTotQualityInitiatives() {
		return totQualityInitiatives;
	}
	public void setTotQualityInitiatives(String totQualityInitiatives) {
		this.totQualityInitiatives = totQualityInitiatives;
	}
	public String getQualityInitiativesTyp1() {
		return qualityInitiativesTyp1;
	}
	public void setQualityInitiativesTyp1(String qualityInitiativesTyp1) {
		this.qualityInitiativesTyp1 = qualityInitiativesTyp1;
	}
	public String getQualityInitiativesTyp2() {
		return qualityInitiativesTyp2;
	}
	public void setQualityInitiativesTyp2(String qualityInitiativesTyp2) {
		this.qualityInitiativesTyp2 = qualityInitiativesTyp2;
	}
	public String getQualityInitiativesTyp3() {
		return qualityInitiativesTyp3;
	}
	public void setQualityInitiativesTyp3(String qualityInitiativesTyp3) {
		this.qualityInitiativesTyp3 = qualityInitiativesTyp3;
	}
	public String getQualityInitiativesTyp4() {
		return qualityInitiativesTyp4;
	}
	public void setQualityInitiativesTyp4(String qualityInitiativesTyp4) {
		this.qualityInitiativesTyp4 = qualityInitiativesTyp4;
	}
	public String getQualityInitiativesTyp5() {
		return qualityInitiativesTyp5;
	}
	public void setQualityInitiativesTyp5(String qualityInitiativesTyp5) {
		this.qualityInitiativesTyp5 = qualityInitiativesTyp5;
	}
	public String getFollowUpActions_doc() {
		return followUpActions_doc;
	}
	public void setFollowUpActions_doc(String followUpActions_doc) {
		this.followUpActions_doc = followUpActions_doc;
	}
	public String getQaReportCertValid_doc() {
		return qaReportCertValid_doc;
	}
	public void setQaReportCertValid_doc(String qaReportCertValid_doc) {
		this.qaReportCertValid_doc = qaReportCertValid_doc;
	}
	public String getCollabQualityInitData_doc() {
		return CollabQualityInitData_doc;
	}
	public void setCollabQualityInitData_doc(String collabQualityInitData_doc) {
		CollabQualityInitData_doc = collabQualityInitData_doc;
	}
	public String getIqacMeetingMinutesURL() {
		return iqacMeetingMinutesURL;
	}
	public void setIqacMeetingMinutesURL(String iqacMeetingMinutesURL) {
		this.iqacMeetingMinutesURL = iqacMeetingMinutesURL;
	}
	public String getRelivantDoc_link4() {
		return relivantDoc_link4;
	}
	public void setRelivantDoc_link4(String relivantDoc_link4) {
		this.relivantDoc_link4 = relivantDoc_link4;
	}
	
	
	
}
