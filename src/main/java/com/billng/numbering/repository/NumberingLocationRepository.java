package com.billng.numbering.repository;

import com.billng.numbering.entities.NumberingLocation;
import com.billng.numbering.repositoryCustom.NumberingLocationRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface NumberingLocationRepository extends JpaRepository<NumberingLocation, BigDecimal>, JpaSpecificationExecutor<NumberingLocation> , NumberingLocationRepositoryCustom {
}