/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import jakarta.persistence.*;

import java.io.Serializable;


/**
 *
 * @author Billing
 */
@Entity
@Table(name = "PHONE_INFO")
public class PhoneInfo implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "SERVICE_LOCATION")
    private String serviceLocation;
    @Column(name = "CRM_STATUS")
    private String crmStatus;
    @Column(name = "PROVIDER")
    private String provider;
    @Column(name = "BLOCK")
    private String block;
    @Column(name = "ASSIGNED")
    private String assigned;
    @Column(name = "LASTEST_BY")
    private String lastestBy;

    public PhoneInfo() {
    }

    public PhoneInfo(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getLastestBy() {
        return lastestBy;
    }

    public void setLastestBy(String lastestBy) {
        this.lastestBy = lastestBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phone != null ? phone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhoneInfo)) {
            return false;
        }
        PhoneInfo other = (PhoneInfo) object;
        if ((this.phone == null && other.phone != null) || (this.phone != null && !this.phone.equals(other.phone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.PhoneInfo[ phone=" + phone + " ]";
    }
    
}
