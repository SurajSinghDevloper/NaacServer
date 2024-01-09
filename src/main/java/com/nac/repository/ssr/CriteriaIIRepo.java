package com.nac.repository.ssr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nac.model.SSR.CriteriaII;

public interface CriteriaIIRepo  extends JpaRepository<CriteriaII , Long>{
	@Query("SELECT s FROM CriteriaII s WHERE s.collegeID = :id")
	public CriteriaII findCriteriaBycollegeID(@Param("id") long id);
}
