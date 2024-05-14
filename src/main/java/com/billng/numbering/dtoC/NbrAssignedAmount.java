package com.billng.numbering.dtoC;

import lombok.Data;

@Data
public class NbrAssignedAmount {
    private Integer assignedId;
    private Integer qty;
    private Integer okLocation;
    private Integer noLocation;

    public NbrAssignedAmount(Integer assignedId,Integer qty,Integer okLocation,Integer noLocation){
        this.assignedId = assignedId;
        this.qty = qty;
        this.okLocation = okLocation;
        this.noLocation = noLocation;
    }
}
