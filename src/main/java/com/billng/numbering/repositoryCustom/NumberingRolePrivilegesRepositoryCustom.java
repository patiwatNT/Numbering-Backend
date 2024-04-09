package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NumberingRolePrivilegesDto;

import java.math.BigDecimal;
import java.util.List;

public interface NumberingRolePrivilegesRepositoryCustom {
    List<NumberingRolePrivilegesDto> findByRoleId(BigDecimal roleId);
}
