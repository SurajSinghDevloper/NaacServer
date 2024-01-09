package com.nac.repository.ssr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nac.model.SSR.CriteriaVII;

public interface CriteriaVIIRepo extends JpaRepository<CriteriaVII, Long>{
	@Query("SELECT s FROM CriteriaVII s WHERE s.collegeID = :id")
	public CriteriaVII findCriteriaBycollegeID(@Param("id") long id);
}
