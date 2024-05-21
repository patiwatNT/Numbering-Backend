package com.billng.numbering.repository;

import com.billng.numbering.entities.NtStaff;
import com.billng.numbering.repositoryCustom.NtStaffRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NtStaffRepository extends JpaRepository<NtStaff, String>, JpaSpecificationExecutor<NtStaff>, NtStaffRepositoryCustom {
}