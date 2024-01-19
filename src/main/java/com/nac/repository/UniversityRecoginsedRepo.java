package com.nac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nac.model.IIQA.UniversityRecoginsed;

public interface UniversityRecoginsedRepo extends JpaRepository<UniversityRecoginsed, Long>{
	 @Query("SELECT au FROM UniversityRecoginsed au WHERE au.prepareIIQA_ID = :prepareIIQA_ID")
	    List<UniversityRecoginsed> findByPrepareIIQAID(@Param("prepareIIQA_ID") long prepareIIQA_ID);
	 
	 @Query("SELECT au FROM UniversityRecoginsed au WHERE au.id = :id")
	 public UniversityRecoginsed findByAffiliatingUniversityId(long id);
}
