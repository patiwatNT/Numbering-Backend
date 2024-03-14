/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Billing
 */
@Entity
@Table(name = "ASSIGNED_RANGE")
public class AssignedRange implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "NO")
    private BigDecimal no;
    @Column(name = "STATION_CODE")
    private String stationCode;
    @Column(name = "STATION_NAME")
    private String stationName;
    @Column(name = "START_TEL")
    private String startTel;
    @Column(name = "END_TEL")
    private String endTel;
    @Column(name = "TEL_AMOUNT")
    private BigInteger telAmount;
    @Column(name = "ASSIGNED_LOCATION")
    private BigInteger assignedLocation;
    @Column(name = "UNASSGINED_LOCATION")
    private BigInteger unassginedLocation;
    @Column(name = "PROVIDER")
    private String provider;
    @Column(name = "LOCATION")
    private String location;

    public AssignedRange() {
    }

    public AssignedRange(BigDecimal no) {
        this.no = no;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
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

    public BigInteger getTelAmount() {
        return telAmount;
    }

    public void setTelAmount(BigInteger telAmount) {
        this.telAmount = telAmount;
    }

    public BigInteger getAssignedLocation() {
        return assignedLocation;
    }

    public void setAssignedLocation(BigInteger assignedLocation) {
        this.assignedLocation = assignedLocation;
    }

    public BigInteger getUnassginedLocation() {
        return unassginedLocation;
    }

    public void setUnassginedLocation(BigInteger unassginedLocation) {
        this.unassginedLocation = unassginedLocation;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssignedRange)) {
            return false;
        }
        AssignedRange other = (AssignedRange) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.AssignedRange[ no=" + no + " ]";
    }
    
}
