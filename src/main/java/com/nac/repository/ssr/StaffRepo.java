package com.nac.repository.ssr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nac.model.SSR.Staff;

public interface StaffRepo extends JpaRepository<Staff, Long> {
	@Query("SELECT s FROM Staff s WHERE s.ssrId = :ssrId")
	List<Staff> findStaffBySsrID(@Param("ssrId") long ssrId);


}
