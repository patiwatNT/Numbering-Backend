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
@Embeddable
public class PhoneDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NO")
    private String no;
    @Basic(optional = false)
    @Column(name = "ASSIGN_RANGE_ID")
    private BigInteger assignRangeId;

    public PhoneDetailPK() {
    }

    public PhoneDetailPK(String no, BigInteger assignRangeId) {
        this.no = no;
        this.assignRangeId = assignRangeId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigInteger getAssignRangeId() {
        return assignRangeId;
    }

    public void setAssignRangeId(BigInteger assignRangeId) {
        this.assignRangeId = assignRangeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        hash += (assignRangeId != null ? assignRangeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhoneDetailPK)) {
            return false;
        }
        PhoneDetailPK other = (PhoneDetailPK) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        if ((this.assignRangeId == null && other.assignRangeId != null) || (this.assignRangeId != null && !this.assignRangeId.equals(other.assignRangeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.PhoneDetailPK[ no=" + no + ", assignRangeId=" + assignRangeId + " ]";
    }
    
}
