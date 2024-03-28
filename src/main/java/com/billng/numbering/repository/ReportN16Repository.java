package com.billng.numbering.repository;

import com.billng.numbering.entities.ReportN16;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportN16Repository extends JpaRepository<ReportN16, String>, JpaSpecificationExecutor<ReportN16> {
}