/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "NUMBERING_ROLES")
public class NumberingRoles implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ROLE_ID")
    private BigDecimal roleId;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @OneToMany(mappedBy = "roleId")
    @JsonBackReference
    private Collection<NumberingUsers> numberingUsersCollection;

    public NumberingRoles() {
    }

    public NumberingRoles(BigDecimal roleId) {
        this.roleId = roleId;
    }

    public BigDecimal getRoleId() {
        return roleId;
    }

    public void setRoleId(BigDecimal roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<NumberingUsers> getNumberingUsersCollection() {
        return numberingUsersCollection;
    }

    public void setNumberingUsersCollection(Collection<NumberingUsers> numberingUsersCollection) {
        this.numberingUsersCollection = numberingUsersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberingRoles)) {
            return false;
        }
        NumberingRoles other = (NumberingRoles) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NumberingRoles[ roleId=" + roleId + " ]";
    }
    
}
