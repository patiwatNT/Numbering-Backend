package com.billng.numbering.repository;

import com.billng.numbering.entities.ReportN16Block1000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportN16Block1000Repository extends JpaRepository<ReportN16Block1000, String>, JpaSpecificationExecutor<ReportN16Block1000> {
}