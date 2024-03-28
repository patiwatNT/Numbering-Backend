package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;

@ApiModel()
public class ReportN11Dto extends AbstractDto<String> {
    @Size(max = 255)
    private String id;
    @Size(max = 255)
    private String provider;
    @Size(max = 255)
    private String blockStatus;
    private BigInteger blockAmount;
    private BigInteger numberAmountAll;
    private BigInteger numberAmountAssigned;
    private BigInteger numberAmountAssignedActive;
    private BigInteger numberAmountNotAssigned;
    private BigDecimal feeAmount;

    public ReportN11Dto() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    public String getBlockStatus() {
        return this.blockStatus;
    }

    public void setBlockAmount(java.math.BigInteger blockAmount) {
        this.blockAmount = blockAmount;
    }

    public java.math.BigInteger getBlockAmount() {
        return this.blockAmount;
    }

    public void setNumberAmountAll(java.math.BigInteger numberAmountAll) {
        this.numberAmountAll = numberAmountAll;
    }

    public java.math.BigInteger getNumberAmountAll() {
        return this.numberAmountAll;
    }

    public void setNumberAmountAssigned(java.math.BigInteger numberAmountAssigned) {
        this.numberAmountAssigned = numberAmountAssigned;
    }

    public java.math.BigInteger getNumberAmountAssigned() {
        return this.numberAmountAssigned;
    }

    public void setNumberAmountAssignedActive(java.math.BigInteger numberAmountAssignedActive) {
        this.numberAmountAssignedActive = numberAmountAssignedActive;
    }

    public java.math.BigInteger getNumberAmountAssignedActive() {
        return this.numberAmountAssignedActive;
    }

    public void setNumberAmountNotAssigned(java.math.BigInteger numberAmountNotAssigned) {
        this.numberAmountNotAssigned = numberAmountNotAssigned;
    }

    public java.math.BigInteger getNumberAmountNotAssigned() {
        return this.numberAmountNotAssigned;
    }

    public void setFeeAmount(java.math.BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public java.math.BigDecimal getFeeAmount() {
        return this.feeAmount;
    }
}