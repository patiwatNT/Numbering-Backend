package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;

@ApiModel()
public class ReportN16Block100OnlyDto extends AbstractDto<String> {
    @Size(max = 255)
    private String id;
    @Size(max = 255)
    private String blockRange;
    @Size(max = 255)
    private String startTel;
    @Size(max = 255)
    private String endTel;
    @Size(max = 255)
    private String location;
    private BigInteger numberAmount;
    private BigInteger annualFee;

    public ReportN16Block100OnlyDto() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setBlockRange(String blockRange) {
        this.blockRange = blockRange;
    }

    public String getBlockRange() {
        return this.blockRange;
    }

    public void setStartTel(String startTel) {
        this.startTel = startTel;
    }

    public String getStartTel() {
        return this.startTel;
    }

    public void setEndTel(String endTel) {
        this.endTel = endTel;
    }

    public String getEndTel() {
        return this.endTel;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setNumberAmount(java.math.BigInteger numberAmount) {
        this.numberAmount = numberAmount;
    }

    public java.math.BigInteger getNumberAmount() {
        return this.numberAmount;
    }

    public void setAnnualFee(java.math.BigInteger annualFee) {
        this.annualFee = annualFee;
    }

    public java.math.BigInteger getAnnualFee() {
        return this.annualFee;
    }
}