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
@Table(name = "NBR_ASSIGNED")
@NamedQueries({
    @NamedQuery(name = "NbrAssigned.findAll", query = "SELECT n FROM NbrAssigned n")})
public class NbrAssigned implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "assigned_id")
    private Integer assignedId;
    @Basic(optional = false)
    @Column(name = "assigned_start")
    private String assignedStart;
    @Basic(optional = false)
    @Column(name = "assigned_end")
    private String assignedEnd;
    @Column(name = "assigned_qty")
    private Integer assignedQty;
    @Column(name = "provider_id")
    private Integer providerId;
    @Column(name = "idx_before")
    private Integer idxBefore;
    @Column(name = "assigned_location_code")
    private String assignedLocationCode;
    @Column(name = "x_assigned_sector")
    private String xAssignedSector;
    @Column(name = "x_assigned_dept")
    private String xAssignedDept;
    @Column(name = "x_assigned_region")
    private String xAssignedRegion;
    @Column(name = "assigned_modified_by")
    private String assignedModifiedBy;
    @Column(name = "assigned_last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedLastModified;
    @Column(name = "block_id")
    private Integer blockId;
    @Column(name = "ready_to_service")
    private Integer readyToService;
    @Column(name = "assigned_detail_id")
    private Integer assignedDetailId;
    @Column(name = "station_code")
    private String stationCode;
    @Column(name = "station_code_ttt")
    private String stationCodeTtt;
    @Column(name = "project")
    private String project;
    @Column(name = "exch_type_ttt")
    private String exchTypeTtt;
    @Column(name = "region")
    private String region;
    @Column(name = "station_abbr")
    private String stationAbbr;
    @Column(name = "station_name_th")
    private String stationNameTh;
    @Column(name = "station_name_en")
    private String stationNameEn;
    @Column(name = "location_name")
    private String locationName;
    @Column(name = "exch_network")
    private String exchNetwork;
    @Column(name = "exch_rank")
    private String exchRank;
    @Column(name = "exch_system")
    private String exchSystem;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "install_location")
    private String installLocation;
    @Column(name = "building")
    private String building;
    @Column(name = "street")
    private String street;
    @Column(name = "road")
    private String road;
    @Column(name = "village")
    private String village;
    @Column(name = "zone")
    private String zone;
    @Column(name = "area")
    private String area;
    @Column(name = "province")
    private String province;
    @Column(name = "postcode")
    private String postcode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "detail_modified_by")
    private String detailModifiedBy;
    @Column(name = "detail_last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date detailLastModified;
    @Column(name = "service_type")
    private String serviceType;
    @Column(name = "doc_ref")
    private String docRef;
    @Column(name = "true_department")
    private String trueDepartment;
    @Column(name = "true_sector")
    private String trueSector;
    @Column(name = "true_loc_code")
    private String trueLocCode;
    @Column(name = "rcu")
    private String rcu;
    @Column(name = "rcu1")
    private String rcu1;
    @Column(name = "assigned_sector")
    private String assignedSector;
    @Column(name = "assigned_dept")
    private String assignedDept;
    @Column(name = "assigned_region")
    private String assignedRegion;
    @Column(name = "assigned_work_area")
    private String assignedWorkArea;

    public NbrAssigned() {
    }

    public NbrAssigned(Integer assignedId) {
        this.assignedId = assignedId;
    }

    public NbrAssigned(Integer assignedId, String assignedStart, String assignedEnd) {
        this.assignedId = assignedId;
        this.assignedStart = assignedStart;
        this.assignedEnd = assignedEnd;
    }

    public Integer getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(Integer assignedId) {
        this.assignedId = assignedId;
    }

    public String getAssignedStart() {
        return assignedStart;
    }

    public void setAssignedStart(String assignedStart) {
        this.assignedStart = assignedStart;
    }

    public String getAssignedEnd() {
        return assignedEnd;
    }

    public void setAssignedEnd(String assignedEnd) {
        this.assignedEnd = assignedEnd;
    }

    public Integer getAssignedQty() {
        return assignedQty;
    }

    public void setAssignedQty(Integer assignedQty) {
        this.assignedQty = assignedQty;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getIdxBefore() {
        return idxBefore;
    }

    public void setIdxBefore(Integer idxBefore) {
        this.idxBefore = idxBefore;
    }

    public String getAssignedLocationCode() {
        return assignedLocationCode;
    }

    public void setAssignedLocationCode(String assignedLocationCode) {
        this.assignedLocationCode = assignedLocationCode;
    }

    public String getXAssignedSector() {
        return xAssignedSector;
    }

    public void setXAssignedSector(String xAssignedSector) {
        this.xAssignedSector = xAssignedSector;
    }

    public String getXAssignedDept() {
        return xAssignedDept;
    }

    public void setXAssignedDept(String xAssignedDept) {
        this.xAssignedDept = xAssignedDept;
    }

    public String getXAssignedRegion() {
        return xAssignedRegion;
    }

    public void setXAssignedRegion(String xAssignedRegion) {
        this.xAssignedRegion = xAssignedRegion;
    }

    public String getAssignedModifiedBy() {
        return assignedModifiedBy;
    }

    public void setAssignedModifiedBy(String assignedModifiedBy) {
        this.assignedModifiedBy = assignedModifiedBy;
    }

    public Date getAssignedLastModified() {
        return assignedLastModified;
    }

    public void setAssignedLastModified(Date assignedLastModified) {
        this.assignedLastModified = assignedLastModified;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getReadyToService() {
        return readyToService;
    }

    public void setReadyToService(Integer readyToService) {
        this.readyToService = readyToService;
    }

    public Integer getAssignedDetailId() {
        return assignedDetailId;
    }

    public void setAssignedDetailId(Integer assignedDetailId) {
        this.assignedDetailId = assignedDetailId;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationCodeTtt() {
        return stationCodeTtt;
    }

    public void setStationCodeTtt(String stationCodeTtt) {
        this.stationCodeTtt = stationCodeTtt;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getExchTypeTtt() {
        return exchTypeTtt;
    }

    public void setExchTypeTtt(String exchTypeTtt) {
        this.exchTypeTtt = exchTypeTtt;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStationAbbr() {
        return stationAbbr;
    }

    public void setStationAbbr(String stationAbbr) {
        this.stationAbbr = stationAbbr;
    }

    public String getStationNameTh() {
        return stationNameTh;
    }

    public void setStationNameTh(String stationNameTh) {
        this.stationNameTh = stationNameTh;
    }

    public String getStationNameEn() {
        return stationNameEn;
    }

    public void setStationNameEn(String stationNameEn) {
        this.stationNameEn = stationNameEn;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getExchNetwork() {
        return exchNetwork;
    }

    public void setExchNetwork(String exchNetwork) {
        this.exchNetwork = exchNetwork;
    }

    public String getExchRank() {
        return exchRank;
    }

    public void setExchRank(String exchRank) {
        this.exchRank = exchRank;
    }

    public String getExchSystem() {
        return exchSystem;
    }

    public void setExchSystem(String exchSystem) {
        this.exchSystem = exchSystem;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDetailModifiedBy() {
        return detailModifiedBy;
    }

    public void setDetailModifiedBy(String detailModifiedBy) {
        this.detailModifiedBy = detailModifiedBy;
    }

    public Date getDetailLastModified() {
        return detailLastModified;
    }

    public void setDetailLastModified(Date detailLastModified) {
        this.detailLastModified = detailLastModified;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDocRef() {
        return docRef;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public String getTrueDepartment() {
        return trueDepartment;
    }

    public void setTrueDepartment(String trueDepartment) {
        this.trueDepartment = trueDepartment;
    }

    public String getTrueSector() {
        return trueSector;
    }

    public void setTrueSector(String trueSector) {
        this.trueSector = trueSector;
    }

    public String getTrueLocCode() {
        return trueLocCode;
    }

    public void setTrueLocCode(String trueLocCode) {
        this.trueLocCode = trueLocCode;
    }

    public String getRcu() {
        return rcu;
    }

    public void setRcu(String rcu) {
        this.rcu = rcu;
    }

    public String getRcu1() {
        return rcu1;
    }

    public void setRcu1(String rcu1) {
        this.rcu1 = rcu1;
    }

    public String getAssignedSector() {
        return assignedSector;
    }

    public void setAssignedSector(String assignedSector) {
        this.assignedSector = assignedSector;
    }

    public String getAssignedDept() {
        return assignedDept;
    }

    public void setAssignedDept(String assignedDept) {
        this.assignedDept = assignedDept;
    }

    public String getAssignedRegion() {
        return assignedRegion;
    }

    public void setAssignedRegion(String assignedRegion) {
        this.assignedRegion = assignedRegion;
    }

    public String getAssignedWorkArea() {
        return assignedWorkArea;
    }

    public void setAssignedWorkArea(String assignedWorkArea) {
        this.assignedWorkArea = assignedWorkArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assignedId != null ? assignedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NbrAssigned)) {
            return false;
        }
        NbrAssigned other = (NbrAssigned) object;
        if ((this.assignedId == null && other.assignedId != null) || (this.assignedId != null && !this.assignedId.equals(other.assignedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.NbrAssigned[ assignedId=" + assignedId + " ]";
    }
    
}
