package com.nac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nac.model.IIQA.PrepareIIQA;

public interface PrepareIIQARepo extends JpaRepository<PrepareIIQA, Long> {

	@Query("SELECT p FROM PrepareIIQA p WHERE p.collegeRegistrationId = :collegeRegistrationId ORDER BY p.id DESC")
	List<PrepareIIQA> findLatestByCollegeRegistration(@Param("collegeRegistrationId") long collegeRegistrationId);

	@Query("SELECT p FROM PrepareIIQA p WHERE p.collegeRegistrationId = :collegeRegistrationId ORDER BY p.id DESC")
	PrepareIIQA findLatestIIQAByCollegeRegistration(@Param("collegeRegistrationId") long collegeRegistrationId);
	
	@Query(value = "select * from PrepareIIQA where college_registration_id=:collegeId", nativeQuery = true)
	List<PrepareIIQA> findByCollegeId(Long collegeId);

}
