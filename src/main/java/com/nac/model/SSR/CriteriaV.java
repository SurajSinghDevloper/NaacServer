package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CriteriaV {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long CriteriaV_Id;
	private long ssrID;
	private long collegeID;
	private long qifId;
	
//	5.1. Student Support
	private String scholarBenefitPercent;//
	private String numBenefiScholarLastY1;//
	private String numBenefiScholarLastY2;//
	private String numBenefiScholarLastY3;//
	private String numBenefiScholarLastY4;//
	private String numBenefiScholarLastY5;//
	private String numStudentsByYear1;
	private String numStudentsByYear2;
	private String numStudentsByYear3;
	private String numStudentsByYear4;
	private String numStudentsByYear5;

	private String institutionalDataTemplate_doc;
	private String addInfoLink;
	
	private String instCareerCounseling;
	private String addInfoDoc;
	private String addInfoLink3;
	private String cdse_activitiesTot;
	private String cdse_activitiesType;
	private String prescribedDataDoc;
	private String relivantDocLink;
	
	private String StudGrievRedresPolicy;
	private String StudGrievRedresPolicyType;
	private String prescribedDataDoc2;
	private String relivantDocLink2;
	
	
//	5.2. StudentProgression
	private String totPlacementProgressRate;
	private String outgoingPlacementProgY1;
	private String outgoingPlacementProgY2;
	private String outgoingPlacementProgY3;
	private String outgoingPlacementProgY4;
	private String outgoingPlacementProgY5;
	
	private String outgoingStudentsPerY1;
	private String outgoingStudentsPerY2;
	private String outgoingStudentsPerY3;
	private String outgoingStudentsPerY4;
	private String outgoingStudentsPerY5;
	
	private String institutionalDataTemplate_doc4;
	private String relivantDocLink3;
	
	private String placementInfoList_doc;
	private String stdProgHighEdDetWithProofLinks;
	private String relivantDocSuportLink4;
	private String totExamPassPercentLast5Years;
	private String qualStudentsCountByY1;
	private String qualStudentsCountByY2;
	private String qualStudentsCountByY3;
	private String qualStudentsCountByY4;
	private String qualStudentsCountByY5;
	private String institutionalDataTemplate_doc5;
	private String qualifiedStudentsByYear_link;
	private String relivantDocSuportLink5;//
	
//	5.3. Student Participation and Activities
	private String totAwardsLast5Years;
	private String awardsCountY1;
	private String awardsCountY2;
	private String awardsCountY3;
	private String awardsCountY4;
	private String awardsCountY5;
	
	private String institutionalDataTemplate_doc6;
	private String relivantDocSuportLink6;
	private String StudCouncil_Rep;
	private String addInfoDo2;
	private String addInfoLink4;
	private String instConductOrganiseTot;
	private String instConductOrganType;
	private String addInfoDo3;
	private String addInfoLink5;
	
	
	
//	5.4. Alumni Engagement
	private String alumniAssocContrTotal;
	private String HEI_Annual_Audit_AlumniDoc;
	private String alumni_contributionsDoc;
	private String addInfoLink6;
	
	private String alumniAssocContribution;
	private String addInfo_doc8;
	private String addInfoLink2;
	
	
	public long getCriteriaV_Id() {
		return CriteriaV_Id;
	}
	public void setCriteriaV_Id(long criteriaV_Id) {
		CriteriaV_Id = criteriaV_Id;
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
	public String getScholarBenefitPercent() {
		return scholarBenefitPercent;
	}
	public void setScholarBenefitPercent(String scholarBenefitPercent) {
		this.scholarBenefitPercent = scholarBenefitPercent;
	}
	public String getNumBenefiScholarLastY1() {
		return numBenefiScholarLastY1;
	}
	public void setNumBenefiScholarLastY1(String numBenefiScholarLastY1) {
		this.numBenefiScholarLastY1 = numBenefiScholarLastY1;
	}
	public String getNumBenefiScholarLastY2() {
		return numBenefiScholarLastY2;
	}
	public void setNumBenefiScholarLastY2(String numBenefiScholarLastY2) {
		this.numBenefiScholarLastY2 = numBenefiScholarLastY2;
	}
	public String getNumBenefiScholarLastY3() {
		return numBenefiScholarLastY3;
	}
	public void setNumBenefiScholarLastY3(String numBenefiScholarLastY3) {
		this.numBenefiScholarLastY3 = numBenefiScholarLastY3;
	}
	public String getNumBenefiScholarLastY4() {
		return numBenefiScholarLastY4;
	}
	public void setNumBenefiScholarLastY4(String numBenefiScholarLastY4) {
		this.numBenefiScholarLastY4 = numBenefiScholarLastY4;
	}
	public String getNumBenefiScholarLastY5() {
		return numBenefiScholarLastY5;
	}
	public void setNumBenefiScholarLastY5(String numBenefiScholarLastY5) {
		this.numBenefiScholarLastY5 = numBenefiScholarLastY5;
	}
	public String getNumStudentsByYear1() {
		return numStudentsByYear1;
	}
	public void setNumStudentsByYear1(String numStudentsByYear1) {
		this.numStudentsByYear1 = numStudentsByYear1;
	}
	public String getNumStudentsByYear2() {
		return numStudentsByYear2;
	}
	public void setNumStudentsByYear2(String numStudentsByYear2) {
		this.numStudentsByYear2 = numStudentsByYear2;
	}
	public String getNumStudentsByYear3() {
		return numStudentsByYear3;
	}
	public void setNumStudentsByYear3(String numStudentsByYear3) {
		this.numStudentsByYear3 = numStudentsByYear3;
	}
	public String getNumStudentsByYear4() {
		return numStudentsByYear4;
	}
	public void setNumStudentsByYear4(String numStudentsByYear4) {
		this.numStudentsByYear4 = numStudentsByYear4;
	}
	public String getNumStudentsByYear5() {
		return numStudentsByYear5;
	}
	public void setNumStudentsByYear5(String numStudentsByYear5) {
		this.numStudentsByYear5 = numStudentsByYear5;
	}
	public String getInstitutionalDataTemplate_doc() {
		return institutionalDataTemplate_doc;
	}
	public void setInstitutionalDataTemplate_doc(String institutionalDataTemplate_doc) {
		this.institutionalDataTemplate_doc = institutionalDataTemplate_doc;
	}
	public String getAddInfoLink() {
		return addInfoLink;
	}
	public void setAddInfoLink(String addInfoLink) {
		this.addInfoLink = addInfoLink;
	}
	public String getInstCareerCounseling() {
		return instCareerCounseling;
	}
	public void setInstCareerCounseling(String instCareerCounseling) {
		this.instCareerCounseling = instCareerCounseling;
	}
	public String getAddInfoDoc() {
		return addInfoDoc;
	}
	public void setAddInfoDoc(String addInfoDoc) {
		this.addInfoDoc = addInfoDoc;
	}
	public String getAddInfoLink3() {
		return addInfoLink3;
	}
	public void setAddInfoLink3(String addInfoLink3) {
		this.addInfoLink3 = addInfoLink3;
	}
	public String getCdse_activitiesTot() {
		return cdse_activitiesTot;
	}
	public void setCdse_activitiesTot(String cdse_activitiesTot) {
		this.cdse_activitiesTot = cdse_activitiesTot;
	}
	public String getCdse_activitiesType() {
		return cdse_activitiesType;
	}
	public void setCdse_activitiesType(String cdse_activitiesType) {
		this.cdse_activitiesType = cdse_activitiesType;
	}
	public String getPrescribedDataDoc() {
		return prescribedDataDoc;
	}
	public void setPrescribedDataDoc(String prescribedDataDoc) {
		this.prescribedDataDoc = prescribedDataDoc;
	}
	public String getRelivantDocLink() {
		return relivantDocLink;
	}
	public void setRelivantDocLink(String relivantDocLink) {
		this.relivantDocLink = relivantDocLink;
	}
	public String getStudGrievRedresPolicy() {
		return StudGrievRedresPolicy;
	}
	public void setStudGrievRedresPolicy(String studGrievRedresPolicy) {
		StudGrievRedresPolicy = studGrievRedresPolicy;
	}
	public String getStudGrievRedresPolicyType() {
		return StudGrievRedresPolicyType;
	}
	public void setStudGrievRedresPolicyType(String studGrievRedresPolicyType) {
		StudGrievRedresPolicyType = studGrievRedresPolicyType;
	}
	public String getPrescribedDataDoc2() {
		return prescribedDataDoc2;
	}
	public void setPrescribedDataDoc2(String prescribedDataDoc2) {
		this.prescribedDataDoc2 = prescribedDataDoc2;
	}
	public String getRelivantDocLink2() {
		return relivantDocLink2;
	}
	public void setRelivantDocLink2(String relivantDocLink2) {
		this.relivantDocLink2 = relivantDocLink2;
	}
	public String getTotPlacementProgressRate() {
		return totPlacementProgressRate;
	}
	public void setTotPlacementProgressRate(String totPlacementProgressRate) {
		this.totPlacementProgressRate = totPlacementProgressRate;
	}
	public String getOutgoingPlacementProgY1() {
		return outgoingPlacementProgY1;
	}
	public void setOutgoingPlacementProgY1(String outgoingPlacementProgY1) {
		this.outgoingPlacementProgY1 = outgoingPlacementProgY1;
	}
	public String getOutgoingPlacementProgY2() {
		return outgoingPlacementProgY2;
	}
	public void setOutgoingPlacementProgY2(String outgoingPlacementProgY2) {
		this.outgoingPlacementProgY2 = outgoingPlacementProgY2;
	}
	public String getOutgoingPlacementProgY3() {
		return outgoingPlacementProgY3;
	}
	public void setOutgoingPlacementProgY3(String outgoingPlacementProgY3) {
		this.outgoingPlacementProgY3 = outgoingPlacementProgY3;
	}
	public String getOutgoingPlacementProgY4() {
		return outgoingPlacementProgY4;
	}
	public void setOutgoingPlacementProgY4(String outgoingPlacementProgY4) {
		this.outgoingPlacementProgY4 = outgoingPlacementProgY4;
	}
	public String getOutgoingPlacementProgY5() {
		return outgoingPlacementProgY5;
	}
	public void setOutgoingPlacementProgY5(String outgoingPlacementProgY5) {
		this.outgoingPlacementProgY5 = outgoingPlacementProgY5;
	}
	public String getOutgoingStudentsPerY1() {
		return outgoingStudentsPerY1;
	}
	public void setOutgoingStudentsPerY1(String outgoingStudentsPerY1) {
		this.outgoingStudentsPerY1 = outgoingStudentsPerY1;
	}
	public String getOutgoingStudentsPerY2() {
		return outgoingStudentsPerY2;
	}
	public void setOutgoingStudentsPerY2(String outgoingStudentsPerY2) {
		this.outgoingStudentsPerY2 = outgoingStudentsPerY2;
	}
	public String getOutgoingStudentsPerY3() {
		return outgoingStudentsPerY3;
	}
	public void setOutgoingStudentsPerY3(String outgoingStudentsPerY3) {
		this.outgoingStudentsPerY3 = outgoingStudentsPerY3;
	}
	public String getOutgoingStudentsPerY4() {
		return outgoingStudentsPerY4;
	}
	public void setOutgoingStudentsPerY4(String outgoingStudentsPerY4) {
		this.outgoingStudentsPerY4 = outgoingStudentsPerY4;
	}
	public String getOutgoingStudentsPerY5() {
		return outgoingStudentsPerY5;
	}
	public void setOutgoingStudentsPerY5(String outgoingStudentsPerY5) {
		this.outgoingStudentsPerY5 = outgoingStudentsPerY5;
	}
	public String getInstitutionalDataTemplate_doc4() {
		return institutionalDataTemplate_doc4;
	}
	public void setInstitutionalDataTemplate_doc4(String institutionalDataTemplate_doc4) {
		this.institutionalDataTemplate_doc4 = institutionalDataTemplate_doc4;
	}
	public String getRelivantDocLink3() {
		return relivantDocLink3;
	}
	public void setRelivantDocLink3(String relivantDocLink3) {
		this.relivantDocLink3 = relivantDocLink3;
	}
	public String getPlacementInfoList_doc() {
		return placementInfoList_doc;
	}
	public void setPlacementInfoList_doc(String placementInfoList_doc) {
		this.placementInfoList_doc = placementInfoList_doc;
	}
	public String getStdProgHighEdDetWithProofLinks() {
		return stdProgHighEdDetWithProofLinks;
	}
	public void setStdProgHighEdDetWithProofLinks(String stdProgHighEdDetWithProofLinks) {
		this.stdProgHighEdDetWithProofLinks = stdProgHighEdDetWithProofLinks;
	}
	public String getRelivantDocSuportLink4() {
		return relivantDocSuportLink4;
	}
	public void setRelivantDocSuportLink4(String relivantDocSuportLink4) {
		this.relivantDocSuportLink4 = relivantDocSuportLink4;
	}
	public String getTotExamPassPercentLast5Years() {
		return totExamPassPercentLast5Years;
	}
	public void setTotExamPassPercentLast5Years(String totExamPassPercentLast5Years) {
		this.totExamPassPercentLast5Years = totExamPassPercentLast5Years;
	}
	public String getQualStudentsCountByY1() {
		return qualStudentsCountByY1;
	}
	public void setQualStudentsCountByY1(String qualStudentsCountByY1) {
		this.qualStudentsCountByY1 = qualStudentsCountByY1;
	}
	public String getQualStudentsCountByY2() {
		return qualStudentsCountByY2;
	}
	public void setQualStudentsCountByY2(String qualStudentsCountByY2) {
		this.qualStudentsCountByY2 = qualStudentsCountByY2;
	}
	public String getQualStudentsCountByY3() {
		return qualStudentsCountByY3;
	}
	public void setQualStudentsCountByY3(String qualStudentsCountByY3) {
		this.qualStudentsCountByY3 = qualStudentsCountByY3;
	}
	public String getQualStudentsCountByY4() {
		return qualStudentsCountByY4;
	}
	public void setQualStudentsCountByY4(String qualStudentsCountByY4) {
		this.qualStudentsCountByY4 = qualStudentsCountByY4;
	}
	public String getQualStudentsCountByY5() {
		return qualStudentsCountByY5;
	}
	public void setQualStudentsCountByY5(String qualStudentsCountByY5) {
		this.qualStudentsCountByY5 = qualStudentsCountByY5;
	}
	public String getInstitutionalDataTemplate_doc5() {
		return institutionalDataTemplate_doc5;
	}
	public void setInstitutionalDataTemplate_doc5(String institutionalDataTemplate_doc5) {
		this.institutionalDataTemplate_doc5 = institutionalDataTemplate_doc5;
	}
	public String getQualifiedStudentsByYear_link() {
		return qualifiedStudentsByYear_link;
	}
	public void setQualifiedStudentsByYear_link(String qualifiedStudentsByYear_link) {
		this.qualifiedStudentsByYear_link = qualifiedStudentsByYear_link;
	}
	public String getRelivantDocSuportLink5() {
		return relivantDocSuportLink5;
	}
	public void setRelivantDocSuportLink5(String relivantDocSuportLink5) {
		this.relivantDocSuportLink5 = relivantDocSuportLink5;
	}
	public String getTotAwardsLast5Years() {
		return totAwardsLast5Years;
	}
	public void setTotAwardsLast5Years(String totAwardsLast5Years) {
		this.totAwardsLast5Years = totAwardsLast5Years;
	}
	public String getAwardsCountY1() {
		return awardsCountY1;
	}
	public void setAwardsCountY1(String awardsCountY1) {
		this.awardsCountY1 = awardsCountY1;
	}
	public String getAwardsCountY2() {
		return awardsCountY2;
	}
	public void setAwardsCountY2(String awardsCountY2) {
		this.awardsCountY2 = awardsCountY2;
	}
	public String getAwardsCountY3() {
		return awardsCountY3;
	}
	public void setAwardsCountY3(String awardsCountY3) {
		this.awardsCountY3 = awardsCountY3;
	}
	public String getAwardsCountY4() {
		return awardsCountY4;
	}
	public void setAwardsCountY4(String awardsCountY4) {
		this.awardsCountY4 = awardsCountY4;
	}
	public String getAwardsCountY5() {
		return awardsCountY5;
	}
	public void setAwardsCountY5(String awardsCountY5) {
		this.awardsCountY5 = awardsCountY5;
	}
	public String getInstitutionalDataTemplate_doc6() {
		return institutionalDataTemplate_doc6;
	}
	public void setInstitutionalDataTemplate_doc6(String institutionalDataTemplate_doc6) {
		this.institutionalDataTemplate_doc6 = institutionalDataTemplate_doc6;
	}
	public String getRelivantDocSuportLink6() {
		return relivantDocSuportLink6;
	}
	public void setRelivantDocSuportLink6(String relivantDocSuportLink6) {
		this.relivantDocSuportLink6 = relivantDocSuportLink6;
	}
	public String getStudCouncil_Rep() {
		return StudCouncil_Rep;
	}
	public void setStudCouncil_Rep(String studCouncil_Rep) {
		StudCouncil_Rep = studCouncil_Rep;
	}
	public String getAddInfoDo2() {
		return addInfoDo2;
	}
	public void setAddInfoDo2(String addInfoDo2) {
		this.addInfoDo2 = addInfoDo2;
	}
	public String getAddInfoLink4() {
		return addInfoLink4;
	}
	public void setAddInfoLink4(String addInfoLink4) {
		this.addInfoLink4 = addInfoLink4;
	}
	public String getInstConductOrganiseTot() {
		return instConductOrganiseTot;
	}
	public void setInstConductOrganiseTot(String instConductOrganiseTot) {
		this.instConductOrganiseTot = instConductOrganiseTot;
	}
	public String getInstConductOrganType() {
		return instConductOrganType;
	}
	public void setInstConductOrganType(String instConductOrganType) {
		this.instConductOrganType = instConductOrganType;
	}
	public String getAddInfoDo3() {
		return addInfoDo3;
	}
	public void setAddInfoDo3(String addInfoDo3) {
		this.addInfoDo3 = addInfoDo3;
	}
	public String getAddInfoLink5() {
		return addInfoLink5;
	}
	public void setAddInfoLink5(String addInfoLink5) {
		this.addInfoLink5 = addInfoLink5;
	}
	public String getAlumniAssocContrTotal() {
		return alumniAssocContrTotal;
	}
	public void setAlumniAssocContrTotal(String alumniAssocContrTotal) {
		this.alumniAssocContrTotal = alumniAssocContrTotal;
	}
	public String getHEI_Annual_Audit_AlumniDoc() {
		return HEI_Annual_Audit_AlumniDoc;
	}
	public void setHEI_Annual_Audit_AlumniDoc(String hEI_Annual_Audit_AlumniDoc) {
		HEI_Annual_Audit_AlumniDoc = hEI_Annual_Audit_AlumniDoc;
	}
	public String getAlumni_contributionsDoc() {
		return alumni_contributionsDoc;
	}
	public void setAlumni_contributionsDoc(String alumni_contributionsDoc) {
		this.alumni_contributionsDoc = alumni_contributionsDoc;
	}
	public String getAddInfoLink6() {
		return addInfoLink6;
	}
	public void setAddInfoLink6(String addInfoLink6) {
		this.addInfoLink6 = addInfoLink6;
	}
	public String getAlumniAssocContribution() {
		return alumniAssocContribution;
	}
	public void setAlumniAssocContribution(String alumniAssocContribution) {
		this.alumniAssocContribution = alumniAssocContribution;
	}
	public String getAddInfo_doc8() {
		return addInfo_doc8;
	}
	public void setAddInfo_doc8(String addInfo_doc8) {
		this.addInfo_doc8 = addInfo_doc8;
	}
	public String getAddInfoLink2() {
		return addInfoLink2;
	}
	public void setAddInfoLink2(String addInfoLink2) {
		this.addInfoLink2 = addInfoLink2;
	}
	
	
	
	
	
}
