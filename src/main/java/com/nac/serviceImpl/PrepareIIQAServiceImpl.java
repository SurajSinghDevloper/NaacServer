package com.nac.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nac.model.NewCollegeRegistration;
import com.nac.model.IIQA.UniversityRecoginsed;
import com.nac.model.IIQA.CollegeProgramBySRA;
import com.nac.model.IIQA.DetailsOfStaffOfCollege;
import com.nac.model.IIQA.DetailsOfStudentOfCollege;
import com.nac.model.IIQA.PrepareIIQA;
import com.nac.model.IIQA.ProgramRunByCollege;
import com.nac.model.IIQA.SraList;
import com.nac.model.SSR.SSR;
import com.nac.repository.UniversityRecoginsedRepo;
import com.nac.repository.CollegeProgramBySRARepo;
import com.nac.repository.DetailsOfStaffOfCollegeRepo;
import com.nac.repository.DetailsOfStudentOfCollegeRepo;
import com.nac.repository.NewCollegeRegistrationRepo;
import com.nac.repository.PrepareIIQARepo;
import com.nac.repository.ProgramRunByCollegeRepo;
import com.nac.repository.SraListRepo;
import com.nac.repository.ssr.SSRRepo;
import com.nac.service.PrepareIIQAService;
import com.nac.util.FileUpload;

@Service
public class PrepareIIQAServiceImpl implements PrepareIIQAService {

	@Autowired
	PrepareIIQARepo iiqaRepo;

	@Autowired
	UniversityRecoginsedRepo univRecogRepo;

	@Autowired
	FileUpload fileService;

	@Autowired
	CollegeProgramBySRARepo cpbsRepo;

	@Autowired
	ProgramRunByCollegeRepo programRunByCollegeRepo;

	@Autowired
	NewCollegeRegistrationRepo newCollegeRepo;

	@Autowired
	SraListRepo sraListRepo;

	@Autowired
	DetailsOfStaffOfCollegeRepo detailsOfStaffRepo;

	@Autowired
	DetailsOfStudentOfCollegeRepo detailsOfStudentRepo;
	
	@Autowired 
	SSRRepo ssrRepo;

