/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billng.numbering.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author NT2_Admin
 */
@Entity
@Table(name = "TOTServiceCenter")
@NamedQueries({
    @NamedQuery(name = "TOTServiceCenter.findAll", query = "SELECT t FROM TOTServiceCenter t")})
public class TOTServiceCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "no")
    private String no;
    @Id
    @Basic(optional = false)
    @Column(name = "location_code")
    private String locationCode;
    @Column(name = "location_name")
    private String locationName;
    @Column(name = "location_abbr")
    private String locationAbbr;
    @Column(name = "cctr")
    private String cctr;
    @Column(name = "office_code")
    private String officeCode;
    @Column(name = "work_area")
    private String workArea;
    @Column(name = "region")
    private String region;
    @Column(name = "department")
    private String department;
    @Column(name = "sector")
    private String sector;
    @Column(name = "id_manager")
    private String idManager;
    @Column(name = "manager")
    private String manager;
    @Column(name = "branceh_of")
    private String brancehOf;
    @Column(name = "tel_manager")
    private String telManager;
    @Column(name = "mobile_manager")
    private String mobileManager;
    @Column(name = "tel_location")
    private String telLocation;
    @Column(name = "tel_location2")
    private String telLocation2;
    @Column(name = "tel_location3")
    private String telLocation3;
    @Column(name = "email")
    private String email;
    @Column(name = "mon_fri")
    private String monFri;
    @Column(name = "sat")
    private String sat;
    @Column(name = "sun")
    private String sun;
    @Column(name = "day_off")
    private String dayOff;
    @Column(name = "address")
    private String address;
    @Column(name = "building")
    private String building;
    @Column(name = "floor_zone")
    private String floorZone;
    @Column(name = "road")
    private String road;
    @Column(name = "street")
    private String street;
    @Column(name = "zone")
    private String zone;
    @Column(name = "area")
    private String area;
    @Column(name = "province")
    private String province;
    @Column(name = "post_code")
    private String postCode;
    @Column(name = "lat")
    private String lat;
    @Column(name = "long")
    private String long1;
    @Column(name = "given_name")
    private String givenName;
    @Column(name = "given_tel")
    private String givenTel;
    @Column(name = "active")
    private String active;
    @Column(name = "branch_level")
    private String branchLevel;
    @Column(name = "in_department_store")
    private String inDepartmentStore;
    @Column(name = "department_store")
    private String departmentStore;
    @Column(name = "area_owner")
    private String areaOwner;
    @Column(name = "expire_date_contact")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDateContact;
    @Column(name = "location_type")
    private String locationType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "area_size")
    private Double areaSize;
    @Column(name = "work_day_in_week")
    private Integer workDayInWeek;
    @Column(name = "decorative_expense")
    private Double decorativeExpense;
    @Column(name = "office_equipment_expense")
    private Double officeEquipmentExpense;
    @Column(name = "investment")
    private Double investment;
    @Column(name = "decorative_expense_per_m2")
    private Double decorativeExpensePerM2;
    @Column(name = "comment")
    private String comment;
    @Column(name = "os_emp_sr")
    private Integer osEmpSr;
    @Column(name = "os_emp_payment")
    private Integer osEmpPayment;
    @Column(name = "eq_just_pay")
    private Integer eqJustPay;
    @Column(name = "eq_pos")
    private Integer eqPos;
    @Column(name = "rent")
    private Double rent;
    @Column(name = "elect")
    private Double elect;
    @Column(name = "common_service")
    private Double commonService;
    @Column(name = "insurance")
    private Double insurance;
    @Column(name = "property_tax")
    private Double propertyTax;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "stop_date")
    private String stopDate;
    @Column(name = "starts_date")
    private String startsDate;
    @Column(name = "end_date")
    private String endDate;

    public TOTServiceCenter() {
    }

    public TOTServiceCenter(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAbbr() {
        return locationAbbr;
    }

    public void setLocationAbbr(String locationAbbr) {
        this.locationAbbr = locationAbbr;
    }

    public String getCctr() {
        return cctr;
    }

    public void setCctr(String cctr) {
        this.cctr = cctr;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIdManager() {
        return idManager;
    }

    public void setIdManager(String idManager) {
        this.idManager = idManager;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getBrancehOf() {
        return brancehOf;
    }

    public void setBrancehOf(String brancehOf) {
        this.brancehOf = brancehOf;
    }

    public String getTelManager() {
        return telManager;
    }

    public void setTelManager(String telManager) {
        this.telManager = telManager;
    }

    public String getMobileManager() {
        return mobileManager;
    }

    public void setMobileManager(String mobileManager) {
        this.mobileManager = mobileManager;
    }

    public String getTelLocation() {
        return telLocation;
    }

    public void setTelLocation(String telLocation) {
        this.telLocation = telLocation;
    }

    public String getTelLocation2() {
        return telLocation2;
    }

    public void setTelLocation2(String telLocation2) {
        this.telLocation2 = telLocation2;
    }

    public String getTelLocation3() {
        return telLocation3;
    }

    public void setTelLocation3(String telLocation3) {
        this.telLocation3 = telLocation3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMonFri() {
        return monFri;
    }

    public void setMonFri(String monFri) {
        this.monFri = monFri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getDayOff() {
        return dayOff;
    }

    public void setDayOff(String dayOff) {
        this.dayOff = dayOff;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloorZone() {
        return floorZone;
    }

    public void setFloorZone(String floorZone) {
        this.floorZone = floorZone;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong1() {
        return long1;
    }

    public void setLong1(String long1) {
        this.long1 = long1;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getGivenTel() {
        return givenTel;
    }

    public void setGivenTel(String givenTel) {
        this.givenTel = givenTel;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getBranchLevel() {
        return branchLevel;
    }

    public void setBranchLevel(String branchLevel) {
        this.branchLevel = branchLevel;
    }

    public String getInDepartmentStore() {
        return inDepartmentStore;
    }

    public void setInDepartmentStore(String inDepartmentStore) {
        this.inDepartmentStore = inDepartmentStore;
    }

    public String getDepartmentStore() {
        return departmentStore;
    }

    public void setDepartmentStore(String departmentStore) {
        this.departmentStore = departmentStore;
    }

    public String getAreaOwner() {
        return areaOwner;
    }

    public void setAreaOwner(String areaOwner) {
        this.areaOwner = areaOwner;
    }

    public Date getExpireDateContact() {
        return expireDateContact;
    }

    public void setExpireDateContact(Date expireDateContact) {
        this.expireDateContact = expireDateContact;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Double getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(Double areaSize) {
        this.areaSize = areaSize;
    }

    public Integer getWorkDayInWeek() {
        return workDayInWeek;
    }

    public void setWorkDayInWeek(Integer workDayInWeek) {
        this.workDayInWeek = workDayInWeek;
    }

    public Double getDecorativeExpense() {
        return decorativeExpense;
    }

    public void setDecorativeExpense(Double decorativeExpense) {
        this.decorativeExpense = decorativeExpense;
    }

    public Double getOfficeEquipmentExpense() {
        return officeEquipmentExpense;
    }

    public void setOfficeEquipmentExpense(Double officeEquipmentExpense) {
        this.officeEquipmentExpense = officeEquipmentExpense;
    }

    public Double getInvestment() {
        return investment;
    }

    public void setInvestment(Double investment) {
        this.investment = investment;
    }

    public Double getDecorativeExpensePerM2() {
        return decorativeExpensePerM2;
    }

    public void setDecorativeExpensePerM2(Double decorativeExpensePerM2) {
        this.decorativeExpensePerM2 = decorativeExpensePerM2;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getOsEmpSr() {
        return osEmpSr;
    }

    public void setOsEmpSr(Integer osEmpSr) {
        this.osEmpSr = osEmpSr;
    }

    public Integer getOsEmpPayment() {
        return osEmpPayment;
    }

    public void setOsEmpPayment(Integer osEmpPayment) {
        this.osEmpPayment = osEmpPayment;
    }

    public Integer getEqJustPay() {
        return eqJustPay;
    }

    public void setEqJustPay(Integer eqJustPay) {
        this.eqJustPay = eqJustPay;
    }

    public Integer getEqPos() {
        return eqPos;
    }

    public void setEqPos(Integer eqPos) {
        this.eqPos = eqPos;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Double getElect() {
        return elect;
    }

    public void setElect(Double elect) {
        this.elect = elect;
    }

    public Double getCommonService() {
        return commonService;
    }

    public void setCommonService(Double commonService) {
        this.commonService = commonService;
    }

    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    public Double getPropertyTax() {
        return propertyTax;
    }

    public void setPropertyTax(Double propertyTax) {
        this.propertyTax = propertyTax;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getStartsDate() {
        return startsDate;
    }

    public void setStartsDate(String startsDate) {
        this.startsDate = startsDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationCode != null ? locationCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TOTServiceCenter)) {
            return false;
        }
        TOTServiceCenter other = (TOTServiceCenter) object;
        if ((this.locationCode == null && other.locationCode != null) || (this.locationCode != null && !this.locationCode.equals(other.locationCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.genentities.TOTServiceCenter[ locationCode=" + locationCode + " ]";
    }
    
}
