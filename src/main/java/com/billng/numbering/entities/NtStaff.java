/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "NT_STAFF")
public class NtStaff implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "empcode")
    private String empcode;
    @Column(name = "title_th")
    private String titleTh;
    @Column(name = "first_name_th")
    private String firstNameTh;
    @Column(name = "last_name_th")
    private String lastNameTh;
    @Column(name = "title_en")
    private String titleEn;
    @Column(name = "first_name_en")
    private String firstNameEn;
    @Column(name = "sex")
    private String sex;
    @Column(name = "last_name_en")
    private String lastNameEn;
    @Column(name = "pc")
    private String pc;
    @Column(name = "cctr")
    private String cctr;
    @Column(name = "pos_abbr")
    private String posAbbr;
    @Column(name = "pos_full")
    private String posFull;
    @Column(name = "dep_abbr")
    private String depAbbr;
    @Column(name = "dep_full")
    private String depFull;
    @Column(name = "pos_level")
    private String posLevel;
    @Column(name = "curr_dep_abbr")
    private String currDepAbbr;
    @Column(name = "curr_dep_full")
    private String currDepFull;
    @Column(name = "hierachy_code")
    private String hierachyCode;
    @Column(name = "header_code")
    private String headerCode;
    @Column(name = "email")
    private String email;
    @Column(name = "org_dep_name_th_lv3")
    private String orgDepNameThLv3;
    @Column(name = "org_dep_name_th_lv4")
    private String orgDepNameThLv4;
    @Column(name = "org_dep_name_th_lv5")
    private String orgDepNameThLv5;
    @Column(name = "org_dep_name_th_lv6")
    private String orgDepNameThLv6;
    @Column(name = "org_dep_abbr_lv3")
    private String orgDepAbbrLv3;
    @Column(name = "org_dep_abbr_lv4")
    private String orgDepAbbrLv4;
    @Column(name = "org_dep_abbr_lv5")
    private String orgDepAbbrLv5;
    @Column(name = "org_dep_abbr_lv6")
    private String orgDepAbbrLv6;

    public NtStaff() {
    }

    public NtStaff(String empcode) {
        this.empcode = empcode;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getTitleTh() {
        return titleTh;
    }

    public void setTitleTh(String titleTh) {
        this.titleTh = titleTh;
    }

    public String getFirstNameTh() {
        return firstNameTh;
    }

    public void setFirstNameTh(String firstNameTh) {
        this.firstNameTh = firstNameTh;
    }

    public String getLastNameTh() {
        return lastNameTh;
    }

    public void setLastNameTh(String lastNameTh) {
        this.lastNameTh = lastNameTh;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getFirstNameEn() {
        return firstNameEn;
    }

    public void setFirstNameEn(String firstNameEn) {
        this.firstNameEn = firstNameEn;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLastNameEn() {
        return lastNameEn;
    }

    public void setLastNameEn(String lastNameEn) {
        this.lastNameEn = lastNameEn;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getCctr() {
        return cctr;
    }

    public void setCctr(String cctr) {
        this.cctr = cctr;
    }

    public String getPosAbbr() {
        return posAbbr;
    }

    public void setPosAbbr(String posAbbr) {
        this.posAbbr = posAbbr;
    }

    public String getPosFull() {
        return posFull;
    }

    public void setPosFull(String posFull) {
        this.posFull = posFull;
    }

    public String getDepAbbr() {
        return depAbbr;
    }

    public void setDepAbbr(String depAbbr) {
        this.depAbbr = depAbbr;
    }

    public String getDepFull() {
        return depFull;
    }

    public void setDepFull(String depFull) {
        this.depFull = depFull;
    }

    public String getPosLevel() {
        return posLevel;
    }

    public void setPosLevel(String posLevel) {
        this.posLevel = posLevel;
    }

    public String getCurrDepAbbr() {
        return currDepAbbr;
    }

    public void setCurrDepAbbr(String currDepAbbr) {
        this.currDepAbbr = currDepAbbr;
    }

    public String getCurrDepFull() {
        return currDepFull;
    }

    public void setCurrDepFull(String currDepFull) {
        this.currDepFull = currDepFull;
    }

    public String getHierachyCode() {
        return hierachyCode;
    }

    public void setHierachyCode(String hierachyCode) {
        this.hierachyCode = hierachyCode;
    }

    public String getHeaderCode() {
        return headerCode;
    }

    public void setHeaderCode(String headerCode) {
        this.headerCode = headerCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgDepNameThLv3() {
        return orgDepNameThLv3;
    }

    public void setOrgDepNameThLv3(String orgDepNameThLv3) {
        this.orgDepNameThLv3 = orgDepNameThLv3;
    }

    public String getOrgDepNameThLv4() {
        return orgDepNameThLv4;
    }

    public void setOrgDepNameThLv4(String orgDepNameThLv4) {
        this.orgDepNameThLv4 = orgDepNameThLv4;
    }

    public String getOrgDepNameThLv5() {
        return orgDepNameThLv5;
    }

    public void setOrgDepNameThLv5(String orgDepNameThLv5) {
        this.orgDepNameThLv5 = orgDepNameThLv5;
    }

    public String getOrgDepNameThLv6() {
        return orgDepNameThLv6;
    }

    public void setOrgDepNameThLv6(String orgDepNameThLv6) {
        this.orgDepNameThLv6 = orgDepNameThLv6;
    }

    public String getOrgDepAbbrLv3() {
        return orgDepAbbrLv3;
    }

    public void setOrgDepAbbrLv3(String orgDepAbbrLv3) {
        this.orgDepAbbrLv3 = orgDepAbbrLv3;
    }

    public String getOrgDepAbbrLv4() {
        return orgDepAbbrLv4;
    }

    public void setOrgDepAbbrLv4(String orgDepAbbrLv4) {
        this.orgDepAbbrLv4 = orgDepAbbrLv4;
    }

    public String getOrgDepAbbrLv5() {
        return orgDepAbbrLv5;
    }

    public void setOrgDepAbbrLv5(String orgDepAbbrLv5) {
        this.orgDepAbbrLv5 = orgDepAbbrLv5;
    }

    public String getOrgDepAbbrLv6() {
        return orgDepAbbrLv6;
    }

    public void setOrgDepAbbrLv6(String orgDepAbbrLv6) {
        this.orgDepAbbrLv6 = orgDepAbbrLv6;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empcode != null ? empcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NtStaff)) {
            return false;
        }
        NtStaff other = (NtStaff) object;
        if ((this.empcode == null && other.empcode != null) || (this.empcode != null && !this.empcode.equals(other.empcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NtStaff[ empcode=" + empcode + " ]";
    }
    
}
