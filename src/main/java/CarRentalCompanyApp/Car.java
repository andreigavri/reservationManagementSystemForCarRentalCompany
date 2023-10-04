package CarRentalCompanyApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


import java.awt.*;
import java.util.List;



@Entity


public class Car {
    @Id
    private int id;
    private String brand;
    private String model;
    private int yearOfFabrication;
    private int rentingPrice;
    private boolean availability;
    private int stockUnit;


    public Car (){

    }



    public Car(int id, String brand, String model, int yearOfFabrication, int rentingPrice, boolean availability, int stockUnit) {

        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfFabrication = yearOfFabrication;
        this.rentingPrice = rentingPrice;
        this.availability = availability;
        this.stockUnit = stockUnit;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setYearOfFabrication(int yearOfFabrication) {
        this.yearOfFabrication = yearOfFabrication;
    }

    public int getRentingPrice() {
        return rentingPrice;
    }

    public void setRentingPrice(int rentingPrice) {
        this.rentingPrice = rentingPrice;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(int stockUnit) {
        this.stockUnit = stockUnit;
    }

    @OneToMany(mappedBy= "car")
    private List<Reservation> reservation;

}





