package com.nac.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Random;

import com.nac.model.Otp;
import com.nac.model.StudentFeedback;
import com.nac.model.NewCollegeRegistration;
import com.nac.repository.NewCollegeRegistrationRepo;
import com.nac.repository.OtpRepo;
import com.nac.repository.StudentFeedbackRepo;
import com.nac.service.OtpService;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private OtpRepo otpRepo;

    @Autowired
    private NewCollegeRegistrationRepo ncr;

    @Autowired
    private StudentFeedbackRepo sfr;

    @Override
    public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    @Override
    public String sendOtpEmail(String email, String otp, String role) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email);
            helper.setSubject("Your OTP Code");

            String htmlContent = "<!DOCTYPE html>\r\n" +
                    "<html>\r\n" +
                    "<head>\r\n" +
                    "    <title>OTP Verification</title>\r\n" +
                    "</head>\r\n" +
                    "<body>\r\n" +
                    "    <p>Hello,</p>\r\n" +
                    "    <p>Please use this code to complete the verification process. Note that this code is only valid for a short period of time.</p>\r\n" +
                    "    <p>Your OTP code for verification is: <strong> <h2>" + otp + "</h2> </strong></p>\r\n" +
                    "    <p>If you did not request this OTP, please ignore this email.</p>\r\n" +
                    "    <p>Thank you for using our service.</p>\r\n" +
                    "    <p>Best regards,</p>\r\n" +
                    "    <p>Your Company Name</p>\r\n" +
                    "</body>\r\n" +
                    "</html>";

            helper.setText(htmlContent, true);

            javaMailSender.send(message);

            Otp newOtp = new Otp();
            newOtp.setEmail(email);
            newOtp.setOtp(otp);
            newOtp.setOtpFlg("0");
            Otp saveOtp = otpRepo.save(newOtp);

            if (saveOtp != null) {
                return "true";
            } else {
                return "false";
            }

        } catch (MessagingException e) {
            e.printStackTrace();
            return "false";
        }
    }

    @Override
    public boolean emailVerification(String email, String role) {
        if ("ROLE_STUDENT".equals(role)) {
            StudentFeedback student = sfr.findStdByEmail(email);

            return student != null && email.equals(student.getStdEmail());
        } else if ("ROLE_COLLEGE".equals(role)) {
            NewCollegeRegistration college = ncr.findByCollegeEmail(email);

            return college != null && email.equals(college.getCollegeEmailID());
        }

        return false;
    }

    @Override
    public boolean otpVerification(String otp, String email, String role) {
        List<Otp> otps = otpRepo.getOtpByEmailOrderByDesc(email);

        if (otps != null && !otps.isEmpty()) {
            Otp otpEntity = otps.get(0);

            String otpStored = otpEntity.getOtp();

            if (otp.equals(otpStored)) {
                otpEntity.setOtpFlg("1");
                otpRepo.save(otpEntity);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean otpflagChange(String email) {
        List<Otp> otps = otpRepo.getOtpByEmailOrderByDesc(email);

        if (otps != null && !otps.isEmpty()) {
            Otp otpEntity = otps.get(0);

            if (otpEntity != null) {
                otpEntity.setOtpFlg("1");
                otpRepo.save(otpEntity);
                return true;
            }
        }

        return false;
    }

    @Override
    public String sendOtpForForgetPassword(String email, String otp, String role) {
        if ("ROLE_COLLEGE".equals(role)) {
            NewCollegeRegistration college = ncr.findByCollegeEmail(email);

            if (college != null) {
                try {
                    MimeMessage message = javaMailSender.createMimeMessage();
                    MimeMessageHelper helper = new MimeMessageHelper(message, true);

                    helper.setTo(email);
                    helper.setSubject("Your OTP Code");

                    String htmlContent = "<!DOCTYPE html>\r\n" +
                            "<html>\r\n" +
                            "<head>\r\n" +
                            "    <title>OTP Verification</title>\r\n" +
                            "</head>\r\n" +
                            "<body>\r\n" +
                            "    <p>Hello,</p>\r\n" +
                            "    <p>Please use this code to complete the verification process. Note that this code is only valid for a short period of time.</p>\r\n" +
                            "    <p>Your OTP code for verification is: <strong> <h2>" + otp + "</h2> </strong></p>\r\n" +
                            "    <p>If you did not request this OTP, please ignore this email.</p>\r\n" +
                            "    <p>Thank you for using our service.</p>\r\n" +
                            "    <p>Best regards,</p>\r\n" +
                            "    <p>Your Company Name</p>\r\n" +
                            "</body>\r\n" +
                            "</html>";

                    helper.setText(htmlContent, true);

                    javaMailSender.send(message);

                    Otp newOtp = new Otp();
                    newOtp.setEmail(email);
                    newOtp.setOtp(otp);
                    newOtp.setOtpFlg("0");
                    Otp saveOtp = otpRepo.save(newOtp);

                    if (saveOtp != null) {
                        return "true";
                    }
                    return "false";
                } catch (MessagingException e) {
                    e.printStackTrace();
                    return "false";
                }
            }
            return "Email Not Found";
        } else if ("ROLE_STUDENT".equals(role)) {
            StudentFeedback student = sfr.findStdByEmail(email);

            if (student != null) {
                try {
                    MimeMessage message = javaMailSender.createMimeMessage();
                    MimeMessageHelper helper = new MimeMessageHelper(message, true);

                    helper.setTo(email);
                    helper.setSubject("Your OTP Code");

                    String htmlContent = "<!DOCTYPE html>\r\n" +
                            "<html>\r\n" +
                            "<head>\r\n" +
                            "    <title>OTP Verification</title>\r\n" +
                            "</head>\r\n" +
                            "<body>\r\n" +
                            "    <p>Hello,</p>\r\n" +
                            "    <p>Please use this code to complete the verification process. Note that this code is only valid for a short period of time.</p>\r\n" +
                            "    <p>Your OTP code for verification is: <strong> <h2>" + otp + "</h2> </strong></p>\r\n" +
                            "    <p>If you did not request this OTP, please ignore this email.</p>\r\n" +
                            "    <p>Thank you for using our service.</p>\r\n" +
                            "    <p>Best regards,</p>\r\n" +
                            "    <p>Your Company Name</p>\r\n" +
                            "</body>\r\n" +
                            "</html>";

                    helper.setText(htmlContent, true);

                    javaMailSender.send(message);

                    Otp newOtp = new Otp();
                    newOtp.setEmail(email);
                    newOtp.setOtp(otp);
                    newOtp.setOtpFlg("0");
                    Otp saveOtp = otpRepo.save(newOtp);

                    if (saveOtp != null) {
                        return "true";
                    }
                    return "false";
                } catch (MessagingException e) {
                    e.printStackTrace();
                    return "false";
                }
            }
            return "Email Not Found";
        }
        return "Invalid Role";
    }
}
