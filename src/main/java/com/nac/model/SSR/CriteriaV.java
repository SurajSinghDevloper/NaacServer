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
	private String scholarBenefitPercent;
	private String numBenefiScholarLastY1;
	private String numBenefiScholarLastY2;
	private String numBenefiScholarLastY3;
	private String numBenefiScholarLastY4;
	private String numBenefiScholarLastY5;
	private String numStudentsByYear;
	private String institutionalDataTemplate_doc;
	private String sanctionLetter_doc;
	private String heiScholarshipPolicy_doc;
	private String beneficiaryListsByYear_doc;
	private String addInfoLink;
	private String numDevSkillsActivities;
	private String skillType1;
	private String skillType2;
	private String skillType3;
	private String skillType4;
	private String institutionalDataTemplate_doc2;
	private String ReportEnhanceSkillsAndActivities_doc;
	private String TechAwarenessProgramReport_doc;
	private String relivantDocSuportLink;
	private String totstudBenefitPercent;
	private String stuBenefitByGuidanceY1;
	private String stuBenefitByGuidanceY2;
	private String stuBenefitByGuidanceY3;
	private String stuBenefitByGuidanceY4;
	private String stuBenefitByGuidanceY5;
	private String institutionalDataTemplate_doc3;
	private String relivantDocSuportLink2;
	private String grievanceResolutionPolicy;
	private String grievanceResolutionTyp1;
	private String grievanceResolutionTyp2;
	private String grievanceResolutionTyp3;
	private String statRegCommittees_doc;
	private String GuidelineComplianceProof_doc;
	private String orgAwarenessPolicyZeroTol_doc;
	private String grievanceSubmitMech_doc;
	private String cmagnogReport_doc;
	private String relivantDocSuportLink3;
	
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
	private String relivantDocSuportLink5;
	
//	5.3. Student Participation and Activities
	private String totAwardsLast5Years;
	private String awardsCountY1;
	private String awardsCountY2;
	private String awardsCountY3;
	private String awardsCountY4;
	private String awardsCountY5;
	private String institutionalDataTemplate_doc6;
	private String awardDocsLinks;
	private String relivantDocSuportLink6;
	private String totAvgNumParticiEvent;
	private String numParticipationsByY1;
	private String numParticipationsByY2;
	private String numParticipationsByY3;
	private String numParticipationsByY4;
	private String numParticipationsByY5;
	private String institutionalDataTemplate_doc7;
	private String suporting_doc;
	
