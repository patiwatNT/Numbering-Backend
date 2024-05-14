package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NbrUsersRolesDto;

public interface NbrUsersRolesRepositoryCustom {
    NbrUsersRolesDto findByEmpId(String empId);
}
