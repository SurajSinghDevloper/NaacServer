package com.nac.repository.ssr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nac.model.SSR.StaffDetails;

public interface StaffDetailsRepo extends JpaRepository<StaffDetails, Long>{
	@Query("SELECT s FROM StaffDetails s WHERE s.ssrId = :ssrId")
	List<StaffDetails> findStaffDetailsBySsrID(@Param("ssrId") long ssrId);
}
