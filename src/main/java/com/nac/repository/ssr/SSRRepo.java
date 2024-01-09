package com.nac.repository.ssr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nac.model.SSR.SSR;

public interface SSRRepo extends JpaRepository<SSR, Long> {
	
	@Query("SELECT s FROM SSR s WHERE s.collegeID = :id")
	public SSR findSSRbycollegeID(@Param("id") long id);


}
