package com.nac.contollerRestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nac.service.OtpService;

@RestController
@CrossOrigin
@RequestMapping("/otp")
public class OTPController {
	@Autowired
    private OtpService otpService;



	@PostMapping("/send-otp")
	public ResponseEntity<String> sendOtp(@RequestParam("email") String email,String role) {
	    String trimmedEmail = email.trim();

	    if (trimmedEmail.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
	        String otp = otpService.generateOtp();

	        if (otp != null) {
	            String success = otpService.sendOtpEmail(email, otp,role);

	            if ("true".equals(success)) {
	                return ResponseEntity.ok("OTP sent successfully");
	            }else if("Email Already Register".equals(success)) {
	                return ResponseEntity.status(500).body("Email Already Register");
	            } 
	            else {
	                return ResponseEntity.status(500).body("Failed to send OTP");
	            }
	        } else {
	            return ResponseEntity.status(500).body("Failed to generate OTP");
	        }
	    } else {
	        return ResponseEntity.badRequest().body("Invalid email address");
	    }
	}

	 
	 @PostMapping("/verify-otp")
	    public ResponseEntity<String> verifyOtp(
	            @RequestParam("otp") String otp,
	            @RequestParam("email") String email,
	            @RequestParam("role") String role) {

	        boolean isVerified = otpService.otpVerification(otp, email,role);

	        if (isVerified) {
	            return ResponseEntity.ok("OTP verification successful");
	        } else {
	            return ResponseEntity.badRequest().body("Invalid OTP");
	        }
	    }
	 
	 @GetMapping("/verify-email")
	    public ResponseEntity<?> verifyEmail(@RequestParam("email") String email,@RequestParam("role") String role) {
	        boolean isEmailVerified = otpService.emailVerification(email,role);

	        if (isEmailVerified) {
	            return ResponseEntity.ok("Varified Email Id");
	        } else {
	            return ResponseEntity.badRequest().body("Not Match Email ID");
	        }
	    }
	 
	 @PostMapping("/repas")
		public ResponseEntity<String> sendOtpForForgetPassword(@RequestParam("email") String email,@RequestParam("role") String role) {
		    String trimmedEmail = email.trim();

		    if (trimmedEmail.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
		        String otp = otpService.generateOtp();

		        if (otp != null) {
		            String success = otpService.sendOtpForForgetPassword(email, otp,role);

		            if ("true".equals(success)) {
		                return ResponseEntity.ok("OTP sent successfully");
		            }else if("Email Not Found".equals(success)) {
		                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email Not Found");
		            } 
		            else {
		                return ResponseEntity.status(500).body("Failed to send OTP");
		            }
		        } else {
		            return ResponseEntity.status(500).body("Failed to generate OTP");
		        }
		    } else {
		        return ResponseEntity.badRequest().body("Invalid email address");
		    }
		}
}
