/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author NT2_Admin
 */
@Embeddable
public class ServiceLocationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SERVICE_LOCATION_ID")
    private String serviceLocationId;
    @Basic(optional = false)
    @Column(name = "SERVICE_CENTER_ID")
    private String serviceCenterId;

    public ServiceLocationPK() {
    }

    public ServiceLocationPK(String serviceLocationId, String serviceCenterId) {
        this.serviceLocationId = serviceLocationId;
        this.serviceCenterId = serviceCenterId;
    }

    public String getServiceLocationId() {
        return serviceLocationId;
    }

    public void setServiceLocationId(String serviceLocationId) {
        this.serviceLocationId = serviceLocationId;
    }

    public String getServiceCenterId() {
        return serviceCenterId;
    }

    public void setServiceCenterId(String serviceCenterId) {
        this.serviceCenterId = serviceCenterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceLocationId != null ? serviceLocationId.hashCode() : 0);
        hash += (serviceCenterId != null ? serviceCenterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceLocationPK)) {
            return false;
        }
        ServiceLocationPK other = (ServiceLocationPK) object;
        if ((this.serviceLocationId == null && other.serviceLocationId != null) || (this.serviceLocationId != null && !this.serviceLocationId.equals(other.serviceLocationId))) {
            return false;
        }
        if ((this.serviceCenterId == null && other.serviceCenterId != null) || (this.serviceCenterId != null && !this.serviceCenterId.equals(other.serviceCenterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.ServiceLocationPK[ serviceLocationId=" + serviceLocationId + ", serviceCenterId=" + serviceCenterId + " ]";
    }
    
}
