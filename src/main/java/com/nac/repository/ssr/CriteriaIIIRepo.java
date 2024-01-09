package com.nac.repository.ssr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nac.model.SSR.CriteriaIII;

public interface CriteriaIIIRepo extends JpaRepository<CriteriaIII , Long>{
	@Query("SELECT s FROM CriteriaIII s WHERE s.collegeID = :id")
	public CriteriaIII findCriteriaBycollegeID(@Param("id") long id);
}
