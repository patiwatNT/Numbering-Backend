package com.billng.numbering.dtoC;

import lombok.Data;

@Data
public class ServiceCenterTemp {
    private String locationCode;
    private String locationName;
    private String sector;

    public ServiceCenterTemp(String locationCode, String locationName, String sector) {
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.sector = sector;
    }
}
