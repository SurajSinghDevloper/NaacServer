package com.nac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nac.model.IIQA.CollegeProgramBySRA;

public interface CollegeProgramBySRARepo extends JpaRepository<CollegeProgramBySRA, Long>{
	List<CollegeProgramBySRA> findByprepareIIQA(Long iiqa);
}
