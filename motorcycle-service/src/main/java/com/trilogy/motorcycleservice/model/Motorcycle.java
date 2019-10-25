package com.trilogy.motorcycleservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="motorcycle")
public class Motorcycle {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int motorcycleId;
    @NotNull
    @NotEmpty
    private BigDecimal price;
    @NotNull
    @NotEmpty
    private String vin;
    @NotNull
    @NotEmpty
    private String make;
    @NotNull
    @NotEmpty
    private String model;
    @NotNull
    @NotEmpty
    private String year;
    @NotNull
    @NotEmpty
    private String color;

    public Motorcycle() {
    }

    public Motorcycle(BigDecimal price, String vin, String make, String model, String year, String color) {
        this.price = price;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Motorcycle(int motorcycleId, BigDecimal price, String vin, String make, String model, String year, String color) {
        this.motorcycleId = motorcycleId;
        this.price = price;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public int getMotorcycleId() {
        return motorcycleId;
    }

    public void setMotorcycleId(int motorcycleId) {
        this.motorcycleId = motorcycleId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return motorcycleId == that.motorcycleId &&
                price.equals(that.price) &&
                vin.equals(that.vin) &&
                make.equals(that.make) &&
                model.equals(that.model) &&
                year.equals(that.year) &&
                color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorcycleId, price, vin, make, model, year, color);
    }
}

