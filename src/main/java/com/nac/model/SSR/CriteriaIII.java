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
	
//	3.1. Resource Mobilization for Research
	private String grantReceivedLastFiveYears;
	private String totGrantGovtNonGovtLastY1;
	private String totGrantGovtNonGovtLastY2;
	private String totGrantGovtNonGovtLastY3;
	private String totGrantGovtNonGovtLastY4;
	private String totGrantGovtNonGovtLastY5;
	private String instDataTemplate_doc;
	private String supporting_doc;
	
//	3.2. Innovation Ecosystem
	private String devlopedKnowledgeSystem;
	private String additionalInfo_doc;
	private String additionalInfoLink;
	private String totWorkshopsOnResearchMethodology;
	private String totWorkshopOnResearchMetho_Y1;
	private String totWorkshopOnResearchMetho_Y2;
	private String totWorkshopOnResearchMetho_Y3;
	private String totWorkshopOnResearchMetho_Y4;
	private String totWorkshopOnResearchMetho_Y5;
	private String institutionalDataFormat_doc;
	private String supporting_doc2;
	
//	3.3. Research Publication and Awards
	private String numPapersPerTeacherUGC;
	private String paperInUGCJournalByY1;
	private String paperInUGCJournalByY2;
	private String paperInUGCJournalByY3;
	private String paperInUGCJournalByY4;
	private String paperInUGCJournalByY5;

	private String institutionalDataFormat_doc2;
	private String ugcCareJournalsPaperLinks;
	private String paperLinkFirstPageOnInstitWeb;
	private String redirectLink;
	private String relivantDocLink;
	
	private String totBookChaptPerTeachLastFiveY;
	private String bookChaptPerTeachY1;
	private String bookChaptPerTeachY2;
	private String bookChaptPerTeachY3;
	private String bookChaptPerTeachY4;
	private String bookChaptPerTeachY5;

	private String institutionalDataFormat_doc3;
	private String firstPageWithISBN_doc; 
	private String sourceWebsiteLink;
	private String relevantDocumentSupport_Link;
//	3.4. Extension Activities
	
	private String extActOutcome_neighComm_5yrs;
	private String addInfo_doc;
	private String addInfoLink;
	private String extActAwardsGovt;
	private String addInfo_doc2;
	private String addInfoLink3;
	private String numExtOutreachProgramsLast5Years;
	private String numExtOutreachProgramsY1;
	private String numExtOutreachProgramsY2;
	private String numExtOutreachProgramsY3;
	private String numExtOutreachProgramsY4;
	private String numExtOutreachProgramsY5;
	private String institutionalDataFormat_doc5;
	private String extensionOutreachProgramDetails_doc;
	private String docWithCaptionsAndDates_doc;
	private String relevantDocumentSupport_Link3;
