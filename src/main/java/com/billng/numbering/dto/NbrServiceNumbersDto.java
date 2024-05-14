package com.billng.numbering.dto;

import com.billng.numbering.annotation.CheckDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.util.Date;

@ApiModel()
public class NbrServiceNumbersDto extends AbstractDto<String> {
    private long serialVersionUID;
    @Size(max = 255)
    private String serviceNo;
    @Size(max = 255)
    private String locationCode;
    @Max(Integer.MAX_VALUE)
    private Integer crmStatus;
    @CheckDate
    private Date crmLastModified;
    @Max(Integer.MAX_VALUE)
    private Integer rtsId;
    @Max(Integer.MAX_VALUE)
    private Integer assignedId;
    @Max(Integer.MAX_VALUE)
    private Integer blockId;
    @Max(Integer.MAX_VALUE)
    private Integer providerId;
    @Max(Integer.MAX_VALUE)
    private Integer productId;
    @Size(max = 255)
    private String modifiedBy;
    @CheckDate
    private Date lastModified;
    @Max(Integer.MAX_VALUE)
    private Integer unmatchedId;

    public NbrServiceNumbersDto() {
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getServiceNo() {
        return this.serviceNo;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationCode() {
        return this.locationCode;
    }

    public void setCrmStatus(Integer crmStatus) {
        this.crmStatus = crmStatus;
    }

    public Integer getCrmStatus() {
        return this.crmStatus;
    }

    public void setCrmLastModified(java.util.Date crmLastModified) {
        this.crmLastModified = crmLastModified;
    }

    public java.util.Date getCrmLastModified() {
        return this.crmLastModified;
    }

    public void setRtsId(Integer rtsId) {
        this.rtsId = rtsId;
    }

    public Integer getRtsId() {
        return this.rtsId;
    }

    public void setAssignedId(Integer assignedId) {
        this.assignedId = assignedId;
    }

    public Integer getAssignedId() {
        return this.assignedId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getBlockId() {
        return this.blockId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getProviderId() {
        return this.providerId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setLastModified(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public void setUnmatchedId(Integer unmatchedId) {
        this.unmatchedId = unmatchedId;
    }

    public Integer getUnmatchedId() {
        return this.unmatchedId;
    }
}