package com.billng.numbering.dto;

import com.billng.numbering.entities.NumberingRolePrivilegesPK;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class NumberingRolePrivilegesDto extends AbstractDto<NumberingRolePrivilegesPK> {
    private NumberingRolePrivilegesPK numberingRolePrivilegesPK;
    @Size(max = 255)
    private String accessRights;

    public NumberingRolePrivilegesDto() {
    }

    public void setNumberingRolePrivilegesPK(NumberingRolePrivilegesPK numberingRolePrivilegesPK) {
        this.numberingRolePrivilegesPK = numberingRolePrivilegesPK;
    }

    public NumberingRolePrivilegesPK getNumberingRolePrivilegesPK() {
        return this.numberingRolePrivilegesPK;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    public String getAccessRights() {
        return this.accessRights;
    }
}