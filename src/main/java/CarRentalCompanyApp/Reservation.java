package CarRentalCompanyApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity


public class Reservation {
    @Id
    private int id;
    private int customerID;
    private int carID;
    private String reservationStatus;
    private String reservations;
    private String startDate;
    private String endDate;

    private int rentingDaysRequested;
    private int totalCost;


    public Reservation() {

    }

    public Reservation(int id, int customerID, int carID, String reservationStatus, String reservations, String startDate, String endDate, int rentingDaysRequested, int totalCost, Customer customer, Car car) {
        this.id = id;
        this.customerID = customerID;
        this.carID = carID;
        this.reservationStatus = reservationStatus;
        this.reservations = reservations;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentingDaysRequested = rentingDaysRequested;
        this.totalCost = totalCost;
        this.customer = customer;
        this.car = car;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getReservations() {
        return reservations;
    }

    public void setReservations(String reservations) {
        this.reservations = reservations;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getRentingDaysRequested() {
        return rentingDaysRequested;
    }

    public void setRentingDaysRequested(int rentingDaysRequested) {
        this.rentingDaysRequested = rentingDaysRequested;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Car car;

}

