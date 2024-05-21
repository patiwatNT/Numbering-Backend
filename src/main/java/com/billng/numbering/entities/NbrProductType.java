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
@Table(name = "NBR_PRODUCT_TYPE")
public class NbrProductType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PT_ID")
    private Integer ptId;
    @Column(name = "PT_Name")
    private String pTName;
    @Column(name = "PT_CRM")
    private String ptCrm;
    @Column(name = "MAIN_PRODUCT_ID")
    private String mainProductId;
    @Column(name = "MAIN_PRODUCT_NAME")
    private String mainProductName;
    @Column(name = "PRODUCT_ID")
    private String productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;

    public NbrProductType() {
    }

    public NbrProductType(Integer ptId) {
        this.ptId = ptId;
    }

    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    public String getPTName() {
        return pTName;
    }

    public void setPTName(String pTName) {
        this.pTName = pTName;
    }

    public String getPtCrm() {
        return ptCrm;
    }

    public void setPtCrm(String ptCrm) {
        this.ptCrm = ptCrm;
    }

    public String getMainProductId() {
        return mainProductId;
    }

    public void setMainProductId(String mainProductId) {
        this.mainProductId = mainProductId;
    }

    public String getMainProductName() {
        return mainProductName;
    }

    public void setMainProductName(String mainProductName) {
        this.mainProductName = mainProductName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ptId != null ? ptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NbrProductType)) {
            return false;
        }
        NbrProductType other = (NbrProductType) object;
        if ((this.ptId == null && other.ptId != null) || (this.ptId != null && !this.ptId.equals(other.ptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NbrProductType[ ptId=" + ptId + " ]";
    }
    
}
