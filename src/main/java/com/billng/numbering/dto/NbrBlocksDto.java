package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class NbrBlocksDto extends AbstractDto<Integer> {
    private long serialVersionUID;
    @Max(Integer.MAX_VALUE)
    private Integer blockId;
    @Size(max = 255)
    private String blockStart;
    @Size(max = 255)
    private String blockEnd;
    @Size(max = 255)
    private String blockRange;
    @Max(Integer.MAX_VALUE)
    private Integer providerId;
    @Size(max = 255)
    private String provider;
    @Size(max = 255)
    private String xBlockArea;
    @Size(max = 255)
    private String xBlockSector;
    @Max(Integer.MAX_VALUE)
    private Integer blockAmount;
    @Max(Integer.MAX_VALUE)
    private Integer blockStatus;
    @Size(max = 255)
    private String docRef;
    @Size(max = 255)
    private String endDate;
    private Double blockFee;
    private Double blockPayable;
    @Size(max = 255)
    private String blockSector;
    @Size(max = 255)
    private String nDepartment;
    @Size(max = 255)
    private String blockArea;
    @Size(max = 255)
    private String nWorkArea;

    public NbrBlocksDto() {
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getBlockId() {
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

    public void setBlockRange(String blockRange) {
        this.blockRange = blockRange;
    }

    public String getBlockRange() {
        return this.blockRange;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getProviderId() {
        return this.providerId;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setXBlockArea(String xBlockArea) {
        this.xBlockArea = xBlockArea;
    }

    public String getXBlockArea() {
        return this.xBlockArea;
    }

    public void setXBlockSector(String xBlockSector) {
        this.xBlockSector = xBlockSector;
    }

    public String getXBlockSector() {
        return this.xBlockSector;
    }

    public void setBlockAmount(Integer blockAmount) {
        this.blockAmount = blockAmount;
    }

    public Integer getBlockAmount() {
        return this.blockAmount;
    }

    public void setBlockStatus(Integer blockStatus) {
        this.blockStatus = blockStatus;
    }

    public Integer getBlockStatus() {
        return this.blockStatus;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public String getDocRef() {
        return this.docRef;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setBlockFee(Double blockFee) {
        this.blockFee = blockFee;
    }

    public Double getBlockFee() {
        return this.blockFee;
    }

    public void setBlockPayable(Double blockPayable) {
        this.blockPayable = blockPayable;
    }

    public Double getBlockPayable() {
        return this.blockPayable;
    }

    public void setBlockSector(String blockSector) {
        this.blockSector = blockSector;
    }

    public String getBlockSector() {
        return this.blockSector;
    }

    public void setNDepartment(String nDepartment) {
        this.nDepartment = nDepartment;
    }

    public String getNDepartment() {
        return this.nDepartment;
    }

    public void setBlockArea(String blockArea) {
        this.blockArea = blockArea;
    }

    public String getBlockArea() {
        return this.blockArea;
    }

    public void setNWorkArea(String nWorkArea) {
        this.nWorkArea = nWorkArea;
    }

    public String getNWorkArea() {
        return this.nWorkArea;
    }
}