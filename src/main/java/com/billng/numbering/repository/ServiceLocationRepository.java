package com.billng.numbering.repository;

import com.billng.numbering.entities.ServiceLocation;
import com.billng.numbering.entities.ServiceLocationPK;
import com.billng.numbering.repositoryCustom.ServiceLocationRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceLocationRepository extends JpaRepository<ServiceLocation, ServiceLocationPK>, JpaSpecificationExecutor<ServiceLocation> , ServiceLocationRepositoryCustom {
}