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
    private double rentingPrice;
    private boolean availability;
    private int stockUnit;

    private String reservationRecordsTracking;

    public Car (){

    }



    public Car(int id, String brand, String model, int yearOfFabrication, double rentingPrice, boolean availability, int stockUnit, String reservationRecordsTracking, List<Reservation> reservation) {

        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfFabrication = yearOfFabrication;
        this.rentingPrice = rentingPrice;
        this.availability = availability;
        this.stockUnit = stockUnit;
        this.reservationRecordsTracking = reservationRecordsTracking;
        this.reservation = reservation;
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

    public double getRentingPrice() {
        return rentingPrice;
    }

    public void setRentingPrice(double rentingPrice) {
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

    public String getReservationRecordsTracking() {
        return reservationRecordsTracking;
    }

    public void setReservationRecordsTracking(String reservationRecordsTracking) {
        this.reservationRecordsTracking = reservationRecordsTracking;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
    @OneToMany(mappedBy= "car")
    private List<Reservation> reservation;

}





