package com.nac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nac.model.NewCollegeRegistration;

@Repository
public interface NewCollegeRegistrationRepo extends JpaRepository<NewCollegeRegistration, Long>{
//	public NewCollegeRegistration findByCollegeEmail(String collegeEmailID);
    @Query("SELECT n FROM NewCollegeRegistration n WHERE n.collegeEmailID = :email")
    NewCollegeRegistration findByCollegeEmail(@Param("email") String email);

}
