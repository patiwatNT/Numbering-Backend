package com.billng.numbering.repository;

import com.billng.numbering.entities.AssignedRange;
import com.billng.numbering.repositoryCustom.AssignedRangeRepositoryCustom;
import com.billng.numbering.repositoryCustom.AssignedRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AssignedRangeRepository extends JpaRepository<AssignedRange, BigDecimal>, JpaSpecificationExecutor<AssignedRange> , AssignedRangeRepositoryCustom {
}