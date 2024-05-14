package com.billng.numbering.dto;

import com.billng.numbering.annotation.CheckDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.util.Date;

@ApiModel()
public class NbrAssignedDto extends AbstractDto<Integer> {
    private long serialVersionUID;
    @Max(Integer.MAX_VALUE)
    private Integer assignedId;
    @Size(max = 255)
    private String assignedStart;
    @Size(max = 255)
    private String assignedEnd;
    @Max(Integer.MAX_VALUE)
    private Integer assignedQty;
    @Max(Integer.MAX_VALUE)
    private Integer providerId;
    @Max(Integer.MAX_VALUE)
    private Integer idxBefore;
    @Size(max = 255)
    private String assignedLocationCode;
    @Size(max = 255)
    private String xAssignedSector;
    @Size(max = 255)
    private String xAssignedDept;
    @Size(max = 255)
    private String xAssignedRegion;
    @Size(max = 255)
    private String assignedModifiedBy;
    @CheckDate
    private Date assignedLastModified;
    @Max(Integer.MAX_VALUE)
    private Integer blockId;
    @Max(Integer.MAX_VALUE)
    private Integer readyToService;
    @Max(Integer.MAX_VALUE)
    private Integer assignedDetailId;
    @Size(max = 255)
    private String stationCode;
    @Size(max = 255)
    private String stationCodeTtt;
    @Size(max = 255)
    private String project;
    @Size(max = 255)
    private String exchTypeTtt;
    @Size(max = 255)
    private String region;
    @Size(max = 255)
    private String stationAbbr;
    @Size(max = 255)
    private String stationNameTh;
    @Size(max = 255)
    private String stationNameEn;
    @Size(max = 255)
    private String locationName;
    @Size(max = 255)
    private String exchNetwork;
    @Size(max = 255)
    private String exchRank;
    @Size(max = 255)
    private String exchSystem;
    @Size(max = 255)
    private String brandName;
    @Size(max = 255)
    private String installLocation;
    @Size(max = 255)
    private String building;
    @Size(max = 255)
    private String street;
    @Size(max = 255)
    private String road;
    @Size(max = 255)
    private String village;
    @Size(max = 255)
    private String zone;
    @Size(max = 255)
    private String area;
    @Size(max = 255)
    private String province;
    @Size(max = 255)
    private String postcode;
    private Double latitude;
    private Double longitude;
    @Size(max = 255)
    private String detailModifiedBy;
    @CheckDate
    private Date detailLastModified;
    @Size(max = 255)
    private String serviceType;
    @Size(max = 255)
    private String docRef;
    @Size(max = 255)
    private String trueDepartment;
    @Size(max = 255)
    private String trueSector;
    @Size(max = 255)
    private String trueLocCode;
    @Size(max = 255)
    private String rcu;
    @Size(max = 255)
    private String rcu1;
    @Size(max = 255)
    private String assignedSector;
    @Size(max = 255)
    private String assignedDept;
    @Size(max = 255)
    private String assignedRegion;
    @Size(max = 255)
    private String assignedWorkArea;

