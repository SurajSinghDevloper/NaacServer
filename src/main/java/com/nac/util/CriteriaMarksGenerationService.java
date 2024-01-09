package com.nac.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nac.model.SSR.CriteriaII;
import com.nac.model.SSR.CriteriaIII;
import com.nac.model.SSR.CriteriaIV;
import com.nac.model.SSR.CriteriaV;
import com.nac.model.SSR.CriteriaVI;
import com.nac.model.SSR.CriteriaVII;
import com.nac.model.SSR.Qif;
import com.nac.repository.ssr.CriteriaIIRepo;
import com.nac.repository.ssr.CriteriaIIIRepo;
import com.nac.repository.ssr.CriteriaIVRepo;
import com.nac.repository.ssr.CriteriaVRepo;
import com.nac.repository.ssr.CriteriaVIRepo;
import com.nac.repository.ssr.CriteriaVIIRepo;
import com.nac.repository.ssr.QifRepository;

@Service
public class CriteriaMarksGenerationService {

    @Autowired
    private QifRepository table1Repository;

    @Autowired
    private CriteriaIIRepo table2Repository;

    @Autowired
    private CriteriaIIIRepo table3Repository;

    @Autowired
    private CriteriaIVRepo table4Repository;

    @Autowired
    private CriteriaVRepo table5Repository;

    @Autowired
    private CriteriaVIRepo table6Repository;

    @Autowired
    private CriteriaVIIRepo table7Repository;

    private Map<Class<?>, JpaRepository<?, ?>> tableRepositories;

    @PostConstruct
    private void initTableRepositories() {
        tableRepositories = new HashMap<>();
        tableRepositories.put(Qif.class, table1Repository);
        tableRepositories.put(CriteriaII.class, table2Repository);
        tableRepositories.put(CriteriaIII.class, table3Repository);
        tableRepositories.put(CriteriaIV.class, table4Repository);
        tableRepositories.put(CriteriaV.class, table5Repository);
        tableRepositories.put(CriteriaVI.class, table6Repository);
        tableRepositories.put(CriteriaVII.class, table7Repository);
    }

    public Map<String, Double> getCalculatePercentage(Long collegeId) {
        Map<String, Double> tablePercentages = new HashMap<>();
        List<Object> allRecords = getAllRecordsFromAllTables();

        for (Object table : allRecords) {
            double tablePercentage = calculateTableFilledColumnPercentage(table, collegeId);
            tablePercentages.put(table.getClass().getSimpleName(), tablePercentage);
        }

        return tablePercentages;
    }

    private double calculateTableFilledColumnPercentage(Object table, Long collegeId) {
        List<Object> filteredRecords = getAllRecordsFromTable(table)
                .stream()
                .filter(record -> isRecordForCollege(record, collegeId))
                .collect(Collectors.toList());

        return calculateFilledColumnPercentage(filteredRecords);
    }

    private boolean isRecordForCollege(Object record, Long collegeId) {
        try {
            Method getCollegeIdMethod = record.getClass().getMethod("getCollegeID");
            Long recordCollegeId = (Long) getCollegeIdMethod.invoke(record);

            return recordCollegeId != null && recordCollegeId.equals(collegeId);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return false;
    }


    private List<Object> getAllRecordsFromTable(Object table) {
        List<Object> tableRecords = new ArrayList<>();
        JpaRepository<?, ?> repository = tableRepositories.get(table.getClass());

        if (repository != null) {
            tableRecords.addAll(repository.findAll());
        }

        return tableRecords;
    }

    private <T> double calculateFilledColumnPercentage(List<T> records) {
        int filledColumnsCount = 0;
        int totalColumns = 0;

        for (T record : records) {
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

        return totalColumns != 0 ? (double) filledColumnsCount / (double) totalColumns * 100 : 0.0;
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
