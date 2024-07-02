/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "NBR_RESERVE")
public class NbrReserve implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "rsvId")
    private Long rsvId;
    @Basic(optional = false)
    @Column(name = "rsvStart")
    private String rsvStart;
    @Basic(optional = false)
    @Column(name = "rsvEnd")
    private String rsvEnd;
    @Column(name = "rsvQty")
    private Integer rsvQty;
    @Column(name = "rsvStatus")
    private String rsvStatus;
    @Column(name = "rsvRequester")
    private String rsvRequester;
    @Column(name = "docRef")
    private String docRef;
    @Column(name = "requestDateTmp")
    private String requestDateTmp;
    @Column(name = "requestDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Column(name = "requestBy")
    private String requestBy;
    @Column(name = "rsvObjective")
    private String rsvObjective;
    @Column(name = "rsvStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsvStartDate;
    @Column(name = "rsvEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsvEndDate;
    @Column(name = "rsvCustName")
    private String rsvCustName;
    @Column(name = "rsvProject")
    private String rsvProject;
    @Column(name = "rsvRemark")
    private String rsvRemark;

    public NbrReserve() {
    }

    public NbrReserve(Long rsvId) {
        this.rsvId = rsvId;
    }

    public NbrReserve(Long rsvId, String rsvStart, String rsvEnd) {
        this.rsvId = rsvId;
        this.rsvStart = rsvStart;
        this.rsvEnd = rsvEnd;
    }

    public Long getRsvId() {
        return rsvId;
    }

    public void setRsvId(Long rsvId) {
        this.rsvId = rsvId;
    }

    public String getRsvStart() {
        return rsvStart;
    }

    public void setRsvStart(String rsvStart) {
        this.rsvStart = rsvStart;
    }

    public String getRsvEnd() {
        return rsvEnd;
    }

    public void setRsvEnd(String rsvEnd) {
        this.rsvEnd = rsvEnd;
    }

    public Integer getRsvQty() {
        return rsvQty;
    }

    public void setRsvQty(Integer rsvQty) {
        this.rsvQty = rsvQty;
    }

    public String getRsvStatus() {
        return rsvStatus;
    }

    public void setRsvStatus(String rsvStatus) {
        this.rsvStatus = rsvStatus;
    }

    public String getRsvRequester() {
        return rsvRequester;
    }

    public void setRsvRequester(String rsvRequester) {
        this.rsvRequester = rsvRequester;
    }

    public String getDocRef() {
        return docRef;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public String getRequestDateTmp() {
        return requestDateTmp;
    }

    public void setRequestDateTmp(String requestDateTmp) {
        this.requestDateTmp = requestDateTmp;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public String getRsvObjective() {
        return rsvObjective;
    }

    public void setRsvObjective(String rsvObjective) {
        this.rsvObjective = rsvObjective;
    }

    public Date getRsvStartDate() {
        return rsvStartDate;
    }

    public void setRsvStartDate(Date rsvStartDate) {
        this.rsvStartDate = rsvStartDate;
    }

    public Date getRsvEndDate() {
        return rsvEndDate;
    }

    public void setRsvEndDate(Date rsvEndDate) {
        this.rsvEndDate = rsvEndDate;
    }

    public String getRsvCustName() {
        return rsvCustName;
    }

    public void setRsvCustName(String rsvCustName) {
        this.rsvCustName = rsvCustName;
    }

    public String getRsvProject() {
        return rsvProject;
    }

    public void setRsvProject(String rsvProject) {
        this.rsvProject = rsvProject;
    }

    public String getRsvRemark() {
        return rsvRemark;
    }

    public void setRsvRemark(String rsvRemark) {
        this.rsvRemark = rsvRemark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rsvId != null ? rsvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NbrReserve)) {
            return false;
        }
        NbrReserve other = (NbrReserve) object;
        if ((this.rsvId == null && other.rsvId != null) || (this.rsvId != null && !this.rsvId.equals(other.rsvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NbrReserve[ rsvId=" + rsvId + " ]";
    }
    
}
