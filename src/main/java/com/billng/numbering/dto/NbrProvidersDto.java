package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class NbrProvidersDto extends AbstractDto<Integer> {
    private long serialVersionUID;
    @Max(Integer.MAX_VALUE)
    private Integer providerId;
    @Size(max = 255)
    private String providerName;
    @Size(max = 255)
    private String providerDesc;

    public NbrProvidersDto() {
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getProviderId() {
        return this.providerId;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderDesc(String providerDesc) {
        this.providerDesc = providerDesc;
    }

    public String getProviderDesc() {
        return this.providerDesc;
    }
}