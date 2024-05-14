package com.billng.numbering.repository;

import com.billng.numbering.entities.ReportN13;
import com.billng.numbering.repositoryCustom.ReportN13RepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportN13Repository extends JpaRepository<ReportN13, String>, JpaSpecificationExecutor<ReportN13> , ReportN13RepositoryCustom {
}