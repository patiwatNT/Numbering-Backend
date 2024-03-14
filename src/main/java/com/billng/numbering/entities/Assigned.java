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
@Table(name = "ASSIGNED")
public class Assigned implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "NO")
    private BigDecimal no;
    @Column(name = "PROVIDER")
    private String provider;
    @Column(name = "PROVIDER_DESCRIPTION")
    private String providerDescription;
    @Column(name = "RANGE_AMOUNT")
    private BigInteger rangeAmount;
    @Column(name = "TEL_AMOUNT")
    private BigInteger telAmount;

    public Assigned() {
    }

    public Assigned(BigDecimal no) {
        this.no = no;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderDescription() {
        return providerDescription;
    }

    public void setProviderDescription(String providerDescription) {
        this.providerDescription = providerDescription;
    }

    public BigInteger getRangeAmount() {
        return rangeAmount;
    }

    public void setRangeAmount(BigInteger rangeAmount) {
        this.rangeAmount = rangeAmount;
    }

    public BigInteger getTelAmount() {
        return telAmount;
    }

    public void setTelAmount(BigInteger telAmount) {
        this.telAmount = telAmount;
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
        if (!(object instanceof Assigned)) {
            return false;
        }
        Assigned other = (Assigned) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.Assigned[ no=" + no + " ]";
    }
    
}
