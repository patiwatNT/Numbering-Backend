package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrRolesRepository extends JpaRepository<NbrRoles, Integer>, JpaSpecificationExecutor<NbrRoles> {
}