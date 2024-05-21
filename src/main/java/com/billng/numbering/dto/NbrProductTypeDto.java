package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class NbrProductTypeDto extends AbstractDto<Integer> {
    private long serialVersionUID;
    @Max(Integer.MAX_VALUE)
    private Integer ptId;
    @Size(max = 255)
    private String pTName;
    @Size(max = 255)
    private String ptCrm;
    @Size(max = 255)
    private String mainProductId;
    @Size(max = 255)
    private String mainProductName;
    @Size(max = 255)
    private String productId;
    @Size(max = 255)
    private String productName;

    public NbrProductTypeDto() {
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    public Integer getPtId() {
        return this.ptId;
    }

    public void setPTName(String pTName) {
        this.pTName = pTName;
    }

    public String getPTName() {
        return this.pTName;
    }

    public void setPtCrm(String ptCrm) {
        this.ptCrm = ptCrm;
    }

    public String getPtCrm() {
        return this.ptCrm;
    }

    public void setMainProductId(String mainProductId) {
        this.mainProductId = mainProductId;
    }

    public String getMainProductId() {
        return this.mainProductId;
    }

    public void setMainProductName(String mainProductName) {
        this.mainProductName = mainProductName;
    }

    public String getMainProductName() {
        return this.mainProductName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }
}