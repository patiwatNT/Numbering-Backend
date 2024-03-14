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
@Table(name = "BLOCK")
public class Block implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal blockId;
    @Column(name = "PROVIDE")
    private String provide;
    @Column(name = "BLOCK_AMOUNT")
    private BigInteger blockAmount;
    @Column(name = "NUMBER_AMOUNT")
    private BigInteger numberAmount;
    @Column(name = "FEE_AMOUNT")
    private BigDecimal feeAmount;

    public Block() {
    }

    public Block(BigDecimal blockId) {
        this.blockId = blockId;
    }

    public BigDecimal getBlockId() {
        return blockId;
    }

    public void setBlockId(BigDecimal blockId) {
        this.blockId = blockId;
    }

    public String getProvide() {
        return provide;
    }

    public void setProvide(String provide) {
        this.provide = provide;
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

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blockId != null ? blockId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Block)) {
            return false;
        }
        Block other = (Block) object;
        if ((this.blockId == null && other.blockId != null) || (this.blockId != null && !this.blockId.equals(other.blockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.Block[ blockId=" + blockId + " ]";
    }
    
}
