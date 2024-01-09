package com.nac.service;

import java.util.List;

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

public interface SSRService {

	public SSR basicInformation(SSR ssr, long clgID);

	public boolean saveDocumentOfMinority(long clgID, MultipartFile pdf);

	public boolean removeDocumentOfMinority(long clgID);

	public boolean saveDocumentOfAutonomus(long clgId, MultipartFile pdf);

	public boolean removeDocumentOfAutonomus(long clgId);

	public Staff saveStaff(Staff staff);

	public List<Staff> getAllStaffBySSRId(long ssrId);

	public Staff saveGuestStaff(Staff staff);

	public Staff updateGuestStaff(long staffId, Staff staff);

	public Staff saveStaff(Staff staff, long staffId);

	public StaffDetails saveStaffDetails(StaffDetails staffDetails);

	public List<StaffDetails> getAllStaffDetailsBySSRId(long ssrId);

	public StaffDetails saveStaffDetails(StaffDetails staff, long staffDetailsId);

	public StudentDetailsCurrentYear saveStudentDetailsCurrentYear(StudentDetailsCurrentYear studentDetailsCurrentYear);

	public List<StudentDetailsCurrentYear> getAllStudentDetailsCurrentYearBySSRId(long ssrId);

	public StudentDetailsCurrentYear updateStudentDetailsCurrentYear(StudentDetailsCurrentYear studentDetails,
			long studentDetailsId);

	public StudentDetailsLastFourYears saveStudentDetailsLastFourYears(
			StudentDetailsLastFourYears studentDetailsLastFourYears);

	public List<StudentDetailsLastFourYears> getAllStudentDetailsLastFourYearsBySSRId(long ssrId);

	public StudentDetailsLastFourYears saveStudentDetailsCurrentYear(StudentDetailsLastFourYears studentDetails,
			long studentDetailsId);

	public StudentDetailsLastFourYears detailsOfStudentsEnrolled(StudentDetailsLastFourYears stdDetails);

	public StudentDetailsLastFourYears updatedDetailsOfStudentsEnrolled(long stdLFYId,
			StudentDetailsLastFourYears stdDetails);

	public SSR getSSRbyCollegeID(long clgId);

	public String academicComplete(ExtendedProfileSSR exSsr);

	public ExtendedProfileSSR saveExtendedSSR(ExtendedProfileSSR extendedSsr, long ssrId);

	public ExtendedProfileSSR updateExtendedSSR(long extendedProfileSSRId, ExtendedProfileSSR updatedExtendedSsr);

	public ExtendedProfileSSR findExtendedSSrById(long extendedSSrId);

	public boolean saveDocumentOfProgramInstructional(long SsrId, MultipartFile pdf);

	public boolean saveDocumentOfStudentInstructional(long SsrId, MultipartFile pdf);

	public boolean saveDocumentOfStuAppearedInstructional(long SsrId, MultipartFile pdf);

	public boolean saveDocumentOfStuRevAppInst(long SsrId, MultipartFile pdf);

	public boolean saveDocumentOfStuOutgoingInstructional(long SsrId, MultipartFile pdf);

	public boolean saveDocumentOfAcadCoursesInAllProgsInst(long SsrId, MultipartFile pdf);

	public boolean saveDocumentOfAcadFullTimeTeachInst(long SsrId, MultipartFile pdf);

	public boolean saveDocumentOfAcadSanctionedPostsInst(long SsrId, MultipartFile pdf);

	public boolean saveDocumentOfAddmAppliReceviedInst(long SsrId, MultipartFile pdf);

	public boolean saveDocumentOfAddmReservedSeatsInst(long SsrId, MultipartFile pdf);

	public boolean saveDocumentOfExpenditureWithoutSalaryInst(long SsrId, MultipartFile pdf);

	public boolean deleteDocumentOfProgramInstructional(long SsrId);

	public boolean deleteDocumentOfStudentInstructional(long SsrId);

	public boolean deleteDocumentOfStuAppearedInstructional(long SsrId);

	public boolean deleteDocumentOfStuRevAppInst(long SsrId);

	public boolean deleteDocumentOfStuOutgoingInstructional(long SsrId);

	public boolean deleteDocumentOfAcadCoursesInAllProgsInst(long SsrId);

	public boolean deleteDocumentOfAcadFullTimeTeachInst(long SsrId);

	public boolean deleteDocumentOfAcadSanctionedPostsInst(long SsrId);

	public boolean deleteDocumentOfAddmAppliReceviedInst(long SsrId);

	public boolean deleteDocumentOfAddmReservedSeatsInst(long SsrId);

	public boolean deleteExpenditureWithoutSalaryInst(long SsrId);

	public String qifCreation(Qif qif);

	public Qif findQifbyCollegeId(long collegeId);

	public boolean saveDocuments_C1(long clgId, MultipartFile pdf, String name);

	public boolean deleteDocuments_C1(long clgId, String name);

	public Qif save_C1(long qifId, Qif qif);

	public CriteriaII save_C2(long qifId, CriteriaII criteriaII);

	public boolean saveDocuments_C2(long criteriaId, MultipartFile pdf, String name);

	public CriteriaII findByCollegeId(long id);

	public boolean deleteDocuments_C2(long criteriaId, String name);

	public CriteriaIII findC3ByCollegeId(long id);

	public CriteriaIII save_C3(long qifId, CriteriaIII criteriaII);

	public boolean saveDocuments_C3(long criteriaId, MultipartFile pdf, String name);

	public boolean deleteDocuments_C3(long criteriaId, String name);

	public CriteriaIV findC4ByCollegeId(long id);

	public CriteriaIV save_C4(long collegeId, CriteriaIV criteriaIV);

	public boolean saveDocuments_C4(long criteriaId, MultipartFile pdf, String name);

	public boolean deleteDocuments_C4(long criteriaId, String name);

	public CriteriaV findC5ByCollegeId(long id);

	public CriteriaV save_C5(long collegeId, CriteriaV criteriaV);

	public boolean saveDocuments_C5(long criteriaId, MultipartFile pdf, String name);

	public boolean deleteDocuments_C5(long criteriaId, String name);

	public CriteriaVI findC6ByCollegeId(long id);

	public CriteriaVI save_C6(long collegeId, CriteriaVI criteriaVI);

	public boolean saveDocuments_C6(long criteriaId, MultipartFile pdf, String name);

	public boolean deleteDocuments_C6(long criteriaId, String name);
	
	public CriteriaVII findC7ByCollegeId(long id);
	
	public CriteriaVII save_C7(long collegeId, CriteriaVII criteriaVII);
	
	public boolean saveDocuments_C7(long criteriaId, MultipartFile pdf, String name);
	
	public boolean deleteDocuments_C7(long criteriaId, String name);
}
