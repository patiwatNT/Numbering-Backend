/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import java.io.Serializable;
import java.math.BigInteger;
import jakarta.persistence.*;

/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "ASSIGNED_RANGE_DETAIL")
public class AssignedRangeDetail implements Serializable {

    @EmbeddedId
    protected AssignedRangeDetailPK assignedRangeDetailPK;
    @Column(name = "AMOUNT")
    private BigInteger amount;
    @Column(name = "STATION_CODE")
    private String stationCode;
    @Column(name = "STATION_NAME_TH")
    private String stationNameTh;
    @Column(name = "STATION_NAME_EN")
    private String stationNameEn;
    @Column(name = "STATION_NAME_SHORT")
    private String stationNameShort;
    @Column(name = "PROJECT")
    private String project;
    @Column(name = "DIVISION")
    private String division;
    @Column(name = "NETWORK")
    private String network;
    @Column(name = "RANK")
    private String rank;
    @Column(name = "SYSTEM")
    private String system;
    @Column(name = "BRAND")
    private String brand;
    @Column(name = "INSTALL_LOCATION")
    private String installLocation;
    @Column(name = "LATITUDE")
    private String latitude;
    @Column(name = "LONGTITUDE")
    private String longtitude;
    @Column(name = "RCU")
    private String rcu;
    @Column(name = "START_TEL")
    private String startTel;
    @Column(name = "END_TEL")
    private String endTel;
    @Column(name = "SERVICE_LOCATION")
    private String serviceLocation;

    public AssignedRangeDetail() {
    }

    public AssignedRangeDetail(AssignedRangeDetailPK assignedRangeDetailPK) {
        this.assignedRangeDetailPK = assignedRangeDetailPK;
    }

    public AssignedRangeDetail(String detailId, BigInteger id) {
        this.assignedRangeDetailPK = new AssignedRangeDetailPK(detailId, id);
    }

    public AssignedRangeDetailPK getAssignedRangeDetailPK() {
        return assignedRangeDetailPK;
    }

    public void setAssignedRangeDetailPK(AssignedRangeDetailPK assignedRangeDetailPK) {
        this.assignedRangeDetailPK = assignedRangeDetailPK;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationNameTh() {
        return stationNameTh;
    }

    public void setStationNameTh(String stationNameTh) {
        this.stationNameTh = stationNameTh;
    }

    public String getStationNameEn() {
        return stationNameEn;
    }

    public void setStationNameEn(String stationNameEn) {
        this.stationNameEn = stationNameEn;
    }

    public String getStationNameShort() {
        return stationNameShort;
    }

    public void setStationNameShort(String stationNameShort) {
        this.stationNameShort = stationNameShort;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getRcu() {
        return rcu;
    }

    public void setRcu(String rcu) {
        this.rcu = rcu;
    }

    public String getStartTel() {
        return startTel;
    }

    public void setStartTel(String startTel) {
        this.startTel = startTel;
    }

    public String getEndTel() {
        return endTel;
    }

    public void setEndTel(String endTel) {
        this.endTel = endTel;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assignedRangeDetailPK != null ? assignedRangeDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssignedRangeDetail)) {
            return false;
        }
        AssignedRangeDetail other = (AssignedRangeDetail) object;
        if ((this.assignedRangeDetailPK == null && other.assignedRangeDetailPK != null) || (this.assignedRangeDetailPK != null && !this.assignedRangeDetailPK.equals(other.assignedRangeDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.AssignedRangeDetail[ assignedRangeDetailPK=" + assignedRangeDetailPK + " ]";
    }
    
}
