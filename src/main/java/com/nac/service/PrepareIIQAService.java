package com.nac.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.nac.model.IIQA.UniversityRecoginsed;
import com.nac.model.IIQA.CollegeProgramBySRA;
import com.nac.model.IIQA.DetailsOfStaffOfCollege;
import com.nac.model.IIQA.DetailsOfStudentOfCollege;
import com.nac.model.IIQA.PrepareIIQA;
import com.nac.model.IIQA.ProgramRunByCollege;
import com.nac.model.IIQA.SraList;

public interface PrepareIIQAService {
	public PrepareIIQA basicEligiblity(PrepareIIQA iiqa,long collegId);

	public PrepareIIQA updateBasicElegiblity(long id, PrepareIIQA piiqa);

	public Map<String, Object> getBasicEligibility(Long iiqa);

	public List<CollegeProgramBySRA> getCollegeProgramBySRA(Long prepareIIQA);
	
	public List<Map.Entry<String, List<Object>>> combineResults(long prepareIIQA_ID);

	public void recognised_University(UniversityRecoginsed affUniv);
	
	public boolean deleteRecognisedUniv(Long id);
	
	public boolean recognised_Univ_Document(MultipartFile pdf, Long id);
	
	public boolean deleteRecog_Univ_Document(Long AffiliatingUniversityId);
	
	public boolean delete_affiliating_University(long affiliatingUniversityId);

	public List<UniversityRecoginsed> getAllRecogUnivByPrepareIIQAID(long prepareIIQA_ID);
	
	public SraList saveSra(SraList sra);
	
	public boolean saveSraDocumentName(long sraId, MultipartFile pdf);
	
	public List<SraList> getSraByPrepareIIQAID(long prepareIIQAID);
	
	public boolean deleteSraBySraID(long sraId) ;
	
	public boolean removeFileFromSraList(long sraId);

	public CollegeProgramBySRA saveCollegeProgramBySRA(CollegeProgramBySRA cps);

	public boolean uploadDocumentOfCollegeProgramBySRA(MultipartFile pdf, Long clgPrgBySRAID);
	
	public void deleteCollegeProgramBySRA(long collegeProgramBySraID);
	
	public boolean deleteDocumentOfRecognitionByUGC_2f(long iiqaId);
	
	public boolean deleteDocumentOfdocumentOfRecognitionByUGC_12B(long iiqaId);
	
	public boolean deleteDocumentOfRecognisedAutonomous(long iiqaId);
	
	public boolean deleteDocumentOfRecognisedAsCPE(long iiqaId);
	
	public boolean deleteDocumentOfRecognisedAsCollege_of_Excellence(long iiqaId);
	
	public boolean deleteDocumentOfAISHE_MHRD(long iiqaId);
	
	public boolean deleteDocumentOfCertification_by_Head_of_the_Institution(long iiqaId);
	
	public boolean deleteCollegeProgramSraDocument(Long collegeProgramBySraID);

	public boolean uploadDocumentRegistereNAD(MultipartFile pdf, Long iiqa_ID);
	
	public boolean deleteDocumentRegistereNAD(long iiqaId);

	public PrepareIIQA saveProfileInformation(PrepareIIQA iiqa);

	public PrepareIIQA getPrepareIIQAById(Long prepareIIQA_ID);
	
	public PrepareIIQA  updateNaturesOfCollege(long prepareIIqaID, PrepareIIQA natureOfCollege);
	
	public boolean deleteDocumentOfNatureOfCollege(long prepareIIqaID);
	
	public boolean saveDocumentOfNatureOfCollege(long prepareIIqaID, MultipartFile pdf);

	public boolean updateDateOfRecognitionByUGCAndDocument(Long prepareIIQA_ID, String date, MultipartFile pdf);

	public boolean updateDateOfRecognitionByUGC_12BAndDocument(Long prepareIIQA_ID, String date, MultipartFile pdf);

	public boolean updateIsInstitutionRecogniseAsAutonomus(Long prepareIIQA_ID, MultipartFile pdf);

	public boolean updateIsInstitutionRecogniseAsCPE(Long prepareIIQA_ID, MultipartFile pdf);

	public boolean updateIsInstitutionRecogniseAsCollegeOfExcellence(Long prepareIIQA_ID, MultipartFile pdf);

	public boolean updateDateOfRecognitionByUGC_AISHE(Long prepareIIQA_ID, String date, MultipartFile pdf);

	public boolean updateDocumentCertification_by_Head_of_the_Institution(Long prepareIIQA_ID, MultipartFile pdf);

	public boolean updateRTIActSection4_1_b_Declaration_Url(Long prepareIIQA_ID, String url);

	public PrepareIIQA updateStatutoryCommittees(Long prepareIIQA_ID, PrepareIIQA statutoryCommittees) ;

	public boolean updateProgramCountOfCollege(Long prepareIIQA_ID, List<String> ProgramCount);

	public ProgramRunByCollege saveProgramRunByCollege(ProgramRunByCollege prbc);
	
	public boolean deleteDocumentOfSelfDeclaration(long prbcID);
	
	public boolean deleteProgramRunBycollege(long prbc);
	
	public boolean uploadDocumentOfSelDeclaration(MultipartFile pdf, Long clgPrgBySRAID);

	public List<PrepareIIQA> findLatestIIQAByCollegeRegistration(long collegeRegistrationId);

	public PrepareIIQA findLatestByCollegeRegistrationId(long collegeRegistrationId);

	public List<ProgramRunByCollege> getAllProgramByPrepaerIIqaId(Long prepareIIQA_Id);
	
	public DetailsOfStaffOfCollege updateInIIQADetailsOfStaf(DetailsOfStaffOfCollege dsoc);
	
	public DetailsOfStaffOfCollege updateInIIQADetailsOfStafByID(DetailsOfStaffOfCollege dsoc, long id);
	
	public DetailsOfStudentOfCollege updateDetailsOfStudentInIIQA(DetailsOfStudentOfCollege dosoc);
	
	public DetailsOfStudentOfCollege updateDetailOfStudentInIIQA(DetailsOfStudentOfCollege dosoc,long id);
	
	public boolean saveDocument_academic_mou_foreignInIIQA(long prepareIIQA_ID, MultipartFile pdf);
	
	public boolean deleteDocumentOfmou(long iiqaId);
	
	public List<DetailsOfStaffOfCollege> findStaffByPrepareIIQAID(long prepareIIQA_ID);
	
	public List<DetailsOfStudentOfCollege> findStudentByPrepareIIQAID(long prepareIIQA_ID);
	
	public boolean updateStudentByID(long id, DetailsOfStudentOfCollege dosc);
	
	public boolean updateStaffByID(long id, DetailsOfStaffOfCollege dosc);
	
	public boolean updateDateOfEstablishment(long id, PrepareIIQA date );

	public List<PrepareIIQA> getprepareIIQAIDByCollegeId(Long collegeId);
}
