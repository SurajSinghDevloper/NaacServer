package com.nac.repository.ssr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nac.model.SSR.StudentDetailsLastFourYears;

public interface StudentDetailsLastFourYearsRepo extends JpaRepository<StudentDetailsLastFourYears, Long> {
	@Query("SELECT s FROM StudentDetailsLastFourYears s WHERE s.ssrId = :ssrId")
	List<StudentDetailsLastFourYears> findStudentDetailsLastFourYearsBySsrID(@Param("ssrId") long ssrId);
}
