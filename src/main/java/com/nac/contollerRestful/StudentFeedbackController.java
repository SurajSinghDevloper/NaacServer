package com.nac.contollerRestful;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nac.configuration.JwtUtil;
import com.nac.configuration.LoginResponse;

import com.nac.model.NewCollegeRegistration;
import com.nac.model.StudentFeedback;
import com.nac.service.StudentFeedbackService;


@RestController
@RequestMapping("/api/student")
public class StudentFeedbackController {
	
	@Autowired
	StudentFeedbackService stdService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
//	@Autowired
////	CustomStudentDetailsService userDetailsService;
//	@Autowired
//	private JwtUtil jwtUtil;
	
	


	 @PostMapping("/re-password")
	    public ResponseEntity<?> resetPassword(@RequestParam String email, @RequestParam String password) {
		 String hashedPassword = passwordEncoder.encode(password);
		 boolean success = stdService.resetPassword(email, hashedPassword);
		 if(success) {
			 return ResponseEntity.ok("Password reset successfully for user with email: " + email);
		 }
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Password reset failed for user with email: " + email);
	 }
}
	 
	 






