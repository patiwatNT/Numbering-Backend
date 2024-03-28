package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;

@ApiModel()
public class ReportN13Dto extends AbstractDto<String> {
    @Size(max = 255)
    private String id;
    @Size(max = 255)
    private String blockId;
    @Size(max = 255)
    private String startTel;
    @Size(max = 255)
    private String endTel;
    @Size(max = 255)
    private String blockStatus;
    @Size(max = 255)
    private String reference;
    private BigInteger numberAmountAll;
    private BigInteger numberAmountAssigned;
    private BigInteger numberAmountActive;

    public ReportN13Dto() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getBlockId() {
        return this.blockId;
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

    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    public String getBlockStatus() {
        return this.blockStatus;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return this.reference;
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

    public void setNumberAmountActive(java.math.BigInteger numberAmountActive) {
        this.numberAmountActive = numberAmountActive;
    }

    public java.math.BigInteger getNumberAmountActive() {
        return this.numberAmountActive;
    }
}