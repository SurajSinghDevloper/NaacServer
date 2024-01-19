package com.nac.model.IIQA;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class PrepareIIQA implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iiqa_ID;

	@Column(name = "cycle")
	private String cycleOfAccreditation;
	@Column(name = "nameOfHEI")
	private String nameOfHigherEducationInstitution;
	private String city;
	private String stateOrUT;
	private String district;
	@Column(name = "dateOfEOI")
	private String Date_of_establishment_of_the_Institution;
	@Column(name = "Years_of_GOLTWOB")
	private String Years_of_graduation_of_the_last_two_batches;
	private String isRecognised;
	private String affiliatingUniversity;
	private String institutionisRegistereNAD_Document;
	private String headOfTheInstitution;
	private String designation;
	private String isCollegeFunctionFromOwnCampus;
	private String collegeAddress;
	private int collegePincode;
	private String collegePhoneAreaCode;
	private String collegePhone;
	private String collegeFaxAreaCode;
	private String collegeFax;
	private String alternateEmail;
	private String alternateFacultyName;
	private String alternateFacultyDesignation;
	private String alternateFacultyAddress;
	private int alternateFacultyPincode;
	private String alternateFacultyPhoneAreaCode;
	private String alternateFacultyPhone;
	private String alternateFacultyFaxAreaCode;
	private String alternateFacultyFax;
	private String alternateFacultyMobile;
	private String alternateFacultyEmail;
	private String alternateFacultyAltenateEmail;
	private String collegeWebsite;
	private String natureOfCollege;//update
	private String natureOfCollegeDoc;
	private String univType;
	private String specificTypeOfUniv;
	private String dateOfRecognitionByUGC_2f;
	private String documentOfRecognitionByUGC_2f;
	private String dateOfRecognitionByUGC_12B;
	@Column(name = "document_of_recognition_byugc_12b")
	private String documentOfRecognitionByUGC_12B;
	private String dateOfGeneralDevelopementGrant;
	private String isInstitutionRecognisedAutonomous;
	private String documentOfRecognisedAutonomous;
	private String institutionRecognisedAsCPE;
	private String documentOfRecognisedAsCPE;
	private String institutionRecognisedAsCollege_of_Excellence;
	private String documentRecognisedAsCollege_of_Excellence;
	private String dateOf_AISHE_Upload;
	@Column(name = "document_of_recognition_by_AISHE_MHRD")
	private String documentofAISHE_MHRD;
	private String documentCertification_by_Head_of_the_Institution;
	private String RTIActSection4_1_b_Declaration_Url;
	private String does_StatutoryCommitteesExist;
	private String StatutoryCommittees_for_ST_SC;
	private String StatutoryCommittees_for_MinorityCell;
	private String StatutoryCommittees_for_Grievance_Redressal;
	private String StatutoryCommittees_for_Internal_Compliant;
	private String StatutoryCommittees_for_Anti_ragging;
	private String StatutoryCommittees_for_OBC_cell;
	private String program_Count_UG;
	private String program_Count_PG;
	private String program_Count_DM_Ayurveda_Vachaspathi;
	private String program_Count_Pre_Doctoral;
	private String program_Count_Doctoral;
	private String program_Count_Post_Doctoral;
	private String program_Count_PG_Diploma;
	private String program_Count_Diploma;
	private String md;
	private String ms;
	private String program_Count_Certificate_Awareness;
	private String selfDeclaration;
	private String document_academic_mou_foreign;
	private String dateOfEstablishmentOfIQACorCIQA;
	private String completed;
	private String verified;

	private long collegeRegistrationId;

	public long getCollegeRegistrationId() {
		return collegeRegistrationId;
	}

	public void setCollegeRegistrationId(long collegeRegistrationId) {
		this.collegeRegistrationId = collegeRegistrationId;
	}

	public Long getIiqa_ID() {
		return iiqa_ID;
	}

	public void setIiqa_ID(Long iiqa_ID) {
		this.iiqa_ID = iiqa_ID;
	}

	public String getCycleOfAccreditation() {
		return cycleOfAccreditation;
	}

	public void setCycleOfAccreditation(String cycleOfAccreditation) {
		this.cycleOfAccreditation = cycleOfAccreditation;
	}

	public String getNameOfHigherEducationInstitution() {
		return nameOfHigherEducationInstitution;
	}

	public void setNameOfHigherEducationInstitution(String nameOfHigherEducationInstitution) {
		this.nameOfHigherEducationInstitution = nameOfHigherEducationInstitution;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrUT() {
		return stateOrUT;
	}

	public void setStateOrUT(String stateOrUT) {
		this.stateOrUT = stateOrUT;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDate_of_establishment_of_the_Institution() {
		return Date_of_establishment_of_the_Institution;
	}

	public void setDate_of_establishment_of_the_Institution(String date_of_establishment_of_the_Institution) {
		Date_of_establishment_of_the_Institution = date_of_establishment_of_the_Institution;
	}

	public String getYears_of_graduation_of_the_last_two_batches() {
		return Years_of_graduation_of_the_last_two_batches;
	}

	public void setYears_of_graduation_of_the_last_two_batches(String years_of_graduation_of_the_last_two_batches) {
		Years_of_graduation_of_the_last_two_batches = years_of_graduation_of_the_last_two_batches;
	}

	public String getIsRecognised() {
		return isRecognised;
	}

	public void setIsRecognised(String isRecognised) {
		this.isRecognised = isRecognised;
	}

	public String getAffiliatingUniversity() {
		return affiliatingUniversity;
	}

	public void setAffiliatingUniversity(String affiliatingUniversity) {
		this.affiliatingUniversity = affiliatingUniversity;
	}

	public String getInstitutionisRegistereNAD_Document() {
		return institutionisRegistereNAD_Document;
	}

	public void setInstitutionisRegistereNAD_Document(String institutionisRegistereNAD_Document) {
		this.institutionisRegistereNAD_Document = institutionisRegistereNAD_Document;
	}

	public String getHeadOfTheInstitution() {
		return headOfTheInstitution;
	}

	public void setHeadOfTheInstitution(String headOfTheInstitution) {
		this.headOfTheInstitution = headOfTheInstitution;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getIsCollegeFunctionFromOwnCampus() {
		return isCollegeFunctionFromOwnCampus;
	}

	public void setIsCollegeFunctionFromOwnCampus(String isCollegeFunctionFromOwnCampus) {
		this.isCollegeFunctionFromOwnCampus = isCollegeFunctionFromOwnCampus;
	}

	public String getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	public int getCollegePincode() {
		return collegePincode;
	}

	public void setCollegePincode(int collegePincode) {
		this.collegePincode = collegePincode;
	}

	public String getCollegePhoneAreaCode() {
		return collegePhoneAreaCode;
	}

	public void setCollegePhoneAreaCode(String collegePhoneAreaCode) {
		this.collegePhoneAreaCode = collegePhoneAreaCode;
	}

	public String getCollegePhone() {
		return collegePhone;
	}

	public void setCollegePhone(String collegePhone) {
		this.collegePhone = collegePhone;
	}

	public String getCollegeFaxAreaCode() {
		return collegeFaxAreaCode;
	}

	public void setCollegeFaxAreaCode(String collegeFaxAreaCode) {
		this.collegeFaxAreaCode = collegeFaxAreaCode;
	}

	public String getCollegeFax() {
		return collegeFax;
	}

	public void setCollegeFax(String collegeFax) {
		this.collegeFax = collegeFax;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public String getAlternateFacultyName() {
		return alternateFacultyName;
	}

	public void setAlternateFacultyName(String alternateFacultyName) {
		this.alternateFacultyName = alternateFacultyName;
	}

	public String getAlternateFacultyDesignation() {
		return alternateFacultyDesignation;
	}

	public void setAlternateFacultyDesignation(String alternateFacultyDesignation) {
		this.alternateFacultyDesignation = alternateFacultyDesignation;
	}

	public String getAlternateFacultyAddress() {
		return alternateFacultyAddress;
	}

	public void setAlternateFacultyAddress(String alternateFacultyAddress) {
		this.alternateFacultyAddress = alternateFacultyAddress;
	}

	public int getAlternateFacultyPincode() {
		return alternateFacultyPincode;
	}

	public void setAlternateFacultyPincode(int alternateFacultyPincode) {
		this.alternateFacultyPincode = alternateFacultyPincode;
	}

	public String getAlternateFacultyPhoneAreaCode() {
		return alternateFacultyPhoneAreaCode;
	}

	public void setAlternateFacultyPhoneAreaCode(String alternateFacultyPhoneAreaCode) {
		this.alternateFacultyPhoneAreaCode = alternateFacultyPhoneAreaCode;
	}

	public String getAlternateFacultyPhone() {
		return alternateFacultyPhone;
	}

	public void setAlternateFacultyPhone(String alternateFacultyPhone) {
		this.alternateFacultyPhone = alternateFacultyPhone;
	}

	public String getAlternateFacultyFaxAreaCode() {
		return alternateFacultyFaxAreaCode;
	}

	public void setAlternateFacultyFaxAreaCode(String alternateFacultyFaxAreaCode) {
		this.alternateFacultyFaxAreaCode = alternateFacultyFaxAreaCode;
	}

	public String getAlternateFacultyFax() {
		return alternateFacultyFax;
	}

	public void setAlternateFacultyFax(String alternateFacultyFax) {
		this.alternateFacultyFax = alternateFacultyFax;
	}

	public String getAlternateFacultyMobile() {
		return alternateFacultyMobile;
	}

	public void setAlternateFacultyMobile(String alternateFacultyMobile) {
		this.alternateFacultyMobile = alternateFacultyMobile;
	}

	public String getAlternateFacultyEmail() {
		return alternateFacultyEmail;
	}

	public void setAlternateFacultyEmail(String alternateFacultyEmail) {
		this.alternateFacultyEmail = alternateFacultyEmail;
	}

	public String getAlternateFacultyAltenateEmail() {
		return alternateFacultyAltenateEmail;
	}

	public void setAlternateFacultyAltenateEmail(String alternateFacultyAltenateEmail) {
		this.alternateFacultyAltenateEmail = alternateFacultyAltenateEmail;
	}

	public String getCollegeWebsite() {
		return collegeWebsite;
	}

	public void setCollegeWebsite(String collegeWebsite) {
		this.collegeWebsite = collegeWebsite;
	}

	public String getNatureOfCollege() {
		return natureOfCollege;
	}

	public void setNatureOfCollege(String natureOfCollege) {
		this.natureOfCollege = natureOfCollege;
	}
	
	
	
	public String getNatureOfCollegeDoc() {
		return natureOfCollegeDoc;
	}

	public void setNatureOfCollegeDoc(String natureOfCollegeDoc) {
		this.natureOfCollegeDoc = natureOfCollegeDoc;
	}

	public String getUnivType() {
		return univType;
	}

	public void setUnivType(String univType) {
		this.univType = univType;
	}
	

	public String getSpecificTypeOfUniv() {
		return specificTypeOfUniv;
	}

	public void setSpecificTypeOfUniv(String specificTypeOfUniv) {
		this.specificTypeOfUniv = specificTypeOfUniv;
	}

	public String getDateOfRecognitionByUGC_2f() {
		return dateOfRecognitionByUGC_2f;
	}

	public void setDateOfRecognitionByUGC_2f(String dateOfRecognitionByUGC_2f) {
		this.dateOfRecognitionByUGC_2f = dateOfRecognitionByUGC_2f;
	}

	public String getDocumentOfRecognitionByUGC_2f() {
		return documentOfRecognitionByUGC_2f;
	}

	public void setDocumentOfRecognitionByUGC_2f(String documentOfRecognitionByUGC_2f) {
		this.documentOfRecognitionByUGC_2f = documentOfRecognitionByUGC_2f;
	}

	public String getDateOfRecognitionByUGC_12B() {
		return dateOfRecognitionByUGC_12B;
	}

	public void setDateOfRecognitionByUGC_12B(String dateOfRecognitionByUGC_12B) {
		this.dateOfRecognitionByUGC_12B = dateOfRecognitionByUGC_12B;
	}

	public String getDocumentOfRecognitionByUGC_12B() {
		return documentOfRecognitionByUGC_12B;
	}

	public void setDocumentOfRecognitionByUGC_12B(String documentOfRecognitionByUGC_12B) {
		this.documentOfRecognitionByUGC_12B = documentOfRecognitionByUGC_12B;
	}

	public String getDateOfGeneralDevelopementGrant() {
		return dateOfGeneralDevelopementGrant;
	}

	public void setDateOfGeneralDevelopementGrant(String dateOfGeneralDevelopementGrant) {
		this.dateOfGeneralDevelopementGrant = dateOfGeneralDevelopementGrant;
	}

	public String getInstitutionRecognisedAutonomous() {
		return isInstitutionRecognisedAutonomous;
	}

	public void setInstitutionRecognisedAutonomous(String isInstitutionRecognisedAutonomous) {
		this.isInstitutionRecognisedAutonomous = isInstitutionRecognisedAutonomous;
	}

	public String getDocumentOfRecognisedAutonomous() {
		return documentOfRecognisedAutonomous;
	}

	public void setDocumentOfRecognisedAutonomous(String documentOfRecognisedAutonomous) {
		this.documentOfRecognisedAutonomous = documentOfRecognisedAutonomous;
	}

	public String getInstitutionRecognisedAsCPE() {
		return institutionRecognisedAsCPE;
	}

	public void setInstitutionRecognisedAsCPE(String institutionRecognisedAsCPE) {
		this.institutionRecognisedAsCPE = institutionRecognisedAsCPE;
	}

	public String getDocumentOfRecognisedAsCPE() {
		return documentOfRecognisedAsCPE;
	}

	public void setDocumentOfRecognisedAsCPE(String documentOfRecognisedAsCPE) {
		this.documentOfRecognisedAsCPE = documentOfRecognisedAsCPE;
	}

	public String getInstitutionRecognisedAsCollege_of_Excellence() {
		return institutionRecognisedAsCollege_of_Excellence;
	}

	public void setInstitutionRecognisedAsCollege_of_Excellence(String institutionRecognisedAsCollege_of_Excellence) {
		this.institutionRecognisedAsCollege_of_Excellence = institutionRecognisedAsCollege_of_Excellence;
	}

	public String getDocumentRecognisedAsCollege_of_Excellence() {
		return documentRecognisedAsCollege_of_Excellence;
	}

	public void setDocumentRecognisedAsCollege_of_Excellence(String documentRecognisedAsCollege_of_Excellence) {
		this.documentRecognisedAsCollege_of_Excellence = documentRecognisedAsCollege_of_Excellence;
	}

	public String getDateOf_AISHE_Upload() {
		return dateOf_AISHE_Upload;
	}

	public void setDateOf_AISHE_Upload(String dateOf_AISHE_Upload) {
		this.dateOf_AISHE_Upload = dateOf_AISHE_Upload;
	}

	public String getDocumentAISHE_Upload_Date() {
		return documentofAISHE_MHRD;
	}

	public void setDocumentAISHE_Upload_Date(String documentofAISHE_MHRD) {
		this.documentofAISHE_MHRD = documentofAISHE_MHRD;
	}

	public String getIsInstitutionRecognisedAutonomous() {
		return isInstitutionRecognisedAutonomous;
	}

	public void setIsInstitutionRecognisedAutonomous(String isInstitutionRecognisedAutonomous) {
		this.isInstitutionRecognisedAutonomous = isInstitutionRecognisedAutonomous;
	}

	public String getDocumentofAISHE_MHRD() {
		return documentofAISHE_MHRD;
	}

	public void setDocumentofAISHE_MHRD(String documentofAISHE_MHRD) {
		this.documentofAISHE_MHRD = documentofAISHE_MHRD;
	}

	public String getDocumentCertification_by_Head_of_the_Institution() {
		return documentCertification_by_Head_of_the_Institution;
	}

	public void setDocumentCertification_by_Head_of_the_Institution(
			String documentCertification_by_Head_of_the_Institution) {
		this.documentCertification_by_Head_of_the_Institution = documentCertification_by_Head_of_the_Institution;
	}

	public String getRTIActSection4_1_b_Declaration_Url() {
		return RTIActSection4_1_b_Declaration_Url;
	}

	public void setRTIActSection4_1_b_Declaration_Url(String rTIActSection4_1_b_Declaration_Url) {
		RTIActSection4_1_b_Declaration_Url = rTIActSection4_1_b_Declaration_Url;
	}

	public String getDoes_StatutoryCommitteesExist() {
		return does_StatutoryCommitteesExist;
	}

	public void setDoes_StatutoryCommitteesExist(String does_StatutoryCommitteesExist) {
		this.does_StatutoryCommitteesExist = does_StatutoryCommitteesExist;
	}

	public String getStatutoryCommittees_for_ST_SC() {
		return StatutoryCommittees_for_ST_SC;
	}

	public void setStatutoryCommittees_for_ST_SC(String statutoryCommittees_for_ST_SC) {
		StatutoryCommittees_for_ST_SC = statutoryCommittees_for_ST_SC;
	}

	public String getStatutoryCommittees_for_MinorityCell() {
		return StatutoryCommittees_for_MinorityCell;
	}

	public void setStatutoryCommittees_for_MinorityCell(String statutoryCommittees_for_MinorityCell) {
		StatutoryCommittees_for_MinorityCell = statutoryCommittees_for_MinorityCell;
	}

	public String getStatutoryCommittees_for_Grievance_Redressal() {
		return StatutoryCommittees_for_Grievance_Redressal;
	}

	public void setStatutoryCommittees_for_Grievance_Redressal(String statutoryCommittees_for_Grievance_Redressal) {
		StatutoryCommittees_for_Grievance_Redressal = statutoryCommittees_for_Grievance_Redressal;
	}

	public String getStatutoryCommittees_for_Internal_Compliant() {
		return StatutoryCommittees_for_Internal_Compliant;
	}

	public void setStatutoryCommittees_for_Internal_Compliant(String statutoryCommittees_for_Internal_Compliant) {
		StatutoryCommittees_for_Internal_Compliant = statutoryCommittees_for_Internal_Compliant;
	}

	public String getStatutoryCommittees_for_Anti_ragging() {
		return StatutoryCommittees_for_Anti_ragging;
	}

	public void setStatutoryCommittees_for_Anti_ragging(String statutoryCommittees_for_Anti_ragging) {
		StatutoryCommittees_for_Anti_ragging = statutoryCommittees_for_Anti_ragging;
	}

	public String getStatutoryCommittees_for_OBC_cell() {
		return StatutoryCommittees_for_OBC_cell;
	}

	public void setStatutoryCommittees_for_OBC_cell(String statutoryCommittees_for_OBC_cell) {
		StatutoryCommittees_for_OBC_cell = statutoryCommittees_for_OBC_cell;
	}

	public String getProgram_Count_UG() {
		return program_Count_UG;
	}

	public void setProgram_Count_UG(String program_Count_UG) {
		this.program_Count_UG = program_Count_UG;
	}

	public String getProgram_Count_PG() {
		return program_Count_PG;
	}

	public void setProgram_Count_PG(String program_Count_PG) {
		this.program_Count_PG = program_Count_PG;
	}

	public String getProgram_Count_DM_Ayurveda_Vachaspathi() {
		return program_Count_DM_Ayurveda_Vachaspathi;
	}

	public void setProgram_Count_DM_Ayurveda_Vachaspathi(String program_Count_DM_Ayurveda_Vachaspathi) {
		this.program_Count_DM_Ayurveda_Vachaspathi = program_Count_DM_Ayurveda_Vachaspathi;
	}

	public String getProgram_Count_Pre_Doctoral() {
		return program_Count_Pre_Doctoral;
	}

	public void setProgram_Count_Pre_Doctoral(String program_Count_Pre_Doctoral) {
		this.program_Count_Pre_Doctoral = program_Count_Pre_Doctoral;
	}

	public String getProgram_Count_Doctoral() {
		return program_Count_Doctoral;
	}

	public void setProgram_Count_Doctoral(String program_Count_Doctoral) {
		this.program_Count_Doctoral = program_Count_Doctoral;
	}

	public String getProgram_Count_Post_Doctoral() {
		return program_Count_Post_Doctoral;
	}

	public void setProgram_Count_Post_Doctoral(String program_Count_Post_Doctoral) {
		this.program_Count_Post_Doctoral = program_Count_Post_Doctoral;
	}

	public String getProgram_Count_PG_Diploma() {
		return program_Count_PG_Diploma;
	}

	public void setProgram_Count_PG_Diploma(String program_Count_PG_Diploma) {
		this.program_Count_PG_Diploma = program_Count_PG_Diploma;
	}

	public String getProgram_Count_Diploma() {
		return program_Count_Diploma;
	}

	public void setProgram_Count_Diploma(String program_Count_Diploma) {
		this.program_Count_Diploma = program_Count_Diploma;
	}

	public String getProgram_Count_Certificate_Awareness() {
		return program_Count_Certificate_Awareness;
	}

	public void setProgram_Count_Certificate_Awareness(String program_Count_Certificate_Awareness) {
		this.program_Count_Certificate_Awareness = program_Count_Certificate_Awareness;
	}
	
	public String getMd() {
		return md;
	}

	public void setMd(String md) {
		this.md = md;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getDocument_academic_mou_foreign() {
		return document_academic_mou_foreign;
	}
	
	

	public String getSelfDeclaration() {
		return selfDeclaration;
	}

	public void setSelfDeclaration(String selfDeclaration) {
		this.selfDeclaration = selfDeclaration;
	}

	public void setDocument_academic_mou_foreign(String document_academic_mou_foreign) {
		this.document_academic_mou_foreign = document_academic_mou_foreign;
	}

	public String getDateOfEstablishmentOfIQACorCIQA() {
		return dateOfEstablishmentOfIQACorCIQA;
	}

	public void setDateOfEstablishmentOfIQACorCIQA(String dateOfEstablishmentOfIQACorCIQA) {
		this.dateOfEstablishmentOfIQACorCIQA = dateOfEstablishmentOfIQACorCIQA;
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
