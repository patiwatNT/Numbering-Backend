package com.billng.numbering.repository;

import com.billng.numbering.entities.BlockDetail;
import com.billng.numbering.repositoryCustom.BlockDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BlockDetailRepository extends JpaRepository<BlockDetail, BigDecimal>, JpaSpecificationExecutor<BlockDetail> , BlockDetailRepositoryCustom {
}