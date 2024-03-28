/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "REPORT_N_12")
public class ReportN12 implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "BLOCK_ID")
    private BigInteger blockId;
    @Column(name = "START_TEL")
    private String startTel;
    @Column(name = "END_TEL")
    private String endTel;
    @Column(name = "BLOCK_STATUS")
    private String blockStatus;
    @Column(name = "RESERVE_STATUS")
    private String reserveStatus;
    @Column(name = "NUMBER_AMOUNT_ALL")
    private BigInteger numberAmountAll;
    @Column(name = "NUMBER_AMOUNT_ASSIGNED")
    private BigInteger numberAmountAssigned;
    @Column(name = "NUMBER_AMOUNT_ACTIVE")
    private BigInteger numberAmountActive;

    public ReportN12() {
    }

    public ReportN12(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getBlockId() {
        return blockId;
    }

    public void setBlockId(BigInteger blockId) {
        this.blockId = blockId;
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

    public String getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    public String getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(String reserveStatus) {
        this.reserveStatus = reserveStatus;
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

    public BigInteger getNumberAmountActive() {
        return numberAmountActive;
    }

    public void setNumberAmountActive(BigInteger numberAmountActive) {
        this.numberAmountActive = numberAmountActive;
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
        if (!(object instanceof ReportN12)) {
            return false;
        }
        ReportN12 other = (ReportN12) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.ReprotN12[ id=" + id + " ]";
    }
    
}
