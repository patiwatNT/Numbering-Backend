package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NbrUsersRolesDto;
import com.billng.numbering.entities.NbrUsersRoles;
import com.billng.numbering.mapper.NbrUsersRolesMapper;
import com.billng.numbering.repositoryCustom.NbrUsersRolesRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class NbrUsersRolesRepositoryCustomImpl implements NbrUsersRolesRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrUsersRolesMapper nbrUsersRolesMapper;
    @Value("${table.numbering.users}")
    String tableName;
    @Override
    public NbrUsersRolesDto findByEmpId(String empId) {
        try{
            String query = "SELECT * FROM " + tableName + " WHERE emp_id = '" + empId + "'";
            return nbrUsersRolesMapper.toDto((NbrUsersRoles) entityManager.createNativeQuery(query, NbrUsersRoles.class).getSingleResult());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
