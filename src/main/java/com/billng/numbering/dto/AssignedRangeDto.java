package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;

@ApiModel()
public class AssignedRangeDto extends AbstractDto<BigDecimal> {
    private BigDecimal no;
    @Size(max = 255)
    private String stationCode;
    @Size(max = 255)
    private String stationName;
    @Size(max = 255)
    private String startTel;
    @Size(max = 255)
    private String endTel;
    private BigInteger telAmount;
    private BigInteger assignedLocation;
    private BigInteger unassginedLocation;
    @Size(max = 255)
    private String provider;
    @Size(max = 255)
    private String location;

    public AssignedRangeDto() {
    }

    public void setNo(java.math.BigDecimal no) {
        this.no = no;
    }

    public java.math.BigDecimal getNo() {
        return this.no;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationCode() {
        return this.stationCode;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setStartTel(String startTel) {
        this.startTel = startTel;
    }

    public String getStartTel() {
        return this.startTel;
    }

    public void setEndTel(String endTel) {
        this.endTel = endTel;
    }

    public String getEndTel() {
        return this.endTel;
    }

    public void setTelAmount(java.math.BigInteger telAmount) {
        this.telAmount = telAmount;
    }

    public java.math.BigInteger getTelAmount() {
        return this.telAmount;
    }

    public void setAssignedLocation(java.math.BigInteger assignedLocation) {
        this.assignedLocation = assignedLocation;
    }

    public java.math.BigInteger getAssignedLocation() {
        return this.assignedLocation;
    }

    public void setUnassginedLocation(java.math.BigInteger unassginedLocation) {
        this.unassginedLocation = unassginedLocation;
    }

    public java.math.BigInteger getUnassginedLocation() {
        return this.unassginedLocation;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }
}