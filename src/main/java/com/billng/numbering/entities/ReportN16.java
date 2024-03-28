/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.persistence.*;

/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "REPORT_N_16")
public class ReportN16 implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "BLOCK")
    private String block;
    @Column(name = "BLOCK_AMOUNT")
    private BigInteger blockAmount;
    @Column(name = "NUMBER_AMOUNT")
    private BigInteger numberAmount;
    @Column(name = "MONTHLY_FEE")
    private BigInteger monthlyFee;
    @Column(name = "ANNUAL_FEE")
    private BigDecimal annualFee;

    public ReportN16() {
    }

    public ReportN16(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public BigInteger getBlockAmount() {
        return blockAmount;
    }

    public void setBlockAmount(BigInteger blockAmount) {
        this.blockAmount = blockAmount;
    }

    public BigInteger getNumberAmount() {
        return numberAmount;
    }

    public void setNumberAmount(BigInteger numberAmount) {
        this.numberAmount = numberAmount;
    }

    public BigInteger getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigInteger monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public BigDecimal getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(BigDecimal annualFee) {
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
        if (!(object instanceof ReportN16)) {
            return false;
        }
        ReportN16 other = (ReportN16) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.ReportN16[ id=" + id + " ]";
    }
    
}
