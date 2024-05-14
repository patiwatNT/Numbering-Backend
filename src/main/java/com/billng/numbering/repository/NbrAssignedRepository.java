package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrAssigned;
import com.billng.numbering.repositoryCustom.NbrAssignedRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrAssignedRepository extends JpaRepository<NbrAssigned, Integer>, JpaSpecificationExecutor<NbrAssigned> , NbrAssignedRepositoryCustom {
}