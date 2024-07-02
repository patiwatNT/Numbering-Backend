package com.billng.numbering.dto;

import com.billng.numbering.annotation.CheckDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.util.Date;

@ApiModel()
public class NbrReserveDto extends AbstractDto<Long> {
    private Long rsvId;
    @Size(max = 255)
    private String rsvStart;
    @Size(max = 255)
    private String rsvEnd;
    @Max(Integer.MAX_VALUE)
    private Integer rsvQty;
    @Size(max = 255)
    private String rsvStatus;
    @Size(max = 255)
    private String rsvRequester;
    @Size(max = 255)
    private String docRef;
    @Size(max = 255)
    private String requestDateTmp;
    @CheckDate
    private Date requestDate;
    @Size(max = 255)
    private String requestBy;
    @Size(max = 255)
    private String rsvObjective;
    @CheckDate
    private Date rsvStartDate;
    @CheckDate
    private Date rsvEndDate;
    @Size(max = 255)
    private String rsvCustName;
    @Size(max = 255)
    private String rsvProject;
    @Size(max = 255)
    private String rsvRemark;

    public NbrReserveDto() {
    }

    public void setRsvId(Long rsvId) {
        this.rsvId = rsvId;
    }

    public Long getRsvId() {
        return this.rsvId;
    }

    public void setRsvStart(String rsvStart) {
        this.rsvStart = rsvStart;
    }

    public String getRsvStart() {
        return this.rsvStart;
    }

    public void setRsvEnd(String rsvEnd) {
        this.rsvEnd = rsvEnd;
    }

    public String getRsvEnd() {
        return this.rsvEnd;
    }

    public void setRsvQty(Integer rsvQty) {
        this.rsvQty = rsvQty;
    }

    public Integer getRsvQty() {
        return this.rsvQty;
    }

    public void setRsvStatus(String rsvStatus) {
        this.rsvStatus = rsvStatus;
    }

    public String getRsvStatus() {
        return this.rsvStatus;
    }

    public void setRsvRequester(String rsvRequester) {
        this.rsvRequester = rsvRequester;
    }

    public String getRsvRequester() {
        return this.rsvRequester;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public String getDocRef() {
        return this.docRef;
    }

    public void setRequestDateTmp(String requestDateTmp) {
        this.requestDateTmp = requestDateTmp;
    }

    public String getRequestDateTmp() {
        return this.requestDateTmp;
    }

    public void setRequestDate(java.util.Date requestDate) {
        this.requestDate = requestDate;
    }

    public java.util.Date getRequestDate() {
        return this.requestDate;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public String getRequestBy() {
        return this.requestBy;
    }

    public void setRsvObjective(String rsvObjective) {
        this.rsvObjective = rsvObjective;
    }

    public String getRsvObjective() {
        return this.rsvObjective;
    }

    public void setRsvStartDate(java.util.Date rsvStartDate) {
        this.rsvStartDate = rsvStartDate;
    }

    public java.util.Date getRsvStartDate() {
        return this.rsvStartDate;
    }

    public void setRsvEndDate(java.util.Date rsvEndDate) {
        this.rsvEndDate = rsvEndDate;
    }

    public java.util.Date getRsvEndDate() {
        return this.rsvEndDate;
    }

    public void setRsvCustName(String rsvCustName) {
        this.rsvCustName = rsvCustName;
    }

    public String getRsvCustName() {
        return this.rsvCustName;
    }

    public void setRsvProject(String rsvProject) {
        this.rsvProject = rsvProject;
    }

    public String getRsvProject() {
        return this.rsvProject;
    }

    public void setRsvRemark(String rsvRemark) {
        this.rsvRemark = rsvRemark;
    }

    public String getRsvRemark() {
        return this.rsvRemark;
    }
}