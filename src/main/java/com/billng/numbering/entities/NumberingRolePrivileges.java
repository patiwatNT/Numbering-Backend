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
@Entity
@Table(name = "NUMBERING_ROLE_PRIVILEGES")
public class NumberingRolePrivileges implements Serializable {

    @EmbeddedId
    protected NumberingRolePrivilegesPK numberingRolePrivilegesPK;
    @Column(name = "ACCESS_RIGHTS")
    private String accessRights;

    public NumberingRolePrivileges() {
    }

    public NumberingRolePrivileges(NumberingRolePrivilegesPK numberingRolePrivilegesPK) {
        this.numberingRolePrivilegesPK = numberingRolePrivilegesPK;
    }

    public NumberingRolePrivileges(BigInteger roleId, BigInteger privilegeId) {
        this.numberingRolePrivilegesPK = new NumberingRolePrivilegesPK(roleId, privilegeId);
    }

    public NumberingRolePrivilegesPK getNumberingRolePrivilegesPK() {
        return numberingRolePrivilegesPK;
    }

    public void setNumberingRolePrivilegesPK(NumberingRolePrivilegesPK numberingRolePrivilegesPK) {
        this.numberingRolePrivilegesPK = numberingRolePrivilegesPK;
    }

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberingRolePrivilegesPK != null ? numberingRolePrivilegesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberingRolePrivileges)) {
            return false;
        }
        NumberingRolePrivileges other = (NumberingRolePrivileges) object;
        if ((this.numberingRolePrivilegesPK == null && other.numberingRolePrivilegesPK != null) || (this.numberingRolePrivilegesPK != null && !this.numberingRolePrivilegesPK.equals(other.numberingRolePrivilegesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NumberingRolePrivileges[ numberingRolePrivilegesPK=" + numberingRolePrivilegesPK + " ]";
    }
    
}
