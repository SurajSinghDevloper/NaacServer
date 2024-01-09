package com.nac.repository.ssr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nac.model.SSR.ExtendedProfileSSR;
import com.nac.model.SSR.SSR;

public interface ExtendedProfileSSRRepo extends JpaRepository<ExtendedProfileSSR,Long>{
	
    @Query("SELECT s FROM ExtendedProfileSSR s WHERE s.ssrID = :ssrId")
    ExtendedProfileSSR findBySsrId(@Param("ssrId") long ssrId);
	
    @Query("SELECT s FROM ExtendedProfileSSR s WHERE s.collegeId = :collegeId")
    ExtendedProfileSSR findByCollegeId(@Param("collegeId") long collegeId);
	
	
}
