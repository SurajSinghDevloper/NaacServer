package com.nac.configuration;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nac.model.NewCollegeRegistration;
import com.nac.model.StudentFeedback;
import com.nac.repository.*;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private  NewCollegeRegistrationRepo newCollegeRepo;
	@Autowired
    private StudentFeedbackRepo studentRepo;


//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//    	NewCollegeRegistration user = newCollegeRepo.findByCollegeEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with email: " + email);
//        }
//        return new org.springframework.security.core.userdetails.User(
//            user.getCollegeEmailID(),
//            user.getPassword(),
//            new ArrayList<>()
//        );
//    }
	
	 @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        NewCollegeRegistration collegeUser = newCollegeRepo.findByCollegeEmail(email);
	        StudentFeedback studentUser = studentRepo.findStdByEmail(email);

	        if (collegeUser != null) {
	            return new org.springframework.security.core.userdetails.User(
	                    collegeUser.getCollegeEmailID(),
	                    collegeUser.getPassword(),
	                    new ArrayList<>()
	            );
	        } else if (studentUser != null) {
	            return new org.springframework.security.core.userdetails.User(
	                    studentUser.getStdEmail(),
	                    studentUser.getPassword(),
	                    new ArrayList<>()
	            );
	        } else {
	            throw new UsernameNotFoundException("User not found with email: " + email);
	        }
	    }
}
