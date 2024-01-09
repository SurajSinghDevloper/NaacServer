package com.nac.contollerRestful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.nac.model.IIQA.PrepareIIQA;
import com.nac.model.IIQA.SraList;
import com.nac.model.SSR.Staff;
import com.nac.model.SSR.StaffDetails;
import com.nac.model.SSR.StudentDetailsCurrentYear;
import com.nac.model.SSR.StudentDetailsLastFourYears;
import com.nac.model.SSR.CriteriaII;
import com.nac.model.SSR.CriteriaIII;
import com.nac.model.SSR.CriteriaIV;
import com.nac.model.SSR.CriteriaV;
import com.nac.model.SSR.CriteriaVI;
import com.nac.model.SSR.CriteriaVII;
import com.nac.model.SSR.ExtendedProfileSSR;
import com.nac.model.SSR.Qif;
import com.nac.model.SSR.SSR;
import com.nac.repository.ssr.SSRRepo;
import com.nac.service.SSRService;
import com.nac.util.FileUpload;

@RestController
@CrossOrigin
@RequestMapping("/ssr")
public class SSRController {
	private final SSRService ssrService;

	@Autowired
	FileUpload fileService;
	@Autowired
	private SSRRepo ssrRepo;

	@Autowired
	public SSRController(SSRService ssrService) {
		this.ssrService = ssrService;
	}

	@PostMapping("/{clgID}/basic-information")
	public ResponseEntity<?> basicInformation(@ModelAttribute SSR ssr, @PathVariable long clgID) {
		SSR savedSSR = ssrService.basicInformation(ssr, clgID);
		if (savedSSR != null) {
			return ResponseEntity.status(HttpStatus.OK).body(savedSSR);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Failed to save the basic information.");
		}
	}

	@PostMapping("/{clgID}/doc-of-minority")
	public ResponseEntity<?> updateFileInSRA(@PathVariable long clgID, @RequestParam("pdf") MultipartFile pdf) {
		try {
			boolean success = ssrService.saveDocumentOfMinority(clgID, pdf);
			SSR newSSR = ssrRepo.findSSRbycollegeID(clgID);
			long ssrID = newSSR.getSsrID();
			if (success) {
				String fieldName = "documentOFMinorityInstitution";
				String documentName = fileService.waitUntilDocumentNameIsSet(SSR.class, ssrID, fieldName);
				if (!documentName.isEmpty()) {
					return ResponseEntity.status(HttpStatus.OK).body(documentName);
				} else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body("Document name retrieval failed.");
				}
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the document.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Internal server error: " + e.getMessage());
		}
	}

