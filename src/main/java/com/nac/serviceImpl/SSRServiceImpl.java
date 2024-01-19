package com.nac.serviceImpl;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.nac.model.SSR.Staff;
import com.nac.model.SSR.StaffDetails;
import com.nac.model.SSR.StudentDetailsCurrentYear;
import com.nac.model.SSR.StudentDetailsLastFourYears;
import com.nac.model.IIQA.UniversityRecoginsed;
import com.nac.model.SSR.CriteriaII;
import com.nac.model.SSR.CriteriaIII;
import com.nac.model.SSR.CriteriaIV;
import com.nac.model.SSR.CriteriaV;
import com.nac.model.SSR.CriteriaVI;
import com.nac.model.SSR.CriteriaVII;
import com.nac.model.SSR.ExtendedProfileSSR;
import com.nac.model.SSR.Qif;
import com.nac.model.SSR.SSR;
import com.nac.repository.ssr.StaffRepo;
import com.nac.repository.ssr.StudentDetailsCurrentYearRepo;
import com.nac.repository.ssr.StudentDetailsLastFourYearsRepo;
import com.nac.repository.ssr.CriteriaIIIRepo;
import com.nac.repository.ssr.CriteriaIIRepo;
import com.nac.repository.ssr.CriteriaIVRepo;
import com.nac.repository.ssr.CriteriaVIIRepo;
import com.nac.repository.ssr.CriteriaVIRepo;
import com.nac.repository.ssr.CriteriaVRepo;
import com.nac.repository.ssr.ExtendedProfileSSRRepo;
import com.nac.repository.ssr.QifRepository;
import com.nac.repository.ssr.SSRRepo;
import com.nac.repository.ssr.StaffDetailsRepo;
import com.nac.service.SSRService;
import com.nac.util.FileUpload;

@Service
public class SSRServiceImpl implements SSRService {

	@Autowired
	StaffRepo staffRepo;
	@Autowired
	SSRRepo ssrRepo;
	@Autowired
	StaffDetailsRepo staffDetailRepo;
	@Autowired
	StudentDetailsCurrentYearRepo studentRepo;
	@Autowired
	StudentDetailsLastFourYearsRepo stdDetailsRepoFourYearRepo;
	@Autowired
	ExtendedProfileSSRRepo extendedSSRRepo;
	@Autowired
	QifRepository qifRepo;
	@Autowired
	CriteriaIIRepo c2_repo;
	@Autowired
	CriteriaIIIRepo c3_repo;
	@Autowired
	CriteriaIVRepo c4_repo;
	@Autowired
	CriteriaVRepo c5_repo;
	@Autowired
	CriteriaVIRepo c6_repo;
	@Autowired
	CriteriaVIIRepo c7_repo;
	@Autowired
	FileUpload fileService;

	public SSR getSSRbyID(long id) {
		return ssrRepo.getById(id);
	}

	public SSR getSSRbyClgID(long id) {
		return ssrRepo.findSSRbycollegeID(id);
	}

	public SSR basicInformation(SSR ssr, long clgID) {
		SSR sr = ssrRepo.findSSRbycollegeID(clgID);
		if (sr != null) {
			sr.setByGender(ssr.getByGender());
			sr.setByShift(ssr.getByShift());
			sr.setRecognizedMinorityInstitution(ssr.getRecognizedMinorityInstitution());
			sr.setMinorityByReligious(ssr.getMinorityByReligious());
			sr.setMinorityByLinguistic(ssr.getMinorityByLinguistic());
			sr.setMinorityByOther(ssr.getMinorityByOther());
			sr.setIsAutonomyGranted(ssr.getIsAutonomyGranted());
			sr.setIsAutonomyGrantedDocumnet(ssr.getIsAutonomyGrantedDocumnet());
			sr.setCollegeAutonomousApplicationStatus(ssr.getCollegeAutonomousApplicationStatus());
			sr.setIsCollegeRecognizedByGovtAgency(ssr.getIsCollegeRecognizedByGovtAgency());
			sr.setRecognizedAgencyName(ssr.getRecognizedAgencyName());
			sr.setDateOfRecognisation(ssr.getDateOfRecognisation());
			sr.setCampusLocation(ssr.getCampusLocation());
			sr.setCampusAreaInAcres(ssr.getCampusAreaInAcres());
			sr.setBuiltUpAreaInSqMt(ssr.getBuiltUpAreaInSqMt());
			sr.setRemarks(ssr.getRemarks());
			SSR savedSSR = ssrRepo.save(sr);
			if (savedSSR != null) {
				return savedSSR;
			}
		}

		return null;
	}

