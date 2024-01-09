package com.nac.configuration;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nac.model.NewCollegeRegistration;
import com.nac.repository.*;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private  NewCollegeRegistrationRepo newCollegeRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	NewCollegeRegistration user = newCollegeRepo.findByCollegeEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(
            user.getCollegeEmailID(),
            user.getPassword(),
            new ArrayList<>()
        );
    }
}
