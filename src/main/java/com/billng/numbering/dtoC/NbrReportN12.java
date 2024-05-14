package com.billng.numbering.dtoC;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NbrReportN12 {
    private Integer blockId;
    private String blockStart;
    private String blockEnd;
    private Integer blockStatus;
    private Integer qtyNo;
    private Integer qtyAssigned;
    private Integer qtyActive;
    private BigDecimal rsvId;
    private String rsvStatus;

    public NbrReportN12(Integer blockId, String blockStart, String blockEnd, Integer blockStatus, Integer qtyNo, Integer qtyAssigned, Integer qtyActive, BigDecimal rsvId, String rsvStatus) {
        this.blockId = blockId;
        this.blockStart = blockStart;
        this.blockEnd = blockEnd;
        this.blockStatus = blockStatus;
        this.qtyNo = qtyNo;
        this.qtyAssigned = qtyAssigned;
        this.qtyActive = qtyActive;
        this.rsvId = rsvId;
        this.rsvStatus = rsvStatus;
    }
}
