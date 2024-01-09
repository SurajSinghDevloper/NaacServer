package com.nac.repository.ssr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nac.model.SSR.CriteriaVI;


public interface CriteriaVIRepo extends JpaRepository<CriteriaVI, Long> {
	@Query("SELECT s FROM CriteriaVI s WHERE s.collegeID = :id")
	public CriteriaVI findCriteriaBycollegeID(@Param("id") long id);
}
