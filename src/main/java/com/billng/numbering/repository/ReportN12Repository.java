package com.billng.numbering.repository;

import com.billng.numbering.entities.ReportN12;
import com.billng.numbering.repositoryCustom.ReportN12RepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportN12Repository extends JpaRepository<ReportN12, String>, JpaSpecificationExecutor<ReportN12> , ReportN12RepositoryCustom {
}