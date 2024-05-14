package com.billng.numbering.repository;

import com.billng.numbering.entities.TOTServiceCenter;
import com.billng.numbering.repositoryCustom.TOTServiceCenterRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TOTServiceCenterRepository extends JpaRepository<TOTServiceCenter, String>, JpaSpecificationExecutor<TOTServiceCenter>, TOTServiceCenterRepositoryCustom {

}