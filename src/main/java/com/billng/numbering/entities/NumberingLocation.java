/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 *
 * @author Billing
 */
@Entity
@Table(name = "NUMBERING_LOCATION")
public class NumberingLocation implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "VALUE")
    private String value;
    @Column(name = "STATUS")
    private String status;

    public NumberingLocation() {
    }

    public NumberingLocation(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof NumberingLocation)) {
            return false;
        }
        NumberingLocation other = (NumberingLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NumberingLocation[ id=" + id + " ]";
    }
    
}
