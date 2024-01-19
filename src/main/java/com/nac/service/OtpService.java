package com.nac.service;


public interface OtpService {
	
	 public String sendOtpEmail(String email, String otp, String role);
	
	public String generateOtp();
	
	 public boolean otpVerification(String otp, String email, String role);
	
	 public boolean emailVerification(String email, String role);
	
	public boolean otpflagChange( String email);
	
	public String sendOtpForForgetPassword(String email, String otp, String role);

}
