package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrCrmAsset;
import com.billng.numbering.repositoryCustom.NbrCrmAssetRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrCrmAssetRepository extends JpaRepository<NbrCrmAsset, String>, JpaSpecificationExecutor<NbrCrmAsset>, NbrCrmAssetRepositoryCustom {
}