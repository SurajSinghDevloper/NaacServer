package com.nac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nac.model.IIQA.AffiliatingUniversity;

public interface AffiliatingUniversityRepo extends JpaRepository<AffiliatingUniversity, Long>{
	 @Query("SELECT au FROM AffiliatingUniversity au WHERE au.prepareIIQA_ID = :prepareIIQA_ID")
	    List<AffiliatingUniversity> findByPrepareIIQAID(@Param("prepareIIQA_ID") long prepareIIQA_ID);
	 
	 @Query("SELECT au FROM AffiliatingUniversity au WHERE au.id = :id")
	 public AffiliatingUniversity findByAffiliatingUniversityId(long id);
}