//	5.4. Alumni Engagement
	private String alumniAssocContribution;
	private String addInfo_doc;
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
	public String getNumStudentsByYear() {
		return numStudentsByYear;
	}
	public void setNumStudentsByYear(String numStudentsByYear) {
		this.numStudentsByYear = numStudentsByYear;
	}
	public String getInstitutionalDataTemplate_doc() {
		return institutionalDataTemplate_doc;
	}
	public void setInstitutionalDataTemplate_doc(String institutionalDataTemplate_doc) {
		this.institutionalDataTemplate_doc = institutionalDataTemplate_doc;
	}
	public String getSanctionLetter_doc() {
		return sanctionLetter_doc;
	}
	public void setSanctionLetter_doc(String sanctionLetter_doc) {
		this.sanctionLetter_doc = sanctionLetter_doc;
	}
	public String getHeiScholarshipPolicy_doc() {
		return heiScholarshipPolicy_doc;
	}
	public void setHeiScholarshipPolicy_doc(String heiScholarshipPolicy_doc) {
		this.heiScholarshipPolicy_doc = heiScholarshipPolicy_doc;
	}
	public String getBeneficiaryListsByYear_doc() {
		return beneficiaryListsByYear_doc;
	}
	public void setBeneficiaryListsByYear_doc(String beneficiaryListsByYear_doc) {
		this.beneficiaryListsByYear_doc = beneficiaryListsByYear_doc;
	}
	public String getAddInfoLink() {
		return addInfoLink;
	}
	public void setAddInfoLink(String addInfoLink) {
		this.addInfoLink = addInfoLink;
	}
	public String getNumDevSkillsActivities() {
		return numDevSkillsActivities;
	}
	public void setNumDevSkillsActivities(String numDevSkillsActivities) {
		this.numDevSkillsActivities = numDevSkillsActivities;
	}
	public String getSkillType1() {
		return skillType1;
	}
	public void setSkillType1(String skillType1) {
		this.skillType1 = skillType1;
	}
	public String getSkillType2() {
		return skillType2;
	}
	public void setSkillType2(String skillType2) {
		this.skillType2 = skillType2;
	}
	public String getSkillType3() {
		return skillType3;
	}
	public void setSkillType3(String skillType3) {
		this.skillType3 = skillType3;
	}
	public String getSkillType4() {
		return skillType4;
	}
	public void setSkillType4(String skillType4) {
		this.skillType4 = skillType4;
	}
	public String getInstitutionalDataTemplate_doc2() {
		return institutionalDataTemplate_doc2;
	}
	public void setInstitutionalDataTemplate_doc2(String institutionalDataTemplate_doc2) {
		this.institutionalDataTemplate_doc2 = institutionalDataTemplate_doc2;
	}
	public String getReportEnhanceSkillsAndActivities_doc() {
		return ReportEnhanceSkillsAndActivities_doc;
	}
	public void setReportEnhanceSkillsAndActivities_doc(String reportEnhanceSkillsAndActivities_doc) {
		ReportEnhanceSkillsAndActivities_doc = reportEnhanceSkillsAndActivities_doc;
	}
	public String getTechAwarenessProgramReport_doc() {
		return TechAwarenessProgramReport_doc;
	}
	public void setTechAwarenessProgramReport_doc(String techAwarenessProgramReport_doc) {
		TechAwarenessProgramReport_doc = techAwarenessProgramReport_doc;
	}
	public String getRelivantDocSuportLink() {
		return relivantDocSuportLink;
	}
	public void setRelivantDocSuportLink(String relivantDocSuportLink) {
		this.relivantDocSuportLink = relivantDocSuportLink;
	}
	public String getTotstudBenefitPercent() {
		return totstudBenefitPercent;
	}
	public void setTotstudBenefitPercent(String totstudBenefitPercent) {
		this.totstudBenefitPercent = totstudBenefitPercent;
	}
	public String getStuBenefitByGuidanceY1() {
		return stuBenefitByGuidanceY1;
	}
	public void setStuBenefitByGuidanceY1(String stuBenefitByGuidanceY1) {
		this.stuBenefitByGuidanceY1 = stuBenefitByGuidanceY1;
	}
	public String getStuBenefitByGuidanceY2() {
		return stuBenefitByGuidanceY2;
	}
	public void setStuBenefitByGuidanceY2(String stuBenefitByGuidanceY2) {
		this.stuBenefitByGuidanceY2 = stuBenefitByGuidanceY2;
	}
	public String getStuBenefitByGuidanceY3() {
		return stuBenefitByGuidanceY3;
	}
	public void setStuBenefitByGuidanceY3(String stuBenefitByGuidanceY3) {
		this.stuBenefitByGuidanceY3 = stuBenefitByGuidanceY3;
	}
	public String getStuBenefitByGuidanceY4() {
		return stuBenefitByGuidanceY4;
	}
	public void setStuBenefitByGuidanceY4(String stuBenefitByGuidanceY4) {
		this.stuBenefitByGuidanceY4 = stuBenefitByGuidanceY4;
	}
	public String getStuBenefitByGuidanceY5() {
		return stuBenefitByGuidanceY5;
	}
	public void setStuBenefitByGuidanceY5(String stuBenefitByGuidanceY5) {
		this.stuBenefitByGuidanceY5 = stuBenefitByGuidanceY5;
	}
	public String getInstitutionalDataTemplate_doc3() {
		return institutionalDataTemplate_doc3;
	}
	public void setInstitutionalDataTemplate_doc3(String institutionalDataTemplate_doc3) {
		this.institutionalDataTemplate_doc3 = institutionalDataTemplate_doc3;
	}
	public String getRelivantDocSuportLink2() {
		return relivantDocSuportLink2;
	}
	public void setRelivantDocSuportLink2(String relivantDocSuportLink2) {
		this.relivantDocSuportLink2 = relivantDocSuportLink2;
	}
	public String getGrievanceResolutionPolicy() {
		return grievanceResolutionPolicy;
	}
	public void setGrievanceResolutionPolicy(String grievanceResolutionPolicy) {
		this.grievanceResolutionPolicy = grievanceResolutionPolicy;
	}
	public String getGrievanceResolutionTyp1() {
		return grievanceResolutionTyp1;
	}
	public void setGrievanceResolutionTyp1(String grievanceResolutionTyp1) {
		this.grievanceResolutionTyp1 = grievanceResolutionTyp1;
	}
	public String getGrievanceResolutionTyp2() {
		return grievanceResolutionTyp2;
	}
	public void setGrievanceResolutionTyp2(String grievanceResolutionTyp2) {
		this.grievanceResolutionTyp2 = grievanceResolutionTyp2;
	}
	public String getGrievanceResolutionTyp3() {
		return grievanceResolutionTyp3;
	}
	public void setGrievanceResolutionTyp3(String grievanceResolutionTyp3) {
		this.grievanceResolutionTyp3 = grievanceResolutionTyp3;
	}
	public String getStatRegCommittees_doc() {
		return statRegCommittees_doc;
	}
	public void setStatRegCommittees_doc(String statRegCommittees_doc) {
		this.statRegCommittees_doc = statRegCommittees_doc;
	}
	public String getGuidelineComplianceProof_doc() {
		return GuidelineComplianceProof_doc;
	}
	public void setGuidelineComplianceProof_doc(String guidelineComplianceProof_doc) {
		GuidelineComplianceProof_doc = guidelineComplianceProof_doc;
	}
	public String getOrgAwarenessPolicyZeroTol_doc() {
		return orgAwarenessPolicyZeroTol_doc;
	}
	public void setOrgAwarenessPolicyZeroTol_doc(String orgAwarenessPolicyZeroTol_doc) {
		this.orgAwarenessPolicyZeroTol_doc = orgAwarenessPolicyZeroTol_doc;
	}
	public String getGrievanceSubmitMech_doc() {
		return grievanceSubmitMech_doc;
	}
	public void setGrievanceSubmitMech_doc(String grievanceSubmitMech_doc) {
		this.grievanceSubmitMech_doc = grievanceSubmitMech_doc;
	}
	public String getCmagnogReport_doc() {
		return cmagnogReport_doc;
	}
	public void setCmagnogReport_doc(String cmagnogReport_doc) {
		this.cmagnogReport_doc = cmagnogReport_doc;
	}
	public String getRelivantDocSuportLink3() {
		return relivantDocSuportLink3;
	}
	public void setRelivantDocSuportLink3(String relivantDocSuportLink3) {
		this.relivantDocSuportLink3 = relivantDocSuportLink3;
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
	public String getAwardDocsLinks() {
		return awardDocsLinks;
	}
	public void setAwardDocsLinks(String awardDocsLinks) {
		this.awardDocsLinks = awardDocsLinks;
	}
	public String getRelivantDocSuportLink6() {
		return relivantDocSuportLink6;
	}
	public void setRelivantDocSuportLink6(String relivantDocSuportLink6) {
		this.relivantDocSuportLink6 = relivantDocSuportLink6;
	}
	public String getTotAvgNumParticiEvent() {
		return totAvgNumParticiEvent;
	}
	public void setTotAvgNumParticiEvent(String totAvgNumParticiEvent) {
		this.totAvgNumParticiEvent = totAvgNumParticiEvent;
	}
	public String getNumParticipationsByY1() {
		return numParticipationsByY1;
	}
	public void setNumParticipationsByY1(String numParticipationsByY1) {
		this.numParticipationsByY1 = numParticipationsByY1;
	}
	public String getNumParticipationsByY2() {
		return numParticipationsByY2;
	}
	public void setNumParticipationsByY2(String numParticipationsByY2) {
		this.numParticipationsByY2 = numParticipationsByY2;
	}
	public String getNumParticipationsByY3() {
		return numParticipationsByY3;
	}
	public void setNumParticipationsByY3(String numParticipationsByY3) {
		this.numParticipationsByY3 = numParticipationsByY3;
	}
	public String getNumParticipationsByY4() {
		return numParticipationsByY4;
	}
	public void setNumParticipationsByY4(String numParticipationsByY4) {
		this.numParticipationsByY4 = numParticipationsByY4;
	}
	public String getNumParticipationsByY5() {
		return numParticipationsByY5;
	}
	public void setNumParticipationsByY5(String numParticipationsByY5) {
		this.numParticipationsByY5 = numParticipationsByY5;
	}
	public String getInstitutionalDataTemplate_doc7() {
		return institutionalDataTemplate_doc7;
	}
	public void setInstitutionalDataTemplate_doc7(String institutionalDataTemplate_doc7) {
		this.institutionalDataTemplate_doc7 = institutionalDataTemplate_doc7;
	}
	public String getSuporting_doc() {
		return suporting_doc;
	}
	public void setSuporting_doc(String suporting_doc) {
		this.suporting_doc = suporting_doc;
	}
	public String getAlumniAssocContribution() {
		return alumniAssocContribution;
	}
	public void setAlumniAssocContribution(String alumniAssocContribution) {
		this.alumniAssocContribution = alumniAssocContribution;
	}
	public String getAddInfo_doc() {
		return addInfo_doc;
	}
	public void setAddInfo_doc(String addInfo_doc) {
		this.addInfo_doc = addInfo_doc;
	}
	public String getAddInfoLink2() {
		return addInfoLink2;
	}
	public void setAddInfoLink2(String addInfoLink2) {
		this.addInfoLink2 = addInfoLink2;
	}
	
	
	
}
