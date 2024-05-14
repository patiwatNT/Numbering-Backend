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
@Table(name = "NBR_BLOCKS")
@NamedQueries({
    @NamedQuery(name = "NbrBlocks.findAll", query = "SELECT n FROM NbrBlocks n")})
public class NbrBlocks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "block_id")
    private Integer blockId;
    @Basic(optional = false)
    @Column(name = "block_start")
    private String blockStart;
    @Basic(optional = false)
    @Column(name = "block_end")
    private String blockEnd;
    @Column(name = "block_range")
    private String blockRange;
    @Column(name = "provider_id")
    private Integer providerId;
    @Column(name = "provider")
    private String provider;
    @Column(name = "x_block_area")
    private String xBlockArea;
    @Column(name = "x_block_sector")
    private String xBlockSector;
    @Column(name = "block_amount")
    private Integer blockAmount;
    @Column(name = "block_status")
    private Integer blockStatus;
    @Column(name = "doc_ref")
    private String docRef;
    @Column(name = "end_date")
    private String endDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "block_fee")
    private Double blockFee;
    @Column(name = "block_payable")
    private Double blockPayable;
    @Column(name = "block_sector")
    private String blockSector;
    @Column(name = "n_department")
    private String nDepartment;
    @Column(name = "block_area")
    private String blockArea;
    @Column(name = "n_work_area")
    private String nWorkArea;

    public NbrBlocks() {
    }

    public NbrBlocks(Integer blockId) {
        this.blockId = blockId;
    }

    public NbrBlocks(Integer blockId, String blockStart, String blockEnd) {
        this.blockId = blockId;
        this.blockStart = blockStart;
        this.blockEnd = blockEnd;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
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

    public String getBlockRange() {
        return blockRange;
    }

    public void setBlockRange(String blockRange) {
        this.blockRange = blockRange;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getXBlockArea() {
        return xBlockArea;
    }

    public void setXBlockArea(String xBlockArea) {
        this.xBlockArea = xBlockArea;
    }

    public String getXBlockSector() {
        return xBlockSector;
    }

    public void setXBlockSector(String xBlockSector) {
        this.xBlockSector = xBlockSector;
    }

    public Integer getBlockAmount() {
        return blockAmount;
    }

    public void setBlockAmount(Integer blockAmount) {
        this.blockAmount = blockAmount;
    }

    public Integer getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(Integer blockStatus) {
        this.blockStatus = blockStatus;
    }

    public String getDocRef() {
        return docRef;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getBlockFee() {
        return blockFee;
    }

    public void setBlockFee(Double blockFee) {
        this.blockFee = blockFee;
    }

    public Double getBlockPayable() {
        return blockPayable;
    }

    public void setBlockPayable(Double blockPayable) {
        this.blockPayable = blockPayable;
    }

    public String getBlockSector() {
        return blockSector;
    }

    public void setBlockSector(String blockSector) {
        this.blockSector = blockSector;
    }

    public String getNDepartment() {
        return nDepartment;
    }

    public void setNDepartment(String nDepartment) {
        this.nDepartment = nDepartment;
    }

    public String getBlockArea() {
        return blockArea;
    }

    public void setBlockArea(String blockArea) {
        this.blockArea = blockArea;
    }

    public String getNWorkArea() {
        return nWorkArea;
    }

    public void setNWorkArea(String nWorkArea) {
        this.nWorkArea = nWorkArea;
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
        if (!(object instanceof NbrBlocks)) {
            return false;
        }
        NbrBlocks other = (NbrBlocks) object;
        if ((this.blockId == null && other.blockId != null) || (this.blockId != null && !this.blockId.equals(other.blockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NbrBlocks[ blockId=" + blockId + " ]";
    }
    
}
