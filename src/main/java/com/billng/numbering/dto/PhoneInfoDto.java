package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class PhoneInfoDto extends AbstractDto<String> {
    @Size(max = 255)
    private String phone;
    @Size(max = 255)
    private String serviceLocation;
    @Size(max = 255)
    private String crmStatus;
    @Size(max = 255)
    private String provider;
    @Size(max = 255)
    private String block;
    @Size(max = 255)
    private String assigned;
    @Size(max = 255)
    private String lastestBy;

    public PhoneInfoDto() {
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
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

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getBlock() {
        return this.block;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getAssigned() {
        return this.assigned;
    }

    public void setLastestBy(String lastestBy) {
        this.lastestBy = lastestBy;
    }

    public String getLastestBy() {
        return this.lastestBy;
    }
}