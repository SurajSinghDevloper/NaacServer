package com.nac.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nac.model.*;
import com.nac.model.IIQA.PrepareIIQA;
import com.nac.repository.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColumnFillService {
    @Autowired
    private NewCollegeRegistrationRepo table1Repository;

    @Autowired
    private AffiliatingUniversityRepo table2Repository;

    @Autowired
    private CollegeProgramBySRARepo table3Repository;

    @Autowired
    private DetailsOfStaffOfCollegeRepo table4Repository;

    @Autowired
    private DetailsOfStudentOfCollegeRepo table5Repository;

    @Autowired
    private PrepareIIQARepo table6Repository;

    @Autowired
    private ProgramRunByCollegeRepo table7Repository;

    public List<Object> getAllByPrepareIIQAIDAndCalculatePercentage(Long prepareIIQAID) {
    	 List<Object> result = new ArrayList<>();
        List<Object> allRecords = getAllRecordsFromAllTables();

        List<Object> filteredRecords = allRecords.stream()
                .filter(record -> {
                    if (record instanceof PrepareIIQA) {
                        return ((PrepareIIQA) record).getIiqa_ID().equals(prepareIIQAID);
                    }
                    return false;
                })
                .collect(Collectors.toList());
        result.addAll(filteredRecords);
        if(filteredRecords.size()!=0) {
        	 double overallPercentage = calculateFilledColumnPercentage(allRecords);
        	 result.add("Overall Percentage: " + overallPercentage + "%");
        }
   
        return result;
    }

    private double calculateFilledColumnPercentage(List<Object> records) {
        int filledColumnsCount = 0;
        int totalColumns = 0;

        for (Object record : records) {
            Class<?> entityType = record.getClass();
            totalColumns += entityType.getDeclaredFields().length;

            for (Field field : entityType.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(record);
                    if (value != null) {
                        filledColumnsCount++;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Calculate the overall percentage based on the total filled columns and total columns
        return (double) filledColumnsCount / (double) totalColumns * 100;
    }

    private List<Object> getAllRecordsFromAllTables() {
        List<Object> allRecords = new ArrayList<>();
        allRecords.addAll(table1Repository.findAll());
        allRecords.addAll(table2Repository.findAll());
        allRecords.addAll(table3Repository.findAll());
        allRecords.addAll(table4Repository.findAll());
        allRecords.addAll(table5Repository.findAll());
        allRecords.addAll(table6Repository.findAll());
        allRecords.addAll(table7Repository.findAll());
        return allRecords;
    }
}
