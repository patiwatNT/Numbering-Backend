package com.billng.numbering.dto;

import com.billng.numbering.annotation.CheckEmail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class NtStaffDto extends AbstractDto<String> {
    @Size(max = 255)
    private String empcode;
    @Size(max = 255)
    private String titleTh;
    @Size(max = 255)
    private String firstNameTh;
    @Size(max = 255)
    private String lastNameTh;
    @Size(max = 255)
    private String titleEn;
    @Size(max = 255)
    private String firstNameEn;
    @Size(max = 255)
    private String sex;
    @Size(max = 255)
    private String lastNameEn;
    @Size(max = 255)
    private String pc;
    @Size(max = 255)
    private String cctr;
    @Size(max = 255)
    private String posAbbr;
    @Size(max = 255)
    private String posFull;
    @Size(max = 255)
    private String depAbbr;
    @Size(max = 255)
    private String depFull;
    @Size(max = 255)
    private String posLevel;
    @Size(max = 255)
    private String currDepAbbr;
    @Size(max = 255)
    private String currDepFull;
    @Size(max = 255)
    private String hierachyCode;
    @Size(max = 255)
    private String headerCode;
    @CheckEmail
    @Size(max = 255)
    private String email;
    @Size(max = 255)
    private String orgDepNameThLv3;
    @Size(max = 255)
    private String orgDepNameThLv4;
    @Size(max = 255)
    private String orgDepNameThLv5;
    @Size(max = 255)
    private String orgDepNameThLv6;
    @Size(max = 255)
    private String orgDepAbbrLv3;
    @Size(max = 255)
    private String orgDepAbbrLv4;
    @Size(max = 255)
    private String orgDepAbbrLv5;
    @Size(max = 255)
    private String orgDepAbbrLv6;

    public NtStaffDto() {
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getEmpcode() {
        return this.empcode;
    }

    public void setTitleTh(String titleTh) {
        this.titleTh = titleTh;
    }

    public String getTitleTh() {
        return this.titleTh;
    }

    public void setFirstNameTh(String firstNameTh) {
        this.firstNameTh = firstNameTh;
    }

    public String getFirstNameTh() {
        return this.firstNameTh;
    }

    public void setLastNameTh(String lastNameTh) {
        this.lastNameTh = lastNameTh;
    }

    public String getLastNameTh() {
        return this.lastNameTh;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleEn() {
        return this.titleEn;
    }

    public void setFirstNameEn(String firstNameEn) {
        this.firstNameEn = firstNameEn;
    }

    public String getFirstNameEn() {
        return this.firstNameEn;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    public void setLastNameEn(String lastNameEn) {
        this.lastNameEn = lastNameEn;
    }

    public String getLastNameEn() {
        return this.lastNameEn;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getPc() {
        return this.pc;
    }

    public void setCctr(String cctr) {
        this.cctr = cctr;
    }

    public String getCctr() {
        return this.cctr;
    }

    public void setPosAbbr(String posAbbr) {
        this.posAbbr = posAbbr;
    }

    public String getPosAbbr() {
        return this.posAbbr;
    }

    public void setPosFull(String posFull) {
        this.posFull = posFull;
    }

    public String getPosFull() {
        return this.posFull;
    }

    public void setDepAbbr(String depAbbr) {
        this.depAbbr = depAbbr;
    }

    public String getDepAbbr() {
        return this.depAbbr;
    }

    public void setDepFull(String depFull) {
        this.depFull = depFull;
    }

    public String getDepFull() {
        return this.depFull;
    }

    public void setPosLevel(String posLevel) {
        this.posLevel = posLevel;
    }

    public String getPosLevel() {
        return this.posLevel;
    }

    public void setCurrDepAbbr(String currDepAbbr) {
        this.currDepAbbr = currDepAbbr;
    }

    public String getCurrDepAbbr() {
        return this.currDepAbbr;
    }

    public void setCurrDepFull(String currDepFull) {
        this.currDepFull = currDepFull;
    }

    public String getCurrDepFull() {
        return this.currDepFull;
    }

    public void setHierachyCode(String hierachyCode) {
        this.hierachyCode = hierachyCode;
    }

    public String getHierachyCode() {
        return this.hierachyCode;
    }

    public void setHeaderCode(String headerCode) {
        this.headerCode = headerCode;
    }

    public String getHeaderCode() {
        return this.headerCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setOrgDepNameThLv3(String orgDepNameThLv3) {
        this.orgDepNameThLv3 = orgDepNameThLv3;
    }

    public String getOrgDepNameThLv3() {
        return this.orgDepNameThLv3;
    }

    public void setOrgDepNameThLv4(String orgDepNameThLv4) {
        this.orgDepNameThLv4 = orgDepNameThLv4;
    }

    public String getOrgDepNameThLv4() {
        return this.orgDepNameThLv4;
    }

    public void setOrgDepNameThLv5(String orgDepNameThLv5) {
        this.orgDepNameThLv5 = orgDepNameThLv5;
    }

    public String getOrgDepNameThLv5() {
        return this.orgDepNameThLv5;
    }

    public void setOrgDepNameThLv6(String orgDepNameThLv6) {
        this.orgDepNameThLv6 = orgDepNameThLv6;
    }

    public String getOrgDepNameThLv6() {
        return this.orgDepNameThLv6;
    }

    public void setOrgDepAbbrLv3(String orgDepAbbrLv3) {
        this.orgDepAbbrLv3 = orgDepAbbrLv3;
    }

    public String getOrgDepAbbrLv3() {
        return this.orgDepAbbrLv3;
    }

    public void setOrgDepAbbrLv4(String orgDepAbbrLv4) {
        this.orgDepAbbrLv4 = orgDepAbbrLv4;
    }

    public String getOrgDepAbbrLv4() {
        return this.orgDepAbbrLv4;
    }

    public void setOrgDepAbbrLv5(String orgDepAbbrLv5) {
        this.orgDepAbbrLv5 = orgDepAbbrLv5;
    }

    public String getOrgDepAbbrLv5() {
        return this.orgDepAbbrLv5;
    }

    public void setOrgDepAbbrLv6(String orgDepAbbrLv6) {
        this.orgDepAbbrLv6 = orgDepAbbrLv6;
    }

    public String getOrgDepAbbrLv6() {
        return this.orgDepAbbrLv6;
    }
}