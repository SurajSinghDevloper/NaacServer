package com.nac.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nac.model.NewCollegeRegistration;
import com.nac.model.StudentFeedback;
import com.nac.repository.StudentFeedbackRepo;
import com.nac.service.OtpService;
import com.nac.service.StudentFeedbackService;

@Service
public class StudentFeedbackServiceImpl implements StudentFeedbackService{
	@Autowired
	StudentFeedbackRepo sfr;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private OtpService otpService;
	
	
	@Override
	 public String registerStudent(StudentFeedback sf) {
        StudentFeedback existingStd = sfr.findByRegNoOrEmailOrMobile(sf.getStdRegNo(), sf.getStdEmail(), sf.getStdMobile());
        if (existingStd == null) {
        	sf.setRole("ROLE_STUDENT");
        	String hashedPassword = passwordEncoder.encode(sf.getPassword());
        	sf.setPassword(hashedPassword);
            StudentFeedback newStd = sfr.save(sf); 
            if (newStd != null) {
                return "Saved";
            } else {
                return null;
            }
        } else {
            return "EXISTS";
        }
    }

    @Override
    public StudentFeedback findStudentByEmail(String Email){
        StudentFeedback foundStd = sfr.findStdByEmail( Email);
        if(foundStd != null){
            return foundStd;
        }else{
            return null;
        }
    }
    
    @Override
	public boolean resetPassword(String email, String password) {
    	StudentFeedback student = sfr.findStdByEmail(email);
		if(student !=null ) {
			student.setPassword(password);
			StudentFeedback success = sfr.save(student);
			if(success != null) {
				otpService.otpflagChange(email);
				return true;
			}
		}
		
		return false;
	}
}
