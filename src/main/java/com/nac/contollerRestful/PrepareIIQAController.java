package com.nac.contollerRestful;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.nac.model.IIQA.AffiliatingUniversity;
import com.nac.model.IIQA.CollegeProgramBySRA;
import com.nac.model.IIQA.DetailsOfStaffOfCollege;
import com.nac.model.IIQA.DetailsOfStudentOfCollege;
import com.nac.model.IIQA.PrepareIIQA;
import com.nac.model.IIQA.ProgramRunByCollege;
import com.nac.model.IIQA.SraList;
import com.nac.service.PrepareIIQAService;
import com.nac.util.ColumnFillService;
import com.nac.util.FileUpload;

@RestController
@CrossOrigin
@RequestMapping("/prepareiiqa/")

public class PrepareIIQAController {

	@Autowired
	PrepareIIQAService iiqaService;

	@Autowired
	FileUpload fileService;
	@Autowired
	ColumnFillService tablesColumnFillService;

	
	@PostMapping("{collegId}/basic-eligibility")
	public ResponseEntity<?> basicEligibilityController(
	    @PathVariable long collegId,
	    @ModelAttribute PrepareIIQA iiqa
	) {
	    PrepareIIQA savedData =iiqaService.basicEligiblity(iiqa,collegId);    
	    if (savedData != null) {
	        return ResponseEntity.ok("Basic eligibility checked successfully.").ok(iiqa);
	    } 
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
	}

	
	@PutMapping("/{iiqaId}/updateBasicEligibility")
	public ResponseEntity<?> updateIIQABasicEligibility(@PathVariable Long iiqaId,
			@ModelAttribute PrepareIIQA iiqa
			) {		
				PrepareIIQA updatedIIQA = iiqaService.updateBasicElegiblity(iiqaId, iiqa);
				if (updatedIIQA != null) {
					return ResponseEntity.ok(updatedIIQA);
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Update Basic Eligibility");
				}
	}

	@DeleteMapping("{affiliatingUniversityId}/delete-affiliating-university")
	public ResponseEntity<?> deleteAffiliatingUniversity(@PathVariable Long affiliatingUniversityId
			) {
		
			boolean deleted = iiqaService.deleteAffiliatingUniversity(affiliatingUniversityId);
			if (deleted) {
				return ResponseEntity.ok("Affiliating University deleted successfully");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Affiliating University not found");
			}
		
	}

