package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;

@ApiModel()
public class ReportN15Dto extends AbstractDto<String> {
    @Size(max = 255)
    private String id;
    @Size(max = 255)
    private String department;
    @Size(max = 255)
    private String division;
    @Size(max = 255)
    private String segment;
    @Size(max = 255)
    private String serviceLocation;
    private BigInteger numberAmountAssigned;
    private BigInteger numberAmountActive;
    private BigInteger numberAmountAvailable;

    public ReportN15Dto() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDivision() {
        return this.division;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getSegment() {
        return this.segment;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public String getServiceLocation() {
        return this.serviceLocation;
    }

    public void setNumberAmountAssigned(java.math.BigInteger numberAmountAssigned) {
        this.numberAmountAssigned = numberAmountAssigned;
    }

    public java.math.BigInteger getNumberAmountAssigned() {
        return this.numberAmountAssigned;
    }

    public void setNumberAmountActive(java.math.BigInteger numberAmountActive) {
        this.numberAmountActive = numberAmountActive;
    }

    public java.math.BigInteger getNumberAmountActive() {
        return this.numberAmountActive;
    }

    public void setNumberAmountAvailable(java.math.BigInteger numberAmountAvailable) {
        this.numberAmountAvailable = numberAmountAvailable;
    }

    public java.math.BigInteger getNumberAmountAvailable() {
        return this.numberAmountAvailable;
    }
}