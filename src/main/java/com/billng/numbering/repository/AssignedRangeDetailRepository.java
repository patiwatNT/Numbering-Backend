package com.billng.numbering.repository;

import com.billng.numbering.entities.AssignedRangeDetail;
import com.billng.numbering.entities.AssignedRangeDetailPK;
import com.billng.numbering.repositoryCustom.AssignedRangeDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedRangeDetailRepository extends JpaRepository<AssignedRangeDetail, AssignedRangeDetailPK>, JpaSpecificationExecutor<AssignedRangeDetail> , AssignedRangeDetailRepositoryCustom {
}