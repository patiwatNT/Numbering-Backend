package com.billng.numbering.dto;

import com.billng.numbering.annotation.CheckDate;
import com.billng.numbering.annotation.CheckEmail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import java.util.Date;

@ApiModel()
public class TOTServiceCenterDto extends AbstractDto<String> {
    private long serialVersionUID;
    @Size(max = 255)
    private String no;
    @Size(max = 255)
    private String locationCode;
    @Size(max = 255)
    private String locationName;
    @Size(max = 255)
    private String locationAbbr;
    @Size(max = 255)
    private String cctr;
    @Size(max = 255)
    private String officeCode;
    @Size(max = 255)
    private String workArea;
    @Size(max = 255)
    private String region;
    @Size(max = 255)
    private String department;
    @Size(max = 255)
    private String sector;
    @Size(max = 255)
    private String idManager;
    @Size(max = 255)
    private String manager;
    @Size(max = 255)
    private String brancehOf;
    @Size(max = 255)
    private String telManager;
    @Size(max = 255)
    private String mobileManager;
    @Size(max = 255)
    private String telLocation;
    @Size(max = 255)
    private String telLocation2;
    @Size(max = 255)
    private String telLocation3;
    @CheckEmail
    @Size(max = 255)
    private String email;
    @Size(max = 255)
    private String monFri;
    @Size(max = 255)
    private String sat;
    @Size(max = 255)
    private String sun;
    @Size(max = 255)
    private String dayOff;
    @Size(max = 255)
    private String address;
    @Size(max = 255)
    private String building;
    @Size(max = 255)
    private String floorZone;
    @Size(max = 255)
    private String road;
    @Size(max = 255)
    private String street;
    @Size(max = 255)
    private String zone;
    @Size(max = 255)
    private String area;
    @Size(max = 255)
    private String province;
    @Size(max = 255)
    private String postCode;
    @Size(max = 255)
    private String lat;
    @Size(max = 255)
    private String long1;
    @Size(max = 255)
    private String givenName;
    @Size(max = 255)
    private String givenTel;
    @Size(max = 255)
    private String active;
    @Size(max = 255)
    private String branchLevel;
    @Size(max = 255)
    private String inDepartmentStore;
    @Size(max = 255)
    private String departmentStore;
    @Size(max = 255)
    private String areaOwner;
    @CheckDate
    private Date expireDateContact;
    @Size(max = 255)
    private String locationType;
    private Double areaSize;
    @Max(Integer.MAX_VALUE)
    private Integer workDayInWeek;
    private Double decorativeExpense;
    private Double officeEquipmentExpense;
    private Double investment;
    private Double decorativeExpensePerM2;
    @Size(max = 255)
    private String comment;
    @Max(Integer.MAX_VALUE)
    private Integer osEmpSr;
    @Max(Integer.MAX_VALUE)
    private Integer osEmpPayment;
    @Max(Integer.MAX_VALUE)
    private Integer eqJustPay;
    @Max(Integer.MAX_VALUE)
    private Integer eqPos;
    private Double rent;
    private Double elect;
    private Double commonService;
    private Double insurance;
    private Double propertyTax;
    @Size(max = 255)
    private String startDate;
    @Size(max = 255)
    private String stopDate;
    @Size(max = 255)
    private String startsDate;
    @Size(max = 255)
    private String endDate;

