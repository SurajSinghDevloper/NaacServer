package com.nac.repository.ssr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nac.model.SSR.CriteriaIV;

public interface CriteriaIVRepo extends JpaRepository<CriteriaIV, Long>{
	@Query("SELECT s FROM CriteriaIV s WHERE s.collegeID = :id")
	public CriteriaIV findCriteriaBycollegeID(@Param("id") long id);
}
