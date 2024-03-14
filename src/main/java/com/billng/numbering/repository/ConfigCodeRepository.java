package com.billng.numbering.repository;

import com.billng.numbering.entities.ConfigCode;
import com.billng.numbering.repositoryCustom.ConfigCodeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigCodeRepository extends JpaRepository<ConfigCode, String>, JpaSpecificationExecutor<ConfigCode> , ConfigCodeRepositoryCustom {
}