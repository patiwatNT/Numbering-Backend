package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NtStaffDto;

public interface NtStaffRepositoryCustom {
    NtStaffDto findByEmpCode(String empCode);
}
