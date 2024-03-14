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
@Table(name = "BLOCK_DETAIL")
public class BlockDetail implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "NO")
    private BigDecimal no;
    @Column(name = "BLOCK_START")
    private String blockStart;
    @Column(name = "BLOCK_END")
    private String blockEnd;
    @Column(name = "AMOUNT")
    private BigInteger amount;
    @Column(name = "PROVIDER")
    private String provider;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "BLOCK_STATUS")
    private String blockStatus;
    @Column(name = "ACTION_FLAG")
    private String actionStatus;

    public BlockDetail() {
    }

    public BlockDetail(BigDecimal no) {
        this.no = no;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getBlockStart() {
        return blockStart;
    }

    public void setBlockStart(String blockStart) {
        this.blockStart = blockStart;
    }

    public String getBlockEnd() {
        return blockEnd;
    }

    public void setBlockEnd(String blockEnd) {
        this.blockEnd = blockEnd;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
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

    public String getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    public String getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
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
        if (!(object instanceof BlockDetail)) {
            return false;
        }
        BlockDetail other = (BlockDetail) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.BlockDetail[ no=" + no + " ]";
    }
    
}
