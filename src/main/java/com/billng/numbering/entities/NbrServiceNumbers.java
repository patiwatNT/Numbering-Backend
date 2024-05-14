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
@Table(name = "NBR_SERVICE_NUMBERS")
public class NbrServiceNumbers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "service_no")
    private String serviceNo;
    @Column(name = "location_code")
    private String locationCode;
    @Column(name = "crm_status")
    private Integer crmStatus;
    @Column(name = "crm_last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crmLastModified;
    @Column(name = "rts_id")
    private Integer rtsId;
    @Column(name = "assigned_id")
    private Integer assignedId;
    @Column(name = "block_id")
    private Integer blockId;
    @Column(name = "provider_id")
    private Integer providerId;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "unmatched_id")
    private Integer unmatchedId;

    public NbrServiceNumbers() {
    }

    public NbrServiceNumbers(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public Integer getCrmStatus() {
        return crmStatus;
    }

    public void setCrmStatus(Integer crmStatus) {
        this.crmStatus = crmStatus;
    }

    public Date getCrmLastModified() {
        return crmLastModified;
    }

    public void setCrmLastModified(Date crmLastModified) {
        this.crmLastModified = crmLastModified;
    }

    public Integer getRtsId() {
        return rtsId;
    }

    public void setRtsId(Integer rtsId) {
        this.rtsId = rtsId;
    }

    public Integer getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(Integer assignedId) {
        this.assignedId = assignedId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getUnmatchedId() {
        return unmatchedId;
    }

    public void setUnmatchedId(Integer unmatchedId) {
        this.unmatchedId = unmatchedId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceNo != null ? serviceNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NbrServiceNumbers)) {
            return false;
        }
        NbrServiceNumbers other = (NbrServiceNumbers) object;
        if ((this.serviceNo == null && other.serviceNo != null) || (this.serviceNo != null && !this.serviceNo.equals(other.serviceNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NbrServiceNumbers2[ serviceNo=" + serviceNo + " ]";
    }
    
}