    public NbrAssignedDto() {
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public void setAssignedId(Integer assignedId) {
        this.assignedId = assignedId;
    }

    public Integer getAssignedId() {
        return this.assignedId;
    }

    public void setAssignedStart(String assignedStart) {
        this.assignedStart = assignedStart;
    }

    public String getAssignedStart() {
        return this.assignedStart;
    }

    public void setAssignedEnd(String assignedEnd) {
        this.assignedEnd = assignedEnd;
    }

    public String getAssignedEnd() {
        return this.assignedEnd;
    }

    public void setAssignedQty(Integer assignedQty) {
        this.assignedQty = assignedQty;
    }

    public Integer getAssignedQty() {
        return this.assignedQty;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getProviderId() {
        return this.providerId;
    }

    public void setIdxBefore(Integer idxBefore) {
        this.idxBefore = idxBefore;
    }

    public Integer getIdxBefore() {
        return this.idxBefore;
    }

    public void setAssignedLocationCode(String assignedLocationCode) {
        this.assignedLocationCode = assignedLocationCode;
    }

    public String getAssignedLocationCode() {
        return this.assignedLocationCode;
    }

    public void setXAssignedSector(String xAssignedSector) {
        this.xAssignedSector = xAssignedSector;
    }

    public String getXAssignedSector() {
        return this.xAssignedSector;
    }

    public void setXAssignedDept(String xAssignedDept) {
        this.xAssignedDept = xAssignedDept;
    }

    public String getXAssignedDept() {
        return this.xAssignedDept;
    }

    public void setXAssignedRegion(String xAssignedRegion) {
        this.xAssignedRegion = xAssignedRegion;
    }

    public String getXAssignedRegion() {
        return this.xAssignedRegion;
    }

    public void setAssignedModifiedBy(String assignedModifiedBy) {
        this.assignedModifiedBy = assignedModifiedBy;
    }

    public String getAssignedModifiedBy() {
        return this.assignedModifiedBy;
    }

    public void setAssignedLastModified(java.util.Date assignedLastModified) {
        this.assignedLastModified = assignedLastModified;
    }

    public java.util.Date getAssignedLastModified() {
        return this.assignedLastModified;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getBlockId() {
        return this.blockId;
    }

    public void setReadyToService(Integer readyToService) {
        this.readyToService = readyToService;
    }

    public Integer getReadyToService() {
        return this.readyToService;
    }

    public void setAssignedDetailId(Integer assignedDetailId) {
        this.assignedDetailId = assignedDetailId;
    }

    public Integer getAssignedDetailId() {
        return this.assignedDetailId;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationCode() {
        return this.stationCode;
    }

    public void setStationCodeTtt(String stationCodeTtt) {
        this.stationCodeTtt = stationCodeTtt;
    }

    public String getStationCodeTtt() {
        return this.stationCodeTtt;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProject() {
        return this.project;
    }

    public void setExchTypeTtt(String exchTypeTtt) {
        this.exchTypeTtt = exchTypeTtt;
    }

    public String getExchTypeTtt() {
        return this.exchTypeTtt;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return this.region;
    }

    public void setStationAbbr(String stationAbbr) {
        this.stationAbbr = stationAbbr;
    }

    public String getStationAbbr() {
        return this.stationAbbr;
    }

    public void setStationNameTh(String stationNameTh) {
        this.stationNameTh = stationNameTh;
    }

    public String getStationNameTh() {
        return this.stationNameTh;
    }

    public void setStationNameEn(String stationNameEn) {
        this.stationNameEn = stationNameEn;
    }

    public String getStationNameEn() {
        return this.stationNameEn;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void setExchNetwork(String exchNetwork) {
        this.exchNetwork = exchNetwork;
    }

    public String getExchNetwork() {
        return this.exchNetwork;
    }

    public void setExchRank(String exchRank) {
        this.exchRank = exchRank;
    }

    public String getExchRank() {
        return this.exchRank;
    }

    public void setExchSystem(String exchSystem) {
        this.exchSystem = exchSystem;
    }

    public String getExchSystem() {
        return this.exchSystem;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public String getInstallLocation() {
        return this.installLocation;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBuilding() {
        return this.building;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getRoad() {
        return this.road;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getVillage() {
        return this.village;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getZone() {
        return this.zone;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return this.area;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return this.province;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setDetailModifiedBy(String detailModifiedBy) {
        this.detailModifiedBy = detailModifiedBy;
    }

    public String getDetailModifiedBy() {
        return this.detailModifiedBy;
    }

    public void setDetailLastModified(java.util.Date detailLastModified) {
        this.detailLastModified = detailLastModified;
    }

    public java.util.Date getDetailLastModified() {
        return this.detailLastModified;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public String getDocRef() {
        return this.docRef;
    }

    public void setTrueDepartment(String trueDepartment) {
        this.trueDepartment = trueDepartment;
    }

    public String getTrueDepartment() {
        return this.trueDepartment;
    }

    public void setTrueSector(String trueSector) {
        this.trueSector = trueSector;
    }

    public String getTrueSector() {
        return this.trueSector;
    }

    public void setTrueLocCode(String trueLocCode) {
        this.trueLocCode = trueLocCode;
    }

    public String getTrueLocCode() {
        return this.trueLocCode;
    }

    public void setRcu(String rcu) {
        this.rcu = rcu;
    }

    public String getRcu() {
        return this.rcu;
    }

    public void setRcu1(String rcu1) {
        this.rcu1 = rcu1;
    }

    public String getRcu1() {
        return this.rcu1;
    }

    public void setAssignedSector(String assignedSector) {
        this.assignedSector = assignedSector;
    }

    public String getAssignedSector() {
        return this.assignedSector;
    }

    public void setAssignedDept(String assignedDept) {
        this.assignedDept = assignedDept;
    }

    public String getAssignedDept() {
        return this.assignedDept;
    }

    public void setAssignedRegion(String assignedRegion) {
        this.assignedRegion = assignedRegion;
    }

    public String getAssignedRegion() {
        return this.assignedRegion;
    }

    public void setAssignedWorkArea(String assignedWorkArea) {
        this.assignedWorkArea = assignedWorkArea;
    }

    public String getAssignedWorkArea() {
        return this.assignedWorkArea;
    }
}