package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.ConfigCodeDto;
import com.billng.numbering.entities.ConfigCode;
import com.billng.numbering.mapper.ConfigCodeMapper;
import com.billng.numbering.repositoryCustom.ConfigCodeRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class ConfigCodeRepositoryCustomImpl implements ConfigCodeRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    ConfigCodeMapper configCodeMapper;
    @Value("${table.code.config}")
    String tableName;
    @Override
    public List<ConfigCodeDto> findByStatusGroup(String statusGroup) {
        try{
            String query = "SELECT * FROM " + tableName + " WHERE STATUS_GROUP = '" + statusGroup + "'";
            return configCodeMapper.toDto(entityManager.createNativeQuery(query, ConfigCode.class).getResultList());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
