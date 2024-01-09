package com.nac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nac.model.IIQA.DetailsOfStudentOfCollege;

public interface DetailsOfStudentOfCollegeRepo extends JpaRepository<DetailsOfStudentOfCollege, Long>{
	
	 @Query("SELECT au FROM DetailsOfStudentOfCollege au WHERE au.prepareIIQA_ID = :prepareIIQA_ID")
	    List<DetailsOfStudentOfCollege> findByPrepareIIQAID(@Param("prepareIIQA_ID") long prepareIIQA_ID);
	
}
