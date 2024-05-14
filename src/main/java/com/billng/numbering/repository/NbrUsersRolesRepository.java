package com.billng.numbering.repository;

import com.billng.numbering.entities.NbrUsersRoles;
import com.billng.numbering.repositoryCustom.NbrUsersRolesRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NbrUsersRolesRepository extends JpaRepository<NbrUsersRoles, String>, JpaSpecificationExecutor<NbrUsersRoles> , NbrUsersRolesRepositoryCustom {
}