package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrReportRepository extends JpaRepository<NbrReport, String>, JpaSpecificationExecutor<NbrReport> {
}