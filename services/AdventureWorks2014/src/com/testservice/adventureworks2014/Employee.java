/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testservice.adventureworks2014;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Employee generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Employee`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`rowguid`"}),
        @UniqueConstraint(columnNames = {"`LoginID`"}),
        @UniqueConstraint(columnNames = {"`NationalIDNumber`"})})
public class Employee implements Serializable {

    private Integer businessEntityId;
    private String nationalIdnumber;
    private String loginId;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] organizationNode;
    private Short organizationLevel;
    private String jobTitle;
    private Date birthDate;
    private String maritalStatus;
    private String gender;
    private Date hireDate;
    private boolean salariedFlag;
    private short vacationHours;
    private short sickLeaveHours;
    private boolean currentFlag;
    private String rowguid;
    private Date modifiedDate;
    private List<EmployeePayHistory> employeePayHistories = new ArrayList<>();
    private List<EmployeeDepartmentHistory> employeeDepartmentHistories = new ArrayList<>();
    private List<JobCandidate> jobCandidates = new ArrayList<>();

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "`BusinessEntityID`", nullable = false, scale = 0, precision = 10)
    public Integer getBusinessEntityId() {
        return this.businessEntityId;
    }

    public void setBusinessEntityId(Integer businessEntityId) {
        this.businessEntityId = businessEntityId;
    }

    @Column(name = "`NationalIDNumber`", nullable = false, length = 255)
    public String getNationalIdnumber() {
        return this.nationalIdnumber;
    }

    public void setNationalIdnumber(String nationalIdnumber) {
        this.nationalIdnumber = nationalIdnumber;
    }

    @Column(name = "`LoginID`", nullable = false, length = 255)
    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Column(name = "`OrganizationNode`", nullable = true)
    public byte[] getOrganizationNode() {
        return this.organizationNode;
    }

    public void setOrganizationNode(byte[] organizationNode) {
        this.organizationNode = organizationNode;
    }

    @Column(name = "`OrganizationLevel`", nullable = true, scale = 0, precision = 5)
    public Short getOrganizationLevel() {
        return this.organizationLevel;
    }

    public void setOrganizationLevel(Short organizationLevel) {
        this.organizationLevel = organizationLevel;
    }

    @Column(name = "`JobTitle`", nullable = false, length = 255)
    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`BirthDate`", nullable = false)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "`MaritalStatus`", nullable = false, length = 255)
    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Column(name = "`Gender`", nullable = false, length = 255)
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`HireDate`", nullable = false)
    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "`SalariedFlag`", nullable = false)
    public boolean isSalariedFlag() {
        return this.salariedFlag;
    }

    public void setSalariedFlag(boolean salariedFlag) {
        this.salariedFlag = salariedFlag;
    }

    @Column(name = "`VacationHours`", nullable = false, scale = 0, precision = 5)
    public short getVacationHours() {
        return this.vacationHours;
    }

    public void setVacationHours(short vacationHours) {
        this.vacationHours = vacationHours;
    }

    @Column(name = "`SickLeaveHours`", nullable = false, scale = 0, precision = 5)
    public short getSickLeaveHours() {
        return this.sickLeaveHours;
    }

    public void setSickLeaveHours(short sickLeaveHours) {
        this.sickLeaveHours = sickLeaveHours;
    }

    @Column(name = "`CurrentFlag`", nullable = false)
    public boolean isCurrentFlag() {
        return this.currentFlag;
    }

    public void setCurrentFlag(boolean currentFlag) {
        this.currentFlag = currentFlag;
    }

    @Column(name = "`rowguid`", nullable = false, length = 36)
    public String getRowguid() {
        return this.rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`ModifiedDate`", nullable = false)
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "employee")
    public List<EmployeePayHistory> getEmployeePayHistories() {
        return this.employeePayHistories;
    }

    public void setEmployeePayHistories(List<EmployeePayHistory> employeePayHistories) {
        this.employeePayHistories = employeePayHistories;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "employee")
    public List<EmployeeDepartmentHistory> getEmployeeDepartmentHistories() {
        return this.employeeDepartmentHistories;
    }

    public void setEmployeeDepartmentHistories(List<EmployeeDepartmentHistory> employeeDepartmentHistories) {
        this.employeeDepartmentHistories = employeeDepartmentHistories;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "employee")
    public List<JobCandidate> getJobCandidates() {
        return this.jobCandidates;
    }

    public void setJobCandidates(List<JobCandidate> jobCandidates) {
        this.jobCandidates = jobCandidates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        final Employee employee = (Employee) o;
        return Objects.equals(getBusinessEntityId(), employee.getBusinessEntityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBusinessEntityId());
    }
}

