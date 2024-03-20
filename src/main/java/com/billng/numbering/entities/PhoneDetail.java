/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "PHONE_DETAIL")
public class PhoneDetail implements Serializable {

    @EmbeddedId
    protected PhoneDetailPK phoneDetailPK;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "SERVICE_LOCATION")
    private String serviceLocation;
    @Column(name = "CRM_STATUS")
    private String crmStatus;
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "UPDATE_BY")
    private String updateBy;

    public PhoneDetail() {
    }

    public PhoneDetail(PhoneDetailPK phoneDetailPK) {
        this.phoneDetailPK = phoneDetailPK;
    }

    public PhoneDetail(String no, BigInteger assignRangeId) {
        this.phoneDetailPK = new PhoneDetailPK(no, assignRangeId);
    }

    public PhoneDetailPK getPhoneDetailPK() {
        return phoneDetailPK;
    }

    public void setPhoneDetailPK(PhoneDetailPK phoneDetailPK) {
        this.phoneDetailPK = phoneDetailPK;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public String getCrmStatus() {
        return crmStatus;
    }

    public void setCrmStatus(String crmStatus) {
        this.crmStatus = crmStatus;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneDetailPK != null ? phoneDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhoneDetail)) {
            return false;
        }
        PhoneDetail other = (PhoneDetail) object;
        if ((this.phoneDetailPK == null && other.phoneDetailPK != null) || (this.phoneDetailPK != null && !this.phoneDetailPK.equals(other.phoneDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.PhoneDetail[ phoneDetailPK=" + phoneDetailPK + " ]";
    }
    
}
