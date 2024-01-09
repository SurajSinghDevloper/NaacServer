package com.nac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nac.model.IIQA.DetailsOfStaffOfCollege;


public interface DetailsOfStaffOfCollegeRepo extends JpaRepository<DetailsOfStaffOfCollege, Long>{

	 @Query("SELECT au FROM DetailsOfStaffOfCollege au WHERE au.prepareIIQA_ID = :prepareIIQA_ID")
	    List<DetailsOfStaffOfCollege> findByPrepareIIQAID(@Param("prepareIIQA_ID") long prepareIIQA_ID);
	
}
