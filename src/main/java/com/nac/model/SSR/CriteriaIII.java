package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CriteriaIII {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long CriteriaIII_Id;
	private long ssrID;
	private long collegeID;
	private long qifId;

// 3.0. Promotions of Research and Facilities
	private String researchPromotionPolicy;
	private String additionalInforDoc;//
	private String linkForAdditionalInfo;
	private String supportingDoc;//
	private String seedMoneyForResearchPerYear;
	private String seedMoneyByYear1;
	private String seedMoneyByYear2;
	private String seedMoneyByYear3;
	private String seedMoneyByYear4;
	private String seedMoneyByYear5;
	private String supportingDocumentLinks3;
	private String teachFellowshipPercent;
	private String teacherFellowshipsY1;
	private String teacherFellowshipsY2;
	private String teacherFellowshipsY3;
	private String teacherFellowshipsY4;
	private String teacherFellowshipsY5;
	private String fullTimeTeachersY1;
	private String fullTimeTeachersY2;
	private String fullTimeTeachersY3;
	private String fullTimeTeachersY4;
	private String fullTimeTeachersY5;
	private String institDataTempDoc2;//
	private String relevantDocLink;
	private String phdScholarsEnrolledPercnt;
	private String jrfCountLastFiveYears;
	private String noOfPhdScholarEnroledY1;
	private String noOfPhdScholarEnroledY2;
	private String noOfPhdScholarEnroledY3;
	private String noOfPhdScholarEnroledY4;
	private String noOfPhdScholarEnroledY5;
	private String institDataTemp_Doc;//
	private String relevantDocsLink;
//	3.2. Resource Mobilization for Research
	private String grantReceivedLastFiveYears;
	private String totGrantGovtNonGovtLastY1;
	private String totGrantGovtNonGovtLastY2;
	private String totGrantGovtNonGovtLastY3;
	private String totGrantGovtNonGovtLastY4;
	private String totGrantGovtNonGovtLastY5;
	private String instDataTemplate_doc;//
	private String supporting_doc91;//
	private String noCorpoResearchProjects;
	private String nonGovtFundedProjectsY1;
	private String nonGovtFundedProjectsY2;
	private String nonGovtFundedProjectsY3;
	private String nonGovtFundedProjectsY4;
	private String nonGovtFundedProjectsY5;
	private String ftTeachersByYear1;
	private String ftTeachersByYear2;
	private String ftTeachersByYear3;
	private String ftTeachersByYear4;
	private String ftTeachersByYear5;
	private String totalFullTimeTeachersY1;
	private String totalFullTimeTeachersY2;
	private String totalFullTimeTeachersY3;
	private String totalFullTimeTeachersY4;
	private String totalFullTimeTeachersY5;
	private String institutionalDataTemplateDoc;//
	private String otherRelevantDocLink;
	
//	3.2. Innovation Ecosystem
	private String devlopedKnowledgeSystem;
	private String additionalInfo_doc;//
	private String additionalInfoLink;
	private String totWorkshopsOnResearchMethodology;
	private String totWorkshopOnResearchMetho_Y1;
	private String totWorkshopOnResearchMetho_Y2;
	private String totWorkshopOnResearchMetho_Y3;
	private String totWorkshopOnResearchMetho_Y4;
	private String totWorkshopOnResearchMetho_Y5;
	private String institutionalDataFormat_doc;//
	private String supporting_doc32;//
	
//	3.3. Research Publication and Awards
	private String ethicsCodeImplementation;
	private String ethicsCodeImplementationType;
	private String institutionalDataFormat_doc2;//
	private String relivantDocLink;
	private String noOfParentAwareded;
	private String noOfParentAwarededY1;
	private String noOfParentAwarededY2;
	private String noOfParentAwarededY3;
	private String noOfParentAwarededY4;
	private String noOfParentAwarededY5;
	private String institutionalDataFormat_doc3;//
	private String relevantDocumentSupport_Link;
	private String totNoPhdsAwarededPerGuide;
	private String noPhdsAwarededPerGuideY1;
	private String noPhdsAwarededPerGuideY2;
	private String noPhdsAwarededPerGuideY3;
	private String noPhdsAwarededPerGuideY4;
	private String noPhdsAwarededPerGuideY5;
	private String guideRecognitionY1;
	private String guideRecognitionY2;
	private String guideRecognitionY3;
	private String guideRecognitionY4;
	private String guideRecognitionY5;
	private String institDataFormat_doc;//
	private String otherRelivantLink;
	private String NoResearchPapersPerTeach;
	private String pubJournalsUGCListY1;
	private String pubJournalsUGCListY2;
	private String pubJournalsUGCListY3;
	private String pubJournalsUGCListY4;
	private String pubJournalsUGCListY5;
	private String fullTimeTeachersWorkedY1;
	private String fullTimeTeachersWorkedY2;
	private String fullTimeTeachersWorkedY3;
	private String fullTimeTeachersWorkedY4;
	private String fullTimeTeachersWorkedY5;
	private String institDataFormat_doc2;//
	private String otherRelivantLink2;
	private String booksPerTeacherLast5Years;
	private String totalBooksAndChaptersY1;
	private String totalBooksAndChaptersY2;
	private String totalBooksAndChaptersY3;
	private String totalBooksAndChaptersY4;
	private String totalBooksAndChaptersY5;
	private String uniqueFullTimeTeachY1;
	private String uniqueFullTimeTeachY2;
	private String uniqueFullTimeTeachY3;
	private String uniqueFullTimeTeachY4;
	private String uniqueFullTimeTeachY5;
	private String instDataTempDoc;//
	private String relevantDocLink3;
	private String eContentDevelopers;
	private String eContentDevelopersType;
	private String ftTeachersLast5Years1;
	private String ftTeachersLast5Years2;
	private String ftTeachersLast5Years3;
	private String ftTeachersLast5Years4;
	private String ftTeachersLast5Years5;
	private String instDataTempDoc2;//
	private String otherRelivantLink3;

//	3.5. Consultancy
	
	private String extActOutcome_neighComm_5yrs;
	private String consultancyTrainingRevenueY1;
	private String consultancyTrainingRevenueY2;
	private String consultancyTrainingRevenueY3;
	private String consultancyTrainingRevenueY4;
	private String consultancyTrainingRevenueY5;
	private String addInfo_doc;//
	private String addInfoLink;

// 3.6. Extension Activities
	private String extActAwardsGovt;
	private String addInfo_doc2;//
	private String publicDisclosureInfo;
	private String addInfoLink3;
	private String numExtOutreachPrograms;
	private String numExtOutreachProgramsY1;
	private String numExtOutreachProgramsY2;
	private String numExtOutreachProgramsY3;
	private String numExtOutreachProgramsY4;
	private String numExtOutreachProgramsY5;
	private String institutionalDataFormat_doc5;//
	private String relevantDocumentSupport_Link3;
//	3.7. Collaboration
	private String totFunctLinkagesLast5Years;
	private String functLinkagesLastY1;
	private String functLinkagesLastY2;
	private String functLinkagesLastY3;
	private String functLinkagesLastY4;
	private String functLinkagesLastY5;
	private String institutionalDataFormat_doc4;//
	private String relevantDocumentSupport_Link2;


	public long getCriteriaIII_Id() {
		return CriteriaIII_Id;
	}
	public void setCriteriaIII_Id(long criteriaIII_Id) {
		CriteriaIII_Id = criteriaIII_Id;
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
	public String getResearchPromotionPolicy() {
		return researchPromotionPolicy;
	}
	public void setResearchPromotionPolicy(String researchPromotionPolicy) {
		this.researchPromotionPolicy = researchPromotionPolicy;
	}

	public String getAdditionalInforDoc() {
		return additionalInforDoc;
	}
	public void setAdditionalInforDoc(String additionalInforDoc) {
		this.additionalInforDoc = additionalInforDoc;
	}
	public String getLinkForAdditionalInfo() {
		return linkForAdditionalInfo;
	}
	public void setLinkForAdditionalInfo(String linkForAdditionalInfo) {
		this.linkForAdditionalInfo = linkForAdditionalInfo;
	}
	public String getSupportingDoc() {
		return supportingDoc;
	}
	public void setSupportingDoc(String supportingDoc) {
		this.supportingDoc = supportingDoc;
	}
	public String getSeedMoneyForResearchPerYear() {
		return seedMoneyForResearchPerYear;
	}
	public void setSeedMoneyForResearchPerYear(String seedMoneyForResearchPerYear) {
		this.seedMoneyForResearchPerYear = seedMoneyForResearchPerYear;
	}
	public String getSeedMoneyByYear1() {
		return seedMoneyByYear1;
	}
	public void setSeedMoneyByYear1(String seedMoneyByYear1) {
		this.seedMoneyByYear1 = seedMoneyByYear1;
	}
	public String getSeedMoneyByYear2() {
		return seedMoneyByYear2;
	}
	public void setSeedMoneyByYear2(String seedMoneyByYear2) {
		this.seedMoneyByYear2 = seedMoneyByYear2;
	}
	public String getSeedMoneyByYear3() {
		return seedMoneyByYear3;
	}
	public void setSeedMoneyByYear3(String seedMoneyByYear3) {
		this.seedMoneyByYear3 = seedMoneyByYear3;
	}
	public String getSeedMoneyByYear4() {
		return seedMoneyByYear4;
	}
	public void setSeedMoneyByYear4(String seedMoneyByYear4) {
		this.seedMoneyByYear4 = seedMoneyByYear4;
	}
	public String getSeedMoneyByYear5() {
		return seedMoneyByYear5;
	}
	public void setSeedMoneyByYear5(String seedMoneyByYear5) {
		this.seedMoneyByYear5 = seedMoneyByYear5;
	}
	public String getSupportingDocumentLinks3() {
		return supportingDocumentLinks3;
	}
	public void setSupportingDocumentLinks3(String supportingDocumentLinks3) {
		this.supportingDocumentLinks3 = supportingDocumentLinks3;
	}
	public String getTeachFellowshipPercent() {
		return teachFellowshipPercent;
	}
	public void setTeachFellowshipPercent(String teachFellowshipPercent) {
		this.teachFellowshipPercent = teachFellowshipPercent;
	}
	public String getTeacherFellowshipsY1() {
		return teacherFellowshipsY1;
	}
	public void setTeacherFellowshipsY1(String teacherFellowshipsY1) {
		this.teacherFellowshipsY1 = teacherFellowshipsY1;
	}
	public String getTeacherFellowshipsY2() {
		return teacherFellowshipsY2;
	}
	public void setTeacherFellowshipsY2(String teacherFellowshipsY2) {
		this.teacherFellowshipsY2 = teacherFellowshipsY2;
	}
	public String getTeacherFellowshipsY3() {
		return teacherFellowshipsY3;
	}
	public void setTeacherFellowshipsY3(String teacherFellowshipsY3) {
		this.teacherFellowshipsY3 = teacherFellowshipsY3;
	}
	public String getTeacherFellowshipsY4() {
		return teacherFellowshipsY4;
	}
	public void setTeacherFellowshipsY4(String teacherFellowshipsY4) {
		this.teacherFellowshipsY4 = teacherFellowshipsY4;
	}
	public String getTeacherFellowshipsY5() {
		return teacherFellowshipsY5;
	}
	public void setTeacherFellowshipsY5(String teacherFellowshipsY5) {
		this.teacherFellowshipsY5 = teacherFellowshipsY5;
	}
	public String getFullTimeTeachersY1() {
		return fullTimeTeachersY1;
	}
	public void setFullTimeTeachersY1(String fullTimeTeachersY1) {
		this.fullTimeTeachersY1 = fullTimeTeachersY1;
	}
	public String getFullTimeTeachersY2() {
		return fullTimeTeachersY2;
	}
	public void setFullTimeTeachersY2(String fullTimeTeachersY2) {
		this.fullTimeTeachersY2 = fullTimeTeachersY2;
	}
	public String getFullTimeTeachersY3() {
		return fullTimeTeachersY3;
	}
	public void setFullTimeTeachersY3(String fullTimeTeachersY3) {
		this.fullTimeTeachersY3 = fullTimeTeachersY3;
	}
	public String getFullTimeTeachersY4() {
		return fullTimeTeachersY4;
	}
	public void setFullTimeTeachersY4(String fullTimeTeachersY4) {
		this.fullTimeTeachersY4 = fullTimeTeachersY4;
	}
	public String getFullTimeTeachersY5() {
		return fullTimeTeachersY5;
	}
	public void setFullTimeTeachersY5(String fullTimeTeachersY5) {
		this.fullTimeTeachersY5 = fullTimeTeachersY5;
	}
	
	public String getRelevantDocLink() {
		return relevantDocLink;
	}
	public void setRelevantDocLink(String relevantDocLink) {
		this.relevantDocLink = relevantDocLink;
	}
	public String getPhdScholarsEnrolledPercnt() {
		return phdScholarsEnrolledPercnt;
	}
	public void setPhdScholarsEnrolledPercnt(String phdScholarsEnrolledPercnt) {
		this.phdScholarsEnrolledPercnt = phdScholarsEnrolledPercnt;
	}
	public String getJrfCountLastFiveYears() {
		return jrfCountLastFiveYears;
	}
	public void setJrfCountLastFiveYears(String jrfCountLastFiveYears) {
		this.jrfCountLastFiveYears = jrfCountLastFiveYears;
	}
	public String getNoOfPhdScholarEnroledY1() {
		return noOfPhdScholarEnroledY1;
	}
	public void setNoOfPhdScholarEnroledY1(String noOfPhdScholarEnroledY1) {
		this.noOfPhdScholarEnroledY1 = noOfPhdScholarEnroledY1;
	}
	public String getNoOfPhdScholarEnroledY2() {
		return noOfPhdScholarEnroledY2;
	}
	public void setNoOfPhdScholarEnroledY2(String noOfPhdScholarEnroledY2) {
		this.noOfPhdScholarEnroledY2 = noOfPhdScholarEnroledY2;
	}
	public String getNoOfPhdScholarEnroledY3() {
		return noOfPhdScholarEnroledY3;
	}
	public void setNoOfPhdScholarEnroledY3(String noOfPhdScholarEnroledY3) {
		this.noOfPhdScholarEnroledY3 = noOfPhdScholarEnroledY3;
	}
	public String getNoOfPhdScholarEnroledY4() {
		return noOfPhdScholarEnroledY4;
	}
	public void setNoOfPhdScholarEnroledY4(String noOfPhdScholarEnroledY4) {
		this.noOfPhdScholarEnroledY4 = noOfPhdScholarEnroledY4;
	}
	public String getNoOfPhdScholarEnroledY5() {
		return noOfPhdScholarEnroledY5;
	}
	public void setNoOfPhdScholarEnroledY5(String noOfPhdScholarEnroledY5) {
		this.noOfPhdScholarEnroledY5 = noOfPhdScholarEnroledY5;
	}
	public String getInstitDataTemp_Doc() {
		return institDataTemp_Doc;
	}
	public void setInstitDataTemp_Doc(String institDataTemp_Doc) {
		this.institDataTemp_Doc = institDataTemp_Doc;
	}
	public String getRelevantDocsLink() {
		return relevantDocsLink;
	}
	public void setRelevantDocsLink(String relevantDocsLink) {
		this.relevantDocsLink = relevantDocsLink;
	}
	public String getGrantReceivedLastFiveYears() {
		return grantReceivedLastFiveYears;
	}
	public void setGrantReceivedLastFiveYears(String grantReceivedLastFiveYears) {
		this.grantReceivedLastFiveYears = grantReceivedLastFiveYears;
	}
	public String getTotGrantGovtNonGovtLastY1() {
		return totGrantGovtNonGovtLastY1;
	}
	public void setTotGrantGovtNonGovtLastY1(String totGrantGovtNonGovtLastY1) {
		this.totGrantGovtNonGovtLastY1 = totGrantGovtNonGovtLastY1;
	}
	public String getTotGrantGovtNonGovtLastY2() {
		return totGrantGovtNonGovtLastY2;
	}
	public void setTotGrantGovtNonGovtLastY2(String totGrantGovtNonGovtLastY2) {
		this.totGrantGovtNonGovtLastY2 = totGrantGovtNonGovtLastY2;
	}
	public String getTotGrantGovtNonGovtLastY3() {
		return totGrantGovtNonGovtLastY3;
	}
	public void setTotGrantGovtNonGovtLastY3(String totGrantGovtNonGovtLastY3) {
		this.totGrantGovtNonGovtLastY3 = totGrantGovtNonGovtLastY3;
	}
	public String getTotGrantGovtNonGovtLastY4() {
		return totGrantGovtNonGovtLastY4;
	}
	public void setTotGrantGovtNonGovtLastY4(String totGrantGovtNonGovtLastY4) {
		this.totGrantGovtNonGovtLastY4 = totGrantGovtNonGovtLastY4;
	}
	public String getTotGrantGovtNonGovtLastY5() {
		return totGrantGovtNonGovtLastY5;
	}
	public void setTotGrantGovtNonGovtLastY5(String totGrantGovtNonGovtLastY5) {
		this.totGrantGovtNonGovtLastY5 = totGrantGovtNonGovtLastY5;
	}
	public String getInstDataTemplate_doc() {
		return instDataTemplate_doc;
	}
	public void setInstDataTemplate_doc(String instDataTemplate_doc) {
		this.instDataTemplate_doc = instDataTemplate_doc;
	}
	
	public String getSupporting_doc91() {
		return supporting_doc91;
	}
	public void setSupporting_doc91(String supporting_doc91) {
		this.supporting_doc91 = supporting_doc91;
	}
	public String getNoCorpoResearchProjects() {
		return noCorpoResearchProjects;
	}
	public void setNoCorpoResearchProjects(String noCorpoResearchProjects) {
		this.noCorpoResearchProjects = noCorpoResearchProjects;
	}
	public String getNonGovtFundedProjectsY1() {
		return nonGovtFundedProjectsY1;
	}
	public void setNonGovtFundedProjectsY1(String nonGovtFundedProjectsY1) {
		this.nonGovtFundedProjectsY1 = nonGovtFundedProjectsY1;
	}
	public String getNonGovtFundedProjectsY2() {
		return nonGovtFundedProjectsY2;
	}
	public void setNonGovtFundedProjectsY2(String nonGovtFundedProjectsY2) {
		this.nonGovtFundedProjectsY2 = nonGovtFundedProjectsY2;
	}
	public String getNonGovtFundedProjectsY3() {
		return nonGovtFundedProjectsY3;
	}
	public void setNonGovtFundedProjectsY3(String nonGovtFundedProjectsY3) {
		this.nonGovtFundedProjectsY3 = nonGovtFundedProjectsY3;
	}
	public String getNonGovtFundedProjectsY4() {
		return nonGovtFundedProjectsY4;
	}
	public void setNonGovtFundedProjectsY4(String nonGovtFundedProjectsY4) {
		this.nonGovtFundedProjectsY4 = nonGovtFundedProjectsY4;
	}
	public String getNonGovtFundedProjectsY5() {
		return nonGovtFundedProjectsY5;
	}
	public void setNonGovtFundedProjectsY5(String nonGovtFundedProjectsY5) {
		this.nonGovtFundedProjectsY5 = nonGovtFundedProjectsY5;
	}
	public String getFtTeachersByYear1() {
		return ftTeachersByYear1;
	}
	public void setFtTeachersByYear1(String ftTeachersByYear1) {
		this.ftTeachersByYear1 = ftTeachersByYear1;
	}
	public String getFtTeachersByYear2() {
		return ftTeachersByYear2;
	}
	public void setFtTeachersByYear2(String ftTeachersByYear2) {
		this.ftTeachersByYear2 = ftTeachersByYear2;
	}
	public String getFtTeachersByYear3() {
		return ftTeachersByYear3;
	}
	public void setFtTeachersByYear3(String ftTeachersByYear3) {
		this.ftTeachersByYear3 = ftTeachersByYear3;
	}
	public String getFtTeachersByYear4() {
		return ftTeachersByYear4;
	}
	public void setFtTeachersByYear4(String ftTeachersByYear4) {
		this.ftTeachersByYear4 = ftTeachersByYear4;
	}
	public String getFtTeachersByYear5() {
		return ftTeachersByYear5;
	}
	public void setFtTeachersByYear5(String ftTeachersByYear5) {
		this.ftTeachersByYear5 = ftTeachersByYear5;
	}
	public String getTotalFullTimeTeachersY1() {
		return totalFullTimeTeachersY1;
	}
	public void setTotalFullTimeTeachersY1(String totalFullTimeTeachersY1) {
		this.totalFullTimeTeachersY1 = totalFullTimeTeachersY1;
	}
	public String getTotalFullTimeTeachersY2() {
		return totalFullTimeTeachersY2;
	}
	public void setTotalFullTimeTeachersY2(String totalFullTimeTeachersY2) {
		this.totalFullTimeTeachersY2 = totalFullTimeTeachersY2;
	}
	public String getTotalFullTimeTeachersY3() {
		return totalFullTimeTeachersY3;
	}
	public void setTotalFullTimeTeachersY3(String totalFullTimeTeachersY3) {
		this.totalFullTimeTeachersY3 = totalFullTimeTeachersY3;
	}
	public String getTotalFullTimeTeachersY4() {
		return totalFullTimeTeachersY4;
	}
	public void setTotalFullTimeTeachersY4(String totalFullTimeTeachersY4) {
		this.totalFullTimeTeachersY4 = totalFullTimeTeachersY4;
	}
	public String getTotalFullTimeTeachersY5() {
		return totalFullTimeTeachersY5;
	}
	public void setTotalFullTimeTeachersY5(String totalFullTimeTeachersY5) {
		this.totalFullTimeTeachersY5 = totalFullTimeTeachersY5;
	}
	public String getInstitutionalDataTemplateDoc() {
		return institutionalDataTemplateDoc;
	}
	public void setInstitutionalDataTemplateDoc(String institutionalDataTemplateDoc) {
		this.institutionalDataTemplateDoc = institutionalDataTemplateDoc;
	}
	public String getOtherRelevantDocLink() {
		return otherRelevantDocLink;
	}
	public void setOtherRelevantDocLink(String otherRelevantDocLink) {
		this.otherRelevantDocLink = otherRelevantDocLink;
	}
	public String getDevlopedKnowledgeSystem() {
		return devlopedKnowledgeSystem;
	}
	public void setDevlopedKnowledgeSystem(String devlopedKnowledgeSystem) {
		this.devlopedKnowledgeSystem = devlopedKnowledgeSystem;
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
	public String getTotWorkshopsOnResearchMethodology() {
		return totWorkshopsOnResearchMethodology;
	}
	public void setTotWorkshopsOnResearchMethodology(String totWorkshopsOnResearchMethodology) {
		this.totWorkshopsOnResearchMethodology = totWorkshopsOnResearchMethodology;
	}
	public String getTotWorkshopOnResearchMetho_Y1() {
		return totWorkshopOnResearchMetho_Y1;
	}
	public void setTotWorkshopOnResearchMetho_Y1(String totWorkshopOnResearchMetho_Y1) {
		this.totWorkshopOnResearchMetho_Y1 = totWorkshopOnResearchMetho_Y1;
	}
	public String getTotWorkshopOnResearchMetho_Y2() {
		return totWorkshopOnResearchMetho_Y2;
	}
	public void setTotWorkshopOnResearchMetho_Y2(String totWorkshopOnResearchMetho_Y2) {
		this.totWorkshopOnResearchMetho_Y2 = totWorkshopOnResearchMetho_Y2;
	}
	public String getTotWorkshopOnResearchMetho_Y3() {
		return totWorkshopOnResearchMetho_Y3;
	}
	public void setTotWorkshopOnResearchMetho_Y3(String totWorkshopOnResearchMetho_Y3) {
		this.totWorkshopOnResearchMetho_Y3 = totWorkshopOnResearchMetho_Y3;
	}
	public String getTotWorkshopOnResearchMetho_Y4() {
		return totWorkshopOnResearchMetho_Y4;
	}
	public void setTotWorkshopOnResearchMetho_Y4(String totWorkshopOnResearchMetho_Y4) {
		this.totWorkshopOnResearchMetho_Y4 = totWorkshopOnResearchMetho_Y4;
	}
	public String getTotWorkshopOnResearchMetho_Y5() {
		return totWorkshopOnResearchMetho_Y5;
	}
	public void setTotWorkshopOnResearchMetho_Y5(String totWorkshopOnResearchMetho_Y5) {
		this.totWorkshopOnResearchMetho_Y5 = totWorkshopOnResearchMetho_Y5;
	}
	public String getInstitutionalDataFormat_doc() {
		return institutionalDataFormat_doc;
	}
	public void setInstitutionalDataFormat_doc(String institutionalDataFormat_doc) {
		this.institutionalDataFormat_doc = institutionalDataFormat_doc;
	}
	public String getSupporting_doc32() {
		return supporting_doc32;
	}
	public void setSupporting_doc32(String supporting_doc32) {
		this.supporting_doc32 = supporting_doc32;
	}
	public String getEthicsCodeImplementation() {
		return ethicsCodeImplementation;
	}
	public void setEthicsCodeImplementation(String ethicsCodeImplementation) {
		this.ethicsCodeImplementation = ethicsCodeImplementation;
	}
	public String getEthicsCodeImplementationType() {
		return ethicsCodeImplementationType;
	}
	public void setEthicsCodeImplementationType(String ethicsCodeImplementationType) {
		this.ethicsCodeImplementationType = ethicsCodeImplementationType;
	}
	public String getInstitutionalDataFormat_doc2() {
		return institutionalDataFormat_doc2;
	}
	public void setInstitutionalDataFormat_doc2(String institutionalDataFormat_doc2) {
		this.institutionalDataFormat_doc2 = institutionalDataFormat_doc2;
	}
	public String getRelivantDocLink() {
		return relivantDocLink;
	}
	public void setRelivantDocLink(String relivantDocLink) {
		this.relivantDocLink = relivantDocLink;
	}
	public String getNoOfParentAwareded() {
		return noOfParentAwareded;
	}
	public void setNoOfParentAwareded(String noOfParentAwareded) {
		this.noOfParentAwareded = noOfParentAwareded;
	}
	public String getNoOfParentAwarededY1() {
		return noOfParentAwarededY1;
	}
	public void setNoOfParentAwarededY1(String noOfParentAwarededY1) {
		this.noOfParentAwarededY1 = noOfParentAwarededY1;
	}
	public String getNoOfParentAwarededY2() {
		return noOfParentAwarededY2;
	}
	public void setNoOfParentAwarededY2(String noOfParentAwarededY2) {
		this.noOfParentAwarededY2 = noOfParentAwarededY2;
	}
	public String getNoOfParentAwarededY3() {
		return noOfParentAwarededY3;
	}
	public void setNoOfParentAwarededY3(String noOfParentAwarededY3) {
		this.noOfParentAwarededY3 = noOfParentAwarededY3;
	}
	public String getNoOfParentAwarededY4() {
		return noOfParentAwarededY4;
	}
	public void setNoOfParentAwarededY4(String noOfParentAwarededY4) {
		this.noOfParentAwarededY4 = noOfParentAwarededY4;
	}
	public String getNoOfParentAwarededY5() {
		return noOfParentAwarededY5;
	}
	public void setNoOfParentAwarededY5(String noOfParentAwarededY5) {
		this.noOfParentAwarededY5 = noOfParentAwarededY5;
	}
	public String getInstitutionalDataFormat_doc3() {
		return institutionalDataFormat_doc3;
	}
	public void setInstitutionalDataFormat_doc3(String institutionalDataFormat_doc3) {
		this.institutionalDataFormat_doc3 = institutionalDataFormat_doc3;
	}
	public String getRelevantDocumentSupport_Link() {
		return relevantDocumentSupport_Link;
	}
	public void setRelevantDocumentSupport_Link(String relevantDocumentSupport_Link) {
		this.relevantDocumentSupport_Link = relevantDocumentSupport_Link;
	}
	public String getTotNoPhdsAwarededPerGuide() {
		return totNoPhdsAwarededPerGuide;
	}
	public void setTotNoPhdsAwarededPerGuide(String totNoPhdsAwarededPerGuide) {
		this.totNoPhdsAwarededPerGuide = totNoPhdsAwarededPerGuide;
	}
	public String getNoPhdsAwarededPerGuideY1() {
		return noPhdsAwarededPerGuideY1;
	}
	public void setNoPhdsAwarededPerGuideY1(String noPhdsAwarededPerGuideY1) {
		this.noPhdsAwarededPerGuideY1 = noPhdsAwarededPerGuideY1;
	}
	public String getNoPhdsAwarededPerGuideY2() {
		return noPhdsAwarededPerGuideY2;
	}
	public void setNoPhdsAwarededPerGuideY2(String noPhdsAwarededPerGuideY2) {
		this.noPhdsAwarededPerGuideY2 = noPhdsAwarededPerGuideY2;
	}
	public String getNoPhdsAwarededPerGuideY3() {
		return noPhdsAwarededPerGuideY3;
	}
	public void setNoPhdsAwarededPerGuideY3(String noPhdsAwarededPerGuideY3) {
		this.noPhdsAwarededPerGuideY3 = noPhdsAwarededPerGuideY3;
	}
	public String getNoPhdsAwarededPerGuideY4() {
		return noPhdsAwarededPerGuideY4;
	}
	public void setNoPhdsAwarededPerGuideY4(String noPhdsAwarededPerGuideY4) {
		this.noPhdsAwarededPerGuideY4 = noPhdsAwarededPerGuideY4;
	}
	public String getNoPhdsAwarededPerGuideY5() {
		return noPhdsAwarededPerGuideY5;
	}
	public void setNoPhdsAwarededPerGuideY5(String noPhdsAwarededPerGuideY5) {
		this.noPhdsAwarededPerGuideY5 = noPhdsAwarededPerGuideY5;
	}
	public String getGuideRecognitionY1() {
		return guideRecognitionY1;
	}
	public void setGuideRecognitionY1(String guideRecognitionY1) {
		this.guideRecognitionY1 = guideRecognitionY1;
	}
	public String getGuideRecognitionY2() {
		return guideRecognitionY2;
	}
	public void setGuideRecognitionY2(String guideRecognitionY2) {
		this.guideRecognitionY2 = guideRecognitionY2;
	}
	public String getGuideRecognitionY3() {
		return guideRecognitionY3;
	}
	public void setGuideRecognitionY3(String guideRecognitionY3) {
		this.guideRecognitionY3 = guideRecognitionY3;
	}
	public String getGuideRecognitionY4() {
		return guideRecognitionY4;
	}
	public void setGuideRecognitionY4(String guideRecognitionY4) {
		this.guideRecognitionY4 = guideRecognitionY4;
	}
	public String getGuideRecognitionY5() {
		return guideRecognitionY5;
	}
	public void setGuideRecognitionY5(String guideRecognitionY5) {
		this.guideRecognitionY5 = guideRecognitionY5;
	}
	public String getInstitDataFormat_doc() {
		return institDataFormat_doc;
	}
	public void setInstitDataFormat_doc(String institDataFormat_doc) {
		this.institDataFormat_doc = institDataFormat_doc;
	}
	public String getOtherRelivantLink() {
		return otherRelivantLink;
	}
	public void setOtherRelivantLink(String otherRelivantLink) {
		this.otherRelivantLink = otherRelivantLink;
	}
	public String getNoResearchPapersPerTeach() {
		return NoResearchPapersPerTeach;
	}
	public void setNoResearchPapersPerTeach(String noResearchPapersPerTeach) {
		NoResearchPapersPerTeach = noResearchPapersPerTeach;
	}
	public String getPubJournalsUGCListY1() {
		return pubJournalsUGCListY1;
	}
	public void setPubJournalsUGCListY1(String pubJournalsUGCListY1) {
		this.pubJournalsUGCListY1 = pubJournalsUGCListY1;
	}
	public String getPubJournalsUGCListY2() {
		return pubJournalsUGCListY2;
	}
	public void setPubJournalsUGCListY2(String pubJournalsUGCListY2) {
		this.pubJournalsUGCListY2 = pubJournalsUGCListY2;
	}
	public String getPubJournalsUGCListY3() {
		return pubJournalsUGCListY3;
	}
	public void setPubJournalsUGCListY3(String pubJournalsUGCListY3) {
		this.pubJournalsUGCListY3 = pubJournalsUGCListY3;
	}
	public String getPubJournalsUGCListY4() {
		return pubJournalsUGCListY4;
	}
	public void setPubJournalsUGCListY4(String pubJournalsUGCListY4) {
		this.pubJournalsUGCListY4 = pubJournalsUGCListY4;
	}
	public String getPubJournalsUGCListY5() {
		return pubJournalsUGCListY5;
	}
	public void setPubJournalsUGCListY5(String pubJournalsUGCListY5) {
		this.pubJournalsUGCListY5 = pubJournalsUGCListY5;
	}
	public String getFullTimeTeachersWorkedY1() {
		return fullTimeTeachersWorkedY1;
	}
	public void setFullTimeTeachersWorkedY1(String fullTimeTeachersWorkedY1) {
		this.fullTimeTeachersWorkedY1 = fullTimeTeachersWorkedY1;
	}
	public String getFullTimeTeachersWorkedY2() {
		return fullTimeTeachersWorkedY2;
	}
	public void setFullTimeTeachersWorkedY2(String fullTimeTeachersWorkedY2) {
		this.fullTimeTeachersWorkedY2 = fullTimeTeachersWorkedY2;
	}
	public String getFullTimeTeachersWorkedY3() {
		return fullTimeTeachersWorkedY3;
	}
	public void setFullTimeTeachersWorkedY3(String fullTimeTeachersWorkedY3) {
		this.fullTimeTeachersWorkedY3 = fullTimeTeachersWorkedY3;
	}
	public String getFullTimeTeachersWorkedY4() {
		return fullTimeTeachersWorkedY4;
	}
	public void setFullTimeTeachersWorkedY4(String fullTimeTeachersWorkedY4) {
		this.fullTimeTeachersWorkedY4 = fullTimeTeachersWorkedY4;
	}
	public String getFullTimeTeachersWorkedY5() {
		return fullTimeTeachersWorkedY5;
	}
	public void setFullTimeTeachersWorkedY5(String fullTimeTeachersWorkedY5) {
		this.fullTimeTeachersWorkedY5 = fullTimeTeachersWorkedY5;
	}
	public String getInstitDataFormat_doc2() {
		return institDataFormat_doc2;
	}
	public void setInstitDataFormat_doc2(String institDataFormat_doc2) {
		this.institDataFormat_doc2 = institDataFormat_doc2;
	}
	public String getOtherRelivantLink2() {
		return otherRelivantLink2;
	}
	public void setOtherRelivantLink2(String otherRelivantLink2) {
		this.otherRelivantLink2 = otherRelivantLink2;
	}
	public String getBooksPerTeacherLast5Years() {
		return booksPerTeacherLast5Years;
	}
	public void setBooksPerTeacherLast5Years(String booksPerTeacherLast5Years) {
		this.booksPerTeacherLast5Years = booksPerTeacherLast5Years;
	}
	public String getTotalBooksAndChaptersY1() {
		return totalBooksAndChaptersY1;
	}
	public void setTotalBooksAndChaptersY1(String totalBooksAndChaptersY1) {
		this.totalBooksAndChaptersY1 = totalBooksAndChaptersY1;
	}
	public String getTotalBooksAndChaptersY2() {
		return totalBooksAndChaptersY2;
	}
	public void setTotalBooksAndChaptersY2(String totalBooksAndChaptersY2) {
		this.totalBooksAndChaptersY2 = totalBooksAndChaptersY2;
	}
	public String getTotalBooksAndChaptersY3() {
		return totalBooksAndChaptersY3;
	}
	public void setTotalBooksAndChaptersY3(String totalBooksAndChaptersY3) {
		this.totalBooksAndChaptersY3 = totalBooksAndChaptersY3;
	}
	public String getTotalBooksAndChaptersY4() {
		return totalBooksAndChaptersY4;
	}
	public void setTotalBooksAndChaptersY4(String totalBooksAndChaptersY4) {
		this.totalBooksAndChaptersY4 = totalBooksAndChaptersY4;
	}
	public String getTotalBooksAndChaptersY5() {
		return totalBooksAndChaptersY5;
	}
	public void setTotalBooksAndChaptersY5(String totalBooksAndChaptersY5) {
		this.totalBooksAndChaptersY5 = totalBooksAndChaptersY5;
	}
	public String getUniqueFullTimeTeachY1() {
		return uniqueFullTimeTeachY1;
	}
	public void setUniqueFullTimeTeachY1(String uniqueFullTimeTeachY1) {
		this.uniqueFullTimeTeachY1 = uniqueFullTimeTeachY1;
	}
	public String getUniqueFullTimeTeachY2() {
		return uniqueFullTimeTeachY2;
	}
	public void setUniqueFullTimeTeachY2(String uniqueFullTimeTeachY2) {
		this.uniqueFullTimeTeachY2 = uniqueFullTimeTeachY2;
	}
	public String getUniqueFullTimeTeachY3() {
		return uniqueFullTimeTeachY3;
	}
	public void setUniqueFullTimeTeachY3(String uniqueFullTimeTeachY3) {
		this.uniqueFullTimeTeachY3 = uniqueFullTimeTeachY3;
	}
	public String getUniqueFullTimeTeachY4() {
		return uniqueFullTimeTeachY4;
	}
	public void setUniqueFullTimeTeachY4(String uniqueFullTimeTeachY4) {
		this.uniqueFullTimeTeachY4 = uniqueFullTimeTeachY4;
	}
	public String getUniqueFullTimeTeachY5() {
		return uniqueFullTimeTeachY5;
	}
	public void setUniqueFullTimeTeachY5(String uniqueFullTimeTeachY5) {
		this.uniqueFullTimeTeachY5 = uniqueFullTimeTeachY5;
	}
	public String getInstDataTempDoc() {
		return instDataTempDoc;
	}
	public void setInstDataTempDoc(String instDataTempDoc) {
		this.instDataTempDoc = instDataTempDoc;
	}
	public String getRelevantDocLink3() {
		return relevantDocLink3;
	}
	public void setRelevantDocLink3(String relevantDocLink3) {
		this.relevantDocLink3 = relevantDocLink3;
	}
	public String geteContentDevelopers() {
		return eContentDevelopers;
	}
	public void seteContentDevelopers(String eContentDevelopers) {
		this.eContentDevelopers = eContentDevelopers;
	}
	public String geteContentDevelopersType() {
		return eContentDevelopersType;
	}
	public void seteContentDevelopersType(String eContentDevelopersType) {
		this.eContentDevelopersType = eContentDevelopersType;
	}
	public String getFtTeachersLast5Years1() {
		return ftTeachersLast5Years1;
	}
	public void setFtTeachersLast5Years1(String ftTeachersLast5Years1) {
		this.ftTeachersLast5Years1 = ftTeachersLast5Years1;
	}
	public String getFtTeachersLast5Years2() {
		return ftTeachersLast5Years2;
	}
	public void setFtTeachersLast5Years2(String ftTeachersLast5Years2) {
		this.ftTeachersLast5Years2 = ftTeachersLast5Years2;
	}
	public String getFtTeachersLast5Years3() {
		return ftTeachersLast5Years3;
	}
	public void setFtTeachersLast5Years3(String ftTeachersLast5Years3) {
		this.ftTeachersLast5Years3 = ftTeachersLast5Years3;
	}
	public String getFtTeachersLast5Years4() {
		return ftTeachersLast5Years4;
	}
	public void setFtTeachersLast5Years4(String ftTeachersLast5Years4) {
		this.ftTeachersLast5Years4 = ftTeachersLast5Years4;
	}
	public String getFtTeachersLast5Years5() {
		return ftTeachersLast5Years5;
	}
	public void setFtTeachersLast5Years5(String ftTeachersLast5Years5) {
		this.ftTeachersLast5Years5 = ftTeachersLast5Years5;
	}
	public String getInstDataTempDoc2() {
		return instDataTempDoc2;
	}
	public void setInstDataTempDoc2(String instDataTempDoc2) {
		this.instDataTempDoc2 = instDataTempDoc2;
	}
	public String getOtherRelivantLink3() {
		return otherRelivantLink3;
	}
	public void setOtherRelivantLink3(String otherRelivantLink3) {
		this.otherRelivantLink3 = otherRelivantLink3;
	}
	public String getExtActOutcome_neighComm_5yrs() {
		return extActOutcome_neighComm_5yrs;
	}
	public void setExtActOutcome_neighComm_5yrs(String extActOutcome_neighComm_5yrs) {
		this.extActOutcome_neighComm_5yrs = extActOutcome_neighComm_5yrs;
	}
	public String getConsultancyTrainingRevenueY1() {
		return consultancyTrainingRevenueY1;
	}
	public void setConsultancyTrainingRevenueY1(String consultancyTrainingRevenueY1) {
		this.consultancyTrainingRevenueY1 = consultancyTrainingRevenueY1;
	}
	public String getConsultancyTrainingRevenueY2() {
		return consultancyTrainingRevenueY2;
	}
	public void setConsultancyTrainingRevenueY2(String consultancyTrainingRevenueY2) {
		this.consultancyTrainingRevenueY2 = consultancyTrainingRevenueY2;
	}
	public String getConsultancyTrainingRevenueY3() {
		return consultancyTrainingRevenueY3;
	}
	public void setConsultancyTrainingRevenueY3(String consultancyTrainingRevenueY3) {
		this.consultancyTrainingRevenueY3 = consultancyTrainingRevenueY3;
	}
	public String getConsultancyTrainingRevenueY4() {
		return consultancyTrainingRevenueY4;
	}
	public void setConsultancyTrainingRevenueY4(String consultancyTrainingRevenueY4) {
		this.consultancyTrainingRevenueY4 = consultancyTrainingRevenueY4;
	}
	public String getConsultancyTrainingRevenueY5() {
		return consultancyTrainingRevenueY5;
	}
	public void setConsultancyTrainingRevenueY5(String consultancyTrainingRevenueY5) {
		this.consultancyTrainingRevenueY5 = consultancyTrainingRevenueY5;
	}
	public String getAddInfo_doc() {
		return addInfo_doc;
	}
	public void setAddInfo_doc(String addInfo_doc) {
		this.addInfo_doc = addInfo_doc;
	}
	public String getAddInfoLink() {
		return addInfoLink;
	}
	public void setAddInfoLink(String addInfoLink) {
		this.addInfoLink = addInfoLink;
	}
	public String getExtActAwardsGovt() {
		return extActAwardsGovt;
	}
	public void setExtActAwardsGovt(String extActAwardsGovt) {
		this.extActAwardsGovt = extActAwardsGovt;
	}
	public String getAddInfo_doc2() {
		return addInfo_doc2;
	}
	public void setAddInfo_doc2(String addInfo_doc2) {
		this.addInfo_doc2 = addInfo_doc2;
	}
	public String getPublicDisclosureInfo() {
		return publicDisclosureInfo;
	}
	public void setPublicDisclosureInfo(String publicDisclosureInfo) {
		this.publicDisclosureInfo = publicDisclosureInfo;
	}
	public String getAddInfoLink3() {
		return addInfoLink3;
	}
	public void setAddInfoLink3(String addInfoLink3) {
		this.addInfoLink3 = addInfoLink3;
	}
	public String getNumExtOutreachPrograms() {
		return numExtOutreachPrograms;
	}
	public void setNumExtOutreachPrograms(String numExtOutreachPrograms) {
		this.numExtOutreachPrograms = numExtOutreachPrograms;
	}
	public String getNumExtOutreachProgramsY1() {
		return numExtOutreachProgramsY1;
	}
	public void setNumExtOutreachProgramsY1(String numExtOutreachProgramsY1) {
		this.numExtOutreachProgramsY1 = numExtOutreachProgramsY1;
	}
	public String getNumExtOutreachProgramsY2() {
		return numExtOutreachProgramsY2;
	}
	public void setNumExtOutreachProgramsY2(String numExtOutreachProgramsY2) {
		this.numExtOutreachProgramsY2 = numExtOutreachProgramsY2;
	}
	public String getNumExtOutreachProgramsY3() {
		return numExtOutreachProgramsY3;
	}
	public void setNumExtOutreachProgramsY3(String numExtOutreachProgramsY3) {
		this.numExtOutreachProgramsY3 = numExtOutreachProgramsY3;
	}
	public String getNumExtOutreachProgramsY4() {
		return numExtOutreachProgramsY4;
	}
	public void setNumExtOutreachProgramsY4(String numExtOutreachProgramsY4) {
		this.numExtOutreachProgramsY4 = numExtOutreachProgramsY4;
	}
	public String getNumExtOutreachProgramsY5() {
		return numExtOutreachProgramsY5;
	}
	public void setNumExtOutreachProgramsY5(String numExtOutreachProgramsY5) {
		this.numExtOutreachProgramsY5 = numExtOutreachProgramsY5;
	}
	public String getInstitutionalDataFormat_doc5() {
		return institutionalDataFormat_doc5;
	}
	public void setInstitutionalDataFormat_doc5(String institutionalDataFormat_doc5) {
		this.institutionalDataFormat_doc5 = institutionalDataFormat_doc5;
	}
	public String getRelevantDocumentSupport_Link3() {
		return relevantDocumentSupport_Link3;
	}
	public void setRelevantDocumentSupport_Link3(String relevantDocumentSupport_Link3) {
		this.relevantDocumentSupport_Link3 = relevantDocumentSupport_Link3;
	}
	public String getTotFunctLinkagesLast5Years() {
		return totFunctLinkagesLast5Years;
	}
	public void setTotFunctLinkagesLast5Years(String totFunctLinkagesLast5Years) {
		this.totFunctLinkagesLast5Years = totFunctLinkagesLast5Years;
	}
	public String getFunctLinkagesLastY1() {
		return functLinkagesLastY1;
	}
	public void setFunctLinkagesLastY1(String functLinkagesLastY1) {
		this.functLinkagesLastY1 = functLinkagesLastY1;
	}
	public String getFunctLinkagesLastY2() {
		return functLinkagesLastY2;
	}
	public void setFunctLinkagesLastY2(String functLinkagesLastY2) {
		this.functLinkagesLastY2 = functLinkagesLastY2;
	}
	public String getFunctLinkagesLastY3() {
		return functLinkagesLastY3;
	}
	public void setFunctLinkagesLastY3(String functLinkagesLastY3) {
		this.functLinkagesLastY3 = functLinkagesLastY3;
	}
	public String getFunctLinkagesLastY4() {
		return functLinkagesLastY4;
	}
	public void setFunctLinkagesLastY4(String functLinkagesLastY4) {
		this.functLinkagesLastY4 = functLinkagesLastY4;
	}
	public String getFunctLinkagesLastY5() {
		return functLinkagesLastY5;
	}
	public void setFunctLinkagesLastY5(String functLinkagesLastY5) {
		this.functLinkagesLastY5 = functLinkagesLastY5;
	}
	public String getInstitutionalDataFormat_doc4() {
		return institutionalDataFormat_doc4;
	}
	public void setInstitutionalDataFormat_doc4(String institutionalDataFormat_doc4) {
		this.institutionalDataFormat_doc4 = institutionalDataFormat_doc4;
	}
	public String getRelevantDocumentSupport_Link2() {
		return relevantDocumentSupport_Link2;
	}
	public void setRelevantDocumentSupport_Link2(String relevantDocumentSupport_Link2) {
		this.relevantDocumentSupport_Link2 = relevantDocumentSupport_Link2;
	}
	public String getInstitDataTempDoc2() {
		return institDataTempDoc2;
	}
	public void setInstitDataTempDoc2(String institDataTempDoc2) {
		this.institDataTempDoc2 = institDataTempDoc2;
	}
	
	
	
	
	
	

	
	
	
	
	
	
}
