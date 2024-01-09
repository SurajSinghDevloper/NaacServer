package com.nac.repository.ssr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nac.model.SSR.StudentDetailsCurrentYear;

public interface StudentDetailsCurrentYearRepo extends JpaRepository<StudentDetailsCurrentYear, Long>{
	@Query("SELECT s FROM StudentDetailsCurrentYear s WHERE s.ssrId = :ssrId")
	List<StudentDetailsCurrentYear> findStudentDetailsCurrentYearBySsrID(@Param("ssrId") long ssrId);
}
