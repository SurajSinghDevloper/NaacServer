package com.nac.contollerRestful;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nac.configuration.CustomUserDetailsService;
import com.nac.configuration.JwtUtil;
import com.nac.configuration.LoginResponse;
import com.nac.model.NewCollegeRegistration;
import com.nac.service.NewCollegeRegistrationService;
import com.nac.service.PrepareIIQAService;

@RestController
@CrossOrigin
@RequestMapping("/api/auth/")
public class NewCollegeRegistrationController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private NewCollegeRegistrationService clgRegistrationService;

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private PrepareIIQAService iiqaService;

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

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody NewCollegeRegistration loginCollege) {
		try {
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					loginCollege.getCollegeEmailID(), loginCollege.getPassword()));

			// Load user details
			UserDetails userDetails = userDetailsService.loadUserByUsername(loginCollege.getCollegeEmailID());

			// Generate JWT token
			String token = jwtUtil.generateToken(loginCollege.getCollegeEmailID());

			NewCollegeRegistration college = clgRegistrationService.getCollegeByCollegeEmail(userDetails.getUsername());

			if (college != null) {
				// Create a response object with token and user details
				lastLoginDetail(userDetails.getUsername());
				
				LoginResponse loginResponse = new LoginResponse(token, college);
				return ResponseEntity.ok(loginResponse);
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (AuthenticationException e) {
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
		

	       
}
