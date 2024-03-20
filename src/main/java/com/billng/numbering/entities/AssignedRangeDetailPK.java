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
@Embeddable
public class AssignedRangeDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "DETAIL_ID")
    private String detailId;
    @Basic(optional = false)
    @Column(name = "ID")
    private BigInteger id;

    public AssignedRangeDetailPK() {
    }

    public AssignedRangeDetailPK(String detailId, BigInteger id) {
        this.detailId = detailId;
        this.id = id;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailId != null ? detailId.hashCode() : 0);
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssignedRangeDetailPK)) {
            return false;
        }
        AssignedRangeDetailPK other = (AssignedRangeDetailPK) object;
        if ((this.detailId == null && other.detailId != null) || (this.detailId != null && !this.detailId.equals(other.detailId))) {
            return false;
        }
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.AssignedRangeDetailPK[ detailId=" + detailId + ", id=" + id + " ]";
    }
    
}
