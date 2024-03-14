package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@ApiModel()
public class DivisionDto extends AbstractDto<BigDecimal> {
    private BigDecimal id;
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String description;

    public DivisionDto() {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}