package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NbrReport500Dto;
import com.billng.numbering.entities.NbrReport500;
import com.billng.numbering.mapper.NbrReport500Mapper;
import com.billng.numbering.mapper.NbrServiceNumbersMapper;
import com.billng.numbering.repositoryCustom.NbrReport500RepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class NbrReport500RepositoryCustomImpl implements NbrReport500RepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrReport500Mapper nbrReport500Mapper;
    @Value("${table.numbering.block500}")
    String tableName;
    @Override
    public List<NbrReport500Dto> findAllOnly() {
        try {
            String query = "Select * From " + tableName + " Where block_id NOT IN (SELECT block_id FROM NBR_REPORT1000) order by block_start";
            return nbrReport500Mapper.toDto(entityManager.createNativeQuery(query, NbrReport500.class).getResultList());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
