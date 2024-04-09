/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;


/**
 *
 * @author NT2_Admin
 */
@Embeddable
public class NumberingRolePrivilegesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ROLE_ID")
    private BigInteger roleId;
    @Basic(optional = false)
    @Column(name = "PRIVILEGE_ID")
    private BigInteger privilegeId;

    public NumberingRolePrivilegesPK() {
    }

    public NumberingRolePrivilegesPK(BigInteger roleId, BigInteger privilegeId) {
        this.roleId = roleId;
        this.privilegeId = privilegeId;
    }

    public BigInteger getRoleId() {
        return roleId;
    }

    public void setRoleId(BigInteger roleId) {
        this.roleId = roleId;
    }

    public BigInteger getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(BigInteger privilegeId) {
        this.privilegeId = privilegeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        hash += (privilegeId != null ? privilegeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberingRolePrivilegesPK)) {
            return false;
        }
        NumberingRolePrivilegesPK other = (NumberingRolePrivilegesPK) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        if ((this.privilegeId == null && other.privilegeId != null) || (this.privilegeId != null && !this.privilegeId.equals(other.privilegeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NumberingRolePrivilegesPK[ roleId=" + roleId + ", privilegeId=" + privilegeId + " ]";
    }
    
}