	@Override
	public boolean removeDocumentOfMinority(long clgId) {
		SSR ssr = getSSRbyClgID(clgId);
		if (ssr != null) {
			String docName = ssr.getDocumentOFMinorityInstitution();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				ssr.setDocumentOFMinorityInstitution("");
				ssrRepo.save(ssr);
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

	@Override
	public boolean saveDocumentOfMinority(long clgId, MultipartFile pdf) {

		try {
			SSR ssr = getSSRbyClgID(clgId);
			if (ssr != null) {
				String fileName = fileService.uploadFile(pdf);
				ssr.setDocumentOFMinorityInstitution(fileName);
				ssrRepo.save(ssr);
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
	public boolean saveDocumentOfAutonomus(long clgId, MultipartFile pdf) {

		try {
			SSR ssr = getSSRbyClgID(clgId);
			if (ssr != null) {
				String fileName = fileService.uploadFile(pdf);
				ssr.setIsAutonomyGrantedDocumnet(fileName);
				ssrRepo.save(ssr);
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
	public boolean removeDocumentOfAutonomus(long clgId) {
		SSR ssr = getSSRbyClgID(clgId);
		if (ssr != null) {
			String docName = ssr.getIsAutonomyGrantedDocumnet();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				ssr.setIsAutonomyGrantedDocumnet("");
				ssrRepo.save(ssr);
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

	@Override
	public Staff saveStaff(Staff staff) {
		Staff savedStaff = staffRepo.save(staff);
		if (savedStaff != null) {
			return savedStaff;
		}
		return null;
	}

	@Override
	public List<Staff> getAllStaffBySSRId(long ssrId) {
		List<Staff> staffs = staffRepo.findStaffBySsrID(ssrId);
		if (staffs != null) {
			return staffs;
		}
		return null;
	}

	@Override
	public Staff saveStaff(Staff staff, long staffId) {
		Staff newStaff = staffRepo.findById(staffId).get();
		newStaff.setFacultyType(staff.getFacultyType());
		newStaff.setStaffType(staff.getStaffType());
		newStaff.setRecruitedFemale(staff.getRecruitedFemale());
		newStaff.setTotalStaff(staff.getTotalStaff());
		newStaff.setRecruitedMale(staff.getRecruitedMale());
		newStaff.setRecruitedOther(staff.getRecruitedOther());
		newStaff.setSanctionedBy(staff.getSanctionedBy());
		newStaff.setYetToRecruited(staff.getYetToRecruited());
		Staff savedStaff = staffRepo.save(newStaff);
		if (savedStaff != null) {
			return savedStaff;
		}
		return null;
	}

	@Override
	public Staff saveGuestStaff(Staff staff) {
		Staff saveGuestStaff = staffRepo.save(staff);
		if (saveGuestStaff != null) {
			return saveGuestStaff;
		}
		return null;
	}

	@Override
	public Staff updateGuestStaff(long staffId, Staff staff) {
		Staff existingGuestStaff = staffRepo.findById(staffId).get();
		if (existingGuestStaff != null) {
			Staff saveGuestStaff = staffRepo.save(staff);
			if (saveGuestStaff != null) {
				return saveGuestStaff;
			}
		}
		return null;
	}

	@Override
	public StaffDetails saveStaffDetails(StaffDetails staffDetails) {
		StaffDetails savedStaffDetails = staffDetailRepo.save(staffDetails);
		if (savedStaffDetails != null) {
			return savedStaffDetails;
		}
		return null;
	}

	@Override
	public List<StaffDetails> getAllStaffDetailsBySSRId(long ssrId) {
		List<StaffDetails> staffDetails = staffDetailRepo.findStaffDetailsBySsrID(ssrId);
		if (staffDetails != null) {
			return staffDetails;
		}
		return null;
	}

	@Override
	public StaffDetails saveStaffDetails(StaffDetails staff, long staffDetailsId) {
		StaffDetails newStaffDetails = staffDetailRepo.findById(staffDetailsId).get();
		newStaffDetails.setFacultyType(staff.getFacultyType());
		newStaffDetails.setTeacherType(staff.getTeacherType());
		newStaffDetails.setQualifications(staff.getQualifications());
		newStaffDetails.setMaleTeacher(staff.getMaleTeacher());
		newStaffDetails.setFemaleTeacher(staff.getFemaleTeacher());
		newStaffDetails.setOtherTeacher(staff.getOtherTeacher());
		newStaffDetails.setTotalTeacher(staff.getTotalTeacher());
		StaffDetails savedStaffDetails = staffDetailRepo.save(newStaffDetails);
		if (savedStaffDetails != null) {
			return savedStaffDetails;
		}
		return null;
	}

	@Override
	public StudentDetailsCurrentYear saveStudentDetailsCurrentYear(
			StudentDetailsCurrentYear studentDetailsCurrentYear) {
		StudentDetailsCurrentYear savedStudentDetails = studentRepo.save(studentDetailsCurrentYear);
		if (savedStudentDetails != null) {
			return savedStudentDetails;
		}
		return null;
	}

	@Override
	public List<StudentDetailsCurrentYear> getAllStudentDetailsCurrentYearBySSRId(long ssrId) {
		List<StudentDetailsCurrentYear> studentDetails = studentRepo.findStudentDetailsCurrentYearBySsrID(ssrId);
		if (studentDetails != null) {
			return studentDetails;
		}
		return null;
	}

	@Override
	public StudentDetailsCurrentYear updateStudentDetailsCurrentYear(StudentDetailsCurrentYear studentDetails,
			long studentDetailsId) {
		StudentDetailsCurrentYear newStudentDetails = studentRepo.findById(studentDetailsId).get();
		newStudentDetails.setProgram(studentDetails.getProgram());
		newStudentDetails.setGender(studentDetails.getGender());
		newStudentDetails.setFromState(studentDetails.getFromState());
		newStudentDetails.setFromOther(studentDetails.getFromOther());
		newStudentDetails.setNriStudent(studentDetails.getNriStudent());
		newStudentDetails.setForeignStudent(studentDetails.getForeignStudent());
		newStudentDetails.setTotal(studentDetails.getTotal());
		StudentDetailsCurrentYear savedStudentDetails = studentRepo.save(newStudentDetails);
		if (savedStudentDetails != null) {
			return savedStudentDetails;
		}
		return null;
	}

	@Override
	public StudentDetailsLastFourYears saveStudentDetailsLastFourYears(
			StudentDetailsLastFourYears studentDetailsLastFourYears) {
		StudentDetailsLastFourYears savedStudentDetails = stdDetailsRepoFourYearRepo.save(studentDetailsLastFourYears);
		if (savedStudentDetails != null) {
			return savedStudentDetails;
		}
		return null;
	}

	@Override
	public List<StudentDetailsLastFourYears> getAllStudentDetailsLastFourYearsBySSRId(long ssrId) {
		List<StudentDetailsLastFourYears> studentDetails = stdDetailsRepoFourYearRepo
				.findStudentDetailsLastFourYearsBySsrID(ssrId);
		if (studentDetails != null) {
			return studentDetails;
		}
		return null;
	}

	@Override
	public StudentDetailsLastFourYears saveStudentDetailsCurrentYear(StudentDetailsLastFourYears studentDetails,
			long studentDetailsId) {
		StudentDetailsLastFourYears newStudentDetails = stdDetailsRepoFourYearRepo.findById(studentDetailsId).get();
		newStudentDetails.setCategory(studentDetails.getCategory());
		newStudentDetails.setGender(studentDetails.getGender());
		newStudentDetails.setYear1(studentDetails.getYear1());
		newStudentDetails.setYear2(studentDetails.getYear2());
		newStudentDetails.setYear3(studentDetails.getYear3());
		newStudentDetails.setYear4(studentDetails.getYear4());
		newStudentDetails.setTotal1(studentDetails.getTotal1());
		newStudentDetails.setTotal2(studentDetails.getTotal2());
		newStudentDetails.setTotal3(studentDetails.getTotal3());
		newStudentDetails.setTotal4(studentDetails.getTotal4());
		StudentDetailsLastFourYears savedStudentDetails = stdDetailsRepoFourYearRepo.save(newStudentDetails);
		if (savedStudentDetails != null) {
			return savedStudentDetails;
		}
		return null;
	}

	@Override
	public StudentDetailsLastFourYears detailsOfStudentsEnrolled(StudentDetailsLastFourYears stdDetails) {
		StudentDetailsLastFourYears saveDeatils = stdDetailsRepoFourYearRepo.save(stdDetails);
		if (saveDeatils != null) {
			return saveDeatils;
		}
		return null;
	}

	@Override
	public StudentDetailsLastFourYears updatedDetailsOfStudentsEnrolled(long stdLFYId,
			StudentDetailsLastFourYears stdDetails) {
		StudentDetailsLastFourYears existingDetails = stdDetailsRepoFourYearRepo.findById(stdLFYId).get();
		if (existingDetails != null) {
			existingDetails.setSelfFinancedPrograms(stdDetails.getSelfFinancedPrograms());
			existingDetails.setNewProgramsIntroduced(stdDetails.getNewProgramsIntroduced());
			existingDetails.setUnitCostofEducation(stdDetails.getUnitCostofEducation());
			existingDetails.setIncludingSalary(stdDetails.getIncludingSalary());
			existingDetails.setExcludingSalary(stdDetails.getExcludingSalary());
			StudentDetailsLastFourYears saveDetails = stdDetailsRepoFourYearRepo.save(existingDetails);
			if (saveDetails != null) {
				return saveDetails;
			}
		}
		return null;
	}

	@Override
	public SSR getSSRbyCollegeID(long clgId) {
		SSR ssr = ssrRepo.findSSRbycollegeID(clgId);
		if (ssr != null) {
			return ssr;
		}
		return null;
	}

	@Override
	public String academicComplete(ExtendedProfileSSR exSsr) {
		long id = exSsr.getCollegeId();
		ExtendedProfileSSR existing_ExtendedSSR = extendedSSRRepo.findByCollegeId(id);

		if (existing_ExtendedSSR == null) {
			ExtendedProfileSSR tableCreated = extendedSSRRepo.save(exSsr);
			if (tableCreated != null) {
				return "Saved";
			} else {

				return "ER";
			}
		} else {

			return "Exists";
		}
	}

	// extended SSR
	@Override
	public ExtendedProfileSSR saveExtendedSSR(ExtendedProfileSSR extendedSsr, long ssrId) {
		ExtendedProfileSSR existingExtendedSsr = extendedSSRRepo.findBySsrId(ssrId);
		BeanUtils.copyProperties(extendedSsr, existingExtendedSsr, getNullPropertyNames(extendedSsr));
		ExtendedProfileSSR newExtendedSsr = extendedSSRRepo.save(extendedSsr);
		if (newExtendedSsr != null) {
			return newExtendedSsr;
		}
		return null;
	}

	@Override
	public ExtendedProfileSSR updateExtendedSSR(long extendedProfileSSRId, ExtendedProfileSSR updatedExtendedSsr) {
		ExtendedProfileSSR existingExtendedSsr = extendedSSRRepo.getById(extendedProfileSSRId);

		if (existingExtendedSsr != null) {
			// Copy non-null properties from updatedExtendedSsr to existingExtendedSsr
			BeanUtils.copyProperties(updatedExtendedSsr, existingExtendedSsr, getNullPropertyNames(updatedExtendedSsr));
			// Save the updated entity
			existingExtendedSsr.setSsrID(updatedExtendedSsr.getSsrID());
			existingExtendedSsr.setCollegeId(updatedExtendedSsr.getCollegeId());
			ExtendedProfileSSR savedExtendedSsr = extendedSSRRepo.save(existingExtendedSsr);

			return savedExtendedSsr;
		}

		return null; // or throw an exception, depending on your business logic
	}

	String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<>();
		for (PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null && isExcludedField(pd.getName()))
				emptyNames.add(pd.getName());
		}

		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	boolean isExcludedField(String fieldName) {
		// List of field names to exclude from updates
		Set<String> excludedFields = new HashSet<>(
				Arrays.asList("CriteriaII_Id", "CriteriaVII_Id", "CriteriaIII_Id", "ssrID", "collegeID", "qifId"));
		return excludedFields.stream().anyMatch(excluded -> excluded.equalsIgnoreCase(fieldName));
	}

	@Override
	public ExtendedProfileSSR findExtendedSSrById(long collegeId) {
		ExtendedProfileSSR existingExtendedSSR = extendedSSRRepo.findByCollegeId(collegeId);
		if (existingExtendedSSR != null) {
			return existingExtendedSSR;
		}
		return null;
	}

	@Override
	public boolean deleteDocumentOfProgramInstructional(long SsrId) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// if (extendedSsr != null) {
		// String docName = extendedSsr.getProgramCourseInstDataDoc();
		// boolean success = fileService.deleteFileByName(docName);
		// if (success) {
		// extendedSsr.setProgramCourseInstDataDoc("");
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// } else {
		// return false;
		// }
		//
		// }
		return false;

	}

	@Override
	public boolean saveDocumentOfStudentInstructional(long SsrId, MultipartFile pdf) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setStudentInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDocumentOfStudentInstructional(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String docName = extendedSsr.getStudentInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setStudentInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	@Override
	public boolean saveDocumentOfStuAppearedInstructional(long SsrId, MultipartFile pdf) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// if (extendedSsr != null) {
		// String fileName = fileService.uploadFile(pdf);
		// extendedSsr.setStuAppearedInstDataDoc(fileName);
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// }
		return false;
	}

	@Override
	public boolean deleteDocumentOfStuAppearedInstructional(long SsrId) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// if (extendedSsr != null) {
		// String docName = extendedSsr.getStuAppearedInstDataDoc();
		// boolean success = fileService.deleteFileByName(docName);
		// if (success) {
		// extendedSsr.setStuAppearedInstDataDoc("");
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// } else {
		// return false;
		// }
		//
		// }
		return false;

	}

	@Override
	public boolean saveDocumentOfStuRevAppInst(long SsrId, MultipartFile pdf) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// ;
		// if (extendedSsr != null) {
		// String fileName = fileService.uploadFile(pdf);
		// extendedSsr.setStuRevalApplicationsInstDataDoc(fileName);
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// }
		return false;
	}

	@Override
	public boolean deleteDocumentOfStuRevAppInst(long SsrId) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// ;
		// if (extendedSsr != null) {
		// String docName = extendedSsr.getStuRevalApplicationsInstDataDoc();
		// boolean success = fileService.deleteFileByName(docName);
		// if (success) {
		// extendedSsr.setStuRevalApplicationsInstDataDoc("");
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// } else {
		// return false;
		// }
		//
		// }
		return false;

	}

	@Override
	public boolean saveDocumentOfStuOutgoingInstructional(long SsrId, MultipartFile pdf) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setStuOutgoingInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDocumentOfStuOutgoingInstructional(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String docName = extendedSsr.getStuOutgoingInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setStuOutgoingInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	@Override
	public boolean saveDocumentOfAcadCoursesInAllProgsInst(long SsrId, MultipartFile pdf) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// if (extendedSsr != null) {
		// String fileName = fileService.uploadFile(pdf);
		// extendedSsr.setAcadCoursesInAllProgsInstDataDoc(fileName);
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// }
		return false;
	}

	@Override
	public boolean deleteDocumentOfAcadCoursesInAllProgsInst(long SsrId) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// if (extendedSsr != null) {
		// String docName = extendedSsr.getAcadCoursesInAllProgsInstDataDoc();
		// boolean success = fileService.deleteFileByName(docName);
		// if (success) {
		// extendedSsr.setAcadCoursesInAllProgsInstDataDoc("");
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// } else {
		// return false;
		// }
		//
		// }
		return false;

	}

	@Override
	public boolean saveDocumentOfAcadFullTimeTeachInst(long SsrId, MultipartFile pdf) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setAcadFullTimeTeachInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDocumentOfAcadFullTimeTeachInst(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String docName = extendedSsr.getAcadFullTimeTeachInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setAcadFullTimeTeachInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	@Override
	public boolean saveDocumentOfAcadSanctionedPostsInst(long SsrId, MultipartFile pdf) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setAcadSanctionedPostsInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDocumentOfAcadSanctionedPostsInst(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String docName = extendedSsr.getAcadSanctionedPostsInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setAcadSanctionedPostsInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	@Override
	public boolean saveDocumentOfAddmAppliReceviedInst(long SsrId, MultipartFile pdf) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// if (extendedSsr != null) {
		// String fileName = fileService.uploadFile(pdf);
		// extendedSsr.setAddmAppliReceviedInstDataDoc(fileName);
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// }
		return false;
	}

	@Override
	public boolean deleteDocumentOfAddmAppliReceviedInst(long SsrId) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// if (extendedSsr != null) {
		// String docName = extendedSsr.getAddmAppliReceviedInstDataDoc();
		// boolean success = fileService.deleteFileByName(docName);
		// if (success) {
		// extendedSsr.setAddmAppliReceviedInstDataDoc("");
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// } else {
		// return false;
		// }
		//
		// }
		return false;

	}

	@Override
	public boolean saveDocumentOfAddmReservedSeatsInst(long SsrId, MultipartFile pdf) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// if (extendedSsr != null) {
		// String fileName = fileService.uploadFile(pdf);
		// extendedSsr.setAddmReservedSeatsInstDataDoc(fileName);
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// }
		return false;
	}

	@Override
	public boolean deleteDocumentOfAddmReservedSeatsInst(long SsrId) {
		// ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		// if (extendedSsr != null) {
		// String docName = extendedSsr.getAddmReservedSeatsInstDataDoc();
		// boolean success = fileService.deleteFileByName(docName);
		// if (success) {
		// extendedSsr.setAddmReservedSeatsInstDataDoc("");
		// extendedSSRRepo.save(extendedSsr);
		// return true;
		// } else {
		// return false;
		// }
		//
		// }
		return false;

	}

	@Override
	public boolean saveDocumentOfExpenditureWithoutSalaryInst(long SsrId, MultipartFile pdf) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setExpenditureWithoutSalaryInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteExpenditureWithoutSalaryInst(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String docName = extendedSsr.getExpenditureWithoutSalaryInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setExpenditureWithoutSalaryInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	@Override
	public String qifCreation(Qif qif) {
		long id = qif.getCollegeID();
		Qif existingQif = qifRepo.findQifbycollegeID(id);

		creationOfCriterias(id);

		if (existingQif == null) {
			Qif newQif = qifRepo.save(qif);
			if (newQif != null) {
				return "Saved";
			} else {
				return "ER";
			}
		} else {
			return "EX";
		}
	}

	public boolean creationOfCriterias(long collegeId) {
		Qif existingQif = qifRepo.findQifbycollegeID(collegeId);

		if (existingQif == null) {
			return false;
		}

		try {
			CriteriaII newC2 = c2_repo.findCriteriaBycollegeID(collegeId);
			if (newC2 == null) {
				newC2 = new CriteriaII();
				newC2.setCollegeID(collegeId);
				newC2.setSsrID(existingQif.getSsrID());
				newC2.setQifId(existingQif.getQifID());
				c2_repo.save(newC2);
			}

			CriteriaIII newC3 = c3_repo.findCriteriaBycollegeID(collegeId);
			if (newC3 == null) {
				newC3 = new CriteriaIII();
				newC3.setCollegeID(collegeId);
				newC3.setSsrID(existingQif.getSsrID());
				newC3.setQifId(existingQif.getQifID());
				c3_repo.save(newC3);
			}
			CriteriaIV newC4 = c4_repo.findCriteriaBycollegeID(collegeId);
			if (newC4 == null) {
				newC4 = new CriteriaIV();
				newC4.setCollegeID(collegeId);
				newC4.setSsrID(existingQif.getSsrID());
				newC4.setQifId(existingQif.getQifID());
				c4_repo.save(newC4);
			}
			CriteriaV newC5 = c5_repo.findCriteriaBycollegeID(collegeId);
			if (newC5 == null) {
				newC5 = new CriteriaV();
				newC5.setCollegeID(collegeId);
				newC5.setSsrID(existingQif.getSsrID());
				newC5.setQifId(existingQif.getQifID());
				c5_repo.save(newC5);
			}
			CriteriaVI newC6 = c6_repo.findCriteriaBycollegeID(collegeId);
			if (newC6 == null) {
				newC6 = new CriteriaVI();
				newC6.setCollegeID(collegeId);
				newC6.setSsrID(existingQif.getSsrID());
				newC6.setQifId(existingQif.getQifID());
				c6_repo.save(newC6);
			}
			CriteriaVII newC7 = c7_repo.findCriteriaBycollegeID(collegeId);
			if (newC7 == null) {
				newC7 = new CriteriaVII();
				newC7.setCollegeID(collegeId);
				newC7.setSsrID(existingQif.getSsrID());
				newC7.setQifId(existingQif.getQifID());
				c7_repo.save(newC7);
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// QIF

	@Override
	public Qif findQifbyCollegeId(long collegeId) {
		Qif existingQif = qifRepo.findQifbycollegeID(collegeId);
		if (existingQif != null) {
			return existingQif;
		}
		return null;
	}

	@Override
	public boolean saveDocuments_C1(long qifId, MultipartFile pdf, String name) {
		Qif existingQif = qifRepo.findById(qifId).get();
		String fileName = "";
		if (existingQif != null) {
			switch (name) {
				case "uploadAdditionalInfoDoc":
					fileName = fileService.uploadFile(pdf);
					existingQif.setUploadAdditionalInfoDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "uploadAdditionalInfoDoc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setUploadAdditionalInfoDoc2(fileName);
					qifRepo.save(existingQif);
					return true;
				case "institutionalDataFormatDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInstDataFormatDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "instWebDisclosureDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInstWebDisclosureDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "bosMeetingMinutesDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setBosMeetingMinutesDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "academicCouncilEndorDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setAcademicCouncilEndorDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "linkForAnyReleventDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setLinkForAnyReleventDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "additionalInfoDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setAdditionalInfoDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "institutionalWebsiteInfoDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInstitutionalWebsiteInfoDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "programBrochureNoticeDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setProgramBrochureNoticeDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "studentsAttendanceListDOC":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setStudentsAttendanceListDOC(fileName);
					qifRepo.save(existingQif);
					return true;
				case "courseCompletionEvidenceDOC":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setStudentsAttendanceListDOC(fileName);
					qifRepo.save(existingQif);
					return true;
				case "institutionalDataFormatDOC":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInstitutionalDataFormatDOC(fileName);
					qifRepo.save(existingQif);
					return true;

				case "institutionalDataFormatDoc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInstitutionalDataFormatDoc2(fileName);
					qifRepo.save(existingQif);
					return true;
				case "progContWithBOSProjDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setProgContWithBOSProjDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "InternCompleLetterDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInternCompleLetterDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "EvaluatedProjReportDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setEvaluatedProjReportDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "institutionalDataFormatDoc3":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInstitutionalDataFormatDoc3(fileName);
					qifRepo.save(existingQif);
					return true;
				case "feedFormDiffStakeHoldersDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setFeedFormDiffStakeHoldersDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "feedbackAnalysisReportDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setFeedbackAnalysisReportDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				case "actionTakenReportDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setFeedbackAnalysisReportDoc(fileName);
					qifRepo.save(existingQif);
					return true;
				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public boolean deleteDocuments_C1(long qifId, String name) {
		Qif existingQif = qifRepo.findById(qifId).get();

		String fileName = "";
		boolean success;
		if (existingQif != null) {
			switch (name) {
				case "uploadAdditionalInfoDoc":
					fileName = existingQif.getUploadAdditionalInfoDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setUploadAdditionalInfoDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "uploadAdditionalInfoDoc2":
					fileName = existingQif.getUploadAdditionalInfoDoc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setUploadAdditionalInfoDoc2("");
						qifRepo.save(existingQif);
						return true;
					}
				case "institutionalDataFormatDoc":
					fileName = existingQif.getInstDataFormatDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setInstDataFormatDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "instWebDisclosureDoc":
					fileName = existingQif.getInstWebDisclosureDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setInstWebDisclosureDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "bosMeetingMinutesDoc":
					fileName = existingQif.getBosMeetingMinutesDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setBosMeetingMinutesDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "academicCouncilEndorDoc":
					fileName = existingQif.getAcademicCouncilEndorDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setAcademicCouncilEndorDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "linkForAnyReleventDoc":
					fileName = existingQif.getLinkForAnyReleventDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setLinkForAnyReleventDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "additionalInfoDoc":
					fileName = existingQif.getAdditionalInfoDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setAdditionalInfoDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "institutionalWebsiteInfoDoc":
					fileName = existingQif.getInstitutionalWebsiteInfoDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setInstitutionalWebsiteInfoDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "programBrochureNoticeDoc":
					fileName = existingQif.getProgramBrochureNoticeDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setProgramBrochureNoticeDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "studentsAttendanceListDOC":
					fileName = existingQif.getStudentsAttendanceListDOC();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setStudentsAttendanceListDOC("");
						qifRepo.save(existingQif);
						return true;
					}
				case "courseCompletionEvidenceDOC":
					fileName = existingQif.getCourseCompletionEvidenceDOC();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setCourseCompletionEvidenceDOC("");
						qifRepo.save(existingQif);
						return true;
					}
				case "institutionalDataFormatDOC":
					fileName = existingQif.getInstitutionalDataFormatDOC();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setInstitutionalDataFormatDOC("");
						qifRepo.save(existingQif);
						return true;
					}
				case "progContWithBOSProjDoc":
					fileName = existingQif.getProgContWithBOSProjDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setProgContWithBOSProjDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "InternCompleLetterDoc":
					fileName = existingQif.getInternCompleLetterDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setInternCompleLetterDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "EvaluatedProjReportDoc":
					fileName = existingQif.getEvaluatedProjReportDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setEvaluatedProjReportDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "institutionalDataFormatDoc3":
					fileName = existingQif.getInstitutionalDataFormatDoc3();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setInstitutionalDataFormatDoc3("");
						qifRepo.save(existingQif);
						return true;
					}
				case "feedFormDiffStakeHoldersDoc":
					fileName = existingQif.getFeedFormDiffStakeHoldersDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setFeedFormDiffStakeHoldersDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "feedbackAnalysisReportDoc":
					fileName = existingQif.getFeedbackAnalysisReportDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setFeedbackAnalysisReportDoc("");
						qifRepo.save(existingQif);
						return true;
					}
				case "actionTakenReportDoc":
					fileName = existingQif.getActionTakenReportDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setActionTakenReportDoc("");
						qifRepo.save(existingQif);
						return true;
					}

				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public Qif save_C1(long qifId, Qif qif) {
		Qif existingQif = qifRepo.findById(qifId).get();
		if (existingQif != null) {
			// Copy non-null properties from updatedExtendedSsr to existingExtendedSsr
			BeanUtils.copyProperties(qif, existingQif, getNullPropertyNames(qif));
			// Save the updated entity
			Qif savedQif = qifRepo.save(existingQif);
			if (savedQif != null) {

				return savedQif;
			}

		}
		return null;
	}

	@Override
	public CriteriaII save_C2(long collegeId, CriteriaII criteriaII) {
		CriteriaII existingC2 = c2_repo.findCriteriaBycollegeID(collegeId);
		if (existingC2 != null) {

			// Copy non-null properties from updatedExtendedSsr to existingExtendedSsr
			BeanUtils.copyProperties(criteriaII, existingC2, getNullPropertyNames(criteriaII));
			// Save the updated entity
			CriteriaII savedC2 = c2_repo.save(existingC2);
			if (savedC2 != null) {

				return savedC2;
			}
		}
		return null;
	}

	@Override
	public CriteriaII findByCollegeId(long id) {
		CriteriaII foundC2 = c2_repo.findCriteriaBycollegeID(id);
		if (foundC2 != null) {
			return foundC2;
		}
		return null;
	}

	@Override
	public boolean saveDocuments_C2(long criteriaId, MultipartFile pdf, String name) {
		CriteriaII existingCriteriaII = c2_repo.findById(criteriaId).get();
		String fileName = "";
		if (existingCriteriaII != null) {
			switch (name) {
				case "institutionalDataTemplate_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setInstiPresDataTemplate_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "instDataTemplate_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setInstDataTemplate_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "intakeSanctionApproval_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setIntakeSanctionApproval_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "finalAdmissionList_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setFinalAdmissionList_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "finalAdmissionList_doc2":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setFinalAdmissionList_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "instDataTemplate_doc2":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setInstDataTemplate_doc2(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "govtLetter_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setGovtLetter_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "finalAdmiList_Doc60":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setFinalAdmiList_Doc60(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_Doc80":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_Doc80(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_doc86":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_doc86(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_Doc2":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_Doc2(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "listOfActvMentor_Doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setListOfActvMentor_Doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "sanctionedPostsMap_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setSanctionedPostsMap_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "instDataTemplate_doc3":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setInstDataTemplate_doc3(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_doc3":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_doc3(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "instDataTemplate_doc5":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setInstDataTemplate_doc5(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "dataTemp_Doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setDataTemp_Doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_doc4":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_doc4(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "cosForAllCoursesDoc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setCosForAllCoursesDoc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_doc5":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_doc5(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "dataTemplate_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setDataTemplate_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "coeReportPassPercentage_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setCoeReportPassPercentage_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "coePassPercentReport_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setCoePassPercentReport_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalIfoDoc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setCoePassPercentReport_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "currentlyEnrolledStudDoc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setCoePassPercentReport_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;

				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public boolean deleteDocuments_C2(long criteriaId, String name) {
		CriteriaII existingCriteriaII = c2_repo.findById(criteriaId).get();
		String fileName = "";
		boolean success;
		if (existingCriteriaII != null) {
			switch (name) {
				case "institutionalDataTemplate_doc":
					fileName = existingCriteriaII.getInstiPresDataTemplate_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setInstiPresDataTemplate_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "instDataTemplate_doc":
					fileName = existingCriteriaII.getInstDataTemplate_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setInstDataTemplate_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "intakeSanctionApproval_doc":
					fileName = existingCriteriaII.getIntakeSanctionApproval_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setIntakeSanctionApproval_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "finalAdmissionList_doc":
					fileName = existingCriteriaII.getFinalAdmissionList_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setFinalAdmissionList_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "finalAdmissionList_doc2":
					fileName = existingCriteriaII.getFinalAdmissionList_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setFinalAdmissionList_doc2("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "instDataTemplate_doc2":
					fileName = existingCriteriaII.getInstDataTemplate_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setInstDataTemplate_doc2("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "govtLetter_doc":
					fileName = existingCriteriaII.getGovtLetter_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setGovtLetter_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "finalAdmiList_Doc60":
					fileName = existingCriteriaII.getFinalAdmiList_Doc60();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setFinalAdmiList_Doc60("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "additionalInfo_doc":
					fileName = existingCriteriaII.getAdditionalInfo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setAdditionalInfo_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "additionalInfo_Doc":
					fileName = existingCriteriaII.getAdditionalInfo_Doc80();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setAdditionalInfo_Doc80("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "additionalInfo_doc86":
					fileName = existingCriteriaII.getAdditionalInfo_doc86();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setAdditionalInfo_doc86("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "additionalInfo_Doc2":
					fileName = existingCriteriaII.getAdditionalInfo_Doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setAdditionalInfo_Doc2("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "listOfActvMentor_Doc":
					fileName = existingCriteriaII.getListOfActvMentor_Doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setListOfActvMentor_Doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "sanctionedPostsMap_doc":
					fileName = existingCriteriaII.getSanctionedPostsMap_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setSanctionedPostsMap_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "instDataTemplate_doc3":
					fileName = existingCriteriaII.getInstDataTemplate_doc3();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setInstDataTemplate_doc3("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "additionalInfo_doc3":
					fileName = existingCriteriaII.getAdditionalInfo_doc3();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setAdditionalInfo_doc3("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "instDataTemplate_doc5":
					fileName = existingCriteriaII.getInstDataTemplate_doc5();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setInstDataTemplate_doc5("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "dataTemp_Doc":
					fileName = existingCriteriaII.getDataTemp_Doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setDataTemp_Doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "additionalInfo_doc4":
					fileName = existingCriteriaII.getAdditionalInfo_doc4();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setAdditionalInfo_doc4("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "cosForAllCoursesDoc":
					fileName = existingCriteriaII.getCosForAllCoursesDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setCosForAllCoursesDoc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "additionalInfo_doc5":
					fileName = existingCriteriaII.getAdditionalInfo_doc5();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setAdditionalInfo_doc5("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "dataTemplate_doc":
					fileName = existingCriteriaII.getDataTemplate_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setDataTemplate_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "coeReportPassPercentage_doc":
					fileName = existingCriteriaII.getCoeReportPassPercentage_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setCoeReportPassPercentage_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "coePassPercentReport_doc":
					fileName = existingCriteriaII.getCoePassPercentReport_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setCoePassPercentReport_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "additionalIfoDoc":
					fileName = existingCriteriaII.getAdditionalIfoDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setAdditionalIfoDoc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "currentlyEnrolledStudDoc":
					fileName = existingCriteriaII.getCurrentlyEnrolledStudDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setCurrentlyEnrolledStudDoc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}

				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public CriteriaIII save_C3(long collegeId, CriteriaIII criteriaII) {
		CriteriaIII existingCriteriaIII = c3_repo.findCriteriaBycollegeID(collegeId);
		if (existingCriteriaIII != null) {
			// Copy non-null properties from updatedExtendedSsr to existingExtendedSsr
			BeanUtils.copyProperties(criteriaII, existingCriteriaIII, getNullPropertyNames(criteriaII));
			// Save the updated entity
			CriteriaIII savedCriteriaIII = c3_repo.save(existingCriteriaIII);
			if (savedCriteriaIII != null) {

				return savedCriteriaIII;
			}

		}
		return null;
	}

	@Override
	public CriteriaIII findC3ByCollegeId(long id) {
		CriteriaIII criteriaIII = c3_repo.findCriteriaBycollegeID(id);
		if (criteriaIII != null) {
			return criteriaIII;
		}
		return null;
	}

	@Override
	public boolean saveDocuments_C3(long criteriaId, MultipartFile pdf, String name) {
		CriteriaIII existingCriteriaIII = c3_repo.findById(criteriaId).get();
		String fileName = "";
		if (existingCriteriaIII != null) {
			switch (name) {
				case "additionalInfoDoc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setAdditionalInforDoc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "supportingDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setSupportingDoc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "institDataTempDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitDataTempDoc2(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "institDataTemp_Doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitDataTemp_Doc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "instDataTemplate_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstDataTemplate_doc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "supporting_doc91":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setSupporting_doc91(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "institutionalDataTemplateDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitutionalDataTemplateDoc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "additionalInfo_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setAdditionalInfo_doc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "institutionalDataFormat_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitutionalDataFormat_doc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "supporting_doc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setSupporting_doc32(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "institutionalDataFormat_doc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitutionalDataFormat_doc2(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;

				case "institutionalDataFormat_doc3":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitutionalDataFormat_doc3(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;

				case "institDataFormat_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitDataFormat_doc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "institDataFormat_doc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitDataFormat_doc2(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;

				case "instDataTempDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstDataTempDoc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "instDataTempDoc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstDataTempDoc2(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "addInfo_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setAddInfo_doc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "addInfo_doc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setAddInfo_doc2(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "institutionalDataFormat_doc5":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitutionalDataFormat_doc5(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "institutionalDataFormat_doc4":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitutionalDataFormat_doc4(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public boolean deleteDocuments_C3(long criteriaId, String name) {
		CriteriaIII existingCriteriaIII = c3_repo.findById(criteriaId).get();
		String fileName = "";
		boolean success;
		if (existingCriteriaIII != null) {
			switch (name) {
				case "additionalInfoDoc":
					fileName = existingCriteriaIII.getAdditionalInforDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setAdditionalInforDoc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "supportingDoc":
					fileName = existingCriteriaIII.getSupportingDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setSupportingDoc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institDataTempDoc":
					fileName = existingCriteriaIII.getInstitDataTempDoc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitDataTempDoc2("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institDataTemp_Doc":
					fileName = existingCriteriaIII.getInstitDataTemp_Doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitDataTemp_Doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "instDataTemplate_doc":
					fileName = existingCriteriaIII.getInstDataTemplate_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstDataTemplate_doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "supporting_doc91":
					fileName = existingCriteriaIII.getSupporting_doc91();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setSupporting_doc91("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institutionalDataTemplateDoc":
					fileName = existingCriteriaIII.getInstitutionalDataTemplateDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitutionalDataTemplateDoc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "additionalInfo_doc":
					fileName = existingCriteriaIII.getAdditionalInfo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setAdditionalInfo_doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institutionalDataFormat_doc":
					fileName = existingCriteriaIII.getInstitutionalDataFormat_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitutionalDataFormat_doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "supporting_doc2":
					fileName = existingCriteriaIII.getSupporting_doc32();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setSupporting_doc32("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institutionalDataFormat_doc2":
					fileName = existingCriteriaIII.getInstitutionalDataFormat_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitutionalDataFormat_doc2("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institutionalDataFormat_doc3":
					fileName = existingCriteriaIII.getInstitutionalDataFormat_doc3();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitutionalDataFormat_doc3("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institDataFormat_doc":
					fileName = existingCriteriaIII.getInstitDataFormat_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitDataFormat_doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institDataFormat_doc2":
					fileName = existingCriteriaIII.getInstitDataFormat_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitDataFormat_doc2("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "instDataTempDoc":
					fileName = existingCriteriaIII.getInstDataTempDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstDataTempDoc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "instDataTempDoc2":
					fileName = existingCriteriaIII.getInstDataTempDoc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstDataTempDoc2("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "addInfo_doc":
					fileName = existingCriteriaIII.getAddInfo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setAddInfo_doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "addInfo_doc2":
					fileName = existingCriteriaIII.getAddInfo_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setAddInfo_doc2("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institutionalDataFormat_doc5":
					fileName = existingCriteriaIII.getInstitutionalDataFormat_doc5();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitutionalDataFormat_doc5("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institutionalDataFormat_doc4":
					fileName = existingCriteriaIII.getInstitutionalDataFormat_doc4();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitutionalDataFormat_doc4("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public CriteriaIV findC4ByCollegeId(long id) {
		CriteriaIV criteriaIV = c4_repo.findCriteriaBycollegeID(id);
		if (criteriaIV != null) {
			return criteriaIV;
		}
		return null;
	}

	@Override
	public CriteriaIV save_C4(long collegeId, CriteriaIV criteriaIV) {
		CriteriaIV existingCriteriaIV = c4_repo.findCriteriaBycollegeID(collegeId);
		if (existingCriteriaIV != null) {
			// Copy non-null properties from updatedExtendedSsr to existingExtendedSsr
			BeanUtils.copyProperties(criteriaIV, existingCriteriaIV, getNullPropertyNames(criteriaIV));
			// Save the updated entity
			CriteriaIV savedCriteriaIV = c4_repo.save(existingCriteriaIV);
			if (savedCriteriaIV != null) {

				return savedCriteriaIV;
			}

		}
		return null;
	}

	@Override
	public boolean saveDocuments_C4(long criteriaId, MultipartFile pdf, String name) {
		CriteriaIV existingCriteriaIV = c4_repo.findById(criteriaId).get();
		String fileName = "";
		if (existingCriteriaIV != null) {
			switch (name) {
				case "addInfo_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setAddInfo_doc(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "institutionalDataTemplate_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setInstitutionalDataTemplate_doc(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "AudRep_incomExpendiState_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setAudRep_incomExpendiState_doc(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "addInfo_doc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setAddInfo_doc2(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "relevantDOc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setRelevantDOc(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "addInfo_doc8":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setAddInfo_doc8(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "addInfo_doc3":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setAddInfo_doc3(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "StockRegistryExtractor_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setStockRegistryExtractor_doc(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "numCompPurchased_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setNumCompPurchased_doc(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "prescribedformatDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setPrescribedformatDoc(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "addInfo_doc4":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setAddInfo_doc4(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				case "addInfo_doc5":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setAddInfo_doc5(fileName);
					c4_repo.save(existingCriteriaIV);
					return true;
				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public boolean deleteDocuments_C4(long criteriaId, String name) {
		CriteriaIV existingCriteriaIV = c4_repo.findById(criteriaId).get();
		String fileName = "";
		boolean success;
		if (existingCriteriaIV != null) {
			switch (name) {
				case "addInfo_doc":
					fileName = existingCriteriaIV.getAddInfo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setAddInfo_doc("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "institutionalDataTemplate_doc":
					fileName = existingCriteriaIV.getInstitutionalDataTemplate_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setInstitutionalDataTemplate_doc("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "AudRep_incomExpendiState_doc":
					fileName = existingCriteriaIV.getAudRep_incomExpendiState_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setAudRep_incomExpendiState_doc("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "addInfo_doc2":
					fileName = existingCriteriaIV.getAddInfo_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setAddInfo_doc2("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "relevantDOc":
					fileName = existingCriteriaIV.getRelevantDOc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setRelevantDOc("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "addInfo_doc8":
					fileName = existingCriteriaIV.getAddInfo_doc8();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setAddInfo_doc8("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "addInfo_doc3":
					fileName = existingCriteriaIV.getAddInfo_doc3();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setAddInfo_doc3("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "StockRegistryExtractor_doc":
					fileName = existingCriteriaIV.getStockRegistryExtractor_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setStockRegistryExtractor_doc("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "numCompPurchased_doc":
					fileName = existingCriteriaIV.getNumCompPurchased_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setNumCompPurchased_doc("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "prescribedformatDoc":
					fileName = existingCriteriaIV.getPrescribedformatDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setPrescribedformatDoc("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "addInfo_doc4":
					fileName = existingCriteriaIV.getAddInfo_doc4();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setAddInfo_doc4("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}
				case "addInfo_doc5":
					fileName = existingCriteriaIV.getAddInfo_doc5();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIV.setAddInfo_doc4("");
						c4_repo.save(existingCriteriaIV);
						return true;
					}

				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public CriteriaV findC5ByCollegeId(long id) {
		CriteriaV criteriaV = c5_repo.findCriteriaBycollegeID(id);
		if (criteriaV != null) {
			return criteriaV;
		}
		return null;
	}

	@Override
	public CriteriaV save_C5(long collegeId, CriteriaV criteriaV) {
		CriteriaV existingCriteriaV = c5_repo.findCriteriaBycollegeID(collegeId);
		if (existingCriteriaV != null) {
			// Copy non-null properties from updatedExtendedSsr to existingExtendedSsr
			BeanUtils.copyProperties(criteriaV, existingCriteriaV, getNullPropertyNames(criteriaV));
			// Save the updated entity
			CriteriaV savedCriteriaV = c5_repo.save(existingCriteriaV);
			if (savedCriteriaV != null) {

				return savedCriteriaV;
			}

		}
		return null;
	}

	@Override
	public boolean saveDocuments_C5(long criteriaId, MultipartFile pdf, String name) {
		CriteriaV existingCriteriaV = c5_repo.findById(criteriaId).get();
		String fileName = "";
		if (existingCriteriaV != null) {
			switch (name) {
				case "institutionalDataTemplate_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setInstitutionalDataTemplate_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "addInfoDoc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setAddInfoDoc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "prescribedDataDoc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setPrescribedDataDoc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "prescribedDataDoc2":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setPrescribedDataDoc2(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "institutionalDataTemplate_doc4":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setInstitutionalDataTemplate_doc4(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "placementInfoList_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setPlacementInfoList_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "institutionalDataTemplate_doc5":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setInstitutionalDataTemplate_doc5(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "institutionalDataTemplate_doc6":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setInstitutionalDataTemplate_doc6(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "addInfoDo2":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setAddInfoDo2(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "addInfoDo3":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setAddInfoDo3(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "HEI_Annual_Audit_AlumniDoc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setHEI_Annual_Audit_AlumniDoc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "alumni_contributionsDoc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setAlumni_contributionsDoc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "addInfo_doc8":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setAddInfo_doc8(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				
				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public boolean deleteDocuments_C5(long criteriaId, String name) {
		CriteriaV existingCriteriaV = c5_repo.findById(criteriaId).get();
		String fileName = "";
		boolean success;
		if (existingCriteriaV != null) {
			switch (name) {
				case "institutionalDataTemplate_doc":
					fileName = existingCriteriaV.getInstitutionalDataTemplate_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setInstitutionalDataTemplate_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "addInfoDoc":
					fileName = existingCriteriaV.getAddInfoDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setAddInfoDoc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "prescribedDataDoc":
					fileName = existingCriteriaV.getPrescribedDataDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setPrescribedDataDoc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "prescribedDataDoc2":
					fileName = existingCriteriaV.getPrescribedDataDoc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setPrescribedDataDoc2("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "institutionalDataTemplate_doc4":
					fileName = existingCriteriaV.getInstitutionalDataTemplate_doc4();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setInstitutionalDataTemplate_doc4("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "placementInfoList_doc":
					fileName = existingCriteriaV.getPlacementInfoList_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setPlacementInfoList_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "institutionalDataTemplate_doc5":
					fileName = existingCriteriaV.getInstitutionalDataTemplate_doc5();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setInstitutionalDataTemplate_doc5("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "institutionalDataTemplate_doc6":
					fileName = existingCriteriaV.getInstitutionalDataTemplate_doc6();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setInstitutionalDataTemplate_doc6("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "addInfoDo2":
					fileName = existingCriteriaV.getAddInfoDo2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setAddInfoDo2("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "addInfoDo3":
					fileName = existingCriteriaV.getAddInfoDo3();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setAddInfoDo3("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "HEI_Annual_Audit_AlumniDoc":
					fileName = existingCriteriaV.getHEI_Annual_Audit_AlumniDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setHEI_Annual_Audit_AlumniDoc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "alumni_contributionsDoc":
					fileName = existingCriteriaV.getAlumni_contributionsDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setAlumni_contributionsDoc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "addInfo_doc8":
					fileName = existingCriteriaV.getAddInfo_doc8();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setAddInfo_doc8("");
						c5_repo.save(existingCriteriaV);
						return true;
					}

				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public CriteriaVI findC6ByCollegeId(long id) {
		CriteriaVI criteriaVI = c6_repo.findCriteriaBycollegeID(id);
		if (criteriaVI != null) {
			return criteriaVI;
		}
		return null;
	}

	@Override
	public CriteriaVI save_C6(long collegeId, CriteriaVI criteriaVI) {
		CriteriaVI existingCriteriaVI = c6_repo.findCriteriaBycollegeID(collegeId);
		if (existingCriteriaVI != null) {
			// Copy non-null properties from updatedExtendedSsr to existingExtendedSsr
			BeanUtils.copyProperties(criteriaVI, existingCriteriaVI, getNullPropertyNames(criteriaVI));
			// Save the updated entity
			CriteriaVI savedCriteriaVI = c6_repo.save(existingCriteriaVI);
			if (savedCriteriaVI != null) {

				return savedCriteriaVI;
			}

		}
		return null;
	}

	@Override
	public boolean saveDocuments_C6(long criteriaId, MultipartFile pdf, String name) {
		CriteriaVI existingCriteriaVI = c6_repo.findById(criteriaId).get();
		String fileName = "";
		if (existingCriteriaVI != null) {
			switch (name) {
				case "addInfo_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setAddInfo_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "webDocsPlan_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setWebDocsPlan_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "addInfo_doc2":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setAddInfo_doc2(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "egovImplementation_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setEgovImplementation_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "iegErpExpStatements_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setIegErpExpStatements_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "egovReportApprovalPolicy_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setEgovReportApprovalPolicy_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "addInfo_doc3":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setAddInfo_doc3(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "instDataTemplate_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setInstDataTemplate_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "teacherSupportPolicy_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setTeacherSupportPolicy_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "financialAssistanceHead_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setFinancialAssistanceHead_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "instDataTemplate_doc2":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setInstDataTemplate_doc2(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "facultyTrainingEvents_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setFacultyTrainingEvents_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "certificatesList_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setCertificatesList_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "teacherProgramReports_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setTeacherProgramReports_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "addInfo_doc4":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setAddInfo_doc4(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "addInfo_doc5":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setAddInfo_doc5(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "followUpActions_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setFollowUpActions_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "qaReportCertValid_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setQaReportCertValid_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				case "CollabQualityInitData_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVI.setCollabQualityInitData_doc(fileName);
					c6_repo.save(existingCriteriaVI);
					return true;
				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public boolean deleteDocuments_C6(long criteriaId, String name) {
		CriteriaVI existingCriteriaVI = c6_repo.findById(criteriaId).get();
		String fileName = "";
		boolean success;
		if (existingCriteriaVI != null) {
			switch (name) {
				case "addInfo_doc":
					fileName = existingCriteriaVI.getAddInfo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setAddInfo_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "webDocsPlan_doc":
					fileName = existingCriteriaVI.getWebDocsPlan_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setWebDocsPlan_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "addInfo_doc2":
					fileName = existingCriteriaVI.getAddInfo_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setAddInfo_doc2("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "egovImplementation_doc":
					fileName = existingCriteriaVI.getEgovImplementation_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setEgovImplementation_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "iegErpExpStatements_doc":
					fileName = existingCriteriaVI.getIegErpExpStatements_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setIegErpExpStatements_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "egovReportApprovalPolicy_doc":
					fileName = existingCriteriaVI.getEgovReportApprovalPolicy_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setEgovReportApprovalPolicy_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "addInfo_doc3":
					fileName = existingCriteriaVI.getAddInfo_doc3();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setAddInfo_doc3("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "instDataTemplate_doc":
					fileName = existingCriteriaVI.getInstDataTemplate_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setInstDataTemplate_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "teacherSupportPolicy_doc":
					fileName = existingCriteriaVI.getTeacherSupportPolicy_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setTeacherSupportPolicy_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "financialAssistanceHead_doc":
					fileName = existingCriteriaVI.getFinancialAssistanceHead_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setFinancialAssistanceHead_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "instDataTemplate_doc2":
					fileName = existingCriteriaVI.getInstDataTemplate_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setInstDataTemplate_doc2("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "facultyTrainingEvents_doc":
					fileName = existingCriteriaVI.getFacultyTrainingEvents_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setFacultyTrainingEvents_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "certificatesList_doc":
					fileName = existingCriteriaVI.getCertificatesList_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setCertificatesList_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "teacherProgramReports_doc":
					fileName = existingCriteriaVI.getTeacherProgramReports_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setTeacherProgramReports_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "addInfo_doc4":
					fileName = existingCriteriaVI.getAddInfo_doc4();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setAddInfo_doc4("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "addInfo_doc5":
					fileName = existingCriteriaVI.getAddInfo_doc5();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setAddInfo_doc5("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "followUpActions_doc":
					fileName = existingCriteriaVI.getFollowUpActions_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setFollowUpActions_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "qaReportCertValid_doc":
					fileName = existingCriteriaVI.getQaReportCertValid_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setQaReportCertValid_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				case "CollabQualityInitData_doc":
					fileName = existingCriteriaVI.getCollabQualityInitData_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVI.setCollabQualityInitData_doc("");
						c6_repo.save(existingCriteriaVI);
						return true;
					}
				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	// ---------------------------------------------------------------------------------------

	@Override
	public CriteriaVII findC7ByCollegeId(long id) {
		CriteriaVII criteriaVII = c7_repo.findCriteriaBycollegeID(id);
		if (criteriaVII != null) {
			return criteriaVII;
		}
		return null;
	}

	@Override
	public CriteriaVII save_C7(long collegeId, CriteriaVII criteriaVII) {
		CriteriaVII existingCriteriaVII = c7_repo.findCriteriaBycollegeID(collegeId);
		if (existingCriteriaVII != null) {
			// Copy non-null properties from updatedExtendedSsr to existingExtendedSsr
			BeanUtils.copyProperties(criteriaVII, existingCriteriaVII, getNullPropertyNames(criteriaVII));
			// Save the updated entity
			CriteriaVII savedCriteriaVII = c7_repo.save(existingCriteriaVII);
			if (savedCriteriaVII != null) {

				return savedCriteriaVII;
			}

		}
		return null;
	}

	@Override
	public boolean saveDocuments_C7(long criteriaId, MultipartFile pdf, String name) {
		CriteriaVII existingCriteriaVII = c7_repo.findById(criteriaId).get();
		String fileName = "";
		if (existingCriteriaVII != null) {
			switch (name) {
				case "addInfo_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setAddInfo_doc(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;
				case "pfcPolicy_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setPfcPolicy_doc(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;
				case "equipPurchaseBills_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setEquipPurchaseBills_doc(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;
				case "facilityMediaGeo_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setFacilityMediaGeo_doc(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;
				case "cirActReports_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setCirActReports_doc(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;
				case "instDataTemplate_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setInstDataTemplate_doc(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;
				case "EnvEnergyCertPolicy_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setEnvEnergyCertPolicy_doc(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;
				case "awardsCertiFormRecogAgncy_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setAwardsCertiFormRecogAgncy_doc(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;
				case "envPromoSustActGeoPhotos_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setEnvPromoSustActGeoPhotos_doc(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;
				case "envAudRepFormRecogAgncy_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setEnvAudRepFormRecogAgncy_doc(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;
				case "addInfo_doc2":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaVII.setAddInfo_doc2(fileName);
					c7_repo.save(existingCriteriaVII);
					return true;

				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

	@Override
	public boolean deleteDocuments_C7(long criteriaId, String name) {
		CriteriaVII existingCriteriaVII = c7_repo.findById(criteriaId).get();
		String fileName = "";
		boolean success;
		if (existingCriteriaVII != null) {
			switch (name) {
				case "addInfo_doc":
					fileName = existingCriteriaVII.getAddInfo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setAddInfo_doc("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				case "pfcPolicy_doc":
					fileName = existingCriteriaVII.getPfcPolicy_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setPfcPolicy_doc("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				case "equipPurchaseBills_doc":
					fileName = existingCriteriaVII.getEquipPurchaseBills_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setAddInfo_doc2("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				case "facilityMediaGeo_doc":
					fileName = existingCriteriaVII.getFacilityMediaGeo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setFacilityMediaGeo_doc("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				case "cirActReports_doc":
					fileName = existingCriteriaVII.getCirActReports_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setCirActReports_doc("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				case "instDataTemplate_doc":
					fileName = existingCriteriaVII.getInstDataTemplate_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setInstDataTemplate_doc("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				case "EnvEnergyCertPolicy_doc":
					fileName = existingCriteriaVII.getEnvEnergyCertPolicy_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setEnvEnergyCertPolicy_doc("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				case "awardsCertiFormRecogAgncy_doc":
					fileName = existingCriteriaVII.getAwardsCertiFormRecogAgncy_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setAwardsCertiFormRecogAgncy_doc("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				case "envPromoSustActGeoPhotos_doc":
					fileName = existingCriteriaVII.getEnvPromoSustActGeoPhotos_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setEnvPromoSustActGeoPhotos_doc("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				case "envAudRepFormRecogAgncy_doc":
					fileName = existingCriteriaVII.getEnvAudRepFormRecogAgncy_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setEnvAudRepFormRecogAgncy_doc("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				case "addInfo_doc2":
					fileName = existingCriteriaVII.getAddInfo_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaVII.setAddInfo_doc2("");
						c7_repo.save(existingCriteriaVII);
						return true;
					}
				default:
					// Handle unexpected name
					break;
			}
		}
		return false;
	}

}
