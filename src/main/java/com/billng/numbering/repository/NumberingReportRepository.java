package com.billng.numbering.repository;

import com.billng.numbering.entities.NumberingReport;
import com.billng.numbering.repositoryCustom.ReportN11RepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberingReportRepository extends JpaRepository<NumberingReport, String>, JpaSpecificationExecutor<NumberingReport> , ReportN11RepositoryCustom {
}