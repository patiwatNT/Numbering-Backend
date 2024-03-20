package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.AssignedRangeDetailDto;
import com.billng.numbering.entities.AssignedRangeDetail;
import com.billng.numbering.mapper.AssignedRangeDetailMapper;
import com.billng.numbering.repositoryCustom.AssignedRangeDetailRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class AssignedRangeDetailRepositoryCustomImpl implements AssignedRangeDetailRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    AssignedRangeDetailMapper assignedRangeDetailMapper;
    @Value("${table.assigned.range_detail}")
    String tableName;
    @Override
    public AssignedRangeDetailDto findByMainId(String id) {
        try{
            String query = "SELECT * FROM " + tableName + " WHERE ID = '" + id + "'";
            return assignedRangeDetailMapper.toDto((AssignedRangeDetail) entityManager.createNativeQuery(query,AssignedRangeDetail.class).getSingleResult());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
