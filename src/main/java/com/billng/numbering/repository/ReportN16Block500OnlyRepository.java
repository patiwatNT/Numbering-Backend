package com.billng.numbering.repository;

import com.billng.numbering.entities.ReportN16Block500Only;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportN16Block500OnlyRepository extends JpaRepository<ReportN16Block500Only, String>, JpaSpecificationExecutor<ReportN16Block500Only> {
}