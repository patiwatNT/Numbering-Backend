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
@Table(name = "REPORT_N_16_BLOCK_100_ONLY")
public class ReportN16Block100Only implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "BLOCK_RANGE")
    private String blockRange;
    @Column(name = "START_TEL")
    private String startTel;
    @Column(name = "END_TEL")
    private String endTel;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "NUMBER_AMOUNT")
    private BigInteger numberAmount;
    @Column(name = "ANNUAL_FEE")
    private BigInteger annualFee;

    public ReportN16Block100Only() {
    }

    public ReportN16Block100Only(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlockRange() {
        return blockRange;
    }

    public void setBlockRange(String blockRange) {
        this.blockRange = blockRange;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigInteger getNumberAmount() {
        return numberAmount;
    }

    public void setNumberAmount(BigInteger numberAmount) {
        this.numberAmount = numberAmount;
    }

    public BigInteger getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(BigInteger annualFee) {
        this.annualFee = annualFee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportN16Block100Only)) {
            return false;
        }
        ReportN16Block100Only other = (ReportN16Block100Only) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.ReportN16Block100Only[ id=" + id + " ]";
    }
    
}
