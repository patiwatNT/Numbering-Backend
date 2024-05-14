package com.billng.numbering.dtoC;

import lombok.Data;

@Data
public class ReportN11InactiveAndInProgress {
    private String provider;
    private Integer providerId;
    private Integer blockStatus;
    private Integer qtyBlock;
    private Integer qtyNo;
    private Double qtyPay;


    public ReportN11InactiveAndInProgress(String provider,Integer providerId, Integer blockStatus, Integer qtyBlock, Integer qtyNo, Double qtyPay) {
        this.provider = provider;
        this.providerId = providerId;
        this.blockStatus = blockStatus;
        this.qtyBlock = qtyBlock;
        this.qtyNo = qtyNo;
        this.qtyPay = qtyPay;
    }
}
