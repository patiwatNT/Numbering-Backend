package com.billng.numbering.dtoC;

import lombok.Data;

@Data
public class ReportN11Active {
    private Integer providerId;
    private String provider;
    private Integer blockStatus;
    private Integer qtyBlock;
    private Integer qtyNo;
    private Double qtyPay;
    private Integer qtyAssigned;
    private Integer qtyActive;
    private Integer qtyActiveAssigned;

    public ReportN11Active(Integer providerId, String provider, Integer blockStatus, Integer qtyBlock, Integer qtyNo, Double qtyPay, Integer qtyAssigned, Integer qtyActive, Integer qtyActiveAssigned) {
        this.providerId = providerId;
        this.provider = provider;
        this.blockStatus = blockStatus;
        this.qtyBlock = qtyBlock;
        this.qtyNo = qtyNo;
        this.qtyPay = qtyPay;
        this.qtyAssigned = qtyAssigned;
        this.qtyActive = qtyActive;
        this.qtyActiveAssigned = qtyActiveAssigned;
    }
}
