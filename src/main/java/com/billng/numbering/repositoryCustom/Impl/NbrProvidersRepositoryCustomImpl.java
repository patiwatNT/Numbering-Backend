package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NbrProvidersDto;
import com.billng.numbering.entities.NbrProviders;
import com.billng.numbering.mapper.NbrProvidersMapper;
import com.billng.numbering.repositoryCustom.NbrProvidersRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class NbrProvidersRepositoryCustomImpl implements NbrProvidersRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrProvidersMapper nbrProvidersMapper;
    @Value("${table.numbering.provider}")
    String tableName;
    @Override
    public NbrProvidersDto findByProviderId(String id) {
        try {
            String query = "Select * From " + tableName + " Where provider_id = '" + id + "'";
            return nbrProvidersMapper.toDto((NbrProviders) entityManager.createNativeQuery(query, NbrProviders.class).getSingleResult());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
