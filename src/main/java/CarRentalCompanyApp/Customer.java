package CarRentalCompanyApp;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity



public class Customer {

    public Customer(int ID, String firstName, String lastName, String address, int phoneNumber, String reservationRecords, List<Reservation> reservation) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.reservationRecords = reservationRecords;
        this.reservation = reservation;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReservationRecords() {
        return reservationRecords;
    }

    public void setReservationRecords(String reservationRecords) {
        this.reservationRecords = reservationRecords;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    @Id
    private int ID;
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNumber;
    private String reservationRecords;

    @OneToMany()
    private List<Reservation> reservation;
}



