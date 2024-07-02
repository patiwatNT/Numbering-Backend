package com.billng.numbering.dtoC;

import lombok.Data;

@Data
public class DataExport {
    private String serviceNo;
    private String exchNameEN;
    private String exchNameThai;
    private String serviceLocation;

    public DataExport(String serviceNo, String exchNameEN, String exchNameThai, String serviceLocation) {
        this.serviceNo = serviceNo;
        this.exchNameEN = exchNameEN;
        this.exchNameThai = exchNameThai;
        this.serviceLocation = serviceLocation;
    }
}
