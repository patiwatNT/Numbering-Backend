package com.billng.numbering.dtoC;

import lombok.Data;

@Data
public class NbrReportN15 {
    private String region;
    private String department;
    private String sector;
    private String locationCode;
    private String locationAbbr;
    private Integer qtyAssigned;
    private Integer qtyActive;
    private Integer qtyEmpty;
    private Integer percentUtl;

    public NbrReportN15(String region, String department, String sector, String locationCode, String locationAbbr, Integer qtyAssigned, Integer qtyActive, Integer qtyEmpty, Integer percentUtl) {
        this.region = region;
        this.department = department;
        this.sector = sector;
        this.locationCode = locationCode;
        this.locationAbbr = locationAbbr;
        this.qtyAssigned = qtyAssigned;
        this.qtyActive = qtyActive;
        this.qtyEmpty = qtyEmpty;
        this.percentUtl = percentUtl;
    }
}
