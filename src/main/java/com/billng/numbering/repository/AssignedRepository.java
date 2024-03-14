package com.billng.numbering.repository;

import com.billng.numbering.entities.Assigned;
import com.billng.numbering.repositoryCustom.AssignedRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AssignedRepository extends JpaRepository<Assigned, BigDecimal>, JpaSpecificationExecutor<Assigned> , AssignedRepositoryCustom {
}