package com.billng.numbering.repository;

import com.billng.numbering.entities.ReportN15;
import com.billng.numbering.repositoryCustom.ReportN15RepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportN15Repository extends JpaRepository<ReportN15, String>, JpaSpecificationExecutor<ReportN15> , ReportN15RepositoryCustom {
}