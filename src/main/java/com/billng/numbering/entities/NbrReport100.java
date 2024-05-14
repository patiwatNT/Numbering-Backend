/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import jakarta.persistence.*;

import java.io.Serializable;


/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "NBR_REPORT100")
public class NbrReport100 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "blockId")
    private int blockId;
    @Column(name = "flag")
    private Integer flag;
    @Id
    @Basic(optional = false)
    @Column(name = "blockStart")
    private String blockStart;
    @Basic(optional = false)
    @Column(name = "blockEnd")
    private String blockEnd;
    @Column(name = "blockArea")
    private String blockArea;
    @Column(name = "qty")
    private Integer qty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amt")
    private Double amt;
    @Column(name = "flag500")
    private Integer flag500;

    public NbrReport100() {
    }

    public NbrReport100(String blockStart) {
        this.blockStart = blockStart;
    }

    public NbrReport100(String blockStart, int blockId, String blockEnd) {
        this.blockStart = blockStart;
        this.blockId = blockId;
        this.blockEnd = blockEnd;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public String getBlockArea() {
        return blockArea;
    }

    public void setBlockArea(String blockArea) {
        this.blockArea = blockArea;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    public Integer getFlag500() {
        return flag500;
    }

    public void setFlag500(Integer flag500) {
        this.flag500 = flag500;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blockStart != null ? blockStart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NbrReport100)) {
            return false;
        }
        NbrReport100 other = (NbrReport100) object;
        if ((this.blockStart == null && other.blockStart != null) || (this.blockStart != null && !this.blockStart.equals(other.blockStart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NbrReport100[ blockStart=" + blockStart + " ]";
    }
    
}
