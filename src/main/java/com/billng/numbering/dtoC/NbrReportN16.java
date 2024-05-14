package com.billng.numbering.dtoC;

import lombok.Data;

@Data
public class NbrReportN16 {
    private String block;
    private Integer qtyRange;
    private Integer qty;
    private Double amt;
    private Double amtYearly;

    public NbrReportN16(String block, Integer qtyRange, Integer qty, Double amt, Double amtYearly) {
        this.block = block;
        this.qtyRange = qtyRange;
        this.qty = qty;
        this.amt = amt;
        this.amtYearly = amtYearly;
    }
}
