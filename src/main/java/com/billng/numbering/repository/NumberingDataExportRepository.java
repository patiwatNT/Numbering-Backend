package com.billng.numbering.repository;

import com.billng.numbering.entities.NumberingDataExport;
import com.billng.numbering.repositoryCustom.NumberingDataExportRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberingDataExportRepository extends JpaRepository<NumberingDataExport, String>, JpaSpecificationExecutor<NumberingDataExport> , NumberingDataExportRepositoryCustom {
}