	@GetMapping("{prepareIIQA}/getBasicEligibility")
	public ResponseEntity<?> getBasicEligibility(@PathVariable Long prepareIIQA) {

			try {
				Map<String, Object> basicEligibility = iiqaService.getBasicEligibility(prepareIIQA);

				if (basicEligibility != null && !basicEligibility.isEmpty()) {
					return ResponseEntity.ok(basicEligibility);
				} else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
				}
			} catch (javax.persistence.EntityNotFoundException ex) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("No IIQA found with the provided ID: " + prepareIIQA);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("An error occurred while processing the request.");
			}
	}

	@DeleteMapping("{allAffiliatingUniversityId}/affiliatingUniversity")
	public ResponseEntity<?> affiliatingUniversityDelete(@PathVariable long allAffiliatingUniversityId) {
		
			boolean success = iiqaService.delete_affiliating_University(allAffiliatingUniversityId);
			if (success) {
				return ResponseEntity.status(HttpStatus.OK).body("University Deleted Successfully");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
			}
	}

	@PostMapping("{prepareIIQA_ID}/affiliating-universities")
	public ResponseEntity<?> affiliatingUniversity(@RequestParam("state") String state,
			@PathVariable long prepareIIQA_ID, @RequestParam("universityName") String universityName) {
			AffiliatingUniversity univ = new AffiliatingUniversity();
			univ.setState(state);
			univ.setPrepareIIQA_ID(prepareIIQA_ID);
			univ.setUniversityName(universityName);

			iiqaService.affiliating_University(univ, prepareIIQA_ID);

			if (univ != null) {
				return ResponseEntity.status(201).body(univ);
			} 
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add Affiliating University");

	}

	@PostMapping("upload-document-affiliating-universities")
	public ResponseEntity<?> uploadDocumentOfaffiliatingUniversity(
			@RequestParam("AffiliatingUniversityId") Long AffiliatingUniversityId,
			@RequestParam("pdf") MultipartFile pdf) {
			boolean success = iiqaService.affiliating_Univ_Document(pdf, AffiliatingUniversityId);
			if (success) {
				String documentName = fileService.waitUntilDocumentNameIsSet(AffiliatingUniversityId);

				if (!documentName.isEmpty()) {
					return ResponseEntity.status(200).body(documentName);
				} else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body("Document name retrieval timed out.");
				}
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to upload document.");

			}
	}

	@GetMapping("{prepareIIQA_ID}/getAffiliation")
	public ResponseEntity<List<Map.Entry<String, List<Object>>>> getCombinedResults(@PathVariable long prepareIIQA_ID) {
			List<Map.Entry<String, List<Object>>> combinedResults = iiqaService.combineResults(prepareIIQA_ID);
			if(combinedResults != null) {
				return ResponseEntity.ok(combinedResults);
			}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{prepareIIQA_ID}/allAffiliatingUniversity")
	public ResponseEntity<?> getAllAffiliatingUniversityByPrepareIIQAID(@PathVariable long prepareIIQA_ID) {
			List<AffiliatingUniversity> universities = iiqaService
					.getAllAffiliatingUniversityByPrepareIIQAID(prepareIIQA_ID);

			if (!universities.isEmpty()) {
				return ResponseEntity.ok(universities);
			} else {
				return ResponseEntity.notFound().build();
			}
	}

	@PostMapping("{id}/remove-file")
	public ResponseEntity<?> removeFileOfAffliatingUniversity(@PathVariable long id) {	
			boolean success = iiqaService.deleteAffiliating_Univ_Document(id);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}

	@PostMapping("{prepareIIQAID}/remove-file-nad-documnet")
	public ResponseEntity<?> removeFileofNADDocument(@PathVariable long prepareIIQAID) {
			boolean success = iiqaService.deleteDocumentRegistereNAD(prepareIIQAID);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}


	@PostMapping("{prepareIIQA_ID}/sra")
	public ResponseEntity<?> saveSraList(@RequestParam("sraType") String sraType, @PathVariable long prepareIIQA_ID) {
			SraList sra = new SraList();
			sra.setSraType(sraType);
			sra.setPrepareIIQA(prepareIIQA_ID);
			SraList sraa = iiqaService.saveSra(sra);
			if (sraa != null) {
				return ResponseEntity.status(201).body(sraa);
			} else {
				return ResponseEntity.status(400).body("Something Went wrong");
			}	
	}


	 @PostMapping("/{sraId}/updatingFile-sra")
	    public ResponseEntity<?> updateFileInSRA(@PathVariable long sraId, @RequestParam("pdf") MultipartFile pdf) {
	        try {
	            boolean success = iiqaService.saveSraDocumentName(sraId, pdf);

	            if (success) {
	                String fieldName = "sraDocumentName";
	                String documentName = fileService.waitUntilDocumentNameIsSet(SraList.class, sraId, fieldName);
	                if (!documentName.isEmpty()) {
	                    return ResponseEntity.status(HttpStatus.OK).body(documentName);
	                } else {
	                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                            .body("Document name retrieval timed out.");
	                }
	            } else {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                        .body("Failed to save document for SRA ID: " + sraId);
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Internal server error: " + e.getMessage());
	        }
	    }


	@GetMapping("{prepareIIQAID}/sralist")
	public ResponseEntity<?> saveProgramRecognisedBySRA(@PathVariable long prepareIIQAID) {
		
			List<SraList> sraList = iiqaService.getSraByPrepareIIQAID(prepareIIQAID);
			if (sraList != null) {
				return ResponseEntity.status(HttpStatus.OK).body(sraList);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sraList);
			}
	}

	
	@DeleteMapping("/{sraListId}/remove-sra-by-sraId")
    public ResponseEntity<?> removSra(@PathVariable long sraListId) {
        try {
            boolean deleted = iiqaService.deleteSraBySraID(sraListId);
            if (deleted) {
                return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SRA not found with ID: " + sraListId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete SRA: " + e.getMessage());
        }
    }
	


	@PostMapping("{sraId}/remove-file-sralist")
	public ResponseEntity<?> removeFileOfSraList(@PathVariable long sraId) {
		
			boolean success = iiqaService.removeFileFromSraList(sraId);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}

	@PostMapping("programRecognisedBySRA")
	public ResponseEntity<?> saveProgramRecognisedBySRA(
			@RequestParam("collegeProgramBySRA_Type") String collegeProgramBySRA_Type,
			@RequestParam("prepareIIQA_ID") long prepareIIQA_ID) {
		
			CollegeProgramBySRA cpbs = new CollegeProgramBySRA();
			cpbs.setCollegeProgramBySRA_Type(collegeProgramBySRA_Type);
			cpbs.setPrepareIIQA_ID(prepareIIQA_ID);
			CollegeProgramBySRA cpb = iiqaService.saveCollegeProgramBySRA(cpbs);
			if (cpb != null) {
				return ResponseEntity.status(201).body(cpbs);
			}
			return ResponseEntity.status(204).body("Something went wrong");
	}



	 @PostMapping("/updatingFile-programRunBySRA")
	    public ResponseEntity<?> updateFileInCollegeSRA(
	            @RequestParam("clgPrgBySRAID") Long clgPrgBySRAID,
	            @RequestParam("pdf") MultipartFile pdf) {

	        try {
	            boolean success = iiqaService.uploadDocumentOfCollegeProgramBySRA(pdf, clgPrgBySRAID);

	            if (success) {
	                String fieldName = "collegeProgramBySRA_Document";
	                String documentName = fileService.waitUntilDocumentNameIsSet(CollegeProgramBySRA.class,
	                        clgPrgBySRAID, fieldName);
	                if (!documentName.isEmpty()) {
	                    return ResponseEntity.status(HttpStatus.OK).body(documentName);
	                } else {
	                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                            .body("Document name retrieval timed out.");
	                }
	            } else {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                        .body("Failed to upload document for clgPrgBySRAID: " + clgPrgBySRAID);
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Internal server error: " + e.getMessage());
	        }
	    }
	
	 @PostMapping("/{programRunByCollegeID}/file-self-declaration")
	 public ResponseEntity<?> updateFileInProgramRunByCollege(
	         @PathVariable Long programRunByCollegeID,
	         @RequestParam("pdf") MultipartFile pdf) {

	     try {
	         if (iiqaService.uploadDocumentOfSelDeclaration(pdf, programRunByCollegeID)) {
	             String documentName = fileService.waitUntilDocumentNameIsSet(ProgramRunByCollege.class,
	                     programRunByCollegeID, "selfDeclaration");
	             return ResponseEntity.status(documentName.isEmpty() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK)
	                     .body(documentName.isEmpty() ? "Document name retrieval timed out." : documentName);
	         } else {
	             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body("Failed to upload self-declaration document for programRunByCollegeID: " + programRunByCollegeID);
	         }
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                 .body("Internal server error: " + e.getMessage());
	     }
	 }

	
	
	@PostMapping("{prbcID}/remove-file-self-declaration")
	public ResponseEntity<?> removeFileOfselfDeclartion(@PathVariable long prbcID) {
			boolean success = iiqaService.deleteDocumentOfSelfDeclaration(prbcID);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}
	
	
	
	@DeleteMapping("{prbcID}/program-run-by-college")
	public ResponseEntity<?> deleteProgramRunByCollegeById(@PathVariable long prbcID) {
	        boolean success = iiqaService.deleteProgramRunBycollege(prbcID);
	        if (success) {
	            return ResponseEntity.ok().build(); 
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete program run by college"); 
	        } 
	}


	@DeleteMapping("{collegeProgramSraId}/college-program-sra")
	public ResponseEntity<?> deletingCollegeProgramSraByPrepareIIQAID(
			@PathVariable("collegeProgramSraId") Long collegeProgramSraId) {
		
			try {
				iiqaService.deleteCollegeProgramBySRA(collegeProgramSraId);
				return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
			}
	}


	@PostMapping("{collegeProgramBySraID}/remove-file-college-program-sra")
	public ResponseEntity<?> removeFileOfCollegeProgram(@PathVariable long collegeProgramBySraID) {		
			boolean success = iiqaService.deleteCollegeProgramSraDocument(collegeProgramBySraID);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}
	
	
	@PostMapping("{prepareIIQAID}/file-recognitionByUGC-documnet")
	public ResponseEntity<?> removeFileOfRecognitionByUGC_2f(@PathVariable long prepareIIQAID) {	
			boolean success = iiqaService.deleteDocumentOfRecognitionByUGC_2f(prepareIIQAID);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}
	
	
	@PostMapping("{prepareIIQAID}/file-recognitionByUGC12B-documnet")
	public ResponseEntity<?> removeFileOfRecognitionByUGC_12B(@PathVariable long prepareIIQAID) {
			boolean success = iiqaService.deleteDocumentOfdocumentOfRecognitionByUGC_12B(prepareIIQAID);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}
	
	
	@PostMapping("{prepareIIQAID}/file-recognitionAutonomous-documnet")
	public ResponseEntity<?> removeFileOfRecognisedAutonomous(@PathVariable long prepareIIQAID) {
			boolean success = iiqaService.deleteDocumentOfRecognisedAutonomous(prepareIIQAID);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}
	
	@PostMapping("{prepareIIQAID}/file-recognitioncpe-documnet")
	public ResponseEntity<?> removeFileOfRecognisedCPE(@PathVariable long prepareIIQAID) {
			boolean success = iiqaService.deleteDocumentOfRecognisedAsCPE(prepareIIQAID);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}
	
	@PostMapping("{prepareIIQAID}/file-recognition-college-of-Excellence-documnet")
	public ResponseEntity<?> removeFileRecognisedCOE(@PathVariable long prepareIIQAID) {
			boolean success = iiqaService.deleteDocumentOfRecognisedAsCollege_of_Excellence(prepareIIQAID);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}
	
	@PostMapping("{prepareIIQAID}/file-aishe-mhrd")
	public ResponseEntity<?> removeFileofAISHE_MHRD(@PathVariable long prepareIIQAID) {
			boolean success = iiqaService.deleteDocumentOfAISHE_MHRD(prepareIIQAID);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}
	
	@PostMapping("{prepareIIQAID}/file-head-of-institution")
	public ResponseEntity<?> removeFileofHeadOfInstution(@PathVariable long prepareIIQAID) {
			boolean success = iiqaService.deleteDocumentOfCertification_by_Head_of_the_Institution(prepareIIQAID);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}
	

	@PostMapping("/{iiqa_ID}/file-institutionisRegistereNAD-Document")
	public ResponseEntity<?> updatingFileofRegistereNAD(@PathVariable("iiqa_ID") Long iiqa_ID,
	                                                     @RequestParam("pdf") MultipartFile pdf) {
	    try {
	        boolean success = iiqaService.uploadDocumentRegistereNAD(pdf, iiqa_ID);
	        String fieldName = "institutionisRegistereNAD_Document";
	        
	        if (success) {
	            String documentName = fileService.waitUntilDocumentNameIsSet(PrepareIIQA.class, iiqa_ID, fieldName);
	            return ResponseEntity.status(documentName.isEmpty() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK)
	                    .body(documentName.isEmpty() ? "Document name retrieval timed out." : documentName);
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to upload institutionisRegistereNAD document for iiqa_ID: " + iiqa_ID);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Internal server error: " + e.getMessage());
	    }
	}

//method = updateOfPIinIIQA <it have to remove> 
	@PutMapping("updateProfileInformationInIIQA")
	public ResponseEntity<?> updateOfPIinIIQA(@RequestBody PrepareIIQA iiqa) {
		
			Long id = iiqa.getIiqa_ID();
			PrepareIIQA piiqa = iiqaService.getPrepareIIQAById(id);
			piiqa.setHeadOfTheInstitution(iiqa.getHeadOfTheInstitution());
			piiqa.setDesignation(iiqa.getDesignation());
			piiqa.setIsCollegeFunctionFromOwnCampus(iiqa.getIsCollegeFunctionFromOwnCampus());
			piiqa.setCollegeAddress(iiqa.getCollegeAddress());
			piiqa.setStateOrUT(iiqa.getStateOrUT());
			piiqa.setCity(iiqa.getCity());
			piiqa.setCollegePincode(iiqa.getCollegePincode());
			piiqa.setCollegePhoneAreaCode(iiqa.getCollegePhoneAreaCode());
			piiqa.setCollegePhone(iiqa.getCollegePhone());
			piiqa.setCollegeFaxAreaCode(iiqa.getCollegeFaxAreaCode());
			piiqa.setCollegeFax(iiqa.getCollegeFax());
			piiqa.setAlternateEmail(iiqa.getAlternateEmail());
			piiqa.setCollegeWebsite(iiqa.getCollegeWebsite());
			piiqa.setAlternateFacultyName(iiqa.getAlternateFacultyName());
			piiqa.setAlternateFacultyDesignation(iiqa.getAlternateFacultyDesignation());
			piiqa.setAlternateFacultyAddress(iiqa.getAlternateFacultyAddress());
			piiqa.setAlternateFacultyPhoneAreaCode(iiqa.getAlternateFacultyPhoneAreaCode());
			piiqa.setAlternateFacultyPhone(iiqa.getAlternateFacultyPhone());
			piiqa.setAlternateFacultyFaxAreaCode(iiqa.getAlternateFacultyFaxAreaCode());
			piiqa.setAlternateFacultyPincode(iiqa.getAlternateFacultyPincode());
			piiqa.setAlternateFacultyFax(iiqa.getAlternateFacultyFax());
			piiqa.setAlternateFacultyMobile(iiqa.getAlternateFacultyMobile());
			piiqa.setAlternateFacultyEmail(iiqa.getAlternateFacultyEmail());
			piiqa.setAlternateFacultyAltenateEmail(iiqa.getAlternateFacultyAltenateEmail());
			piiqa.setIsSpecificTypeOfCollege(iiqa.getIsSpecificTypeOfCollege());
			PrepareIIQA piqa = iiqaService.saveProfileInformation(piiqa);
			if(piqa!=null) {
				return ResponseEntity.ok(piiqa);
			}else {
				return ResponseEntity.noContent().build();
			}	
	}

	@PutMapping("updateProfileInformationInIIQAoooo")
	public ResponseEntity<?> updateOfPIinIIQAoooooo(@ModelAttribute PrepareIIQA iiqa){
		PrepareIIQA savePI = iiqaService.saveProfileInformation(iiqa);
        if (savePI != null) {
            return ResponseEntity.status(HttpStatus.OK).body(savePI);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the basic information.");
        }
	}

	
	@PutMapping("{prepareIIqaID}/update-natures-of-college")
	public ResponseEntity<?> updateNaturesOfCollege(
	        @PathVariable long prepareIIqaID,
	        @RequestBody PrepareIIQA noc) {
	        PrepareIIQA updatedIIQA = iiqaService.updateNaturesOfCollege(prepareIIqaID, noc);
	        if (updatedIIQA != null) {
	            return ResponseEntity.ok(updatedIIQA);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	}

	
	
	@PostMapping("updateIn-IIQA_DateOfRecognitionByUGCAndDocument")
	public ResponseEntity<?> updateDateOfRecognitionByUGCAndDocument(
	        @RequestParam("prepareIIQA_ID") Long prepareIIQA_ID,
	        @RequestParam("pdf") MultipartFile pdf,
	        @RequestParam("date") String date) {
	    try {
	        boolean success = iiqaService.updateDateOfRecognitionByUGCAndDocument(prepareIIQA_ID, date, pdf);
	        String fieldName = "documentOfRecognitionByUGC_2f";

	        if (success) {
	            String documentName = fileService.waitUntilDocumentNameIsSet(PrepareIIQA.class, prepareIIQA_ID, fieldName);
	            return ResponseEntity.status(documentName.isEmpty() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK)
	                    .body(documentName.isEmpty() ? "Document name retrieval timed out." : documentName);
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to update Date of Recognition by UGC and document for prepareIIQA_ID: " + prepareIIQA_ID);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Internal server error: " + e.getMessage());
	    }
	}


	@PostMapping("updateIn-IIQA_DateOfRecognitionByUGC_12BAndDocument")
	public ResponseEntity<?> updateDateOfRecognitionByUGC_12BAndDocument(
	        @RequestParam("prepareIIQA_ID") Long prepareIIQA_ID, @RequestParam("date") String date,
	        @RequestParam("pdf") MultipartFile pdf) {

	    try {
	        boolean success = iiqaService.updateDateOfRecognitionByUGC_12BAndDocument(prepareIIQA_ID, date, pdf);
	        String fieldName = "documentOfRecognitionByUGC_12B";
	        
	        if (success) {
	            String documentName = fileService.waitUntilDocumentNameIsSet(PrepareIIQA.class, prepareIIQA_ID,
	                    fieldName);
	            return ResponseEntity.status(documentName.isEmpty() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK)
	                    .body( documentName);
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to upload document for PrepareIIQA ID: " + prepareIIQA_ID);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Internal server error: " + e.getMessage());
	    }
	}


	@PostMapping("updateIIQA-IsCollege-Autonomus")
	public ResponseEntity<?> updateCollegeAsAnAutonomous(@RequestParam("pdf") MultipartFile pdf,
	                                                     @RequestParam("prepareIIQA_ID") Long prepareIIQA_ID) {
	    try {
	        boolean success = iiqaService.updateIsInstitutionRecogniseAsAutonomus(prepareIIQA_ID, pdf);
	        String fieldName = "documentOfRecognisedAutonomous";
	        
	        if (success) {
	            String documentName = fileService.waitUntilDocumentNameIsSet(PrepareIIQA.class, prepareIIQA_ID,
	                    fieldName);
	            if (!documentName.isEmpty()) {
	                return ResponseEntity.status(HttpStatus.OK).body(documentName);
	            } else {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                        .body("Document name retrieval timed out.");
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to upload document for prepareIIQA_ID: " + prepareIIQA_ID);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Internal server error: " + e.getMessage());
	    }
	}


	@PostMapping("updateIIQA-IsCollege-CPE")
	public ResponseEntity<?> updateCollegeAsCPE(@RequestParam("pdf") MultipartFile pdf,
	                                            @RequestParam("prepareIIQA_ID") Long prepareIIQA_ID) {
	    try {
	        boolean success = iiqaService.updateIsInstitutionRecogniseAsCPE(prepareIIQA_ID, pdf);
	        String fieldName = "documentOfRecognisedAsCPE";
	        
	        if (success) {
	            String documentName = fileService.waitUntilDocumentNameIsSet(PrepareIIQA.class, prepareIIQA_ID,
	                    fieldName);
	            return ResponseEntity.status(documentName.isEmpty() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK)
	                    .body(documentName.isEmpty() ? "Document name retrieval timed out." : documentName);
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to update institution as Recognized CPE for prepareIIQA_ID: " + prepareIIQA_ID);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Internal server error: " + e.getMessage());
	    }
	}


	@PostMapping("updateIIQA-IsCollege-COE")
	public ResponseEntity<?> updateCollegeAsCollegeOfExcellence(@RequestParam("pdf") MultipartFile pdf,
	                                                            @RequestParam("prepareIIQA_ID") Long prepareIIQA_ID) {

	    try {
	        boolean success = iiqaService.updateIsInstitutionRecogniseAsCollegeOfExcellence(prepareIIQA_ID, pdf);
	        String fieldName = "documentRecognisedAsCollege_of_Excellence";

	        if (success) {
	            String documentName = fileService.waitUntilDocumentNameIsSet(PrepareIIQA.class, prepareIIQA_ID,
	                    fieldName);
	            return ResponseEntity.status(documentName.isEmpty() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK)
	                    .body(documentName.isEmpty() ? "Document name retrieval timed out." : documentName);
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to update document for prepareIIQA_ID: " + prepareIIQA_ID);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Internal server error: " + e.getMessage());
	    }
	}


	@PostMapping("updateIn-IIQA_College_as_AISHE")
	public ResponseEntity<?> updateDateOfRecognitionByUGC_AISHE(@RequestParam("prepareIIQA_ID") Long prepareIIQA_ID,
	                                                             @RequestParam("date") String date,
	                                                             @RequestParam("pdf") MultipartFile pdf) {
	    try {
	        boolean success = iiqaService.updateDateOfRecognitionByUGC_AISHE(prepareIIQA_ID, date, pdf);

	        String fieldName = "documentofAISHE_MHRD";
	        if (success) {
	            String documentName = fileService.waitUntilDocumentNameIsSet(PrepareIIQA.class, prepareIIQA_ID,
	                    fieldName);
	            if (!documentName.isEmpty()) {
	                return ResponseEntity.status(HttpStatus.OK).body(documentName);
	            } else {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                        .body("Document name retrieval timed out.");
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to update Date of Recognition for prepareIIQA_ID: " + prepareIIQA_ID);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Internal server error: " + e.getMessage());
	    }
	}


	@PostMapping("updateIn-IIQA_DocumentCertification_by_Head_of_the_Institution")
	public ResponseEntity<?> updateDocumentCertification_by_Head_of_the_Institution(
	        @RequestParam("prepareIIQA_ID") Long prepareIIQA_ID, @RequestParam("pdf") MultipartFile pdf) {
	    try {
	        boolean success = iiqaService.updateDocumentCertification_by_Head_of_the_Institution(prepareIIQA_ID, pdf);
	        String fieldName = "documentCertification_by_Head_of_the_Institution";

	        if (success) {
	            String documentName = fileService.waitUntilDocumentNameIsSet(PrepareIIQA.class, prepareIIQA_ID,
	                    fieldName);
	            return ResponseEntity.status(documentName.isEmpty() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK)
	                    .body(documentName.isEmpty() ? "Document name retrieval timed out." : documentName);
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to update document certification by Head of the Institution for prepareIIQA_ID: "
	                            + prepareIIQA_ID);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Internal server error: " + e.getMessage());
	    }
	}


	@PostMapping("{prepareIIQA_ID}/rti-act-Section4-1-b")
	public ResponseEntity<?> updateRTIActSection4_1_b_Declaration_Url(
			@PathVariable Long prepareIIQA_ID, @RequestParam("url") String url) {
			boolean success = iiqaService.updateRTIActSection4_1_b_Declaration_Url(prepareIIQA_ID, url);
			if (success) {
				return ResponseEntity.status(HttpStatus.OK).body("Url Updated successfully.");
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Something Went Wrong.... try again");
			}
	}
	
	@PutMapping("{prepareIIqaID}/updateStatutoryCommittees")
	public ResponseEntity<?> updateStatutoryCommittees(
	        @PathVariable long prepareIIqaID,
	        @RequestParam("StatutoryCommittees_for_ST_SC") String StatutoryCommittees_for_ST_SC,
	        @RequestParam("StatutoryCommittees_for_MinorityCell") String StatutoryCommittees_for_MinorityCell,
	        @RequestParam("StatutoryCommittees_for_Grievance_Redressal") String StatutoryCommittees_for_Grievance_Redressal,
	        @RequestParam("StatutoryCommittees_for_Internal_Compliant") String StatutoryCommittees_for_Internal_Compliant,
	        @RequestParam("StatutoryCommittees_for_Anti_ragging") String StatutoryCommittees_for_Anti_ragging,
	        @RequestParam("StatutoryCommittees_for_OBC_cell") String StatutoryCommittees_for_OBC_cell) {

	        PrepareIIQA iiqa = iiqaService.getPrepareIIQAById(prepareIIqaID);
	        if (iiqa != null) {
	            iiqa.setStatutoryCommittees_for_ST_SC(StatutoryCommittees_for_ST_SC);
	            iiqa.setStatutoryCommittees_for_MinorityCell(StatutoryCommittees_for_MinorityCell);
	            iiqa.setStatutoryCommittees_for_Grievance_Redressal(StatutoryCommittees_for_Grievance_Redressal);
	            iiqa.setStatutoryCommittees_for_Internal_Compliant(StatutoryCommittees_for_Internal_Compliant);
	            iiqa.setStatutoryCommittees_for_Anti_ragging(StatutoryCommittees_for_Anti_ragging);
	            iiqa.setStatutoryCommittees_for_OBC_cell(StatutoryCommittees_for_OBC_cell);

	            PrepareIIQA updatedIIQA = iiqaService.updateStatutoryCommittees(prepareIIqaID,iiqa);
	            return ResponseEntity.ok(updatedIIQA);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	   
	}


	@PostMapping("/{prepareIIQA_ID}/updateProgramCount")
	public ResponseEntity<String> updateProgramCountOfCollege(@PathVariable Long prepareIIQA_ID,
			@RequestBody List<String> programCount) {
			boolean updated = iiqaService.updateProgramCountOfCollege(prepareIIQA_ID, programCount);
			if (updated) {
				return ResponseEntity.status(200).body("Program counts updated successfully.");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update program counts.");
			}
	}

	@PostMapping("updateCollegeProgram")
	public ResponseEntity<?> updateCollegeProgam(@RequestBody ProgramRunByCollege prbc) {
			ProgramRunByCollege cp = iiqaService.saveProgramRunByCollege(prbc);
			if (cp != null) {
				return ResponseEntity.ok(cp);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update program.");
			}
	}

	@GetMapping("{prepareIIQA_Id}/AllProgramBybyPrepareIIQAId")
	public ResponseEntity<List<ProgramRunByCollege>> getAllProgramByPrepareIIQAId(@PathVariable Long prepareIIQA_Id) {
	    List<ProgramRunByCollege> programList = iiqaService.getAllProgramByPrepaerIIqaId(prepareIIQA_Id);
	    if (programList.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(programList);
	    }
	    return ResponseEntity.ok(programList);
	}

	@GetMapping("{collegeId}/get-prepare-iiqa")
	public ResponseEntity<?> getPrepareIIQA(@PathVariable long collegeId) {
	    PrepareIIQA iiqa = iiqaService.findLatestByCollegeRegistrationId(collegeId);
	    
	    if (iiqa == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    return ResponseEntity.ok(iiqa);
	}


	@PostMapping("{prepareIIQA_ID}/save-details-of-staff")
	public ResponseEntity<?> updateDetailsOfStaffInIIQA(@RequestParam("category") String category,
			@RequestParam("male") int male, @RequestParam("female") int female,
			@RequestParam("transgender") int transgender, @PathVariable long prepareIIQA_ID) {
		
			DetailsOfStaffOfCollege dosoc = new DetailsOfStaffOfCollege();
			dosoc.setCategory(category);
			dosoc.setMale(male);
			dosoc.setFemale(female);
			dosoc.setTransgender(transgender);
			dosoc.setPrepareIIQA_ID(prepareIIQA_ID);
			DetailsOfStaffOfCollege dsoc = iiqaService.updateInIIQADetailsOfStaf(dosoc);
			if (dsoc != null) {
				return ResponseEntity.ok(dsoc);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
			}
		
	}

	@PostMapping("{prepareIIQA_ID}/{id}/save-details-of-staff")
	public ResponseEntity<?> updateDetailOfStaffInIIQA(@RequestParam("category") String category,
			@RequestParam("male") int male, @RequestParam("female") int female,
			@RequestParam("transgender") int transgender, @PathVariable long prepareIIQA_ID, @PathVariable long id) {
		
			DetailsOfStaffOfCollege dosoc = new DetailsOfStaffOfCollege();
			dosoc.setCategory(category);
			dosoc.setMale(male);
			dosoc.setFemale(female);
			dosoc.setTransgender(transgender);
			dosoc.setPrepareIIQA_ID(prepareIIQA_ID);
			DetailsOfStaffOfCollege dsoc = iiqaService.updateInIIQADetailsOfStafByID(dosoc, id);
			if (dsoc != null) {
				return ResponseEntity.ok(dsoc);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
			}
	}

	@PostMapping("{prepareIIQA_ID}/save-student-detail-of-college")
	public ResponseEntity<?> updateStudentDeailsInIIQA(@RequestParam("categories") String categories,
			@RequestParam("male") int male, @RequestParam("female") int female,
			@RequestParam("transgender") int transgender, @PathVariable long prepareIIQA_ID) {
		
			DetailsOfStudentOfCollege std = new DetailsOfStudentOfCollege();
			std.setCategories(categories);
			std.setMale(male);
			std.setFemale(female);
			std.setTransgender(transgender);
			DetailsOfStudentOfCollege saveDetails = iiqaService.updateDetailsOfStudentInIIQA(std);
			if (saveDetails != null) {
				return ResponseEntity.ok(saveDetails);

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
			}
	}

	@PostMapping("{prepareIIQA_ID}/update-details-of-student")
	public ResponseEntity<?> updateDetailOfStudentInIIQA(@RequestParam("category") String category,
			@RequestParam("male") int male, @RequestParam("female") int female,
			@RequestParam("transgender") int transgender, @PathVariable long prepareIIQA_ID) {

			DetailsOfStudentOfCollege dosoc = new DetailsOfStudentOfCollege();
			dosoc.setCategories(category);
			dosoc.setMale(male);
			dosoc.setFemale(female);
			dosoc.setTransgender(transgender);
			dosoc.setPrepareIIQA_ID(prepareIIQA_ID);

			DetailsOfStudentOfCollege dsoc = iiqaService.updateDetailOfStudentInIIQA(dosoc, prepareIIQA_ID);

			if (dsoc != null) {
				return ResponseEntity.ok(dsoc);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
			}
	}

	@PostMapping("{prepareIIQA_ID}/updateIn-IIQA-document-academic-mou")
	public ResponseEntity<?> saveDocumentAcademicMou(
	        @PathVariable Long prepareIIQA_ID,
	        @RequestParam("pdf") MultipartFile pdf) {
	    try {
	        boolean success = iiqaService.saveDocument_academic_mou_foreignInIIQA(prepareIIQA_ID, pdf);
	        String fieldName = "document_academic_mou_foreign";

	        if (success) {
	            String documentName = fileService.waitUntilDocumentNameIsSet(PrepareIIQA.class, prepareIIQA_ID, fieldName);
	            if (!documentName.isEmpty()) {
	                return ResponseEntity.status(HttpStatus.OK)
	                        .body(documentName);
	            } else {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                        .body("Document name retrieval timed out.");
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Document saving failed.");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Internal server error: " + e.getMessage());
	    }
	}


	@GetMapping("{prepareIIQAID}/by-prepareIIQAID")
	public List<Object> getAllByPrepareIIQAIDAndCalculatePercentage(@PathVariable Long prepareIIQAID) {
		return tablesColumnFillService.getAllByPrepareIIQAIDAndCalculatePercentage(prepareIIQAID);
	}
	
	@PostMapping("{iiqaId}/remove-file-mou")
	public ResponseEntity<?> removeFileOfmou(@PathVariable long iiqaId) {
			boolean success = iiqaService.deleteDocumentOfmou(iiqaId);
			if (success) {
				return ResponseEntity.status(200).body("Deleted Successfully");
			} else {
				return ResponseEntity.status(400).body("something went wrong try again");
			}
	}
	
	
	 @GetMapping("{prepareIIQA_ID}/all-students")
	    public ResponseEntity<?> findStudentsByPrepareIIQAID(
	            @PathVariable long prepareIIQA_ID
	    ) {
	            List<DetailsOfStudentOfCollege> students = iiqaService.findStudentByPrepareIIQAID(prepareIIQA_ID);
	            if(students != null) {
	            	 return new ResponseEntity<>(students, HttpStatus.OK);
	            }
	            return new ResponseEntity<>("Not Found", HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("{prepareIIQA_ID}/all-staff")
	    public ResponseEntity<?> findStaffByPrepareIIQAID(
	            @PathVariable long prepareIIQA_ID
	    ) {
	            List<DetailsOfStaffOfCollege> staff = iiqaService.findStaffByPrepareIIQAID(prepareIIQA_ID);
	            if(staff != null) {
	            	
	            return new ResponseEntity<>(staff, HttpStatus.OK);
	        }

	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Not Found By this ID");
	    }
	    
	    
	    @PutMapping("{id}/update-details-of-staff")
	    public ResponseEntity<?> updateDetailOfStaff(
	            @RequestParam("male") int male, @RequestParam("female") int female,
	            @RequestParam("transgender") int transgender, @PathVariable long id) {
	            DetailsOfStaffOfCollege dosc = new DetailsOfStaffOfCollege();
	            
	            dosc.setMale(male);
	            dosc.setFemale(female);
	            dosc.setTransgender(transgender);
	            

	            boolean success = iiqaService.updateStaffByID(id,dosc);

	            if (success) {
	                return ResponseEntity.ok("Updated Successfully");
	            } else {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
	            }
	    }

	    @PutMapping("{id}/update-details-of-student")
	    public ResponseEntity<?> updateDetailsOfStudentInIIQA(
	            @RequestParam("male") int male, @RequestParam("female") int female,
	            @RequestParam("transgender") int transgender, @PathVariable long id) {
	            DetailsOfStudentOfCollege dosc = new DetailsOfStudentOfCollege();            
	            dosc.setMale(male);
	            dosc.setFemale(female);
	            dosc.setTransgender(transgender);
	            boolean success = iiqaService.updateStudentByID(id,dosc);
	            if (success) {
	            	 return ResponseEntity.ok("Updated Successfully");
	            } else {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
	            }
	    }
	    
	    @PutMapping("{id}/update-date-of-establishment")
	    public ResponseEntity<String> updateDateOfEstablishment(@PathVariable long id, @RequestParam("date") String date) {
	        
	        	PrepareIIQA iiqa = new PrepareIIQA();
	        	iiqa.setDateOfEstablishmentOfIQACorCIQA(date);
	            boolean updated = iiqaService.updateDateOfEstablishment(id, iiqa);
	            if (updated) {
	                return ResponseEntity.ok("Date of establishment updated successfully.");
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("IIQA form not found with ID: " + id);
	            }
	    }
	    
	    @GetMapping("{collegeId}/by-collegeId")
		public List<PrepareIIQA> getprepareIIQAIDByCollegeId(@PathVariable Long collegeId) {
			return iiqaService.getprepareIIQAIDByCollegeId(collegeId);
		}

}
