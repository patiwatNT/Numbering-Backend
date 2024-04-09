package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NumberingUsersDto;
import com.billng.numbering.entities.NumberingUsers;
import com.billng.numbering.mapper.NumberingUsersMapper;
import com.billng.numbering.repositoryCustom.NumberingUsersRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class NumberingUsersRepositoryCustomImpl implements NumberingUsersRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NumberingUsersMapper numberingUsersMapper;
    @Value("${table.numbering.users}")
    String tableName;
    @Override
    public NumberingUsersDto findByUsername(String username) {
        try {
            String query = "SELECT * FROM " + tableName + " WHERE USERNAME = '" + username + "'";
            return numberingUsersMapper.toDto((NumberingUsers) entityManager.createNativeQuery(query, NumberingUsers.class).getSingleResult());
        }catch (Exception e){
           e.printStackTrace();
            return null;
        }
    }
}
