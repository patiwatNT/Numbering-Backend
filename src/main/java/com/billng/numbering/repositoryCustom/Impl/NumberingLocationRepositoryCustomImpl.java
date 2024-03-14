package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NumberingLocationDto;
import com.billng.numbering.entities.NumberingLocation;
import com.billng.numbering.mapper.NumberingLocationMapper;
import com.billng.numbering.repositoryCustom.NumberingLocationRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class NumberingLocationRepositoryCustomImpl implements NumberingLocationRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NumberingLocationMapper numberingLocationMapper;
    @Value("${table.numbering.location}")
    String tableName;
    @Override
    public List<NumberingLocationDto> findAllCustom() {
        try{
            String query = "SELECT * FROM " + tableName + " WHERE STATUS = 'ST001'";
            return numberingLocationMapper.toDto(entityManager.createNativeQuery(query, NumberingLocation.class).getResultList());
        }catch (Exception e){
           e.printStackTrace();
           return null;
        }
    }
}
