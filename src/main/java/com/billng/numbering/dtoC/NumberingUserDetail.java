package com.billng.numbering.dtoC;

import com.billng.numbering.dto.NumberingRolePrivilegesDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class NumberingUserDetail {
    private String username;
    private BigDecimal roleId;
    private List<NumberingUserPrivilege> numberingUserPrivilegeList;
}
