package com.nac.service;

import com.nac.model.StudentFeedback;

public interface StudentFeedbackService {
	 public String registerStudent(StudentFeedback sf);
	 public StudentFeedback findStudentByEmail(String Email);
	 public boolean resetPassword(String email, String password);
}
