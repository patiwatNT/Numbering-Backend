package com.billng.numbering.repository;

import com.billng.numbering.entities.PhoneDetail;
import com.billng.numbering.entities.PhoneDetailPK;
import com.billng.numbering.repositoryCustom.PhoneDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneDetailRepository extends JpaRepository<PhoneDetail, PhoneDetailPK>, JpaSpecificationExecutor<PhoneDetail> , PhoneDetailRepositoryCustom {
}