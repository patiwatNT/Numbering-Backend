package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrReport1000;
import com.billng.numbering.repositoryCustom.NbrReport1000RepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrReport1000Repository extends JpaRepository<NbrReport1000, String>, JpaSpecificationExecutor<NbrReport1000> , NbrReport1000RepositoryCustom {
}