	@PostMapping("/{clgID}/doc-of-minority-detach")
	public ResponseEntity<?> removeFileOfselfDeclartion(@PathVariable long clgID) {

		boolean success = ssrService.removeDocumentOfMinority(clgID);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}

	}

	@PostMapping("/{clgID}/doc-of-autonomy")
	public ResponseEntity<?> updateFileInSSR(@PathVariable long clgID, @RequestParam("pdf") MultipartFile pdf) {
		try {
			boolean success = ssrService.saveDocumentOfAutonomus(clgID, pdf);
			SSR newSSR = ssrRepo.findSSRbycollegeID(clgID);
			long ssrID = newSSR.getSsrID();
			if (success) {
				String fieldName = "isAutonomyGrantedDocumnet";
				String documentName = fileService.waitUntilDocumentNameIsSet(SSR.class, ssrID, fieldName);
				if (!documentName.isEmpty()) {
					return ResponseEntity.status(HttpStatus.OK).body(documentName);
				} else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body("Document name retrieval failed.");
				}
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the document.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Internal server error: " + e.getMessage());
		}
	}

	@PostMapping("/{clgID}/doc-of-autonomy-detach")
	public ResponseEntity<?> removeFileOfautonomy(@PathVariable long clgID) {

		boolean success = ssrService.removeDocumentOfAutonomus(clgID);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}

	}

	@PostMapping("/staff")
	public ResponseEntity<?> saveStaffs(@ModelAttribute Staff staff) {
		Staff savedStaff = ssrService.saveStaff(staff);
		if (savedStaff != null) {
			return ResponseEntity.status(201).body("Staff Added Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@GetMapping("/staff/{ssrId}")
	public ResponseEntity<?> getAllStaffs(@PathVariable long ssrId) {
		List<Staff> staffs = ssrService.getAllStaffBySSRId(ssrId);
		if (staffs != null) {
			return ResponseEntity.status(201).body(staffs);
		} else {
			return ResponseEntity.status(400).body("Not Found");
		}
	}

	@PutMapping("/staff-guest")
	public ResponseEntity<?> saveGuestStaffs(@ModelAttribute Staff staff) {
		Staff savedGuestStaff = ssrService.saveStaff(staff);
		if (savedGuestStaff != null) {
			return ResponseEntity.status(201).body("Staff Added Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PutMapping("/staff-guest/{staffId}")
	public ResponseEntity<?> updateGuestStaffs(@ModelAttribute Staff staff, @PathVariable long staffId) {
		Staff savedGuestStaff = ssrService.updateGuestStaff(staffId, staff);
		if (savedGuestStaff != null) {
			return ResponseEntity.status(201).body("Staff Added Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PutMapping("/staff/{staffId}")
	public ResponseEntity<?> saveStaffs(@ModelAttribute Staff staff, @PathVariable("staffId") long staffId) {
		Staff savedStaff = ssrService.saveStaff(staff, staffId);
		if (savedStaff != null) {
			return ResponseEntity.status(201).body("Staff Updated Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/staff-details")
	public ResponseEntity<?> saveStaffDeatils(@ModelAttribute StaffDetails staff) {
		StaffDetails savedStaffDetails = ssrService.saveStaffDetails(staff);
		if (savedStaffDetails != null) {
			return ResponseEntity.status(201).body("Staff Details Added Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@GetMapping("/staff-details/{ssrId}")
	public ResponseEntity<?> getAllStaffsDetail(@PathVariable long ssrId) {
		List<StaffDetails> staffsDetails = ssrService.getAllStaffDetailsBySSRId(ssrId);
		if (staffsDetails != null) {
			return ResponseEntity.status(201).body(staffsDetails);
		} else {
			return ResponseEntity.status(400).body("Not Found");
		}
	}

	@PutMapping("/staff-details/{staffDetailId}")
	public ResponseEntity<?> updateStaffs(@ModelAttribute StaffDetails staff,
			@PathVariable("staffDetailId") long staffId) {
		StaffDetails staffsDetails = ssrService.saveStaffDetails(staff, staffId);
		if (staffsDetails != null) {
			return ResponseEntity.status(201).body("Staff Updated Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/student-details")
	public ResponseEntity<StudentDetailsCurrentYear> saveStudentDetailsCurrentYear(
			@ModelAttribute StudentDetailsCurrentYear studentDetailsCurrentYear) {
		StudentDetailsCurrentYear savedStudentDetails = ssrService
				.saveStudentDetailsCurrentYear(studentDetailsCurrentYear);
		if (savedStudentDetails != null) {
			return ResponseEntity.ok(savedStudentDetails);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/student-details/{ssrId}")
	public ResponseEntity<List<StudentDetailsCurrentYear>> getAllStudentDetailsCurrentYearBySSRId(
			@PathVariable long ssrId) {
		List<StudentDetailsCurrentYear> studentDetails = ssrService.getAllStudentDetailsCurrentYearBySSRId(ssrId);
		if (studentDetails != null && !studentDetails.isEmpty()) {
			return ResponseEntity.ok(studentDetails);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping("/student-details/{studentDetailsId}")
	public ResponseEntity<StudentDetailsCurrentYear> updateStudentDetailsCurrentYear(
			@ModelAttribute StudentDetailsCurrentYear studentDetails, @PathVariable long studentDetailsId) {
		StudentDetailsCurrentYear updatedStudentDetails = ssrService.updateStudentDetailsCurrentYear(studentDetails,
				studentDetailsId);
		if (updatedStudentDetails != null) {
			return ResponseEntity.ok(updatedStudentDetails);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping("/student-details-last-four-year")
	public ResponseEntity<StudentDetailsLastFourYears> saveStudentDetailsLastFourYears(
			@ModelAttribute StudentDetailsLastFourYears studentDetailsLastFourYears) {
		StudentDetailsLastFourYears savedStudentDetails = ssrService
				.saveStudentDetailsLastFourYears(studentDetailsLastFourYears);
		if (savedStudentDetails != null) {
			return ResponseEntity.ok(savedStudentDetails);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@PutMapping("/student-details-enrolled")
	public ResponseEntity<?> saveStudentDetailsLastFourYear(
			@ModelAttribute StudentDetailsLastFourYears studentDetailsLastFourYears) {
		StudentDetailsLastFourYears savedStudentDetails = ssrService
				.detailsOfStudentsEnrolled(studentDetailsLastFourYears);
		if (savedStudentDetails != null) {
			return ResponseEntity.ok(savedStudentDetails);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@PutMapping("/student-details-enrolled/{stdDeatilsId}")
	public ResponseEntity<?> updateStudentDetailsLastFourYear(
			@ModelAttribute StudentDetailsLastFourYears studentDetailsLastFourYears, @PathVariable long stdDeatilsId) {
		StudentDetailsLastFourYears savedStudentDetails = ssrService.updatedDetailsOfStudentsEnrolled(stdDeatilsId,
				studentDetailsLastFourYears);
		if (savedStudentDetails != null) {
			return ResponseEntity.ok(savedStudentDetails);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/student-details-last-four-year/{ssrId}")
	public ResponseEntity<List<StudentDetailsLastFourYears>> getAllStudentDetailsLastFourYearsBySSRId(
			@PathVariable long ssrId) {
		List<StudentDetailsLastFourYears> studentDetails = ssrService.getAllStudentDetailsLastFourYearsBySSRId(ssrId);
		if (studentDetails != null && !studentDetails.isEmpty()) {
			return ResponseEntity.ok(studentDetails);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

//    @PutMapping("/student-details-last-four-year/{studentDetailsId}")
//    public ResponseEntity<StudentDetailsLastFourYears> updateStudentDetailsLastFourYears(@ModelAttribute StudentDetailsLastFourYears studentDetails,
//                                                                                           @PathVariable long studentDetailsId) {
//        StudentDetailsLastFourYears updatedStudentDetails = ssrService.saveStudentDetailsCurrentYear(studentDetails, studentDetailsId);
//        if (updatedStudentDetails != null) {
//            return ResponseEntity.ok(updatedStudentDetails);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
//    
	@GetMapping("/ssr-specifics/{clgId}")
	public ResponseEntity<SSR> getSSRByCollegeID(@PathVariable long clgId) {
		SSR ssr = ssrService.getSSRbyCollegeID(clgId);
		if (ssr != null) {
			return ResponseEntity.ok(ssr);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping("/academic-ssr")
	public ResponseEntity<?> updateExtendedSSR(@ModelAttribute ExtendedProfileSSR newExtendedSSR) {
		String saveExtended = ssrService.academicComplete(newExtendedSSR);

		if ("Saved".equals(saveExtended)) {
			return ResponseEntity.ok("Saved Successfully");
		} else if ("Exists".equals(saveExtended)) {
			return ResponseEntity.status(403).body("Already Exists");
		}
		return ResponseEntity.status(500).body("Somthing Went Wrong");
	}

	@PutMapping("/extended-ssr/{extendedProfileSSRId}")
	public ResponseEntity<?> updateExtendedSSR(@PathVariable long extendedProfileSSRId,
			@ModelAttribute ExtendedProfileSSR newExtendedSSR) {
		ExtendedProfileSSR saveExtended = ssrService.updateExtendedSSR(extendedProfileSSRId, newExtendedSSR);
		if (saveExtended != null) {
			return ResponseEntity.ok(saveExtended);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/extended-ssr/{collegeId}")
	public ResponseEntity<?> getExtendedSSR(@PathVariable long collegeId) {
		ExtendedProfileSSR existingExtendedSSR = ssrService.findExtendedSSrById(collegeId);
		if (existingExtendedSSR != null) {
			return ResponseEntity.ok(existingExtendedSSR);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

//    doc's controller
	@PostMapping("/document-programInstructional/{SsrId}")
	public ResponseEntity<String> uploadDocument(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfProgramInstructional(SsrId, pdf);
		String fieldName = "programCourseInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/document-programInstructional")
	public ResponseEntity<?> removeFileofHeadOfInstution(@PathVariable long SsrId) {
		boolean success = ssrService.deleteDocumentOfProgramInstructional(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/document-studentInstructional/{SsrId}")
	public ResponseEntity<String> uploadDocumentStudentInstructional(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfStudentInstructional(SsrId, pdf);
		String fieldName = "studentInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/document-studentInstructional")
	public ResponseEntity<?> removeFileofStudentInstructional(@PathVariable long SsrId) {
		boolean success = ssrService.deleteDocumentOfStudentInstructional(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/document-stuAppeared-instructional/{SsrId}")
	public ResponseEntity<String> uploadDocumentStuAppearedInstructional(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfStuAppearedInstructional(SsrId, pdf);
		String fieldName = "stuAppearedInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/document-stuAppeared-instructional")
	public ResponseEntity<?> removeFileofStuAppearedInstructional(@PathVariable long SsrId) {
		boolean success = ssrService.deleteDocumentOfStuAppearedInstructional(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/document-stu-rev-appInst/{SsrId}")
	public ResponseEntity<String> uploadDocumentStuRevAppInst(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfStuRevAppInst(SsrId, pdf);
		String fieldName = "stuRevalApplicationsInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/document-stu-rev-appInst")
	public ResponseEntity<?> removeFileofStuRevAppInst(@PathVariable long SsrId) {
		boolean success = ssrService.deleteDocumentOfStuRevAppInst(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/document-stu-outgoing-instructional/{SsrId}")
	public ResponseEntity<String> uploadDocumentStuOutgoingInstructional(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfStuOutgoingInstructional(SsrId, pdf);
		String fieldName = "stuOutgoingInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/document-stu-outgoing-instructional")
	public ResponseEntity<?> removeFileofStuOutgoingInstructional(@PathVariable long SsrId) {
		boolean success = ssrService.deleteDocumentOfStuOutgoingInstructional(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/acad-courses-in-all-progs-inst-data-doc/{SsrId}")
	public ResponseEntity<String> uploadDocumentAcadCoursesInAllProgsInst(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfAcadCoursesInAllProgsInst(SsrId, pdf);
		String fieldName = "acadCoursesInAllProgsInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/acad-courses-in-all-progs-inst-data-doc")
	public ResponseEntity<?> removeFileofAcadCoursesInAllProgsInst(@PathVariable long SsrId) {
		boolean success = ssrService.deleteDocumentOfAcadCoursesInAllProgsInst(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/acad-full-time-teach-inst/{SsrId}")
	public ResponseEntity<String> uploadDocumentAcadFullTimeTeachInst(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfAcadFullTimeTeachInst(SsrId, pdf);
		String fieldName = "acadFullTimeTeachInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/acad-full-time-teach-inst")
	public ResponseEntity<?> removeFileofAcadFullTimeTeachInst(@PathVariable long SsrId) {
		boolean success = ssrService.deleteDocumentOfAcadFullTimeTeachInst(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/acad-sanctioned-posts-inst/{SsrId}")
	public ResponseEntity<String> uploadDocumentAcadSanctionedPostsInst(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfAcadSanctionedPostsInst(SsrId, pdf);
		String fieldName = "acadSanctionedPostsInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/acad-sanctioned-posts-inst")
	public ResponseEntity<?> removeFileofAcadSanctionedPostsInst(@PathVariable long SsrId) {
		boolean success = ssrService.deleteDocumentOfAcadSanctionedPostsInst(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/addm-appli-recevied-inst/{SsrId}")
	public ResponseEntity<String> uploadDocumentAddmAppliReceviedInst(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfAddmAppliReceviedInst(SsrId, pdf);
		String fieldName = "addmAppliReceviedInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/addm-appli-recevied-inst")
	public ResponseEntity<?> removeFileofAddmAppliReceviedInst(@PathVariable long SsrId) {
		boolean success = ssrService.deleteDocumentOfAddmAppliReceviedInst(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/addm-reserved-seats-inst/{SsrId}")
	public ResponseEntity<String> uploadDocumentReservedSeatsInst(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfAddmReservedSeatsInst(SsrId, pdf);
		String fieldName = "addmReservedSeatsInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/addm-reserved-seats-inst")
	public ResponseEntity<?> removeFileofReservedSeatsInst(@PathVariable long SsrId) {
		boolean success = ssrService.deleteDocumentOfAddmReservedSeatsInst(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PostMapping("/expenditure-without-salary-inst/{SsrId}")
	public ResponseEntity<String> uploadDocumentExpenditureWithoutSalaryInst(@PathVariable("SsrId") long SsrId,
			@RequestParam("pdf") MultipartFile pdf) {

		boolean isDocumentSaved = ssrService.saveDocumentOfExpenditureWithoutSalaryInst(SsrId, pdf);
		String fieldName = "expenditureWithoutSalaryInstDataDoc";
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(ExtendedProfileSSR.class, SsrId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PostMapping("{SsrId}/expenditure-without-salary-inst")
	public ResponseEntity<?> removeFileofExpenditureWithoutSalaryInst(@PathVariable long SsrId) {
		boolean success = ssrService.deleteExpenditureWithoutSalaryInst(SsrId);
		if (success) {
			return ResponseEntity.status(200).body("Deleted Successfully");
		} else {
			return ResponseEntity.status(400).body("something went wrong try again");
		}
	}

	@PutMapping("/qif/new-qif")
	public ResponseEntity<?> createQIF(@ModelAttribute Qif qif) {
		String saveQif = ssrService.qifCreation(qif);

		if ("Saved".equals(saveQif)) {
			return ResponseEntity.status(201).body("Saved Successfully");
		} else if ("EX".equals(saveQif)) {
			return ResponseEntity.status(403).body("Already Exists");
		} else {
			return ResponseEntity.status(400).body("Something went wrong, try again");
		}
	}

	@GetMapping("/qif/{collegeId}")
	public ResponseEntity<?> findQifByCollegeId(@PathVariable long collegeId) {
		Qif foundQif = ssrService.findQifbyCollegeId(collegeId);
		if (foundQif != null) {
			return ResponseEntity.status(200).body(foundQif);
		}
		return ResponseEntity.status(400).body("something went wrong try again");
	}

	@PutMapping("/qif/{qifId}/doc")
	public ResponseEntity<?> saveFileofC1(@PathVariable long qifId, @RequestParam("name") String name,
			@RequestParam("pdf") MultipartFile pdf) {
		boolean isDocumentSaved = ssrService.saveDocuments_C1(qifId, pdf, name);
		String fieldName = name;
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(Qif.class, qifId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PutMapping("/qif/doc/{qifId}")
	public ResponseEntity<?> deleteDoc_C1(@PathVariable long qifId, @RequestParam("name") String name) {
		boolean success = ssrService.deleteDocuments_C1(qifId, name);

		if (success) {
			return ResponseEntity.status(200).body("deleted Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@PutMapping("/qif/data-c1/{qifId}")
	public ResponseEntity<?> criteriaOne(@PathVariable long qifId, @ModelAttribute Qif qif) {
		Qif saveQif = ssrService.save_C1(qifId, qif);

		if (saveQif != null) {
			return ResponseEntity.status(200).body("Saved Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

//	criteria 2 apis
	@PutMapping("/qif/data-c2/{collegId}")
	public ResponseEntity<?> criteriaTwo(@PathVariable long collegId, @ModelAttribute CriteriaII criteriaII) {
		CriteriaII SavedC2 = ssrService.save_C2(collegId, criteriaII);
		if (SavedC2 != null) {
			return ResponseEntity.status(200).body("Saved Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@GetMapping("/qif/data-c2/{collegeId}")
	public ResponseEntity<?> criteriaTwo(@PathVariable long collegeId) {
		CriteriaII foundC2 = ssrService.findByCollegeId(collegeId);
		if (foundC2 != null) {
			return ResponseEntity.status(200).body(foundC2);
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");
	}

	@PutMapping("/crite-2/{criteriaId}/doc")
	public ResponseEntity<?> saveFileofC2(@PathVariable long criteriaId, @RequestParam("name") String name,
			@RequestParam("pdf") MultipartFile pdf) {
		boolean isDocumentSaved = ssrService.saveDocuments_C2(criteriaId, pdf, name);
		String fieldName = name;
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(CriteriaII.class, criteriaId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PutMapping("/qif/doc-c2/{criteriaId}")
	public ResponseEntity<?> deleteDoc_C2(@PathVariable long criteriaId, @RequestParam("name") String name) {
		boolean success = ssrService.deleteDocuments_C2(criteriaId, name);

		if (success) {
			return ResponseEntity.status(200).body("deleted Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@GetMapping("/qif/data-c3/{collegeId}")
	public ResponseEntity<?> criteriaThree(@PathVariable long collegeId) {
		CriteriaIII foundC3 = ssrService.findC3ByCollegeId(collegeId);
		if (foundC3 != null) {
			return ResponseEntity.status(200).body(foundC3);
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@PutMapping("/qif/data-c3/{qifId}")
	public ResponseEntity<?> criteriaThre(@PathVariable long qifId, @ModelAttribute CriteriaIII criteriaIII) {
		CriteriaIII SavedC3 = ssrService.save_C3(qifId, criteriaIII);
		if (SavedC3 != null) {
			return ResponseEntity.status(200).body("Saved Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@PutMapping("/crite-3/{criteriaId}/doc")
	public ResponseEntity<?> saveFileofC3(@PathVariable long criteriaId, @RequestParam("name") String name,
			@RequestParam("pdf") MultipartFile pdf) {
		boolean isDocumentSaved = ssrService.saveDocuments_C3(criteriaId, pdf, name);
		String fieldName = name;
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(CriteriaIII.class, criteriaId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PutMapping("/qif/doc-c3/{criteriaId}")
	public ResponseEntity<?> deleteDoc_C3(@PathVariable long criteriaId, @RequestParam("name") String name) {
		boolean success = ssrService.deleteDocuments_C3(criteriaId, name);

		if (success) {
			return ResponseEntity.status(200).body("deleted Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@GetMapping("/qif/data-c4/{collegeId}")
	public ResponseEntity<?> criteriaFour(@PathVariable long collegeId) {
		CriteriaIV foundC4 = ssrService.findC4ByCollegeId(collegeId);
		if (foundC4 != null) {
			return ResponseEntity.status(200).body(foundC4);
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@PutMapping("/qif/data-c4/{qifId}")
	public ResponseEntity<?> criteriaFour(@PathVariable long qifId, @ModelAttribute CriteriaIV criteriaIV) {
		CriteriaIV SavedC4 = ssrService.save_C4(qifId, criteriaIV);
		if (SavedC4 != null) {
			return ResponseEntity.status(200).body("Saved Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@PutMapping("/crite-4/{criteriaId}/doc")
	public ResponseEntity<?> saveFileofC4(@PathVariable long criteriaId, @RequestParam("name") String name,
			@RequestParam("pdf") MultipartFile pdf) {
		boolean isDocumentSaved = ssrService.saveDocuments_C4(criteriaId, pdf, name);
		String fieldName = name;
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(CriteriaIV.class, criteriaId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PutMapping("/qif/doc-c4/{criteriaId}")
	public ResponseEntity<?> deleteDoc_C4(@PathVariable long criteriaId, @RequestParam("name") String name) {
		boolean success = ssrService.deleteDocuments_C3(criteriaId, name);

		if (success) {
			return ResponseEntity.status(200).body("deleted Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@GetMapping("/qif/data-c5/{collegeId}")
	public ResponseEntity<?> criteriaFive(@PathVariable long collegeId) {
		CriteriaV foundC5 = ssrService.findC5ByCollegeId(collegeId);
		if (foundC5 != null) {
			return ResponseEntity.status(200).body(foundC5);
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");
	}

	@PutMapping("/qif/data-c5/{qifId}")
	public ResponseEntity<?> criteriaFive(@PathVariable long qifId, @ModelAttribute CriteriaV criteriaV) {
		CriteriaV SavedC5 = ssrService.save_C5(qifId, criteriaV);
		if (SavedC5 != null) {
			return ResponseEntity.status(200).body("Saved Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@PutMapping("/crite-5/{criteriaId}/doc")
	public ResponseEntity<?> saveFileofC5(@PathVariable long criteriaId, @RequestParam("name") String name,
			@RequestParam("pdf") MultipartFile pdf) {
		boolean isDocumentSaved = ssrService.saveDocuments_C5(criteriaId, pdf, name);
		String fieldName = name;
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(CriteriaV.class, criteriaId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PutMapping("/qif/doc-c5/{criteriaId}")
	public ResponseEntity<?> deleteDoc_C5(@PathVariable long criteriaId, @RequestParam("name") String name) {
		boolean success = ssrService.deleteDocuments_C5(criteriaId, name);

		if (success) {
			return ResponseEntity.status(200).body("deleted Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@GetMapping("/qif/data-c6/{collegeId}")
	public ResponseEntity<?> criteriaSix(@PathVariable long collegeId) {
		CriteriaVI foundC6 = ssrService.findC6ByCollegeId(collegeId);
		if (foundC6 != null) {
			return ResponseEntity.status(200).body(foundC6);
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");
	}

	@PutMapping("/qif/data-c6/{qifId}")
	public ResponseEntity<?> criteriaSix(@PathVariable long qifId, @ModelAttribute CriteriaVI criteriaVI) {
		CriteriaVI SavedC6 = ssrService.save_C6(qifId, criteriaVI);
		if (SavedC6 != null) {
			return ResponseEntity.status(200).body("Saved Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@PutMapping("/crite-6/{criteriaId}/doc")
	public ResponseEntity<?> saveFileofC6(@PathVariable long criteriaId, @RequestParam("name") String name,
			@RequestParam("pdf") MultipartFile pdf) {
		boolean isDocumentSaved = ssrService.saveDocuments_C6(criteriaId, pdf, name);
		String fieldName = name;
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(CriteriaVI.class, criteriaId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PutMapping("/qif/doc-c6/{criteriaId}")
	public ResponseEntity<?> deleteDoc_C6(@PathVariable long criteriaId, @RequestParam("name") String name) {
		boolean success = ssrService.deleteDocuments_C6(criteriaId, name);

		if (success) {
			return ResponseEntity.status(200).body("deleted Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@GetMapping("/qif/data-c7/{collegeId}")
	public ResponseEntity<?> criteriaSeven(@PathVariable long collegeId) {
		CriteriaVII foundC7 = ssrService.findC7ByCollegeId(collegeId);
		if (foundC7 != null) {
			return ResponseEntity.status(200).body(foundC7);
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");
	}

	@PutMapping("/qif/data-c7/{qifId}")
	public ResponseEntity<?> criteriaSeven(@PathVariable long qifId, @ModelAttribute CriteriaVII criteriaVII) {
		CriteriaVII SavedC7 = ssrService.save_C7(qifId, criteriaVII);
		if (SavedC7 != null) {
			return ResponseEntity.status(200).body("Saved Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

	@PutMapping("/crite-7/{criteriaId}/doc")
	public ResponseEntity<?> saveFileofC7(@PathVariable long criteriaId, @RequestParam("name") String name,
			@RequestParam("pdf") MultipartFile pdf) {
		boolean isDocumentSaved = ssrService.saveDocuments_C7(criteriaId, pdf, name);
		String fieldName = name;
		if (isDocumentSaved) {
			String documentName = fileService.waitUntilDocumentNameIsSet(CriteriaVII.class, criteriaId, fieldName);
			return ResponseEntity.ok(documentName);
		} else {
			return ResponseEntity.badRequest().body("Failed to save document");
		}
	}

	@PutMapping("/qif/doc-c7/{criteriaId}")
	public ResponseEntity<?> deleteDoc_C7(@PathVariable long criteriaId, @RequestParam("name") String name) {
		boolean success = ssrService.deleteDocuments_C7(criteriaId, name);

		if (success) {
			return ResponseEntity.status(200).body("deleted Successfully");
		}
		return ResponseEntity.status(400).body("Something went wrong, try again");

	}

}
