package com.billng.numbering.dto;

import com.billng.numbering.entities.AssignedRangeDetailPK;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;

@ApiModel()
public class AssignedRangeDetailDto extends AbstractDto<AssignedRangeDetailPK> {
    private AssignedRangeDetailPK assignedRangeDetailPK;
    private BigInteger amount;
    @Size(max = 255)
    private String stationCode;
    @Size(max = 255)
    private String stationNameTh;
    @Size(max = 255)
    private String stationNameEn;
    @Size(max = 255)
    private String stationNameShort;
    @Size(max = 255)
    private String project;
    @Size(max = 255)
    private String division;
    @Size(max = 255)
    private String network;
    @Size(max = 255)
    private String rank;
    @Size(max = 255)
    private String system;
    @Size(max = 255)
    private String brand;
    @Size(max = 255)
    private String installLocation;
    @Size(max = 255)
    private String latitude;
    @Size(max = 255)
    private String longtitude;
    @Size(max = 255)
    private String rcu;
    @Size(max = 255)
    private String startTel;
    @Size(max = 255)
    private String endTel;
    @Size(max = 255)
    private String serviceLocation;

    public AssignedRangeDetailDto() {
    }

    public void setAssignedRangeDetailPK(AssignedRangeDetailPK assignedRangeDetailPK) {
        this.assignedRangeDetailPK = assignedRangeDetailPK;
    }

    public AssignedRangeDetailPK getAssignedRangeDetailPK() {
        return this.assignedRangeDetailPK;
    }

    public void setAmount(java.math.BigInteger amount) {
        this.amount = amount;
    }

    public java.math.BigInteger getAmount() {
        return this.amount;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationCode() {
        return this.stationCode;
    }

    public void setStationNameTh(String stationNameTh) {
        this.stationNameTh = stationNameTh;
    }

    public String getStationNameTh() {
        return this.stationNameTh;
    }

    public void setStationNameEn(String stationNameEn) {
        this.stationNameEn = stationNameEn;
    }

    public String getStationNameEn() {
        return this.stationNameEn;
    }

    public void setStationNameShort(String stationNameShort) {
        this.stationNameShort = stationNameShort;
    }

    public String getStationNameShort() {
        return this.stationNameShort;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProject() {
        return this.project;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDivision() {
        return this.division;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNetwork() {
        return this.network;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return this.rank;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getSystem() {
        return this.system;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public String getInstallLocation() {
        return this.installLocation;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLongtitude() {
        return this.longtitude;
    }

    public void setRcu(String rcu) {
        this.rcu = rcu;
    }

    public String getRcu() {
        return this.rcu;
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

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public String getServiceLocation() {
        return this.serviceLocation;
    }
}