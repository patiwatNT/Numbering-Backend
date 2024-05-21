package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NbrServiceNumbersDto;
import com.billng.numbering.entities.NbrServiceNumbers;
import com.billng.numbering.mapper.NbrServiceNumbersMapper;
import com.billng.numbering.repositoryCustom.NbrServiceNumbersRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class NbrServiceNumbersRepositoryCustomImpl implements NbrServiceNumbersRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrServiceNumbersMapper nbrServiceNumbersMapper;
    @Value("${table.phone.info}")
    String tableName;
    @Override
    public NbrServiceNumbersDto findByServiceNumber(String serviceNumber) {
        try{
            String query = "SELECT * FROM " + tableName + " WHERE service_no = '" + serviceNumber + "'";
            return nbrServiceNumbersMapper.toDto((NbrServiceNumbers) entityManager.createNativeQuery(query, NbrServiceNumbers.class).getSingleResult());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NbrServiceNumbersDto> findByAssignedId(int assignedId) {
        try{
            String query = "SELECT * FROM " + tableName + " WHERE assigned_id = '" + assignedId + "'";
            return nbrServiceNumbersMapper.toDto(entityManager.createNativeQuery(query, NbrServiceNumbers.class).getResultList());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateServiceLocation(NbrServiceNumbersDto nbrServiceNumbersDto) {
        try{
            String serviceLocation = nbrServiceNumbersDto.getLocationCode();
            String phoneNumber = nbrServiceNumbersDto.getServiceNo();
            String updateBy = nbrServiceNumbersDto.getModifiedBy();
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String updateDate = now.format(formatter);
            String query = "UPDATE " + tableName + " SET location_code = '" + serviceLocation + "', modified_by = '" + updateBy + "', last_modified = '" + updateDate + "' WHERE service_no = '" + phoneNumber + "'";
            entityManager.createNativeQuery(query).executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<NbrServiceNumbersDto> findServiceNumberRange(String startTel, String endTel) {
        try{
            String query = "SELECT * FROM " + tableName + " WHERE service_no between " + startTel + " and " + endTel;
            return nbrServiceNumbersMapper.toDto(entityManager.createNativeQuery(query, NbrServiceNumbers.class).getResultList());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
