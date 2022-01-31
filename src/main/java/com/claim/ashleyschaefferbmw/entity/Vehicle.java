package com.claim.ashleyschaefferbmw.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(name = "vinNum", nullable = false)
    private Long vinNum;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle", cascade = CascadeType.MERGE)
    @JsonBackReference
    private List<Sale> sales;

    public Vehicle() {
    }

    public Vehicle(Long vinNum, String make, String model, int year, List<Sale> sales) {
        this.vinNum = vinNum;
        this.make = make;
        this.model = model;
        this.year = year;
        this.sales = sales;
    }

    public Vehicle(Long vinNum, String make, String model, int year) {
        this.vinNum = vinNum;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Long getVinNum() {
        return vinNum;
    }

    public void setVinNum(Long vinNum) {
        this.vinNum = vinNum;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
