package com.billng.numbering.repository;

import com.billng.numbering.entities.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, String>, JpaSpecificationExecutor<ServiceCenter> {
}