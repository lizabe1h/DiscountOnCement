package com.example.util;

import java.time.LocalDateTime;

public class Order {
    private Company company;
    private LocalDateTime dateTime;
    private double priceOneKg;
    private double kgCement;
    private double discount;

    public Order(Company company, LocalDateTime dateTime, double kgCement, double priceOneKg) {
        this.company = company;
        this.dateTime = dateTime;
        this.kgCement = kgCement;
        this.priceOneKg = priceOneKg;
    }

    public double getPriceOneKg() {
        return priceOneKg;
    }

    public void setPriceOneKg(double priceOneKg) {
        this.priceOneKg = priceOneKg;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    public double getKgCement() {
        return kgCement;
    }

    public void setKgCement(double kgCement) {
        this.kgCement = kgCement;
    }

    @Override
    public String toString() {
        return "Order{" +
                "company=" + company +
                ", dateTime=" + dateTime +
                ", priceOneKg=" + priceOneKg +
                ", kgCement=" + kgCement +
                ", discount=" + discount +
                '}';
    }

    public double getTotalSum() {
        return kgCement * priceOneKg * (1 - discount);
    }
}
