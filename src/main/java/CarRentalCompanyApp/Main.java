package CarRentalCompanyApp;

import jakarta.persistence.EntityManager;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Reservation.class)
                .buildSessionFactory();

        Customer cst1 = new Customer(1, "Alin", "Lazar", "Strada Rahovei nr.5", 0753212320);
        Customer cst2 = new Customer(2, "Claudiu", "Emilian", "Strada Victoriei nr.21", 0752340550);
        Customer cst3 = new Customer(3, "Laurentiu", "Serbaneci", "Strada Emilian nr.1", 07532123347);
        Customer cst4 = new Customer(4, "Eduard", "Constantin", "Strada Teclu nr.10", 0753212426);

        CustomerRepository customerRepository = new CustomerRepository(sessionFactory.createEntityManager());
//        customerRepository.deleteCustomerDetails(cst1);
//        customerRepository.deleteCustomerDetails(cst2);
//        customerRepository.deleteCustomerDetails(cst3);
//        customerRepository.deleteCustomerDetails(cst4);

        Car car1 = new Car(1, "BMW", "X6", 2020, 300, false, 3);
        Car car2 = new Car(2, "BMW", "X3", 2021, 340, true, 2);
        Car car3 = new Car(3, "AUDI", "A3", 2023, 170, false, 4);
        Car car4 = new Car(4, "AUDI", "A8", 2023, 190, true, 5);

        CarRepository carRepository = new CarRepository(sessionFactory.createEntityManager());
//        carRepository.saveCarDetails(car1);
//        carRepository.saveCarDetails(car2);
//        carRepository.saveCarDetails(car3);
//        carRepository.saveCarDetails(car4);
//        carRepository.deleteCarDetails(car1);
//        carRepository.deleteCarDetails(car2);
//        carRepository.deleteCarDetails(car3);
//        carRepository.deleteCarDetails(car4);

        ReservationRepository reservationRepository = new ReservationRepository(sessionFactory.createEntityManager());
        Reservation reservation1 = new Reservation(1, null, null, "10/10/2023", "12/10/2023", 4, 0);
        Reservation reservation2 = new Reservation(2, null, null, "10/10/2023", "12/10/2023", 2, 0);
//        List<Reservation> reservation = new ArrayList<>();
//        reservationRepository.saveReservationDetails(reservation1);
//        reservationRepository.saveReservationDetails(reservation2);
//        reservationRepository.changeReservationStatus(reservation1);
//        reservationRepository.rentingCostCalculation(reservation1);
//        reservationRepository.deleteReservationDetails(reservation1);
//        reservationRepository.deleteReservationDetails(reservation2);
//        reservationRepository.changeReservationStatus(reservation1);
//        reservationRepository.rentingCostCalculation(reservation1);

//        reservationRepository.deleteReservationDetails(reservation1);
//        reservationRepository.deleteReservationDetails(reservation2);

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.persist(cst1);
//        entityManager.persist(cst2);
//        entityManager.persist(cst3);
//        entityManager.persist(cst4);
        entityManager.getTransaction().commit();

        Scanner sc = new Scanner(System.in);
        int name = sc.nextInt();
        sc.nextLine();
        switch (name) {
            case 1:
                String input = sc.nextLine();
                String[] v = input.split(" ");
                int id = Integer.parseInt(v[0]);
                String firstName = v[1];
                String lastName = v[2];
                String address = v[3];
                int phoneNumber = Integer.parseInt(v[4]);
                Customer customer = new Customer(id, firstName, lastName, address, phoneNumber);
                customerRepository.saveCustomerDetails(customer);
                break;

            case 2:
                String car = sc.nextLine();
                String[] vCar = car.split(" ");
                int carId = Integer.parseInt(vCar[0]);
                String brand = vCar[1];
                String model = vCar[2];
                int yearOfFabrication = Integer.parseInt((vCar[3]));
                int rentingPrice = Integer.parseInt(vCar[4]);
                boolean availability = Boolean.parseBoolean(vCar[5]);
                int stockUnit = Integer.parseInt(vCar[6]);
                Car carInput = new Car(carId, brand, model, yearOfFabrication, rentingPrice, availability, stockUnit);
                carRepository.saveCarDetails(carInput);
                break;

            case 3:
                String reservation = sc.nextLine();
                String[] vReservation = reservation.split(" ");
                int idReservation = Integer.parseInt(vReservation[0]);
                String reservationStatus = vReservation[1];
                String reservations = vReservation[2];
                String startDate = vReservation[3];
                String endDate = vReservation[4];
                int carID = Integer.parseInt(vReservation[5]);
                int customerID = Integer.parseInt(vReservation[6]);
                int rentingDayRequested = Integer.parseInt(vReservation[7]);
                Reservation reservationInput = new Reservation(idReservation, reservationStatus, reservations, startDate, endDate, rentingDayRequested,0);
                reservationRepository.saveReservationDetails(reservationInput,carID,customerID);
                int totalCost = reservationRepository.rentingCostCalculation(reservationInput);
                reservationInput.setTotalCost(totalCost);
                break;
        }
    }
}
