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
 * @author NT2_Admin
 */
@Entity
@Table(name = "REPORT_N_11")
public class ReportN11 implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "PROVIDER")
    private String provider;
    @Column(name = "BLOCK_STATUS")
    private String blockStatus;
    @Column(name = "BLOCK_AMOUNT")
    private BigInteger blockAmount;
    @Column(name = "NUMBER_AMOUNT_ALL")
    private BigInteger numberAmountAll;
    @Column(name = "NUMBER_AMOUNT_ASSIGNED")
    private BigInteger numberAmountAssigned;
    @Column(name = "NUMBER_AMOUNT_ASSIGNED_ACTIVE")
    private BigInteger numberAmountAssignedActive;
    @Column(name = "NUMBER_AMOUNT_NOT_ASSIGNED")
    private BigInteger numberAmountNotAssigned;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FEE_AMOUNT")
    private BigDecimal feeAmount;

    public ReportN11() {
    }

    public ReportN11(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    public BigInteger getBlockAmount() {
        return blockAmount;
    }

    public void setBlockAmount(BigInteger blockAmount) {
        this.blockAmount = blockAmount;
    }

    public BigInteger getNumberAmountAll() {
        return numberAmountAll;
    }

    public void setNumberAmountAll(BigInteger numberAmountAll) {
        this.numberAmountAll = numberAmountAll;
    }

    public BigInteger getNumberAmountAssigned() {
        return numberAmountAssigned;
    }

    public void setNumberAmountAssigned(BigInteger numberAmountAssigned) {
        this.numberAmountAssigned = numberAmountAssigned;
    }

    public BigInteger getNumberAmountAssignedActive() {
        return numberAmountAssignedActive;
    }

    public void setNumberAmountAssignedActive(BigInteger numberAmountAssignedActive) {
        this.numberAmountAssignedActive = numberAmountAssignedActive;
    }

    public BigInteger getNumberAmountNotAssigned() {
        return numberAmountNotAssigned;
    }

    public void setNumberAmountNotAssigned(BigInteger numberAmountNotAssigned) {
        this.numberAmountNotAssigned = numberAmountNotAssigned;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
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
        if (!(object instanceof ReportN11)) {
            return false;
        }
        ReportN11 other = (ReportN11) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.ReportN11[ id=" + id + " ]";
    }
    
}
