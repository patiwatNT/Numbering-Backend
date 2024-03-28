package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.PhoneDetailDto;
import com.billng.numbering.entities.PhoneDetail;
import com.billng.numbering.mapper.PhoneDetailMapper;
import com.billng.numbering.repositoryCustom.PhoneDetailRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class PhoneDetailRepositoryCustomImpl implements PhoneDetailRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    PhoneDetailMapper phoneDetailMapper;
    @Value("${table.assigned.phone_detail}")
    String tableName;
    @Override
    public List<PhoneDetailDto> findByAssignRangeId(String assignRangeId) {
        try {
            String query = "SELECT * FROM " + tableName + " WHERE ASSIGN_RANGE_ID = '" + assignRangeId + "'";
            return phoneDetailMapper.toDto(entityManager.createNativeQuery(query, PhoneDetail.class).getResultList());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateServiceLocation(PhoneDetailDto phoneDetailDto) {
        try{
            String serviceLocation = phoneDetailDto.getServiceLocation();
            String phoneNumber = phoneDetailDto.getPhoneNumber();
            String query = "UPDATE " + tableName + " SET SERVICE_LOCATION = '"+serviceLocation+"' WHERE PHONE_NUMBER = '" + phoneNumber + "'";
            entityManager.createNativeQuery(query).executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
