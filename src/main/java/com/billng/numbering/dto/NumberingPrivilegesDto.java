package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;

@ApiModel()
public class NumberingPrivilegesDto extends AbstractDto<BigDecimal> {
    private BigInteger privilegeId;
    @Size(max = 255)
    private String privilegeName;
    @Size(max = 255)
    private String privilegeDescription;

    public NumberingPrivilegesDto() {
    }

    public void setPrivilegeId(BigInteger privilegeId) {
        this.privilegeId = privilegeId;
    }

    public BigInteger getPrivilegeId() {
        return this.privilegeId;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeName() {
        return this.privilegeName;
    }

    public void setPrivilegeDescription(String privilegeDescription) {
        this.privilegeDescription = privilegeDescription;
    }

    public String getPrivilegeDescription() {
        return this.privilegeDescription;
    }
}