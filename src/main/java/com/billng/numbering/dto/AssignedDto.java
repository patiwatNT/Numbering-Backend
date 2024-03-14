package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;

@ApiModel()
public class AssignedDto extends AbstractDto<BigDecimal> {
    private BigDecimal no;
    @Size(max = 255)
    private String provider;
    @Size(max = 255)
    private String providerDescription;
    private BigInteger rangeAmount;
    private BigInteger telAmount;

    public AssignedDto() {
    }

    public void setNo(java.math.BigDecimal no) {
        this.no = no;
    }

    public java.math.BigDecimal getNo() {
        return this.no;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProviderDescription(String providerDescription) {
        this.providerDescription = providerDescription;
    }

    public String getProviderDescription() {
        return this.providerDescription;
    }

    public void setRangeAmount(java.math.BigInteger rangeAmount) {
        this.rangeAmount = rangeAmount;
    }

    public java.math.BigInteger getRangeAmount() {
        return this.rangeAmount;
    }

    public void setTelAmount(java.math.BigInteger telAmount) {
        this.telAmount = telAmount;
    }

    public java.math.BigInteger getTelAmount() {
        return this.telAmount;
    }
}