	@Override
	public PrepareIIQA basicEligiblity(PrepareIIQA iiqa,long collegId) {
		NewCollegeRegistration college = newCollegeRepo.findById(collegId).get();
		if(college != null) {
			iiqa.setCollegeRegistrationId(collegId);
			iiqaRepo.save(iiqa);
			return iiqa;
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrepareIIQA updateBasicElegiblity(long id, PrepareIIQA piiqa) {
		PrepareIIQA iiqa = getPrepareIIQAById(id);
		if(iiqa !=null) {
			iiqa.setCycleOfAccreditation(piiqa.getCycleOfAccreditation());
			iiqa.setNameOfHigherEducationInstitution(piiqa.getNameOfHigherEducationInstitution());
			iiqa.setCity(piiqa.getCity());
			iiqa.setStateOrUT(piiqa.getStateOrUT());
			iiqa.setDistrict(piiqa.getDistrict());
			iiqa.setDate_of_establishment_of_the_Institution(piiqa.getDate_of_establishment_of_the_Institution());
			iiqa.setYears_of_graduation_of_the_last_two_batches(piiqa.getYears_of_graduation_of_the_last_two_batches());
			return iiqaRepo.save(iiqa);
		}
		return null;
	}

	public Map<String, Object> getBasicEligibility(Long iiqa) {
		PrepareIIQA iiqas = getPrepareIIQAById(iiqa);

		if (iiqas != null) {
			Map<String, Object> basicEligibility = new HashMap<>();
			basicEligibility.put("prepareIIQA_Id", iiqas.getIiqa_ID());
			basicEligibility.put("cycleOfAccreditation", iiqas.getCycleOfAccreditation());
			basicEligibility.put("nameOfHigherEducationInstitution", iiqas.getNameOfHigherEducationInstitution());
			basicEligibility.put("city", iiqas.getCity());
			basicEligibility.put("stateOrUT", iiqas.getStateOrUT());
			basicEligibility.put("district", iiqas.getDistrict());
			basicEligibility.put("dateOfEstablishmentOfTheInstitution",
					iiqas.getDate_of_establishment_of_the_Institution());
			basicEligibility.put("yearsOfGraduationOfTheLastTwoBatches",
					iiqas.getYears_of_graduation_of_the_last_two_batches());

			return basicEligibility;
		} else {
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("error", "IIQA with the provided ID not found.");
			return errorResponse;
		}
	}

	@Override
	public void recognised_University(UniversityRecoginsed recogUniv) {
		// TODO Auto-generated method stub
		PrepareIIQA iiqa = getPrepareIIQAById(recogUniv.getPrepareIIQA_ID());
		iiqa.setIsRecognised("TRUE");
		iiqaRepo.save(iiqa);
		univRecogRepo.save(recogUniv);
	}

	@Override
	public boolean deleteRecognisedUniv(Long id) {
//		UniversityRecoginsed au = univRecogRepo.findByAffiliatingUniversityId(id);  deleteRecognisedUniv
		UniversityRecoginsed au = univRecogRepo.findById(id).get();
		if (au != null) {
			univRecogRepo.delete(au);
			return true;
		}
		return false;
	}

	@Override
	public List<PrepareIIQA> findLatestIIQAByCollegeRegistration(long collegeRegistrationId) {

		List<PrepareIIQA> results = iiqaRepo.findLatestByCollegeRegistration(collegeRegistrationId);

		return results;
	}

	@Override
	public PrepareIIQA findLatestByCollegeRegistrationId(long collegeRegistrationId) {
		List<PrepareIIQA> resultList = iiqaRepo.findLatestByCollegeRegistration(collegeRegistrationId);
		if (!resultList.isEmpty()) {
			// Return the first result (latest)
			return resultList.get(0);
		} else {
			return null; // Or throw an exception
		}
	}

	@Override
	public boolean recognised_Univ_Document(MultipartFile pdf, Long recognisedUnivId) {
		try {
			UniversityRecoginsed univ = univRecogRepo.findById(recognisedUnivId).get();
			String fileName = fileService.uploadFile(pdf);
			univ.setCampusApprovalDoc(fileName);
			univRecogRepo.save(univ);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteRecog_Univ_Document(Long recognisedUnivId) {
		UniversityRecoginsed univ = univRecogRepo.findById(recognisedUnivId).get();
		if (univ != null) {
			String docName = univ.getCampusApprovalDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				univ.setCampusApprovalDoc("");
				univRecogRepo.save(univ);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	@Override
	public boolean delete_affiliating_University(long affiliatingUniversityId) {
		UniversityRecoginsed univ = univRecogRepo.getById(affiliatingUniversityId);
		if (univ != null) {
			univRecogRepo.delete(univ);
			return true;
		}
		return false;
	}

	@Override
	public List<UniversityRecoginsed> getAllRecogUnivByPrepareIIQAID(long prepareIIQA_ID) {
		return univRecogRepo.findByPrepareIIQAID(prepareIIQA_ID);
	}

	@Override
	public List<CollegeProgramBySRA> getCollegeProgramBySRA(Long prepareIIQA) {
		return cpbsRepo.findByprepareIIQA(prepareIIQA);
	}

	@Override
	public void deleteCollegeProgramBySRA(long collegeProgramBySraID) {
		CollegeProgramBySRA cpbs = cpbsRepo.getById(collegeProgramBySraID);
		cpbsRepo.delete(cpbs);
	}

	@Override
	public boolean deleteCollegeProgramSraDocument(Long collegeProgramBySraID) {
		CollegeProgramBySRA college = cpbsRepo.getById(collegeProgramBySraID);
		if (college != null) {
			String docName = college.getCollegeProgramBySRA_Document();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				college.setCollegeProgramBySRA_Document("");
				cpbsRepo.save(college);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	@Override
	public List<Map.Entry<String, List<Object>>> combineResults(long prepareIIQA_ID) {
		List<UniversityRecoginsed> recognisedUniversities = getAllRecogUnivByPrepareIIQAID(
				prepareIIQA_ID);
		List<SraList> collegeProgramSraList = sraListRepo.findByPrepareIIQA(prepareIIQA_ID);

		// Create a Map to group objects by type
		Map<String, List<Object>> groupedObjects = new HashMap<>();
		groupedObjects.put("recognisedUniv", new ArrayList<>(recognisedUniversities));
		groupedObjects.put("SraList", new ArrayList<>(collegeProgramSraList));

		// Convert the Map entries to a list of Map.Entry objects
		List<Map.Entry<String, List<Object>>> resultList = new ArrayList<>();
		for (Map.Entry<String, List<Object>> entry : groupedObjects.entrySet()) {
			resultList.add(entry);
		}

		return resultList;
	}

	@Override
	public SraList saveSra(SraList sra) {
		return sraListRepo.save(sra);
	}

	@Override
	public boolean saveSraDocumentName(long sraId, MultipartFile pdf) {

		try {
			SraList sra = sraListRepo.getById(sraId);
			if (sra != null) {
				String fileName = fileService.uploadFile(pdf);
				sra.setSraDocumentName(fileName);
				sraListRepo.save(sra);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<SraList> getSraByPrepareIIQAID(long prepareIIQAID) {
		return sraListRepo.findByPrepareIIQA(prepareIIQAID);

	}

	@Override
	public boolean deleteSraBySraID(long sraId) {
	    try {
	        SraList sra = sraListRepo.getById(sraId);
	        if (sra != null) {
	            sraListRepo.delete(sra);
	            return true;
	        } else {
	            throw new EntityNotFoundException("SraList not found with ID: " + sraId);
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); 
	        return false;
	    }
	}


	@Override
	public boolean removeFileFromSraList(long sraId) {
		SraList sra = sraListRepo.getById(sraId);
		if (sra != null) {
			String docName = sra.getSraDocumentName();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				sra.setSraDocumentName("");
				sraListRepo.save(sra);
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

	@Override
	public CollegeProgramBySRA saveCollegeProgramBySRA(CollegeProgramBySRA cps) {
		return cpbsRepo.save(cps);
	}

	@Override
	public boolean uploadDocumentOfCollegeProgramBySRA(MultipartFile pdf, Long clgPrgBySRAID) {
		try {
			CollegeProgramBySRA cpbs = cpbsRepo.getById(clgPrgBySRAID);
			String fileName = fileService.uploadFile(pdf);
			cpbs.setCollegeProgramBySRA_Document(fileName);
			cpbsRepo.save(cpbs);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean uploadDocumentOfSelDeclaration(MultipartFile pdf, Long clgPrgBySRAID) {
		try {
			ProgramRunByCollege prbc = programRunByCollegeRepo.getById(clgPrgBySRAID);
			String fileName = fileService.uploadFile(pdf);
			prbc.setSelfDeclaration(fileName);
			programRunByCollegeRepo.save(prbc);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteProgramRunBycollege(long prbc) {
		ProgramRunByCollege prbcs =programRunByCollegeRepo.getById(prbc);
		if(prbcs !=null) {
			programRunByCollegeRepo.delete(prbcs);
			return true;
			
		}else {
			return false;
		}
	}
	

	@Override
	public boolean uploadDocumentRegistereNAD(MultipartFile pdf, Long iiqa_ID) {
		try {
			PrepareIIQA piiqa = iiqaRepo.getById(iiqa_ID);
			String fileName = fileService.uploadFile(pdf);
			piiqa.setInstitutionisRegistereNAD_Document(fileName);
			iiqaRepo.save(piiqa);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteDocumentRegistereNAD(long iiqaId) {
		PrepareIIQA piqa = getPrepareIIQAById(iiqaId);
		if (piqa != null) {
			String docName = piqa.getInstitutionisRegistereNAD_Document();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				piqa.setInstitutionisRegistereNAD_Document("");
				iiqaRepo.save(piqa);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	@Override
	public PrepareIIQA saveProfileInformation(PrepareIIQA iiqa) {
		// TODO Auto-generated method stub
		return iiqaRepo.save(iiqa);
	}

	@Override
	public PrepareIIQA getPrepareIIQAById(Long prepareIIQA_ID) {
		PrepareIIQA iiqa = iiqaRepo.findById(prepareIIQA_ID).get();
		if (iiqa != null) {
			return iiqa;
		} else {
			return null;
		}
	}
	
	@Override
	public PrepareIIQA updateNaturesOfCollege(long prepareIIqaID, PrepareIIQA noc) {
		PrepareIIQA iiqa = getPrepareIIQAById(prepareIIqaID);
			iiqa.setNatureOfCollege(noc.getNatureOfCollege());
	        PrepareIIQA saveNatureOfCollege = iiqaRepo.save(iiqa);
	        if(saveNatureOfCollege != null) {
		        return saveNatureOfCollege;
	        }
	        return null;
	}
	
	
	
	
	
	
	
	@Override
	public boolean saveDocumentOfNatureOfCollege(long prepareIIqaID, MultipartFile pdf) {

		try {
			PrepareIIQA iiqa = iiqaRepo.findById(prepareIIqaID).get();
			if (iiqa != null) {
				String fileName = fileService.uploadFile(pdf);
				iiqa.setNatureOfCollegeDoc(fileName);
				iiqaRepo.save(iiqa);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteDocumentOfNatureOfCollege(long prepareIIqaID) {
		PrepareIIQA iiqa = iiqaRepo.findById(prepareIIqaID).get();;
		if (iiqa != null) {
			String docName = iiqa.getNatureOfCollegeDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				iiqa.setNatureOfCollegeDoc("");
				iiqaRepo.save(iiqa);
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean updateDateOfRecognitionByUGCAndDocument(Long prepareIIQA_ID, String date, MultipartFile pdf) {
		try {
			PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);
			String fileName = fileService.uploadFile(pdf);
			iiqa.setDateOfRecognitionByUGC_2f(date);
			iiqa.setDocumentOfRecognitionByUGC_2f(fileName);
			iiqaRepo.save(iiqa);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public boolean deleteDocumentOfRecognitionByUGC_2f(long iiqaId) {
		PrepareIIQA piqa = getPrepareIIQAById(iiqaId);
		if (piqa != null) {
			String docName = piqa.getDocumentOfRecognitionByUGC_2f();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				piqa.setInstitutionisRegistereNAD_Document("");
				iiqaRepo.save(piqa);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
	
	
	@Override
	public boolean deleteDocumentOfmou(long iiqaId) {
		PrepareIIQA piqa = getPrepareIIQAById(iiqaId);
		if (piqa != null) {
			String docName = piqa.getDocument_academic_mou_foreign();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				piqa.setInstitutionisRegistereNAD_Document("");
				iiqaRepo.save(piqa);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
	

	@Override
	public boolean updateDateOfRecognitionByUGC_12BAndDocument(Long prepareIIQA_ID, String date, MultipartFile pdf) {
		try {
			PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);
			String fileName = fileService.uploadFile(pdf);
			System.out.println("HERE IS SREVICE   ======  " + fileName);
			iiqa.setDateOfRecognitionByUGC_12B(date);
			iiqa.setDocumentOfRecognitionByUGC_12B(fileName);
			iiqaRepo.save(iiqa);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public boolean deleteDocumentOfdocumentOfRecognitionByUGC_12B(long iiqaId) {
		PrepareIIQA piqa = getPrepareIIQAById(iiqaId);
		if (piqa != null) {
			String docName = piqa.getDocumentOfRecognitionByUGC_12B();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				piqa.setDocumentOfRecognitionByUGC_12B("");
				iiqaRepo.save(piqa);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
	
	
	@Override
	public boolean deleteDocumentOfRecognisedAutonomous(long iiqaId) {
		PrepareIIQA piqa = getPrepareIIQAById(iiqaId);
		if (piqa != null) {
			String docName = piqa.getDocumentOfRecognisedAutonomous();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				piqa.setInstitutionisRegistereNAD_Document("");
				iiqaRepo.save(piqa);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
	
	@Override
	public boolean deleteDocumentOfRecognisedAsCPE(long iiqaId) {
		PrepareIIQA piqa = getPrepareIIQAById(iiqaId);
		if (piqa != null) {
			String docName = piqa.getDocumentOfRecognisedAsCPE();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				piqa.setInstitutionisRegistereNAD_Document("");
				iiqaRepo.save(piqa);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
	
	@Override
	public boolean deleteDocumentOfRecognisedAsCollege_of_Excellence(long iiqaId) {
		PrepareIIQA piqa = getPrepareIIQAById(iiqaId);
		if (piqa != null) {
			String docName = piqa.getDocumentRecognisedAsCollege_of_Excellence();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				piqa.setInstitutionisRegistereNAD_Document("");
				iiqaRepo.save(piqa);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
	
	@Override
	public boolean deleteDocumentOfAISHE_MHRD(long iiqaId) {
		PrepareIIQA piqa = getPrepareIIQAById(iiqaId);
		if (piqa != null) {
			String docName = piqa.getDocumentofAISHE_MHRD();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				piqa.setInstitutionisRegistereNAD_Document("");
				iiqaRepo.save(piqa);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
	
	@Override
	public boolean deleteDocumentOfCertification_by_Head_of_the_Institution(long iiqaId) {
		PrepareIIQA piqa = getPrepareIIQAById(iiqaId);
		if (piqa != null) {
			String docName = piqa.getDocumentCertification_by_Head_of_the_Institution();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				piqa.setInstitutionisRegistereNAD_Document("");
				iiqaRepo.save(piqa);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
	

	@Override
	public boolean updateIsInstitutionRecogniseAsAutonomus(Long prepareIIQA_ID, MultipartFile pdf) {
		try {
			PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);
			String fileName = fileService.uploadFile(pdf);
			String setInstitutionRecognisedAutonomous = "True";
			iiqa.setDocumentOfRecognisedAutonomous(fileName);
			iiqa.setInstitutionRecognisedAutonomous(setInstitutionRecognisedAutonomous);

			iiqaRepo.save(iiqa);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateIsInstitutionRecogniseAsCPE(Long prepareIIQA_ID, MultipartFile pdf) {
		try {
			PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);
			String fileName = fileService.uploadFile(pdf);
			String setInstitutionRecognisedAutonomous = "True";
			iiqa.setDocumentOfRecognisedAsCPE(fileName);
			iiqa.setInstitutionRecognisedAsCPE(setInstitutionRecognisedAutonomous);

			iiqaRepo.save(iiqa);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateIsInstitutionRecogniseAsCollegeOfExcellence(Long prepareIIQA_ID, MultipartFile pdf) {
		try {
			PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);
			String fileName = fileService.uploadFile(pdf);
			String setInstitutionRecognisedAutonomous = "True";
			iiqa.setDocumentRecognisedAsCollege_of_Excellence(fileName);
			iiqa.setInstitutionRecognisedAsCollege_of_Excellence(setInstitutionRecognisedAutonomous);

			iiqaRepo.save(iiqa);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateDateOfRecognitionByUGC_AISHE(Long prepareIIQA_ID, String date, MultipartFile pdf) {
		try {
			PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);
			String fileName = fileService.uploadFile(pdf);
			iiqa.setDateOf_AISHE_Upload(date);
			iiqa.setDocumentAISHE_Upload_Date(fileName);
			iiqaRepo.save(iiqa);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateDocumentCertification_by_Head_of_the_Institution(Long prepareIIQA_ID, MultipartFile pdf) {
		try {
			PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);
			String fileName = fileService.uploadFile(pdf);
			iiqa.setDocumentCertification_by_Head_of_the_Institution(fileName);
			iiqaRepo.save(iiqa);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRTIActSection4_1_b_Declaration_Url(Long prepareIIQA_ID, String url) {
		try {
			PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);
			if (iiqa != null) {
				iiqa.setRTIActSection4_1_b_Declaration_Url(url);
				iiqaRepo.save(iiqa);
				return true;
			} else {

				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PrepareIIQA updateStatutoryCommittees(Long prepareIIQA_ID, PrepareIIQA statutoryCommittees) {
		PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);



			iiqa.setStatutoryCommittees_for_ST_SC(statutoryCommittees.getStatutoryCommittees_for_ST_SC());
			iiqa.setStatutoryCommittees_for_MinorityCell(statutoryCommittees.getStatutoryCommittees_for_MinorityCell());
			iiqa.setStatutoryCommittees_for_Grievance_Redressal(statutoryCommittees.getStatutoryCommittees_for_Grievance_Redressal());
			iiqa.setStatutoryCommittees_for_Internal_Compliant(statutoryCommittees.getStatutoryCommittees_for_Internal_Compliant());
			iiqa.setStatutoryCommittees_for_Anti_ragging(statutoryCommittees.getStatutoryCommittees_for_Anti_ragging());
			iiqa.setStatutoryCommittees_for_OBC_cell(statutoryCommittees.getStatutoryCommittees_for_OBC_cell());

			 PrepareIIQA saveNatureOfCollege = iiqaRepo.save(iiqa);
		        return saveNatureOfCollege;

	}
	
	
	@Override
	public boolean deleteDocumentOfSelfDeclaration(long prbcID) {
		ProgramRunByCollege prbc = programRunByCollegeRepo.getById(prbcID);
		if (prbc != null) {
			String docName = prbc.getSelfDeclaration();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				prbc.setSelfDeclaration("");
				programRunByCollegeRepo.save(prbc);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
	
	

	@Override
	public boolean updateProgramCountOfCollege(Long prepareIIQA_ID, List<String> ProgramCount) {
		PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);

		if (iiqa != null || ProgramCount != null && ProgramCount.size() > 10) {
			iiqa.setProgram_Count_UG(ProgramCount.get(0));
			iiqa.setProgram_Count_PG(ProgramCount.get(1));
			iiqa.setProgram_Count_DM_Ayurveda_Vachaspathi(ProgramCount.get(2));
			iiqa.setProgram_Count_Pre_Doctoral(ProgramCount.get(3));
			iiqa.setProgram_Count_Doctoral(ProgramCount.get(4));
			iiqa.setProgram_Count_Post_Doctoral(ProgramCount.get(5));
			iiqa.setProgram_Count_PG_Diploma(ProgramCount.get(6));
			iiqa.setProgram_Count_Diploma(ProgramCount.get(7));
			iiqa.setProgram_Count_Certificate_Awareness(ProgramCount.get(8));
			iiqa.setMd(ProgramCount.get(9));
			iiqa.setMs(ProgramCount.get(10));

			iiqaRepo.save(iiqa);
			return true;
		}
		return false;
	}

	@Override
	public ProgramRunByCollege saveProgramRunByCollege(ProgramRunByCollege prbc) {
		return programRunByCollegeRepo.save(prbc);
	}

	@Override
	public List<ProgramRunByCollege> getAllProgramByPrepaerIIqaId(Long prepareIIQA_Id) {
		List<ProgramRunByCollege> prbc = programRunByCollegeRepo.findAll(prepareIIQA_Id);
		return prbc;
	}

	@Override
	public DetailsOfStaffOfCollege updateInIIQADetailsOfStaf(DetailsOfStaffOfCollege dsoc) {
		return detailsOfStaffRepo.save(dsoc);
	}

	@Override
	public DetailsOfStaffOfCollege updateInIIQADetailsOfStafByID(DetailsOfStaffOfCollege dsoc, long id) {
		DetailsOfStaffOfCollege dosoc = detailsOfStaffRepo.findById(id).get();
		dosoc.setCategory(dsoc.getCategory());
		dosoc.setMale(dsoc.getMale());
		dosoc.setFemale(dsoc.getFemale());
		dosoc.setTransgender(dsoc.getTransgender());
		return detailsOfStaffRepo.save(dosoc);
	}

	@Override
	public DetailsOfStudentOfCollege updateDetailsOfStudentInIIQA(DetailsOfStudentOfCollege dosoc) {
		return detailsOfStudentRepo.save(dosoc);
	}

	@Override
	public DetailsOfStudentOfCollege updateDetailOfStudentInIIQA(DetailsOfStudentOfCollege dosoc, long id) {
		DetailsOfStudentOfCollege ds = new DetailsOfStudentOfCollege();
		ds.setMale(dosoc.getMale());
		ds.setFemale(dosoc.getFemale());
		ds.setTransgender(dosoc.getTransgender());
		ds.setCategories(dosoc.getCategories());
		ds.setPrepareIIQA_ID(id);
		return detailsOfStudentRepo.save(ds);
	}

	@Override
	public boolean saveDocument_academic_mou_foreignInIIQA(long prepareIIQA_ID, MultipartFile pdf) {
		try {
			PrepareIIQA iiqa = getPrepareIIQAById(prepareIIQA_ID);
			String fileName = fileService.uploadFile(pdf);
			iiqa.setDocument_academic_mou_foreign(fileName);
			iiqaRepo.save(iiqa);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	@Override
	public List<DetailsOfStudentOfCollege> findStudentByPrepareIIQAID(long prepareIIQA_ID) {
        return detailsOfStudentRepo.findByPrepareIIQAID(prepareIIQA_ID);
    }
	
	@Override
	public List<DetailsOfStaffOfCollege> findStaffByPrepareIIQAID(long prepareIIQA_ID) {
        return detailsOfStaffRepo.findByPrepareIIQAID(prepareIIQA_ID);
    }
	
	
	@Override
	public boolean updateStaffByID(long id, DetailsOfStaffOfCollege dosc) {
	    DetailsOfStaffOfCollege dsc = detailsOfStaffRepo.findById(id).get();
	    if (dsc != null) {
	    	dsc.setFemale(dosc.getFemale());
	    	dsc.setMale(dosc.getMale());
	    	dsc.setTransgender(dosc.getTransgender());
	    	detailsOfStaffRepo.save(dsc);
	        return true;
	    } else {
	       
	        return false;
	    }
	}


	@Override
	public boolean updateStudentByID(long id, DetailsOfStudentOfCollege dosc) {
		DetailsOfStudentOfCollege dsc = detailsOfStudentRepo.findById(id).get();
	    if (dsc != null) {
	    	dsc.setFemale(dosc.getFemale());
	    	dsc.setMale(dosc.getMale());
	    	dsc.setTransgender(dosc.getTransgender());
	    	detailsOfStudentRepo.save(dsc);
	        return true;
	    } else {
	       
	        return false;
	    }
	}	
	
	

	@Override
	public boolean updateDateOfEstablishment(long id, PrepareIIQA iiqas ) {
		PrepareIIQA iiqa = getPrepareIIQAById(id);
	    if (iiqa != null) {
	    	iiqa.setDateOfEstablishmentOfIQACorCIQA(iiqas.getDateOfEstablishmentOfIQACorCIQA());
	    	PrepareIIQA iiq = iiqaRepo.save(iiqa);
	    	if(iiq !=null) {
	    		SSR ssr = ssrRepo.findSSRbycollegeID(iiqa.getCollegeRegistrationId());
	    		if(ssr == null) {
	    			SSR newSSR = new SSR();
	    			newSSR.setPrepareIIQAID(id);
	    			newSSR.setCollegeID(iiqa.getCollegeRegistrationId());
	    			ssrRepo.save(newSSR);
	    		}	
	    		
	    	}
	    	
	        return true;
	    } else {
	       
	        return false;
	    }
	}

	@Override
	public List<PrepareIIQA> getprepareIIQAIDByCollegeId(Long collegeId) {
		return iiqaRepo.findByCollegeId(collegeId);
	}	

}
