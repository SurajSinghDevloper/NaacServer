package com.nac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nac.model.StudentFeedback;

public interface StudentFeedbackRepo extends JpaRepository<StudentFeedback, Long>{
    @Query("SELECT s FROM StudentFeedback s WHERE s.stdEmail = :stdEmail")
    StudentFeedback findStdByEmail(@Param("stdEmail") String stdEmail);
    
    @Query("SELECT s FROM StudentFeedback s WHERE s.stdRegNo = :stdRegNo OR s.stdEmail = :stdEmail OR s.stdMobile = :stdMobile")
    StudentFeedback findByRegNoOrEmailOrMobile(@Param("stdRegNo") String stdRegNo, @Param("stdEmail") String stdEmail, @Param("stdMobile") String stdMobile);
}
