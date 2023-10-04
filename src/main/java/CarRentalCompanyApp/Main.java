package CarRentalCompanyApp;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Reservation.class)
                .buildSessionFactory();


        Car car1 = new Car(1, "BMW", "X6", 2020, 300, false, 3, null, null);
        Car car2 = new Car(2, "BMW", "X3", 2021, 340, true, 2, null, null);
        Car car3 = new Car(3, "AUDI", "A3", 2023, 170, false, 4, null, null);
        Car car4 = new Car(4, "AUDI", "A8", 2023, 190, true, 5, null, null);

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
        Reservation reservation1 = new Reservation(1, 1, 1, null, null, "10/10/2023", "12/10/2023", 4,0, null, car1);
        Reservation reservation2 = new Reservation(2, 2, 1, null, null, "10/10/2023", "12/10/2023", 2,0, null, car2);
        List<Reservation> reservation = new ArrayList<>();
//        reservationRepository.saveReservationDetails(reservation1);
//        reservationRepository.saveReservationDetails(reservation2);
//        reservationRepository.changeReservationStatus(reservation1);
//        reservationRepository.rentingCostCalculation(reservation1);
//        reservationRepository.deleteReservationDetails(reservation1);
//        reservationRepository.deleteReservationDetails(reservation2);
//        reservationRepository.changeReservationStatus(reservation1);
        reservationRepository.rentingCostCalculation(reservation1);



//        reservationRepository.deleteReservationDetails(reservation1);
//        reservationRepository.deleteReservationDetails(reservation2);

        Customer cst1 = new Customer(1, "Alin", "Lazar", "Strada Rahovei nr.5", 0753212320, null, null);
        Customer cst2 = new Customer(2, "Claudiu", "Emilian", "Strada Victoriei nr.21", 0752340550, null, null);
        Customer cst3 = new Customer(3, "Laurentiu", "Serbaneci", "Strada Emilian nr.1", 07532123347, null, null);
        Customer cst4 = new Customer(4, "Eduard", "Constantin", "Strada Teclu nr.10", 0753212426, null, null);

        CustomerRepository customerRepository = new CustomerRepository(sessionFactory.createEntityManager());
//        customerRepository.deleteCustomerDetails(cst1);
//        customerRepository.deleteCustomerDetails(cst2);
//        customerRepository.deleteCustomerDetails(cst3);
//        customerRepository.deleteCustomerDetails(cst4);

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.persist(cst1);
//        entityManager.persist(cst2);
//        entityManager.persist(cst3);
//        entityManager.persist(cst4);
        entityManager.getTransaction().commit();

    }
}
