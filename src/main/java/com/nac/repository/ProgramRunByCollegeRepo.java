package com.nac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nac.model.IIQA.ProgramRunByCollege;

public interface ProgramRunByCollegeRepo extends JpaRepository<ProgramRunByCollege, Long>{
	@Query("SELECT pu FROM ProgramRunByCollege pu WHERE pu.prepareIIQA_ID = :prepareIIQA_Id")
	List<ProgramRunByCollege> findAll(@Param("prepareIIQA_Id") Long prepareIIQA_Id);


}
