package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;

@ApiModel()
public class BlockDetailDto extends AbstractDto<BigDecimal> {
    private BigDecimal no;
    @Size(max = 255)
    private String blockStart;
    @Size(max = 255)
    private String blockEnd;
    private BigInteger amount;
    @Size(max = 255)
    private String provider;
    @Size(max = 255)
    private String location;
    @Size(max = 255)
    private String blockStatus;
    @Size(max = 255)
    private String actionStatus;

    public BlockDetailDto() {
    }

    public void setNo(java.math.BigDecimal no) {
        this.no = no;
    }

    public java.math.BigDecimal getNo() {
        return this.no;
    }

    public void setBlockStart(String blockStart) {
        this.blockStart = blockStart;
    }

    public String getBlockStart() {
        return this.blockStart;
    }

    public void setBlockEnd(String blockEnd) {
        this.blockEnd = blockEnd;
    }

    public String getBlockEnd() {
        return this.blockEnd;
    }

    public void setAmount(java.math.BigInteger amount) {
        this.amount = amount;
    }

    public java.math.BigInteger getAmount() {
        return this.amount;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    public String getBlockStatus() {
        return this.blockStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public String getActionStatus() {
        return this.actionStatus;
    }
}