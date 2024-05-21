package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrProductType;
import com.billng.numbering.repositoryCustom.NbrProductTypeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrProductTypeRepository extends JpaRepository<NbrProductType, Integer>, JpaSpecificationExecutor<NbrProductType>, NbrProductTypeRepositoryCustom {
}