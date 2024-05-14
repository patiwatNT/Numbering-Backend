package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrProviders;
import com.billng.numbering.repositoryCustom.NbrProvidersRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrProvidersRepository extends JpaRepository<NbrProviders, Integer>, JpaSpecificationExecutor<NbrProviders> , NbrProvidersRepositoryCustom {
}