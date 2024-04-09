package com.billng.numbering.dto;

import com.billng.numbering.entities.NumberingUsers;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Collection;

@ApiModel()
public class NumberingRolesDto extends AbstractDto<BigDecimal> {
    private BigDecimal roleId;
    @Size(max = 255)
    private String roleName;
    private Collection<NumberingUsers> numberingUsersCollection;

    public NumberingRolesDto() {
    }

    public void setRoleId(java.math.BigDecimal roleId) {
        this.roleId = roleId;
    }

    public java.math.BigDecimal getRoleId() {
        return this.roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setNumberingUsersCollection(java.util.Collection<com.billng.numbering.entities.NumberingUsers> numberingUsersCollection) {
        this.numberingUsersCollection = numberingUsersCollection;
    }

    public java.util.Collection<com.billng.numbering.entities.NumberingUsers> getNumberingUsersCollection() {
        return this.numberingUsersCollection;
    }
}