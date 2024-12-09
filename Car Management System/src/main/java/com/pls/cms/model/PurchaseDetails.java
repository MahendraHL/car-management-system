package com.pls.cms.model;

import java.io.Serializable;

public class PurchaseDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstname;
    private String lastname;
    private String email;
    private String contact;
    private String address;
    private Integer carId;

    public PurchaseDetails(String firstname, String lastname, String email, String contact, String address, Integer carId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.carId = carId;
    }

    public PurchaseDetails() {}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
