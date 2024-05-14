package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrBlocks;
import com.billng.numbering.repositoryCustom.NbrBlocksRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrBlocksRepository extends JpaRepository<NbrBlocks, Integer>, JpaSpecificationExecutor<NbrBlocks> , NbrBlocksRepositoryCustom {
}