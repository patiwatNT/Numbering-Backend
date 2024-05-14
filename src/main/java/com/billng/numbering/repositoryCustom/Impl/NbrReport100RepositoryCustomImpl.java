package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NbrReport100Dto;
import com.billng.numbering.entities.NbrReport100;
import com.billng.numbering.entities.NbrReport500;
import com.billng.numbering.mapper.NbrReport100Mapper;
import com.billng.numbering.mapper.NbrServiceNumbersMapper;
import com.billng.numbering.repositoryCustom.NbrReport100RepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class NbrReport100RepositoryCustomImpl implements NbrReport100RepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrReport100Mapper nbrReport100Mapper;
    @Value("${table.numbering.block100}")
    String tableName;
    @Override
    public List<NbrReport100Dto> findAllOnly() {

        try {
            String query = "Select * From " + tableName + " t1\n" +
                    "\tWHERE NOT EXISTS\n" +
                    "\t   (SELECT 1 FROM NBR_REPORT500 t2\n" +
                    "\t\tWHERE t1.block_id = t2.block_id AND t1.flag500 = t2.flag)\n" +
                    "\t\tAND block_id NOT IN (SELECT block_id FROM NBR_REPORT1000)\n" +
                    "\torder by block_start";
            return nbrReport100Mapper.toDto(entityManager.createNativeQuery(query, NbrReport100.class).getResultList());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
