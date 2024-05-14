/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "NBR_CRM_ASSET")
public class NbrCrmAsset implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "telno")
    private String telno;
    @Column(name = "telno_status")
    private Integer telnoStatus;
    @Column(name = "location_code")
    private String locationCode;
    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Column(name = "product_type")
    private String productType;

    public NbrCrmAsset() {
    }

    public NbrCrmAsset(String telno) {
        this.telno = telno;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public Integer getTelnoStatus() {
        return telnoStatus;
    }

    public void setTelnoStatus(Integer telnoStatus) {
        this.telnoStatus = telnoStatus;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telno != null ? telno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NbrCrmAsset)) {
            return false;
        }
        NbrCrmAsset other = (NbrCrmAsset) object;
        if ((this.telno == null && other.telno != null) || (this.telno != null && !this.telno.equals(other.telno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NbrCrmAsset2[ telno=" + telno + " ]";
    }
    
}
