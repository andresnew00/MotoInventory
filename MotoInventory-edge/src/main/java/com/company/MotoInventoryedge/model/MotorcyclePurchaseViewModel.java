package com.company.MotoInventoryedge.model;

import java.math.BigDecimal;
import java.util.Objects;

public class MotorcyclePurchaseViewModel {

    private int motorcycleId;
    private BigDecimal prive;
    private String vin;
    private String make;
    private String model;
    private String year;
    private String color;
    private BigDecimal salesTax;
    private BigDecimal documentationFees;
    private BigDecimal transportationCosts;
    private BigDecimal total;

    public int getMotorcycleId() {
        return motorcycleId;
    }

    public void setMotorcycleId(int motorcycleId) {
        this.motorcycleId = motorcycleId;
    }

    public BigDecimal getPrive() {
        return prive;
    }

    public void setPrive(BigDecimal prive) {
        this.prive = prive;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public BigDecimal getDocumentationFees() {
        return documentationFees;
    }

    public void setDocumentationFees(BigDecimal documentationFees) {
        this.documentationFees = documentationFees;
    }

    public BigDecimal getTransportationCosts() {
        return transportationCosts;
    }

    public void setTransportationCosts(BigDecimal transportationCosts) {
        this.transportationCosts = transportationCosts;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotorcyclePurchaseViewModel that = (MotorcyclePurchaseViewModel) o;
        return motorcycleId == that.motorcycleId &&
                Objects.equals(prive, that.prive) &&
                Objects.equals(vin, that.vin) &&
                Objects.equals(make, that.make) &&
                Objects.equals(model, that.model) &&
                Objects.equals(year, that.year) &&
                Objects.equals(color, that.color) &&
                Objects.equals(salesTax, that.salesTax) &&
                Objects.equals(documentationFees, that.documentationFees) &&
                Objects.equals(transportationCosts, that.transportationCosts) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorcycleId, prive, vin, make, model, year, color, salesTax, documentationFees, transportationCosts, total);
    }

}
