package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class NbrReport1000Dto extends AbstractDto<String> {
    private long serialVersionUID;
    private int blockId;
    @Size(max = 255)
    private String blockStart;
    @Size(max = 255)
    private String blockEnd;
    @Size(max = 255)
    private String blockArea;
    @Max(Integer.MAX_VALUE)
    private Integer qty;
    private Double amt;

    public NbrReport1000Dto() {
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getBlockId() {
        return this.blockId;
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

    public void setBlockArea(String blockArea) {
        this.blockArea = blockArea;
    }

    public String getBlockArea() {
        return this.blockArea;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    public Double getAmt() {
        return this.amt;
    }
}