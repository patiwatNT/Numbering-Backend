/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "NUMBERING_PRIVILEGES")
public class NumberingPrivileges implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PRIVILEGE_ID")
    private BigInteger privilegeId;
    @Column(name = "PRIVILEGE_NAME")
    private String privilegeName;
    @Column(name = "PRIVILEGE_DESCRIPTION")
    private String privilegeDescription;

    public NumberingPrivileges() {
    }

    public NumberingPrivileges(BigInteger privilegeId) {
        this.privilegeId = privilegeId;
    }

    public BigInteger getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(BigInteger privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeDescription() {
        return privilegeDescription;
    }

    public void setPrivilegeDescription(String privilegeDescription) {
        this.privilegeDescription = privilegeDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (privilegeId != null ? privilegeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberingPrivileges)) {
            return false;
        }
        NumberingPrivileges other = (NumberingPrivileges) object;
        if ((this.privilegeId == null && other.privilegeId != null) || (this.privilegeId != null && !this.privilegeId.equals(other.privilegeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NumberingPrivileges[ privilegeId=" + privilegeId + " ]";
    }
    
}
