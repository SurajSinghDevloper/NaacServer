package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CriteriaVII {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long CriteriaVII_Id;
	private long ssrID;
	private long collegeID;
	private long qifId;
	
//	7.1. Institutional Values and Social Responsibilities
	private String genderEquityInitiative;
	private String addInfo_doc;
	private String addInfo_link;
	private String facilitiesAndInitiatives;
	private String facilitiesAndInitiativesTyp1;
	private String facilitiesAndInitiativesTyp2;
	private String facilitiesAndInitiativesTyp3;
	private String facilitiesAndInitiativesTyp4;
	private String facilitiesAndInitiativesTyp5;
	private String pfcPolicy_doc;
	private String equipPurchaseBills_doc;
	private String facilityMediaGeo_doc;
	private String cirActReports_doc;
	private String relivantDoc_link;
	private String totEnvEnergyAuditInfo;
	private String envEnergyAuditsTyp1;
	private String envEnergyAuditsTyp2;
	private String envEnergyAuditsTyp3;
	private String envEnergyAuditsTyp4;
	private String envEnergyAuditsTyp5;
	private String instDataTemplate_doc;
	private String EnvEnergyCertPolicy_doc;
	private String awardsCertiFormRecogAgncy_doc;
	private String envPromoSustActGeoPhotos_doc;
	private String envAudRepFormRecogAgncy_doc;
	private String relivantDoc_link2;
	private String InstitutionalDiversityInitiative;
	private String addInfo_doc2;
	private String addInfo_link2;
	
//	7.2. Best Practices
	private String bestPracticesNAACFormat;
	private String bestPracticesURL;
	private String relivantInfo_link;
//	7.3. Institutional Distinctiveness
	private String perfAreaPriorityThrust;
	private String institutionalWeb_link;
	private String relivantInfo_link2;
	
	public long getCriteriaVII_Id() {
		return CriteriaVII_Id;
	}
	public void setCriteriaVII_Id(long criteriaVII_Id) {
		CriteriaVII_Id = criteriaVII_Id;
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
	public String getGenderEquityInitiative() {
		return genderEquityInitiative;
	}
	public void setGenderEquityInitiative(String genderEquityInitiative) {
		this.genderEquityInitiative = genderEquityInitiative;
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
	public String getFacilitiesAndInitiatives() {
		return facilitiesAndInitiatives;
	}
	public void setFacilitiesAndInitiatives(String facilitiesAndInitiatives) {
		this.facilitiesAndInitiatives = facilitiesAndInitiatives;
	}
	public String getFacilitiesAndInitiativesTyp1() {
		return facilitiesAndInitiativesTyp1;
	}
	public void setFacilitiesAndInitiativesTyp1(String facilitiesAndInitiativesTyp1) {
		this.facilitiesAndInitiativesTyp1 = facilitiesAndInitiativesTyp1;
	}
	public String getFacilitiesAndInitiativesTyp2() {
		return facilitiesAndInitiativesTyp2;
	}
	public void setFacilitiesAndInitiativesTyp2(String facilitiesAndInitiativesTyp2) {
		this.facilitiesAndInitiativesTyp2 = facilitiesAndInitiativesTyp2;
	}
	public String getFacilitiesAndInitiativesTyp3() {
		return facilitiesAndInitiativesTyp3;
	}
	public void setFacilitiesAndInitiativesTyp3(String facilitiesAndInitiativesTyp3) {
		this.facilitiesAndInitiativesTyp3 = facilitiesAndInitiativesTyp3;
	}
	public String getFacilitiesAndInitiativesTyp4() {
		return facilitiesAndInitiativesTyp4;
	}
	public void setFacilitiesAndInitiativesTyp4(String facilitiesAndInitiativesTyp4) {
		this.facilitiesAndInitiativesTyp4 = facilitiesAndInitiativesTyp4;
	}
	public String getFacilitiesAndInitiativesTyp5() {
		return facilitiesAndInitiativesTyp5;
	}
	public void setFacilitiesAndInitiativesTyp5(String facilitiesAndInitiativesTyp5) {
		this.facilitiesAndInitiativesTyp5 = facilitiesAndInitiativesTyp5;
	}
	public String getPfcPolicy_doc() {
		return pfcPolicy_doc;
	}
	public void setPfcPolicy_doc(String pfcPolicy_doc) {
		this.pfcPolicy_doc = pfcPolicy_doc;
	}
	public String getEquipPurchaseBills_doc() {
		return equipPurchaseBills_doc;
	}
	public void setEquipPurchaseBills_doc(String equipPurchaseBills_doc) {
		this.equipPurchaseBills_doc = equipPurchaseBills_doc;
	}
	public String getFacilityMediaGeo_doc() {
		return facilityMediaGeo_doc;
	}
	public void setFacilityMediaGeo_doc(String facilityMediaGeo_doc) {
		this.facilityMediaGeo_doc = facilityMediaGeo_doc;
	}
	public String getCirActReports_doc() {
		return cirActReports_doc;
	}
	public void setCirActReports_doc(String cirActReports_doc) {
		this.cirActReports_doc = cirActReports_doc;
	}
	public String getRelivantDoc_link() {
		return relivantDoc_link;
	}
	public void setRelivantDoc_link(String relivantDoc_link) {
		this.relivantDoc_link = relivantDoc_link;
	}
	public String getTotEnvEnergyAuditInfo() {
		return totEnvEnergyAuditInfo;
	}
	public void setTotEnvEnergyAuditInfo(String totEnvEnergyAuditInfo) {
		this.totEnvEnergyAuditInfo = totEnvEnergyAuditInfo;
	}
	public String getEnvEnergyAuditsTyp1() {
		return envEnergyAuditsTyp1;
	}
	public void setEnvEnergyAuditsTyp1(String envEnergyAuditsTyp1) {
		this.envEnergyAuditsTyp1 = envEnergyAuditsTyp1;
	}
	public String getEnvEnergyAuditsTyp2() {
		return envEnergyAuditsTyp2;
	}
	public void setEnvEnergyAuditsTyp2(String envEnergyAuditsTyp2) {
		this.envEnergyAuditsTyp2 = envEnergyAuditsTyp2;
	}
	public String getEnvEnergyAuditsTyp3() {
		return envEnergyAuditsTyp3;
	}
	public void setEnvEnergyAuditsTyp3(String envEnergyAuditsTyp3) {
		this.envEnergyAuditsTyp3 = envEnergyAuditsTyp3;
	}
	public String getEnvEnergyAuditsTyp4() {
		return envEnergyAuditsTyp4;
	}
	public void setEnvEnergyAuditsTyp4(String envEnergyAuditsTyp4) {
		this.envEnergyAuditsTyp4 = envEnergyAuditsTyp4;
	}
	public String getEnvEnergyAuditsTyp5() {
		return envEnergyAuditsTyp5;
	}
	public void setEnvEnergyAuditsTyp5(String envEnergyAuditsTyp5) {
		this.envEnergyAuditsTyp5 = envEnergyAuditsTyp5;
	}
	public String getInstDataTemplate_doc() {
		return instDataTemplate_doc;
	}
	public void setInstDataTemplate_doc(String instDataTemplate_doc) {
		this.instDataTemplate_doc = instDataTemplate_doc;
	}
	public String getEnvEnergyCertPolicy_doc() {
		return EnvEnergyCertPolicy_doc;
	}
	public void setEnvEnergyCertPolicy_doc(String envEnergyCertPolicy_doc) {
		EnvEnergyCertPolicy_doc = envEnergyCertPolicy_doc;
	}
	public String getAwardsCertiFormRecogAgncy_doc() {
		return awardsCertiFormRecogAgncy_doc;
	}
	public void setAwardsCertiFormRecogAgncy_doc(String awardsCertiFormRecogAgncy_doc) {
		this.awardsCertiFormRecogAgncy_doc = awardsCertiFormRecogAgncy_doc;
	}
	public String getEnvPromoSustActGeoPhotos_doc() {
		return envPromoSustActGeoPhotos_doc;
	}
	public void setEnvPromoSustActGeoPhotos_doc(String envPromoSustActGeoPhotos_doc) {
		this.envPromoSustActGeoPhotos_doc = envPromoSustActGeoPhotos_doc;
	}
	public String getEnvAudRepFormRecogAgncy_doc() {
		return envAudRepFormRecogAgncy_doc;
	}
	public void setEnvAudRepFormRecogAgncy_doc(String envAudRepFormRecogAgncy_doc) {
		this.envAudRepFormRecogAgncy_doc = envAudRepFormRecogAgncy_doc;
	}
	public String getRelivantDoc_link2() {
		return relivantDoc_link2;
	}
	public void setRelivantDoc_link2(String relivantDoc_link2) {
		this.relivantDoc_link2 = relivantDoc_link2;
	}
	public String getInstitutionalDiversityInitiative() {
		return InstitutionalDiversityInitiative;
	}
	public void setInstitutionalDiversityInitiative(String institutionalDiversityInitiative) {
		InstitutionalDiversityInitiative = institutionalDiversityInitiative;
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
	public String getBestPracticesNAACFormat() {
		return bestPracticesNAACFormat;
	}
	public void setBestPracticesNAACFormat(String bestPracticesNAACFormat) {
		this.bestPracticesNAACFormat = bestPracticesNAACFormat;
	}
	public String getBestPracticesURL() {
		return bestPracticesURL;
	}
	public void setBestPracticesURL(String bestPracticesURL) {
		this.bestPracticesURL = bestPracticesURL;
	}
	public String getRelivantInfo_link() {
		return relivantInfo_link;
	}
	public void setRelivantInfo_link(String relivantInfo_link) {
		this.relivantInfo_link = relivantInfo_link;
	}
	public String getPerfAreaPriorityThrust() {
		return perfAreaPriorityThrust;
	}
	public void setPerfAreaPriorityThrust(String perfAreaPriorityThrust) {
		this.perfAreaPriorityThrust = perfAreaPriorityThrust;
	}
	public String getInstitutionalWeb_link() {
		return institutionalWeb_link;
	}
	public void setInstitutionalWeb_link(String institutionalWeb_link) {
		this.institutionalWeb_link = institutionalWeb_link;
	}
	public String getRelivantInfo_link2() {
		return relivantInfo_link2;
	}
	public void setRelivantInfo_link2(String relivantInfo_link2) {
		this.relivantInfo_link2 = relivantInfo_link2;
	}

	
}
