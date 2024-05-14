package com.billng.numbering.dtoC;

import lombok.Data;

@Data
public class NbrReportN13 {
    private Integer blockId;
    private String blockStart;
    private String blockEnd;
    private String docRef;
    private Integer blockStatus;
    private Integer qtyNo;
    private Integer qtyAssigned;
    private Integer qtyActive;

    public NbrReportN13(Integer blockId, String blockStart, String blockEnd, String docRef, Integer blockStatus, Integer qtyNo, Integer qtyAssigned, Integer qtyActive) {
        this.blockId = blockId;
        this.blockStart = blockStart;
        this.blockEnd = blockEnd;
        this.docRef = docRef;
        this.blockStatus = blockStatus;
        this.qtyNo = qtyNo;
        this.qtyAssigned = qtyAssigned;
        this.qtyActive = qtyActive;
    }
}
