package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class NbrUsersRolesDto extends AbstractDto<String> {
    @Size(max = 255)
    private String empId;
    private int activeStatus;
    private int role1;
    private int role2;
    private int role3;
    private int role4;
    private int role5;
    private int role6;
    @Max(Integer.MAX_VALUE)
    private Integer role7;
    @Max(Integer.MAX_VALUE)
    private Integer role8;
    @Max(Integer.MAX_VALUE)
    private Integer role9;
    @Max(Integer.MAX_VALUE)
    private Integer role10;
    @Max(Integer.MAX_VALUE)
    private Integer rep1;
    @Max(Integer.MAX_VALUE)
    private Integer rep2;
    @Max(Integer.MAX_VALUE)
    private Integer rep3;
    @Max(Integer.MAX_VALUE)
    private Integer rep4;
    @Max(Integer.MAX_VALUE)
    private Integer rep5;
    @Size(max = 255)
    private String modifiedBy;
    @Size(max = 255)
    private String lastModified;
    @Max(Integer.MAX_VALUE)
    private Integer adminFlag;

    public NbrUsersRolesDto() {
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return this.empId;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public int getActiveStatus() {
        return this.activeStatus;
    }

    public void setRole1(int role1) {
        this.role1 = role1;
    }

    public int getRole1() {
        return this.role1;
    }

    public void setRole2(int role2) {
        this.role2 = role2;
    }

    public int getRole2() {
        return this.role2;
    }

    public void setRole3(int role3) {
        this.role3 = role3;
    }

    public int getRole3() {
        return this.role3;
    }

    public void setRole4(int role4) {
        this.role4 = role4;
    }

    public int getRole4() {
        return this.role4;
    }

    public void setRole5(int role5) {
        this.role5 = role5;
    }

    public int getRole5() {
        return this.role5;
    }

    public void setRole6(int role6) {
        this.role6 = role6;
    }

    public int getRole6() {
        return this.role6;
    }

    public void setRole7(Integer role7) {
        this.role7 = role7;
    }

    public Integer getRole7() {
        return this.role7;
    }

    public void setRole8(Integer role8) {
        this.role8 = role8;
    }

    public Integer getRole8() {
        return this.role8;
    }

    public void setRole9(Integer role9) {
        this.role9 = role9;
    }

    public Integer getRole9() {
        return this.role9;
    }

    public void setRole10(Integer role10) {
        this.role10 = role10;
    }

    public Integer getRole10() {
        return this.role10;
    }

    public void setRep1(Integer rep1) {
        this.rep1 = rep1;
    }

    public Integer getRep1() {
        return this.rep1;
    }

    public void setRep2(Integer rep2) {
        this.rep2 = rep2;
    }

    public Integer getRep2() {
        return this.rep2;
    }

    public void setRep3(Integer rep3) {
        this.rep3 = rep3;
    }

    public Integer getRep3() {
        return this.rep3;
    }

    public void setRep4(Integer rep4) {
        this.rep4 = rep4;
    }

    public Integer getRep4() {
        return this.rep4;
    }

    public void setRep5(Integer rep5) {
        this.rep5 = rep5;
    }

    public Integer getRep5() {
        return this.rep5;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public void setAdminFlag(Integer adminFlag) {
        this.adminFlag = adminFlag;
    }

    public Integer getAdminFlag() {
        return this.adminFlag;
    }
}