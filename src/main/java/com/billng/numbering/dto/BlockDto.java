package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;

@ApiModel()
public class BlockDto extends AbstractDto<BigDecimal> {
    private BigDecimal blockId;
    @Size(max = 255)
    private String provide;
    private BigInteger blockAmount;
    private BigInteger numberAmount;
    private BigDecimal feeAmount;

    public BlockDto() {
    }

    public void setBlockId(java.math.BigDecimal blockId) {
        this.blockId = blockId;
    }

    public java.math.BigDecimal getBlockId() {
        return this.blockId;
    }

    public void setProvide(String provide) {
        this.provide = provide;
    }

    public String getProvide() {
        return this.provide;
    }

    public void setBlockAmount(java.math.BigInteger blockAmount) {
        this.blockAmount = blockAmount;
    }

    public java.math.BigInteger getBlockAmount() {
        return this.blockAmount;
    }

    public void setNumberAmount(java.math.BigInteger numberAmount) {
        this.numberAmount = numberAmount;
    }

    public java.math.BigInteger getNumberAmount() {
        return this.numberAmount;
    }

    public void setFeeAmount(java.math.BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public java.math.BigDecimal getFeeAmount() {
        return this.feeAmount;
    }
}