package com.billng.numbering.dto;

import com.billng.numbering.entities.NumberingRoles;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@ApiModel()
public class NumberingUsersDto extends AbstractDto<BigDecimal> {
    private BigDecimal userId;
    @Size(max = 255)
    private String username;
    @Size(max = 255)
    private String password;
    private NumberingRoles roleId;

    public NumberingUsersDto() {
    }

    public void setUserId(java.math.BigDecimal userId) {
        this.userId = userId;
    }

    public java.math.BigDecimal getUserId() {
        return this.userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setRoleId(NumberingRoles roleId) {
        this.roleId = roleId;
    }

    public NumberingRoles getRoleId() {
        return this.roleId;
    }
}