package com.fsoft.carparkproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class EmployeeDTO {
    private long id;
    private String fullName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;
    private String phoneNumber;
    private int sex;
    private String address;
    private String mail;
    private String account;
    private String pass;
    private String department;

    public EmployeeDTO() {

    }

    public EmployeeDTO(long id, String fullName, Date dob, String phoneNumber, int sex, String address, String mail, String account, String pass, String department) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.address = address;
        this.mail = mail;
        this.account = account;
        this.pass = pass;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
