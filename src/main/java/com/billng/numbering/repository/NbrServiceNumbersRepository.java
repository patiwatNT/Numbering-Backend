package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrServiceNumbers;
import com.billng.numbering.repositoryCustom.NbrServiceNumbersRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrServiceNumbersRepository extends JpaRepository<NbrServiceNumbers, String>, JpaSpecificationExecutor<NbrServiceNumbers>, NbrServiceNumbersRepositoryCustom {
}