    public TOTServiceCenterDto() {
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNo() {
        return this.no;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationCode() {
        return this.locationCode;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void setLocationAbbr(String locationAbbr) {
        this.locationAbbr = locationAbbr;
    }

    public String getLocationAbbr() {
        return this.locationAbbr;
    }

    public void setCctr(String cctr) {
        this.cctr = cctr;
    }

    public String getCctr() {
        return this.cctr;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getOfficeCode() {
        return this.officeCode;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getWorkArea() {
        return this.workArea;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return this.region;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSector() {
        return this.sector;
    }

    public void setIdManager(String idManager) {
        this.idManager = idManager;
    }

    public String getIdManager() {
        return this.idManager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManager() {
        return this.manager;
    }

    public void setBrancehOf(String brancehOf) {
        this.brancehOf = brancehOf;
    }

    public String getBrancehOf() {
        return this.brancehOf;
    }

    public void setTelManager(String telManager) {
        this.telManager = telManager;
    }

    public String getTelManager() {
        return this.telManager;
    }

    public void setMobileManager(String mobileManager) {
        this.mobileManager = mobileManager;
    }

    public String getMobileManager() {
        return this.mobileManager;
    }

    public void setTelLocation(String telLocation) {
        this.telLocation = telLocation;
    }

    public String getTelLocation() {
        return this.telLocation;
    }

    public void setTelLocation2(String telLocation2) {
        this.telLocation2 = telLocation2;
    }

    public String getTelLocation2() {
        return this.telLocation2;
    }

    public void setTelLocation3(String telLocation3) {
        this.telLocation3 = telLocation3;
    }

    public String getTelLocation3() {
        return this.telLocation3;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setMonFri(String monFri) {
        this.monFri = monFri;
    }

    public String getMonFri() {
        return this.monFri;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSat() {
        return this.sat;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getSun() {
        return this.sun;
    }

    public void setDayOff(String dayOff) {
        this.dayOff = dayOff;
    }

    public String getDayOff() {
        return this.dayOff;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBuilding() {
        return this.building;
    }

    public void setFloorZone(String floorZone) {
        this.floorZone = floorZone;
    }

    public String getFloorZone() {
        return this.floorZone;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getRoad() {
        return this.road;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
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

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLong1(String long1) {
        this.long1 = long1;
    }

    public String getLong1() {
        return this.long1;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public void setGivenTel(String givenTel) {
        this.givenTel = givenTel;
    }

    public String getGivenTel() {
        return this.givenTel;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getActive() {
        return this.active;
    }

    public void setBranchLevel(String branchLevel) {
        this.branchLevel = branchLevel;
    }

    public String getBranchLevel() {
        return this.branchLevel;
    }

    public void setInDepartmentStore(String inDepartmentStore) {
        this.inDepartmentStore = inDepartmentStore;
    }

    public String getInDepartmentStore() {
        return this.inDepartmentStore;
    }

    public void setDepartmentStore(String departmentStore) {
        this.departmentStore = departmentStore;
    }

    public String getDepartmentStore() {
        return this.departmentStore;
    }

    public void setAreaOwner(String areaOwner) {
        this.areaOwner = areaOwner;
    }

    public String getAreaOwner() {
        return this.areaOwner;
    }

    public void setExpireDateContact(java.util.Date expireDateContact) {
        this.expireDateContact = expireDateContact;
    }

    public java.util.Date getExpireDateContact() {
        return this.expireDateContact;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getLocationType() {
        return this.locationType;
    }

    public void setAreaSize(Double areaSize) {
        this.areaSize = areaSize;
    }

    public Double getAreaSize() {
        return this.areaSize;
    }

    public void setWorkDayInWeek(Integer workDayInWeek) {
        this.workDayInWeek = workDayInWeek;
    }

    public Integer getWorkDayInWeek() {
        return this.workDayInWeek;
    }

    public void setDecorativeExpense(Double decorativeExpense) {
        this.decorativeExpense = decorativeExpense;
    }

    public Double getDecorativeExpense() {
        return this.decorativeExpense;
    }

    public void setOfficeEquipmentExpense(Double officeEquipmentExpense) {
        this.officeEquipmentExpense = officeEquipmentExpense;
    }

    public Double getOfficeEquipmentExpense() {
        return this.officeEquipmentExpense;
    }

    public void setInvestment(Double investment) {
        this.investment = investment;
    }

    public Double getInvestment() {
        return this.investment;
    }

    public void setDecorativeExpensePerM2(Double decorativeExpensePerM2) {
        this.decorativeExpensePerM2 = decorativeExpensePerM2;
    }

    public Double getDecorativeExpensePerM2() {
        return this.decorativeExpensePerM2;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }

    public void setOsEmpSr(Integer osEmpSr) {
        this.osEmpSr = osEmpSr;
    }

    public Integer getOsEmpSr() {
        return this.osEmpSr;
    }

    public void setOsEmpPayment(Integer osEmpPayment) {
        this.osEmpPayment = osEmpPayment;
    }

    public Integer getOsEmpPayment() {
        return this.osEmpPayment;
    }

    public void setEqJustPay(Integer eqJustPay) {
        this.eqJustPay = eqJustPay;
    }

    public Integer getEqJustPay() {
        return this.eqJustPay;
    }

    public void setEqPos(Integer eqPos) {
        this.eqPos = eqPos;
    }

    public Integer getEqPos() {
        return this.eqPos;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Double getRent() {
        return this.rent;
    }

    public void setElect(Double elect) {
        this.elect = elect;
    }

    public Double getElect() {
        return this.elect;
    }

    public void setCommonService(Double commonService) {
        this.commonService = commonService;
    }

    public Double getCommonService() {
        return this.commonService;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    public Double getInsurance() {
        return this.insurance;
    }

    public void setPropertyTax(Double propertyTax) {
        this.propertyTax = propertyTax;
    }

    public Double getPropertyTax() {
        return this.propertyTax;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getStopDate() {
        return this.stopDate;
    }

    public void setStartsDate(String startsDate) {
        this.startsDate = startsDate;
    }

    public String getStartsDate() {
        return this.startsDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return this.endDate;
    }
}