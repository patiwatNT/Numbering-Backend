package com.billng.numbering.dto;

import com.billng.numbering.annotation.CheckDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.util.Date;

@ApiModel()
public class ConfigCodeDto extends AbstractDto<String> {
    @Size(max = 255)
    private String id;
    @Size(max = 255)
    private String statusCode;
    @Size(max = 255)
    private String statusGroup;
    @Size(max = 255)
    private String statusDescription;
    @CheckDate
    private Date createDate;
    @Size(max = 255)
    private String createBy;
    @CheckDate
    private Date updateDate;
    @Size(max = 255)
    private String updateBy;

    public ConfigCodeDto() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusGroup(String statusGroup) {
        this.statusGroup = statusGroup;
    }

    public String getStatusGroup() {
        return this.statusGroup;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStatusDescription() {
        return this.statusDescription;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }
}