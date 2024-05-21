package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NtStaffDto;
import com.billng.numbering.entities.News;
import com.billng.numbering.entities.NtStaff;
import com.billng.numbering.mapper.NewsMapper;
import com.billng.numbering.mapper.NtStaffMapper;
import com.billng.numbering.repositoryCustom.NtStaffRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class NtStaffRepositoryCustomImpl implements NtStaffRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private NtStaffMapper ntStaffMapper;

    @Value("${table.nt.staff}")
    private String tableName;
    @Override
    public NtStaffDto findByEmpCode(String empCode) {
        try {
            String queryString = "SELECT * FROM " + tableName + " WHERE empcode = '" + empCode + "'";
            return ntStaffMapper.toDto((NtStaff) entityManager.createNativeQuery(queryString, NtStaff.class).getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
