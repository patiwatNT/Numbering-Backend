package com.billng.numbering.repository;

import com.billng.numbering.entities.NumberingRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface NumberingRolesRepository extends JpaRepository<NumberingRoles, BigDecimal>, JpaSpecificationExecutor<NumberingRoles> {
}