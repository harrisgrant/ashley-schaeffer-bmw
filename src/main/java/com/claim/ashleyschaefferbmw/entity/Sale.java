package com.claim.ashleyschaefferbmw.entity;


import javax.persistence.*;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @Column(name = "invoice_num", nullable = false)
    private Integer invoiceNum;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "vinNum", referencedColumnName = "vinNum")
    private Vehicle vehicle;

    //Constructors
    public Sale() {
    }

    public Sale(Integer invoiceNum, Customer customer, Vehicle vehicle) {
        this.invoiceNum = invoiceNum;
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public Integer getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(Integer invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
