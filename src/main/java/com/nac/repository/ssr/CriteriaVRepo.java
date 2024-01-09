package com.nac.repository.ssr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nac.model.SSR.CriteriaV;

public interface CriteriaVRepo extends JpaRepository<CriteriaV, Long>{
	@Query("SELECT s FROM CriteriaV s WHERE s.collegeID = :id")
	public CriteriaV findCriteriaBycollegeID(@Param("id") long id);
}
