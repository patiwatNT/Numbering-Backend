package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.AssignedRangeDto;
import com.billng.numbering.entities.AssignedRange;
import com.billng.numbering.mapper.AssignedRangeMapper;
import com.billng.numbering.repositoryCustom.AssignedRangeRepositoryCustom;
import com.billng.numbering.repositoryCustom.AssignedRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class AssignedRangeRepositoryCustomImpl implements AssignedRangeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private AssignedRangeMapper assignedRangeMapper;
    @Value("${table.assigned.range}")
    private String tableName;

    @Override
    public List<AssignedRangeDto> findByCriteria(String query) {
        try{
            String queryString = "SELECT * FROM "+ tableName + " WHERE " +query;
            return assignedRangeMapper.toDto(entityManager.createNativeQuery(queryString,AssignedRange.class).getResultList());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
