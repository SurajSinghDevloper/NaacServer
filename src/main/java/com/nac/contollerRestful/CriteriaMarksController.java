package com.nac.contollerRestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nac.util.CriteriaMarksGenerationService;

import java.util.Map;

@RestController
@RequestMapping("/api/criteria-marks")
public class CriteriaMarksController {
	 @Autowired
	    private CriteriaMarksGenerationService criteriaMarksGenerationService;

	    @GetMapping("/percentage/{collegeId}")
	    public Map<String, Double> getPercentageByTable(@PathVariable Long collegeId) {
	        return criteriaMarksGenerationService.getCalculatePercentage(collegeId);
	    }
}
