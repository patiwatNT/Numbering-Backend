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
@Table(name = "NBR_PROVIDERS")
@NamedQueries({
    @NamedQuery(name = "NbrProviders.findAll", query = "SELECT n FROM NbrProviders n")})
public class NbrProviders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "provider_id")
    private Integer providerId;
    @Basic(optional = false)
    @Column(name = "provider_name")
    private String providerName;
    @Column(name = "provider_desc")
    private String providerDesc;

    public NbrProviders() {
    }

    public NbrProviders(Integer providerId) {
        this.providerId = providerId;
    }

    public NbrProviders(Integer providerId, String providerName) {
        this.providerId = providerId;
        this.providerName = providerName;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderDesc() {
        return providerDesc;
    }

    public void setProviderDesc(String providerDesc) {
        this.providerDesc = providerDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (providerId != null ? providerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NbrProviders)) {
            return false;
        }
        NbrProviders other = (NbrProviders) object;
        if ((this.providerId == null && other.providerId != null) || (this.providerId != null && !this.providerId.equals(other.providerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NbrProviders[ providerId=" + providerId + " ]";
    }
    
}
