package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.PhoneInfoDto;
import com.billng.numbering.entities.PhoneInfo;
import com.billng.numbering.mapper.PhoneInfoMapper;
import com.billng.numbering.repositoryCustom.PhoneInfoRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class PhoneInfoRepositoryCustomImpl implements PhoneInfoRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PhoneInfoMapper phoneInfoMapper;
    @Value("${table.phone.info}")
    private String tableName;
    @Override
    public PhoneInfoDto findByIdCustom(String id) {
        try {
            String queryString = "SELECT * FROM " + tableName + " WHERE PHONE = '" + id +"'";
            return phoneInfoMapper.toDto((PhoneInfo) entityManager.createNativeQuery(queryString, PhoneInfo.class).getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
