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
@Table(name = "NBR_REPORT1000")
@NamedQueries({
    @NamedQuery(name = "NbrReport1000.findAll", query = "SELECT n FROM NbrReport1000 n")})
public class NbrReport1000 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "blockId")
    private int blockId;
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

    public NbrReport1000() {
    }

    public NbrReport1000(String blockStart) {
        this.blockStart = blockStart;
    }

    public NbrReport1000(String blockStart, int blockId, String blockEnd) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blockStart != null ? blockStart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NbrReport1000)) {
            return false;
        }
        NbrReport1000 other = (NbrReport1000) object;
        if ((this.blockStart == null && other.blockStart != null) || (this.blockStart != null && !this.blockStart.equals(other.blockStart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NbrReport1000[ blockStart=" + blockStart + " ]";
    }
    
}
