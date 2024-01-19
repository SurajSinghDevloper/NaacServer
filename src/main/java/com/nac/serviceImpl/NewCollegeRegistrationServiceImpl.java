package com.nac.serviceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nac.model.NewCollegeRegistration;
import com.nac.model.Otp;
import com.nac.repository.NewCollegeRegistrationRepo;
import com.nac.repository.OtpRepo;
import com.nac.service.NewCollegeRegistrationService;
import com.nac.service.OtpService;

@Service
public class NewCollegeRegistrationServiceImpl implements NewCollegeRegistrationService{
	
	@Autowired
	private NewCollegeRegistrationRepo registrationRepo;
	@Autowired
	private OtpService otpService;



	@Override
	public NewCollegeRegistration saveclgRegistration(NewCollegeRegistration model) {
		model.setRole("ROLE_COLLEGE");
		// TODO Auto-generated method stub
		return registrationRepo.save(model);
	}

	@Override
	public List<NewCollegeRegistration> getAllclgRegistration() {
		// TODO Auto-generated method stub
		return registrationRepo.findAll();
	}

	@Override
	public Optional<NewCollegeRegistration> getclgRegistrationById(Long id) {
		// TODO Auto-generated method stub
		return registrationRepo.findById(id);
	}

	@Override
	public NewCollegeRegistration updateclgRegistration(Long id, NewCollegeRegistration model) {
		// TODO Auto-generated method stub
		return registrationRepo.save(model);
	}
	
	public NewCollegeRegistration getCollegeByCollegeEmail(String email) {
		return registrationRepo.findByCollegeEmail(email);
	}
	
	@Override
	public LocalDateTime lastLoginDetail(String email) {
		NewCollegeRegistration college = registrationRepo.findByCollegeEmail(email);
		LocalDateTime now = LocalDateTime.now();
		college.setLastLoginTime(now);
		registrationRepo.save(college);
		 return now;
	}
	
	@Override
	public boolean resetPassword(String email, String password) {
		NewCollegeRegistration college = registrationRepo.findByCollegeEmail(email);
		if(college !=null ) {
			college.setPassword(password);
			NewCollegeRegistration success = registrationRepo.save(college);
			if(success != null) {
				otpService.otpflagChange(email);
				return true;
			}
		}
		
		return false;
	}

}
