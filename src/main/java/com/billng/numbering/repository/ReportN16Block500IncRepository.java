package com.billng.numbering.repository;

import com.billng.numbering.entities.ReportN16Block500Inc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportN16Block500IncRepository extends JpaRepository<ReportN16Block500Inc, String>, JpaSpecificationExecutor<ReportN16Block500Inc> {
}