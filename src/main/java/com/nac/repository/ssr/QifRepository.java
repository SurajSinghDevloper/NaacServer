package com.nac.repository.ssr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nac.model.SSR.Qif;


public interface QifRepository extends JpaRepository<Qif,Long>{
	@Query("SELECT s FROM Qif s WHERE s.collegeID = :id")
	public Qif findQifbycollegeID(@Param("id") long id);
}
