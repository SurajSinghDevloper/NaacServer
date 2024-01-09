package com.nac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nac.model.IIQA.SraList;

public interface SraListRepo extends JpaRepository<SraList, Long>{

	List<SraList> findByPrepareIIQA(Long iiqa);

}
