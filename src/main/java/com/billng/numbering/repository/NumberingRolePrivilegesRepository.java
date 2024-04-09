package com.billng.numbering.repository;

import com.billng.numbering.entities.NumberingRolePrivileges;
import com.billng.numbering.entities.NumberingRolePrivilegesPK;
import com.billng.numbering.repositoryCustom.Impl.NumberingRolePrivilegesRepositoryCustomImpl;
import com.billng.numbering.repositoryCustom.NumberingRolePrivilegesRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberingRolePrivilegesRepository extends JpaRepository<NumberingRolePrivileges, NumberingRolePrivilegesPK>, JpaSpecificationExecutor<NumberingRolePrivileges> , NumberingRolePrivilegesRepositoryCustom {
}