package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrReport100;
import com.billng.numbering.repositoryCustom.NbrReport100RepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrReport100Repository extends JpaRepository<NbrReport100, String>, JpaSpecificationExecutor<NbrReport100> , NbrReport100RepositoryCustom {
}