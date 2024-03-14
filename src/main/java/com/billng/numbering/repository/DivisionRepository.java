package com.billng.numbering.repository;

import com.billng.numbering.entities.Division;
import com.billng.numbering.repositoryCustom.DivisionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DivisionRepository extends JpaRepository<Division, BigDecimal>, JpaSpecificationExecutor<Division> , DivisionRepositoryCustom {
}