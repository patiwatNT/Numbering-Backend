package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@ApiModel()
public class NumberingLocationDto extends AbstractDto<BigDecimal> {
    private BigDecimal id;
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String value;
    @Size(max = 255)
    private String status;

    public NumberingLocationDto() {
    }

    public void setId(java.math.BigDecimal id) {
        this.id = id;
    }

    public java.math.BigDecimal getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}