package com.billng.numbering.dto;

import com.billng.numbering.annotation.CheckDate;
import com.billng.numbering.entities.PhoneDetailPK;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.util.Date;

@ApiModel()
public class PhoneDetailDto extends AbstractDto<PhoneDetailPK> {
    private PhoneDetailPK phoneDetailPK;
    @Size(max = 255)
    private String phoneNumber;
    @Size(max = 255)
    private String serviceLocation;
    @Size(max = 255)
    private String crmStatus;
    @CheckDate
    private Date updateDate;
    @Size(max = 255)
    private String updateBy;

    public PhoneDetailDto() {
    }

    public void setPhoneDetailPK(PhoneDetailPK phoneDetailPK) {
        this.phoneDetailPK = phoneDetailPK;
    }

    public PhoneDetailPK getPhoneDetailPK() {
        return this.phoneDetailPK;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public String getServiceLocation() {
        return this.serviceLocation;
    }

    public void setCrmStatus(String crmStatus) {
        this.crmStatus = crmStatus;
    }

    public String getCrmStatus() {
        return this.crmStatus;
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