package com.pls.cms.model;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer carId;
    private String carName;
    private String carType;
    private String description;
    private String brand;
    private String model;
    private String price;


    public Car(Integer carId, String carName, String description, String carType, String brand, String model, String price) {
        this.carId = carId;
        this.carName = carName;
        this.description = description;
        this.carType = carType;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarType() {
        return carType;
    }

    public String getDescription() {
        return description;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrice() {
        return price;
    }
}

