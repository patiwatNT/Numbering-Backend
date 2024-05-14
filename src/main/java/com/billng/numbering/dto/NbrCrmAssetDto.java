package com.billng.numbering.dto;

import com.billng.numbering.annotation.CheckDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.util.Date;

@ApiModel()
public class NbrCrmAssetDto extends AbstractDto<String> {
    @Size(max = 255)
    private String telno;
    @Max(Integer.MAX_VALUE)
    private Integer telnoStatus;
    @Size(max = 255)
    private String locationCode;
    @CheckDate
    private Date modifiedOn;
    @Size(max = 255)
    private String productType;

    public NbrCrmAssetDto() {
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getTelno() {
        return this.telno;
    }

    public void setTelnoStatus(Integer telnoStatus) {
        this.telnoStatus = telnoStatus;
    }

    public Integer getTelnoStatus() {
        return this.telnoStatus;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationCode() {
        return this.locationCode;
    }

    public void setModifiedOn(java.util.Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public java.util.Date getModifiedOn() {
        return this.modifiedOn;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return this.productType;
    }
}