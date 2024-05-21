package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.mapper.NbrBlocksMapper;
import com.billng.numbering.mapper.NbrProductTypeMapper;
import com.billng.numbering.repositoryCustom.NbrProductTypeRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class NbrProductTypeRepositoryCustomImpl implements NbrProductTypeRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrProductTypeMapper nbrProductTypeMapper;
    @Value("${table.numbering.product}")
    String tableName;
    @Override
    public List<String> findAllProduct() {
        try{
            String queryString = "Select DISTINCT PT_NAME From " + tableName;
            return entityManager.createNativeQuery(queryString,String.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
