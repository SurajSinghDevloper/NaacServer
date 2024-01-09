package com.nac.service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nac.model.NewCollegeRegistration;


public interface NewCollegeRegistrationService {
	
	
	NewCollegeRegistration saveclgRegistration (NewCollegeRegistration model) ;
	
	List<NewCollegeRegistration>getAllclgRegistration();
	
	Optional<NewCollegeRegistration>getclgRegistrationById(Long id);
	
	NewCollegeRegistration updateclgRegistration(Long id,NewCollegeRegistration model);
		
	NewCollegeRegistration getCollegeByCollegeEmail(String email);
	
	public LocalDateTime lastLoginDetail(String email);

	public boolean resetPassword(String email, String password);
}
