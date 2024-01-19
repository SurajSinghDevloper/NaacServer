package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CriteriaIV {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long CriteriaIV_Id;
	private long ssrID;
	private long collegeID;
	private long qifId;
	
//	4.1. Physical Facilities
	private String facilities;//
	
	private String addInfo_doc;//
	private String addInfo_link;//
	
	private String infraExpenditurePercentage;//
	private String infraExpenditurePercenY1;//
	private String infraExpenditurePercenY2;//
	private String infraExpenditurePercenY3;//
	private String infraExpenditurePercenY4;//
	private String infraExpenditurePercenY5;//
	
	private String expYearlyY1;//
	private String expYearlyY2;//
	private String expYearlyY3;//
	private String expYearlyY4;//
	private String expYearlyY5;//
	
	private String institutionalDataTemplate_doc;//
	private String AudRep_incomExpendiState_doc;//
	private String supportDocLink;//
	
//	4.2. Library as a learning Resource
	private String libraryILMS;//
	private String addInfo_doc2;//
	//chnaged
	private String relevantDOc;
	private String addInfo_link2;//
	private String eJnlExp_YY;
	private String eJnlExp_YY1;
	private String eJnlExp_YY2;
	private String eJnlExp_YY3;
	private String eJnlExp_YY4;
	private String eJnlExp_YY5;
	private String exp_excl_salary_y1;
	private String exp_excl_salary_y2;
	private String exp_excl_salary_y3;
	private String exp_excl_salary_y4;
	private String exp_excl_salary_y5;
	private String addInfo_doc8;
	private String addInfo_link8;
	
//	4.3. IT Infrastructure
	private String itFaciUpdDatWiFiBandwidth;
	private String addInfo_doc3;
	private String addInfo_link3;
	
	private String totStudCompRatioAY;
	private String numStudCompAY1;
	private String numStudCompAY2;
	private String numStudCompAY3;
	private String numStudCompAY4;
	private String numStudCompAY5;
	
	private String numStudentsByY1;
	private String numStudentsByY2;
	private String numStudentsByY3;
	private String numStudentsByY4;
	private String numStudentsByY5;
	
	private String StockRegistryExtractor_doc;
	private String numCompPurchased_doc;
	private String supportDocLink2;
	
	private String facilitForEcontent;
	private String facilitForEcontentType;
	private String  prescribedformatDoc;
	private String relivantDocLink;
	
//	4.4. Maintenance of Campus Infrastructure
	private String facilitiesExpenses;
	
	private String expFaciMaintenanceY1;
	private String expFaciMaintenanceY2;
	private String expFaciMaintenanceY3;
	private String expFaciMaintenanceY4;
	private String expFaciMaintenanceY5;
	
	private String expendiWithoutSalaryY1;
	private String expendiWithoutSalaryY2;
	private String expendiWithoutSalaryY3;
	private String expendiWithoutSalaryY4;
	private String expendiWithoutSalaryY5;
	
	private String addInfo_doc4;
	private String addInfo_link4;
	private String facilities_mgmt_sys;
	private String addInfo_doc5;
	private String addInfo_link5;
	public long getCriteriaIV_Id() {
		return CriteriaIV_Id;
	}
	public void setCriteriaIV_Id(long criteriaIV_Id) {
		CriteriaIV_Id = criteriaIV_Id;
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
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
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
	public String getInfraExpenditurePercentage() {
		return infraExpenditurePercentage;
	}
	public void setInfraExpenditurePercentage(String infraExpenditurePercentage) {
		this.infraExpenditurePercentage = infraExpenditurePercentage;
	}
	public String getInfraExpenditurePercenY1() {
		return infraExpenditurePercenY1;
	}
	public void setInfraExpenditurePercenY1(String infraExpenditurePercenY1) {
		this.infraExpenditurePercenY1 = infraExpenditurePercenY1;
	}
	public String getInfraExpenditurePercenY2() {
		return infraExpenditurePercenY2;
	}
	public void setInfraExpenditurePercenY2(String infraExpenditurePercenY2) {
		this.infraExpenditurePercenY2 = infraExpenditurePercenY2;
	}
	public String getInfraExpenditurePercenY3() {
		return infraExpenditurePercenY3;
	}
	public void setInfraExpenditurePercenY3(String infraExpenditurePercenY3) {
		this.infraExpenditurePercenY3 = infraExpenditurePercenY3;
	}
	public String getInfraExpenditurePercenY4() {
		return infraExpenditurePercenY4;
	}
	public void setInfraExpenditurePercenY4(String infraExpenditurePercenY4) {
		this.infraExpenditurePercenY4 = infraExpenditurePercenY4;
	}
	public String getInfraExpenditurePercenY5() {
		return infraExpenditurePercenY5;
	}
	public void setInfraExpenditurePercenY5(String infraExpenditurePercenY5) {
		this.infraExpenditurePercenY5 = infraExpenditurePercenY5;
	}
	public String getExpYearlyY1() {
		return expYearlyY1;
	}
	public void setExpYearlyY1(String expYearlyY1) {
		this.expYearlyY1 = expYearlyY1;
	}
	public String getExpYearlyY2() {
		return expYearlyY2;
	}
	public void setExpYearlyY2(String expYearlyY2) {
		this.expYearlyY2 = expYearlyY2;
	}
	public String getExpYearlyY3() {
		return expYearlyY3;
	}
	public void setExpYearlyY3(String expYearlyY3) {
		this.expYearlyY3 = expYearlyY3;
	}
	public String getExpYearlyY4() {
		return expYearlyY4;
	}
	public void setExpYearlyY4(String expYearlyY4) {
		this.expYearlyY4 = expYearlyY4;
	}
	public String getExpYearlyY5() {
		return expYearlyY5;
	}
	public void setExpYearlyY5(String expYearlyY5) {
		this.expYearlyY5 = expYearlyY5;
	}
	public String getInstitutionalDataTemplate_doc() {
		return institutionalDataTemplate_doc;
	}
	public void setInstitutionalDataTemplate_doc(String institutionalDataTemplate_doc) {
		this.institutionalDataTemplate_doc = institutionalDataTemplate_doc;
	}
	public String getAudRep_incomExpendiState_doc() {
		return AudRep_incomExpendiState_doc;
	}
	public void setAudRep_incomExpendiState_doc(String audRep_incomExpendiState_doc) {
		AudRep_incomExpendiState_doc = audRep_incomExpendiState_doc;
	}
	public String getSupportDocLink() {
		return supportDocLink;
	}
	public void setSupportDocLink(String supportDocLink) {
		this.supportDocLink = supportDocLink;
	}
	public String getLibraryILMS() {
		return libraryILMS;
	}
	public void setLibraryILMS(String libraryILMS) {
		this.libraryILMS = libraryILMS;
	}
	public String getAddInfo_doc2() {
		return addInfo_doc2;
	}
	public void setAddInfo_doc2(String addInfo_doc2) {
		this.addInfo_doc2 = addInfo_doc2;
	}
	public String getRelevantDOc() {
		return relevantDOc;
	}
	public void setRelevantDOc(String relevantDOc) {
		this.relevantDOc = relevantDOc;
	}
	public String getAddInfo_link2() {
		return addInfo_link2;
	}
	public void setAddInfo_link2(String addInfo_link2) {
		this.addInfo_link2 = addInfo_link2;
	}
	public String geteJnlExp_YY() {
		return eJnlExp_YY;
	}
	public void seteJnlExp_YY(String eJnlExp_YY) {
		this.eJnlExp_YY = eJnlExp_YY;
	}
	public String geteJnlExp_YY1() {
		return eJnlExp_YY1;
	}
	public void seteJnlExp_YY1(String eJnlExp_YY1) {
		this.eJnlExp_YY1 = eJnlExp_YY1;
	}
	public String geteJnlExp_YY2() {
		return eJnlExp_YY2;
	}
	public void seteJnlExp_YY2(String eJnlExp_YY2) {
		this.eJnlExp_YY2 = eJnlExp_YY2;
	}
	public String geteJnlExp_YY3() {
		return eJnlExp_YY3;
	}
	public void seteJnlExp_YY3(String eJnlExp_YY3) {
		this.eJnlExp_YY3 = eJnlExp_YY3;
	}
	public String geteJnlExp_YY4() {
		return eJnlExp_YY4;
	}
	public void seteJnlExp_YY4(String eJnlExp_YY4) {
		this.eJnlExp_YY4 = eJnlExp_YY4;
	}
	public String geteJnlExp_YY5() {
		return eJnlExp_YY5;
	}
	public void seteJnlExp_YY5(String eJnlExp_YY5) {
		this.eJnlExp_YY5 = eJnlExp_YY5;
	}
	public String getExp_excl_salary_y1() {
		return exp_excl_salary_y1;
	}
	public void setExp_excl_salary_y1(String exp_excl_salary_y1) {
		this.exp_excl_salary_y1 = exp_excl_salary_y1;
	}
	public String getExp_excl_salary_y2() {
		return exp_excl_salary_y2;
	}
	public void setExp_excl_salary_y2(String exp_excl_salary_y2) {
		this.exp_excl_salary_y2 = exp_excl_salary_y2;
	}
	public String getExp_excl_salary_y3() {
		return exp_excl_salary_y3;
	}
	public void setExp_excl_salary_y3(String exp_excl_salary_y3) {
		this.exp_excl_salary_y3 = exp_excl_salary_y3;
	}
	public String getExp_excl_salary_y4() {
		return exp_excl_salary_y4;
	}
	public void setExp_excl_salary_y4(String exp_excl_salary_y4) {
		this.exp_excl_salary_y4 = exp_excl_salary_y4;
	}
	public String getExp_excl_salary_y5() {
		return exp_excl_salary_y5;
	}
	public void setExp_excl_salary_y5(String exp_excl_salary_y5) {
		this.exp_excl_salary_y5 = exp_excl_salary_y5;
	}
	public String getAddInfo_doc8() {
		return addInfo_doc8;
	}
	public void setAddInfo_doc8(String addInfo_doc8) {
		this.addInfo_doc8 = addInfo_doc8;
	}
	public String getAddInfo_link8() {
		return addInfo_link8;
	}
	public void setAddInfo_link8(String addInfo_link8) {
		this.addInfo_link8 = addInfo_link8;
	}
	public String getItFaciUpdDatWiFiBandwidth() {
		return itFaciUpdDatWiFiBandwidth;
	}
	public void setItFaciUpdDatWiFiBandwidth(String itFaciUpdDatWiFiBandwidth) {
		this.itFaciUpdDatWiFiBandwidth = itFaciUpdDatWiFiBandwidth;
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
	public String getTotStudCompRatioAY() {
		return totStudCompRatioAY;
	}
	public void setTotStudCompRatioAY(String totStudCompRatioAY) {
		this.totStudCompRatioAY = totStudCompRatioAY;
	}
	public String getNumStudCompAY1() {
		return numStudCompAY1;
	}
	public void setNumStudCompAY1(String numStudCompAY1) {
		this.numStudCompAY1 = numStudCompAY1;
	}
	public String getNumStudCompAY2() {
		return numStudCompAY2;
	}
	public void setNumStudCompAY2(String numStudCompAY2) {
		this.numStudCompAY2 = numStudCompAY2;
	}
	public String getNumStudCompAY3() {
		return numStudCompAY3;
	}
	public void setNumStudCompAY3(String numStudCompAY3) {
		this.numStudCompAY3 = numStudCompAY3;
	}
	public String getNumStudCompAY4() {
		return numStudCompAY4;
	}
	public void setNumStudCompAY4(String numStudCompAY4) {
		this.numStudCompAY4 = numStudCompAY4;
	}
	public String getNumStudCompAY5() {
		return numStudCompAY5;
	}
	public void setNumStudCompAY5(String numStudCompAY5) {
		this.numStudCompAY5 = numStudCompAY5;
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
	public String getStockRegistryExtractor_doc() {
		return StockRegistryExtractor_doc;
	}
	public void setStockRegistryExtractor_doc(String stockRegistryExtractor_doc) {
		StockRegistryExtractor_doc = stockRegistryExtractor_doc;
	}
	public String getNumCompPurchased_doc() {
		return numCompPurchased_doc;
	}
	public void setNumCompPurchased_doc(String numCompPurchased_doc) {
		this.numCompPurchased_doc = numCompPurchased_doc;
	}
	public String getSupportDocLink2() {
		return supportDocLink2;
	}
	public void setSupportDocLink2(String supportDocLink2) {
		this.supportDocLink2 = supportDocLink2;
	}
	public String getFacilitForEcontent() {
		return facilitForEcontent;
	}
	public void setFacilitForEcontent(String facilitForEcontent) {
		this.facilitForEcontent = facilitForEcontent;
	}
	public String getFacilitForEcontentType() {
		return facilitForEcontentType;
	}
	public void setFacilitForEcontentType(String facilitForEcontentType) {
		this.facilitForEcontentType = facilitForEcontentType;
	}
	public String getPrescribedformatDoc() {
		return prescribedformatDoc;
	}
	public void setPrescribedformatDoc(String prescribedformatDoc) {
		this.prescribedformatDoc = prescribedformatDoc;
	}
	public String getRelivantDocLink() {
		return relivantDocLink;
	}
	public void setRelivantDocLink(String relivantDocLink) {
		this.relivantDocLink = relivantDocLink;
	}
	public String getFacilitiesExpenses() {
		return facilitiesExpenses;
	}
	public void setFacilitiesExpenses(String facilitiesExpenses) {
		this.facilitiesExpenses = facilitiesExpenses;
	}
	public String getExpFaciMaintenanceY1() {
		return expFaciMaintenanceY1;
	}
	public void setExpFaciMaintenanceY1(String expFaciMaintenanceY1) {
		this.expFaciMaintenanceY1 = expFaciMaintenanceY1;
	}
	public String getExpFaciMaintenanceY2() {
		return expFaciMaintenanceY2;
	}
	public void setExpFaciMaintenanceY2(String expFaciMaintenanceY2) {
		this.expFaciMaintenanceY2 = expFaciMaintenanceY2;
	}
	public String getExpFaciMaintenanceY3() {
		return expFaciMaintenanceY3;
	}
	public void setExpFaciMaintenanceY3(String expFaciMaintenanceY3) {
		this.expFaciMaintenanceY3 = expFaciMaintenanceY3;
	}
	public String getExpFaciMaintenanceY4() {
		return expFaciMaintenanceY4;
	}
	public void setExpFaciMaintenanceY4(String expFaciMaintenanceY4) {
		this.expFaciMaintenanceY4 = expFaciMaintenanceY4;
	}
	public String getExpFaciMaintenanceY5() {
		return expFaciMaintenanceY5;
	}
	public void setExpFaciMaintenanceY5(String expFaciMaintenanceY5) {
		this.expFaciMaintenanceY5 = expFaciMaintenanceY5;
	}
	public String getExpendiWithoutSalaryY1() {
		return expendiWithoutSalaryY1;
	}
	public void setExpendiWithoutSalaryY1(String expendiWithoutSalaryY1) {
		this.expendiWithoutSalaryY1 = expendiWithoutSalaryY1;
	}
	public String getExpendiWithoutSalaryY2() {
		return expendiWithoutSalaryY2;
	}
	public void setExpendiWithoutSalaryY2(String expendiWithoutSalaryY2) {
		this.expendiWithoutSalaryY2 = expendiWithoutSalaryY2;
	}
	public String getExpendiWithoutSalaryY3() {
		return expendiWithoutSalaryY3;
	}
	public void setExpendiWithoutSalaryY3(String expendiWithoutSalaryY3) {
		this.expendiWithoutSalaryY3 = expendiWithoutSalaryY3;
	}
	public String getExpendiWithoutSalaryY4() {
		return expendiWithoutSalaryY4;
	}
	public void setExpendiWithoutSalaryY4(String expendiWithoutSalaryY4) {
		this.expendiWithoutSalaryY4 = expendiWithoutSalaryY4;
	}
	public String getExpendiWithoutSalaryY5() {
		return expendiWithoutSalaryY5;
	}
	public void setExpendiWithoutSalaryY5(String expendiWithoutSalaryY5) {
		this.expendiWithoutSalaryY5 = expendiWithoutSalaryY5;
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
	public String getFacilities_mgmt_sys() {
		return facilities_mgmt_sys;
	}
	public void setFacilities_mgmt_sys(String facilities_mgmt_sys) {
		this.facilities_mgmt_sys = facilities_mgmt_sys;
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
	
	
	
	
	
}
