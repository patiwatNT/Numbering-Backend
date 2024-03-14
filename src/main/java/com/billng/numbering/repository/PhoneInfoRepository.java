package com.billng.numbering.repository;

import com.billng.numbering.entities.PhoneInfo;
import com.billng.numbering.repositoryCustom.PhoneInfoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneInfoRepository extends JpaRepository<PhoneInfo, String>, JpaSpecificationExecutor<PhoneInfo> , PhoneInfoRepositoryCustom {
}