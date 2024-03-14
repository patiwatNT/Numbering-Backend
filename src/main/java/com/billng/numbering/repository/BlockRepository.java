package com.billng.numbering.repository;

import com.billng.numbering.entities.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BlockRepository extends JpaRepository<Block, BigDecimal>, JpaSpecificationExecutor<Block> {
}