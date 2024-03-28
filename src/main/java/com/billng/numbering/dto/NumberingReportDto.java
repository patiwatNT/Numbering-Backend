package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class NumberingReportDto extends AbstractDto<String> {
    @Size(max = 255)
    private String no;
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String description;

    public NumberingReportDto() {
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNo() {
        return this.no;
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