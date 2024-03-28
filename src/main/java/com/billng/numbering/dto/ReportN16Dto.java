package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;

@ApiModel()
public class ReportN16Dto extends AbstractDto<String> {
    @Size(max = 255)
    private String id;
    @Size(max = 255)
    private String block;
    private BigInteger blockAmount;
    private BigInteger numberAmount;
    private BigInteger monthlyFee;
    private BigDecimal annualFee;

    public ReportN16Dto() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getBlock() {
        return this.block;
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

    public void setMonthlyFee(java.math.BigInteger monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public java.math.BigInteger getMonthlyFee() {
        return this.monthlyFee;
    }

    public void setAnnualFee(java.math.BigDecimal annualFee) {
        this.annualFee = annualFee;
    }

    public java.math.BigDecimal getAnnualFee() {
        return this.annualFee;
    }
}