//	3.5. Collaboration
	private String totFunctLinkagesLast5Years;
	private String functLinkagesLastY1;
	private String functLinkagesLastY2;
	private String functLinkagesLastY3;
	private String functLinkagesLastY4;
	private String functLinkagesLastY5;
	private String institutionalDataFormat_doc4;
	private String collaborationsByActivity_doc;
	private String collaborationDetails_doc;
	private String activitiesByYear_doc;
	private String relevantDocumentSupport_Link2;
	
	
	
	
	
	

	
	
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
	public String getSupporting_doc() {
		return supporting_doc;
	}
	public void setSupporting_doc(String supporting_doc) {
		this.supporting_doc = supporting_doc;
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
	public String getSupporting_doc2() {
		return supporting_doc2;
	}
	public void setSupporting_doc2(String supporting_doc2) {
		this.supporting_doc2 = supporting_doc2;
	}
	public String getNumPapersPerTeacherUGC() {
		return numPapersPerTeacherUGC;
	}
	public void setNumPapersPerTeacherUGC(String numPapersPerTeacherUGC) {
		this.numPapersPerTeacherUGC = numPapersPerTeacherUGC;
	}
	public String getPaperInUGCJournalByY1() {
		return paperInUGCJournalByY1;
	}
	public void setPaperInUGCJournalByY1(String paperInUGCJournalByY1) {
		this.paperInUGCJournalByY1 = paperInUGCJournalByY1;
	}
	public String getPaperInUGCJournalByY2() {
		return paperInUGCJournalByY2;
	}
	public void setPaperInUGCJournalByY2(String paperInUGCJournalByY2) {
		this.paperInUGCJournalByY2 = paperInUGCJournalByY2;
	}
	public String getPaperInUGCJournalByY3() {
		return paperInUGCJournalByY3;
	}
	public void setPaperInUGCJournalByY3(String paperInUGCJournalByY3) {
		this.paperInUGCJournalByY3 = paperInUGCJournalByY3;
	}
	public String getPaperInUGCJournalByY4() {
		return paperInUGCJournalByY4;
	}
	public void setPaperInUGCJournalByY4(String paperInUGCJournalByY4) {
		this.paperInUGCJournalByY4 = paperInUGCJournalByY4;
	}
	public String getPaperInUGCJournalByY5() {
		return paperInUGCJournalByY5;
	}
	public void setPaperInUGCJournalByY5(String paperInUGCJournalByY5) {
		this.paperInUGCJournalByY5 = paperInUGCJournalByY5;
	}
	
	public String getInstitutionalDataFormat_doc2() {
		return institutionalDataFormat_doc2;
	}
	public void setInstitutionalDataFormat_doc2(String institutionalDataFormat_doc2) {
		this.institutionalDataFormat_doc2 = institutionalDataFormat_doc2;
	}
	public String getUgcCareJournalsPaperLinks() {
		return ugcCareJournalsPaperLinks;
	}
	public void setUgcCareJournalsPaperLinks(String ugcCareJournalsPaperLinks) {
		this.ugcCareJournalsPaperLinks = ugcCareJournalsPaperLinks;
	}
	public String getPaperLinkFirstPageOnInstitWeb() {
		return paperLinkFirstPageOnInstitWeb;
	}
	public void setPaperLinkFirstPageOnInstitWeb(String paperLinkFirstPageOnInstitWeb) {
		this.paperLinkFirstPageOnInstitWeb = paperLinkFirstPageOnInstitWeb;
	}
	public String getRedirectLink() {
		return redirectLink;
	}
	public void setRedirectLink(String redirectLink) {
		this.redirectLink = redirectLink;
	}
	public String getRelivantDocLink() {
		return relivantDocLink;
	}
	public void setRelivantDocLink(String relivantDocLink) {
		this.relivantDocLink = relivantDocLink;
	}
	public String getTotBookChaptPerTeachLastFiveY() {
		return totBookChaptPerTeachLastFiveY;
	}
	public void setTotBookChaptPerTeachLastFiveY(String totBookChaptPerTeachLastFiveY) {
		this.totBookChaptPerTeachLastFiveY = totBookChaptPerTeachLastFiveY;
	}
	public String getBookChaptPerTeachY1() {
		return bookChaptPerTeachY1;
	}
	public void setBookChaptPerTeachY1(String bookChaptPerTeachY1) {
		this.bookChaptPerTeachY1 = bookChaptPerTeachY1;
	}
	public String getBookChaptPerTeachY2() {
		return bookChaptPerTeachY2;
	}
	public void setBookChaptPerTeachY2(String bookChaptPerTeachY2) {
		this.bookChaptPerTeachY2 = bookChaptPerTeachY2;
	}
	public String getBookChaptPerTeachY3() {
		return bookChaptPerTeachY3;
	}
	public void setBookChaptPerTeachY3(String bookChaptPerTeachY3) {
		this.bookChaptPerTeachY3 = bookChaptPerTeachY3;
	}
	public String getBookChaptPerTeachY4() {
		return bookChaptPerTeachY4;
	}
	public void setBookChaptPerTeachY4(String bookChaptPerTeachY4) {
		this.bookChaptPerTeachY4 = bookChaptPerTeachY4;
	}
	public String getBookChaptPerTeachY5() {
		return bookChaptPerTeachY5;
	}
	
	public String getInstitutionalDataFormat_doc3() {
		return institutionalDataFormat_doc3;
	}
	public void setInstitutionalDataFormat_doc3(String institutionalDataFormat_doc3) {
		this.institutionalDataFormat_doc3 = institutionalDataFormat_doc3;
	}
	public String getFirstPageWithISBN_doc() {
		return firstPageWithISBN_doc;
	}
	public void setFirstPageWithISBN_doc(String firstPageWithISBN) {
		this.firstPageWithISBN_doc = firstPageWithISBN;
	}
	public String getSourceWebsiteLink() {
		return sourceWebsiteLink;
	}
	public void setSourceWebsiteLink(String sourceWebsiteLink) {
		this.sourceWebsiteLink = sourceWebsiteLink;
	}
	public String getRelevantDocumentSupport_Link() {
		return relevantDocumentSupport_Link;
	}
	public void setRelevantDocumentSupport_Link(String relevantDocumentSupport_Link) {
		this.relevantDocumentSupport_Link = relevantDocumentSupport_Link;
	}
	
	public String getExtActOutcome_neighComm_5yrs() {
		return extActOutcome_neighComm_5yrs;
	}
	public void setExtActOutcome_neighComm_5yrs(String extActOutcome_neighComm_5yrs) {
		this.extActOutcome_neighComm_5yrs = extActOutcome_neighComm_5yrs;
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
	public String getAddInfoLink3() {
		return addInfoLink3;
	}
	public void setAddInfoLink3(String addInfoLink3) {
		this.addInfoLink3 = addInfoLink3;
	}
	public String getNumExtOutreachProgramsLast5Years() {
		return numExtOutreachProgramsLast5Years;
	}
	public void setNumExtOutreachProgramsLast5Years(String numExtOutreachProgramsLast5Years) {
		this.numExtOutreachProgramsLast5Years = numExtOutreachProgramsLast5Years;
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
	public String getExtensionOutreachProgramDetails_doc() {
		return extensionOutreachProgramDetails_doc;
	}
	public void setExtensionOutreachProgramDetails_doc(String extensionOutreachProgramDetails_doc) {
		this.extensionOutreachProgramDetails_doc = extensionOutreachProgramDetails_doc;
	}
	public String getDocWithCaptionsAndDates_doc() {
		return docWithCaptionsAndDates_doc;
	}
	public void setDocWithCaptionsAndDates_doc(String docWithCaptionsAndDates_doc) {
		this.docWithCaptionsAndDates_doc = docWithCaptionsAndDates_doc;
	}
	public String getRelevantDocumentSupport_Link3() {
		return relevantDocumentSupport_Link3;
	}
	public void setRelevantDocumentSupport_Link3(String relevantDocumentSupport_Link3) {
		this.relevantDocumentSupport_Link3 = relevantDocumentSupport_Link3;
	}
	public void setBookChaptPerTeachY5(String bookChaptPerTeachY5) {
		this.bookChaptPerTeachY5 = bookChaptPerTeachY5;
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
	public String getCollaborationsByActivity_doc() {
		return collaborationsByActivity_doc;
	}
	public void setCollaborationsByActivity_doc(String collaborationsByActivity_doc) {
		this.collaborationsByActivity_doc = collaborationsByActivity_doc;
	}
	public String getCollaborationDetails_doc() {
		return collaborationDetails_doc;
	}
	public void setCollaborationDetails_doc(String collaborationDetails_doc) {
		this.collaborationDetails_doc = collaborationDetails_doc;
	}
	public String getActivitiesByYear_doc() {
		return activitiesByYear_doc;
	}
	public void setActivitiesByYear_doc(String activitiesByYear_doc) {
		this.activitiesByYear_doc = activitiesByYear_doc;
	}
	public String getRelevantDocumentSupport_Link2() {
		return relevantDocumentSupport_Link2;
	}
	public void setRelevantDocumentSupport_Link2(String relevantDocumentSupport_Link2) {
		this.relevantDocumentSupport_Link2 = relevantDocumentSupport_Link2;
	}
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
	
	
	
}
