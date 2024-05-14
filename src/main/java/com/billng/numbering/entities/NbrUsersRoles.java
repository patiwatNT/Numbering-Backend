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
@lombok.Data
@Entity
@Table(name = "NBR_USERS_ROLES")
public class NbrUsersRoles implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "empId")
    private String empId;
    @Basic(optional = false)
    @Column(name = "activeStatus")
    private int activeStatus;
    @Basic(optional = false)
    @Column(name = "role1")
    private int role1;
    @Basic(optional = false)
    @Column(name = "role2")
    private int role2;
    @Basic(optional = false)
    @Column(name = "role3")
    private int role3;
    @Basic(optional = false)
    @Column(name = "role4")
    private int role4;
    @Basic(optional = false)
    @Column(name = "role5")
    private int role5;
    @Basic(optional = false)
    @Column(name = "role6")
    private int role6;
    @Column(name = "role7")
    private Integer role7;
    @Column(name = "role8")
    private Integer role8;
    @Column(name = "role9")
    private Integer role9;
    @Column(name = "role10")
    private Integer role10;
    @Column(name = "rep1")
    private Integer rep1;
    @Column(name = "rep2")
    private Integer rep2;
    @Column(name = "rep3")
    private Integer rep3;
    @Column(name = "rep4")
    private Integer rep4;
    @Column(name = "rep5")
    private Integer rep5;
    @Column(name = "modifiedBy")
    private String modifiedBy;
    @Column(name = "lastModified")
    private String lastModified;
    @Column(name = "adminFlag")
    private Integer adminFlag;

    public NbrUsersRoles() {
    }

    public NbrUsersRoles(String empId) {
        this.empId = empId;
    }

    public NbrUsersRoles(String empId, int activeStatus, int role1, int role2, int role3, int role4, int role5, int role6) {
        this.empId = empId;
        this.activeStatus = activeStatus;
        this.role1 = role1;
        this.role2 = role2;
        this.role3 = role3;
        this.role4 = role4;
        this.role5 = role5;
        this.role6 = role6;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public int getRole1() {
        return role1;
    }

    public void setRole1(int role1) {
        this.role1 = role1;
    }

    public int getRole2() {
        return role2;
    }

    public void setRole2(int role2) {
        this.role2 = role2;
    }

    public int getRole3() {
        return role3;
    }

    public void setRole3(int role3) {
        this.role3 = role3;
    }

    public int getRole4() {
        return role4;
    }

    public void setRole4(int role4) {
        this.role4 = role4;
    }

    public int getRole5() {
        return role5;
    }

    public void setRole5(int role5) {
        this.role5 = role5;
    }

    public int getRole6() {
        return role6;
    }

    public void setRole6(int role6) {
        this.role6 = role6;
    }

    public Integer getRole7() {
        return role7;
    }

    public void setRole7(Integer role7) {
        this.role7 = role7;
    }

    public Integer getRole8() {
        return role8;
    }

    public void setRole8(Integer role8) {
        this.role8 = role8;
    }

    public Integer getRole9() {
        return role9;
    }

    public void setRole9(Integer role9) {
        this.role9 = role9;
    }

    public Integer getRole10() {
        return role10;
    }

    public void setRole10(Integer role10) {
        this.role10 = role10;
    }

    public Integer getRep1() {
        return rep1;
    }

    public void setRep1(Integer rep1) {
        this.rep1 = rep1;
    }

    public Integer getRep2() {
        return rep2;
    }

    public void setRep2(Integer rep2) {
        this.rep2 = rep2;
    }

    public Integer getRep3() {
        return rep3;
    }

    public void setRep3(Integer rep3) {
        this.rep3 = rep3;
    }

    public Integer getRep4() {
        return rep4;
    }

    public void setRep4(Integer rep4) {
        this.rep4 = rep4;
    }

    public Integer getRep5() {
        return rep5;
    }

    public void setRep5(Integer rep5) {
        this.rep5 = rep5;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(Integer adminFlag) {
        this.adminFlag = adminFlag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NbrUsersRoles)) {
            return false;
        }
        NbrUsersRoles other = (NbrUsersRoles) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NbrUsersRoles[ empId=" + empId + " ]";
    }
    
}
