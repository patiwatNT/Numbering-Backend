/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "SERVICE_LOCATION")
public class ServiceLocation implements Serializable {

    @EmbeddedId
    protected ServiceLocationPK serviceLocationPK;
    @Column(name = "NAME")
    private String name;

    public ServiceLocation() {
    }

    public ServiceLocation(ServiceLocationPK serviceLocationPK) {
        this.serviceLocationPK = serviceLocationPK;
    }

    public ServiceLocation(String serviceLocationId, String serviceCenterId) {
        this.serviceLocationPK = new ServiceLocationPK(serviceLocationId, serviceCenterId);
    }

    public ServiceLocationPK getServiceLocationPK() {
        return serviceLocationPK;
    }

    public void setServiceLocationPK(ServiceLocationPK serviceLocationPK) {
        this.serviceLocationPK = serviceLocationPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceLocationPK != null ? serviceLocationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceLocation)) {
            return false;
        }
        ServiceLocation other = (ServiceLocation) object;
        if ((this.serviceLocationPK == null && other.serviceLocationPK != null) || (this.serviceLocationPK != null && !this.serviceLocationPK.equals(other.serviceLocationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.ServiceLocation[ serviceLocationPK=" + serviceLocationPK + " ]";
    }
    
}
