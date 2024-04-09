package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NumberingRolePrivilegesDto;
import com.billng.numbering.entities.NumberingRolePrivileges;
import com.billng.numbering.mapper.NumberingRolePrivilegesMapper;
import com.billng.numbering.repositoryCustom.NumberingRolePrivilegesRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.List;

public class NumberingRolePrivilegesRepositoryCustomImpl implements NumberingRolePrivilegesRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NumberingRolePrivilegesMapper numberingRolePrivilegesMapper;
    @Value("${table.numbering.role.privilege}")
    String tableName;
    @Override
    public List<NumberingRolePrivilegesDto> findByRoleId(BigDecimal roleId) {
        String query = "SELECT * FROM " +tableName + " WHERE ROLE_ID = '" + roleId + "'";
        List<NumberingRolePrivilegesDto> numberingRolePrivilegesDtoList = numberingRolePrivilegesMapper.toDto(entityManager.createNativeQuery(query, NumberingRolePrivileges.class).getResultList());
        return numberingRolePrivilegesDtoList;
    }
}
