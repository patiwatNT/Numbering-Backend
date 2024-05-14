package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrReport500;
import com.billng.numbering.repositoryCustom.NbrReport500RepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrReport500Repository extends JpaRepository<NbrReport500, String>, JpaSpecificationExecutor<NbrReport500> , NbrReport500RepositoryCustom {
}