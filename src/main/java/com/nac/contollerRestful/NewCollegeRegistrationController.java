package com.nac.contollerRestful;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nac.configuration.CustomUserDetailsService;
import com.nac.configuration.JwtUtil;
import com.nac.configuration.LoginResponse;
import com.nac.model.NewCollegeRegistration;
import com.nac.model.StudentFeedback;
import com.nac.service.NewCollegeRegistrationService;
import com.nac.service.PrepareIIQAService;
import com.nac.service.StudentFeedbackService;

@RestController
@CrossOrigin
@RequestMapping("/api/auth/")
public class NewCollegeRegistrationController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private NewCollegeRegistrationService clgRegistrationService;
	@Autowired
	private StudentFeedbackService studentService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private PrepareIIQAService iiqaService;
	@Autowired
	StudentFeedbackService stdService;

	@PostMapping("registration")
	public ResponseEntity<?> saveaccountreport(@RequestBody NewCollegeRegistration clgRegistration) {

		String email = clgRegistration.getCollegeEmailID();
		NewCollegeRegistration clgReg = clgRegistrationService.getCollegeByCollegeEmail(email);
		if (clgReg != null) {
			return ResponseEntity.status(409).body("Already Regester by this Details");
		}
		String hashedPassword = passwordEncoder.encode(clgRegistration.getPassword());
		clgRegistration.setPassword(hashedPassword);
		NewCollegeRegistration clgRegistrationObj = clgRegistrationService.saveclgRegistration(clgRegistration);
		return ResponseEntity.status(201).body("Registered Successfully").ok(clgRegistrationObj);

	}
	
	 @PostMapping("/login")
	    public ResponseEntity<?> login(
	            @RequestParam("email") String email,
	            @RequestParam("role") String role,
	            @RequestParam("password") String password) {

	        try {
	            UserDetails userDetails = null;
	            Object user = null;

	            if ("ROLE_STUDENT".equals(role)) {
	                StudentFeedback studentLogin = studentService.findStudentByEmail(email);
	                userDetails = userDetailsService.loadUserByUsername(email);
	                user = studentLogin;
	            } else if ("ROLE_COLLEGE".equals(role)) {
	                NewCollegeRegistration loginCollege = clgRegistrationService.getCollegeByCollegeEmail(email);
	                userDetails = userDetailsService.loadUserByUsername(email);
	                user = loginCollege;
	            } else {
	                return ResponseEntity.badRequest().body("Invalid role specified");
	            }

	            if (userDetails != null && user != null) {
	                // Log some information for debugging
	                System.out.println("User: " + user);
	                System.out.println("UserDetails: " + userDetails);

	                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                        userDetails.getUsername(), password));

	                // Generate JWT token
	                String token = jwtUtil.generateToken(email);

	                // Create a response object with the token and user details
	                lastLoginDetail(email);

	                LoginResponse loginResponse = new LoginResponse(token, user);
	                return ResponseEntity.ok(loginResponse);
	            } else {
	                return ResponseEntity.notFound().build();
	            }

	        } catch (UsernameNotFoundException e) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
	        } catch (BadCredentialsException e) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
	        }
	    }

	
	
	
	 private LocalDateTime lastLoginDetail(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("password")
	    public ResponseEntity<?> resetPassword(@RequestParam String email, @RequestParam String password) {
		 String hashedPassword = passwordEncoder.encode(password);
		 boolean success = clgRegistrationService.resetPassword(email, hashedPassword);
		 if(success) {
			 return ResponseEntity.ok("Password reset successfully for user with email: " + email);
		 }
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Password reset failed for user with email: " + email);
	 }
		
	 @PostMapping("std/register")
	    public ResponseEntity<String> registerStudent(@ModelAttribute StudentFeedback sf) {
	        String result = stdService.registerStudent(sf);

	        if ("Saved".equals(result)) {
	            return ResponseEntity.status(HttpStatus.CREATED).body("Student saved successfully");
	        } else if (result == null) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save student");
	        } else {
	            return ResponseEntity.status(HttpStatus.CONFLICT).body("Student with the given details already exists");
	        }
	    }
	       
}
