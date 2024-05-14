package com.billng.numbering.repository;

import com.billng.numbering.entities.ReportN11;
import com.billng.numbering.repositoryCustom.ReportN11RepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportN11Repository extends JpaRepository<ReportN11, String>, JpaSpecificationExecutor<ReportN11> , ReportN11RepositoryCustom {
}