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
@Entity
@Table(name = "REPORT_N_15")
public class ReportN15 implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "DIVISION")
    private String division;
    @Column(name = "SEGMENT")
    private String segment;
    @Column(name = "SERVICE_LOCATION")
    private String serviceLocation;
    @Column(name = "NUMBER_AMOUNT_ASSIGNED")
    private BigInteger numberAmountAssigned;
    @Column(name = "NUMBER_AMOUNT_ACTIVE")
    private BigInteger numberAmountActive;
    @Column(name = "NUMBER_AMOUNT_AVAILABLE")
    private BigInteger numberAmountAvailable;

    public ReportN15() {
    }

    public ReportN15(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public BigInteger getNumberAmountAssigned() {
        return numberAmountAssigned;
    }

    public void setNumberAmountAssigned(BigInteger numberAmountAssigned) {
        this.numberAmountAssigned = numberAmountAssigned;
    }

    public BigInteger getNumberAmountActive() {
        return numberAmountActive;
    }

    public void setNumberAmountActive(BigInteger numberAmountActive) {
        this.numberAmountActive = numberAmountActive;
    }

    public BigInteger getNumberAmountAvailable() {
        return numberAmountAvailable;
    }

    public void setNumberAmountAvailable(BigInteger numberAmountAvailable) {
        this.numberAmountAvailable = numberAmountAvailable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportN15)) {
            return false;
        }
        ReportN15 other = (ReportN15) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.ReportN15[ id=" + id + " ]";
    }
    
}
