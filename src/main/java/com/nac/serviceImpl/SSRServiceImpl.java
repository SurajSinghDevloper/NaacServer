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
				Arrays.asList("CriteriaII_Id","CriteriaVII_Id", "CriteriaIII_Id", "ssrID", "collegeID", "qifId"));
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
	public boolean saveDocumentOfProgramInstructional(long SsrId, MultipartFile pdf) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setProgramCourseInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDocumentOfProgramInstructional(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String docName = extendedSsr.getProgramCourseInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setProgramCourseInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
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
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setStuAppearedInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDocumentOfStuAppearedInstructional(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String docName = extendedSsr.getStuAppearedInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setStuAppearedInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	@Override
	public boolean saveDocumentOfStuRevAppInst(long SsrId, MultipartFile pdf) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		;
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setStuRevalApplicationsInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDocumentOfStuRevAppInst(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		;
		if (extendedSsr != null) {
			String docName = extendedSsr.getStuRevalApplicationsInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setStuRevalApplicationsInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
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
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setAcadCoursesInAllProgsInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDocumentOfAcadCoursesInAllProgsInst(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String docName = extendedSsr.getAcadCoursesInAllProgsInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setAcadCoursesInAllProgsInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
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
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setAddmAppliReceviedInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDocumentOfAddmAppliReceviedInst(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String docName = extendedSsr.getAddmAppliReceviedInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setAddmAppliReceviedInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	@Override
	public boolean saveDocumentOfAddmReservedSeatsInst(long SsrId, MultipartFile pdf) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String fileName = fileService.uploadFile(pdf);
			extendedSsr.setAddmReservedSeatsInstDataDoc(fileName);
			extendedSSRRepo.save(extendedSsr);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDocumentOfAddmReservedSeatsInst(long SsrId) {
		ExtendedProfileSSR extendedSsr = extendedSSRRepo.findById(SsrId).get();
		if (extendedSsr != null) {
			String docName = extendedSsr.getAddmReservedSeatsInstDataDoc();
			boolean success = fileService.deleteFileByName(docName);
			if (success) {
				extendedSsr.setAddmReservedSeatsInstDataDoc("");
				extendedSSRRepo.save(extendedSsr);
				return true;
			} else {
				return false;
			}

		}
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
				case "documents_CA":
					fileName = fileService.uploadFile(pdf);
					existingQif.setDocuments_CA(fileName);
					qifRepo.save(existingQif);
					return true;
				case "institutionalDataFormatDocs_AF":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInstitutionalDataFormatDocs_AF(fileName);
					qifRepo.save(existingQif);
					return true;
				case "programBrochureDoc_AF":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setProgramBrochureDoc_AF(fileName);
					qifRepo.save(existingQif);
					return true;
				case "studentAttendanceList_AF":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setStudentAttendanceList_AF(fileName);
					qifRepo.save(existingQif);
					return true;
				case "courseCompletionEvidenceDoc_AF":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setCourseCompletionEvidenceDoc_AF(fileName);
					qifRepo.save(existingQif);
					return true;
				case "institutionalDataFormatDoc_AF":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInstitutionalDataFormatDoc_AF(fileName);
					qifRepo.save(existingQif);
					return true;
				case "supportingDoc_AF":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setSupportingDoc_AF(fileName);
					qifRepo.save(existingQif);
					return true;
				case "supportingDoc_CE":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setSupportingDoc_CE(fileName);
					qifRepo.save(existingQif);
					return true;
				case "institutionalDataFormatDoc_CE":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInstitutionalDataFormatDoc_CE(fileName);
					qifRepo.save(existingQif);
					return true;
				case "supportingDocs_CE":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setSupportingDocs_CE(fileName);
					qifRepo.save(existingQif);
					return true;
				case "instiDataFormatDoc_FS":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setInstiDataFormatDoc_FS(fileName);
					qifRepo.save(existingQif);
					return true;
				case "feedbackFormsFromStakeholdersDoc_FS":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setFeedbackFormsFromStakeholdersDoc_FS(fileName);
					qifRepo.save(existingQif);
					return true;
				case "feedbackAnalysisReprtSubmDoc_FS":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setFeedbackAnalysisReprtSubmDoc_FS(fileName);
					qifRepo.save(existingQif);
					return true;
				case "feedbackActionReportDoc_FS":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingQif.setFeedbackActionReportDoc_FS(fileName);
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
		;
		String fileName = "";
		boolean success;
		if (existingQif != null) {
			switch (name) {
				case "documents_CA":
					fileName = existingQif.getDocuments_CA();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setDocuments_CA("");
						qifRepo.save(existingQif);
						return true;
					}
				case "institutionalDataFormatDocs_AF":
					fileName = existingQif.getInstitutionalDataFormatDocs_AF();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setInstitutionalDataFormatDocs_AF("");
						qifRepo.save(existingQif);
						return true;
					}
				case "programBrochureDoc_AF":
					fileName = existingQif.getProgramBrochureDoc_AF();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setProgramBrochureDoc_AF("");
						qifRepo.save(existingQif);
						return true;
					}
				case "studentAttendanceList_AF":
					fileName = existingQif.getStudentAttendanceList_AF();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setStudentAttendanceList_AF("");
						qifRepo.save(existingQif);
						return true;
					}
				case "courseCompletionEvidenceDoc_AF":
					fileName = existingQif.getCourseCompletionEvidenceDoc_AF();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setCourseCompletionEvidenceDoc_AF("");
						qifRepo.save(existingQif);
						return true;
					}
				case "institutionalDataFormatDoc_AF":
					fileName = existingQif.getInstitutionalDataFormatDoc_AF();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setInstitutionalDataFormatDoc_AF("");
						qifRepo.save(existingQif);
						return true;
					}
				case "supportingDoc_AF":
					fileName = existingQif.getSupportingDoc_AF();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setSupportingDoc_AF("");
						qifRepo.save(existingQif);
						return true;
					}
				case "supportingDoc_CE":
					fileName = existingQif.getSupportingDoc_CE();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setSupportingDoc_CE("");
						qifRepo.save(existingQif);
						return true;
					}
				case "institutionalDataFormatDoc_CE":
					fileName = existingQif.getInstitutionalDataFormatDoc_CE();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setInstitutionalDataFormatDoc_CE("");
						qifRepo.save(existingQif);
						return true;
					}
				case "supportingDocs_CE":
					fileName = existingQif.getSupportingDocs_CE();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setSupportingDocs_CE("");
						qifRepo.save(existingQif);
						return true;
					}
				case "instiDataFormatDoc_FS":
					fileName = existingQif.getInstiDataFormatDoc_FS();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setInstiDataFormatDoc_FS("");
						qifRepo.save(existingQif);
						return true;
					}
				case "feedbackFormsFromStakeholdersDoc_FS":
					fileName = existingQif.getFeedbackFormsFromStakeholdersDoc_FS();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setFeedbackFormsFromStakeholdersDoc_FS("");
						qifRepo.save(existingQif);
						return true;
					}
				case "feedbackAnalysisReprtSubmDoc_FS":
					fileName = existingQif.getFeedbackAnalysisReprtSubmDoc_FS();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setFeedbackAnalysisReprtSubmDoc_FS("");
						qifRepo.save(existingQif);
						return true;
					}
				case "feedbackActionReportDoc_FS":
					fileName = existingQif.getFeedbackActionReportDoc_FS();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingQif.setFeedbackActionReportDoc_FS("");
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
				case "instDataTemplate_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setInstDataTemplate_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "intakeSanctionApproval_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setIntakeSanctionApproval_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "finalAdmissionList_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setFinalAdmissionList_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "instDataTemplate_doc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setInstDataTemplate_doc2(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "govtLetter_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setGovtLetter_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "linkForOtherRelivantDoc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setLinkForOtherRelivantDoc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "institutionalDataTemplate_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setInstitutionalDataTemplate_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "finalAdmissionList_doc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setFinalAdmissionList_doc2(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_doc2":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_doc2(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "sanctionedPostsMap_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setSanctionedPostsMap_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "instDataTemplate_doc3":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setInstDataTemplate_doc3(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "facultyPhDList_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setFacultyPhDList_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "ugcRecognizedPhdDegrees_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setUgcRecognizedPhdDegrees_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_doc3":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_doc3(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_doc4":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_doc4(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "additionalInfo_doc5":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setAdditionalInfo_doc5(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "instDataTemplate_doc4":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setInstDataTemplate_doc4(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "coeReportPassPercentage_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaII.setCoeReportPassPercentage_doc(fileName);
					c2_repo.save(existingCriteriaII);
					return true;
				case "coePassPercentReport_doc":
					// Implement logic for institutionalDataFormatDocs_AF
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
				case "linkForOtherRelivantDoc":
					fileName = existingCriteriaII.getLinkForOtherRelivantDoc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setLinkForOtherRelivantDoc("");
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
				case "additionalInfo_doc2":
					fileName = existingCriteriaII.getAdditionalInfo_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setAdditionalInfo_doc2("");
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
				case "facultyPhDList_doc":
					fileName = existingCriteriaII.getFacultyPhDList_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setFacultyPhDList_doc("");
						c2_repo.save(existingCriteriaII);
						return true;
					}
				case "ugcRecognizedPhdDegrees_doc":
					fileName = existingCriteriaII.getUgcRecognizedPhdDegrees_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setUgcRecognizedPhdDegrees_doc("");
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
				case "additionalInfo_doc4":
					fileName = existingCriteriaII.getAdditionalInfo_doc4();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setAdditionalInfo_doc4("");
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
				case "instDataTemplate_doc4":
					fileName = existingCriteriaII.getInstDataTemplate_doc4();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaII.setInstDataTemplate_doc4("");
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
				case "instDataTemplate_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstDataTemplate_doc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "supporting_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setSupporting_doc(fileName);
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
					existingCriteriaIII.setSupporting_doc2(fileName);
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
				case "institutionalDataFormat_doc4":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setInstitutionalDataFormat_doc4(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "collaborationsByActivity_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setCollaborationsByActivity_doc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "collaborationDetails_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setCollaborationDetails_doc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;
				case "activitiesByYear_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setActivitiesByYear_doc(fileName);
					c3_repo.save(existingCriteriaIII);
					return true;

				case "firstPageWithISBN_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setFirstPageWithISBN_doc(fileName);
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
				case "docWithCaptionsAndDates_doc":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIII.setDocWithCaptionsAndDates_doc(fileName);
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
				case "addInfo_doc":
					fileName = existingCriteriaIII.getAddInfo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setAddInfo_doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "institutionalDataFormat_doc5":
					fileName = existingCriteriaIII.getAddInfo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitutionalDataFormat_doc5("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "docWithCaptionsAndDates_doc":
					fileName = existingCriteriaIII.getAddInfo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setDocWithCaptionsAndDates_doc("");
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
				case "instDataTemplate_doc":
					fileName = existingCriteriaIII.getInstDataTemplate_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstDataTemplate_doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "supporting_doc":
					fileName = existingCriteriaIII.getSupporting_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setSupporting_doc("");
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
					fileName = existingCriteriaIII.getSupporting_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setSupporting_doc2("");
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
				case "institutionalDataFormat_doc4":
					fileName = existingCriteriaIII.getInstitutionalDataFormat_doc4();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setInstitutionalDataFormat_doc4("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "collaborationsByActivity_doc":
					fileName = existingCriteriaIII.getCollaborationsByActivity_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setCollaborationsByActivity_doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "collaborationDetails_doc":
					fileName = existingCriteriaIII.getCollaborationDetails_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setCollaborationDetails_doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "activitiesByYear_doc":
					fileName = existingCriteriaIII.getActivitiesByYear_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setActivitiesByYear_doc("");
						c3_repo.save(existingCriteriaIII);
						return true;
					}
				case "firstPageWithISBN_doc":
					fileName = existingCriteriaIII.getFirstPageWithISBN_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaIII.setFirstPageWithISBN_doc("");
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
				case "addInfo_doc4":
					// Implement logic for institutionalDataFormatDocs_AF
					fileName = fileService.uploadFile(pdf);
					existingCriteriaIV.setAddInfo_doc4(fileName);
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
				case "addInfo_doc4":
					fileName = existingCriteriaIV.getAddInfo_doc4();
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
				case "sanctionLetter_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setSanctionLetter_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "heiScholarshipPolicy_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setHeiScholarshipPolicy_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "beneficiaryListsByYear_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setBeneficiaryListsByYear_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "institutionalDataTemplate_doc2":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setInstitutionalDataTemplate_doc2(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "ReportEnhanceSkillsAndActivities_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setReportEnhanceSkillsAndActivities_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "TechAwarenessProgramReport_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setTechAwarenessProgramReport_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "institutionalDataTemplate_doc3":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setInstitutionalDataTemplate_doc3(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "statRegCommittees_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setStatRegCommittees_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "GuidelineComplianceProof_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setGuidelineComplianceProof_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "orgAwarenessPolicyZeroTol_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setOrgAwarenessPolicyZeroTol_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "grievanceSubmitMech_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setGrievanceSubmitMech_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "cmagnogReport_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setCmagnogReport_doc(fileName);
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
				case "institutionalDataTemplate_doc7":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setInstitutionalDataTemplate_doc7(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "suporting_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setSuporting_doc(fileName);
					c5_repo.save(existingCriteriaV);
					return true;
				case "addInfo_doc":
					fileName = fileService.uploadFile(pdf);
					existingCriteriaV.setAddInfo_doc(fileName);
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
				case "sanctionLetter_doc":
					fileName = existingCriteriaV.getSanctionLetter_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setSanctionLetter_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "heiScholarshipPolicy_doc":
					fileName = existingCriteriaV.getHeiScholarshipPolicy_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setHeiScholarshipPolicy_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "beneficiaryListsByYear_doc":
					fileName = existingCriteriaV.getBeneficiaryListsByYear_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setBeneficiaryListsByYear_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "institutionalDataTemplate_doc2":
					fileName = existingCriteriaV.getInstitutionalDataTemplate_doc2();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setInstitutionalDataTemplate_doc2("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "ReportEnhanceSkillsAndActivities_doc":
					fileName = existingCriteriaV.getReportEnhanceSkillsAndActivities_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setReportEnhanceSkillsAndActivities_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "TechAwarenessProgramReport_doc":
					fileName = existingCriteriaV.getTechAwarenessProgramReport_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setTechAwarenessProgramReport_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "institutionalDataTemplate_doc3":
					fileName = existingCriteriaV.getInstitutionalDataTemplate_doc3();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setInstitutionalDataTemplate_doc3("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "statRegCommittees_doc":
					fileName = existingCriteriaV.getStatRegCommittees_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setStatRegCommittees_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "GuidelineComplianceProof_doc":
					fileName = existingCriteriaV.getGuidelineComplianceProof_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setGuidelineComplianceProof_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "orgAwarenessPolicyZeroTol_doc":
					fileName = existingCriteriaV.getOrgAwarenessPolicyZeroTol_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setOrgAwarenessPolicyZeroTol_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "grievanceSubmitMech_doc":
					fileName = existingCriteriaV.getGrievanceSubmitMech_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setGrievanceSubmitMech_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "cmagnogReport_doc":
					fileName = existingCriteriaV.getCmagnogReport_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setCmagnogReport_doc("");
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
				case "institutionalDataTemplate_doc7":
					fileName = existingCriteriaV.getInstitutionalDataTemplate_doc7();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setInstitutionalDataTemplate_doc7("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "suporting_doc":
					fileName = existingCriteriaV.getSuporting_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setSuporting_doc("");
						c5_repo.save(existingCriteriaV);
						return true;
					}
				case "addInfo_doc":
					fileName = existingCriteriaV.getAddInfo_doc();
					success = fileService.deleteFileByName(fileName);
					if (success) {
						existingCriteriaV.setAddInfo_doc("");
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
