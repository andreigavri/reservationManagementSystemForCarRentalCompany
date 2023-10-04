package CarRentalCompanyApp;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.id.uuid.StandardRandomStrategy;

public class ReservationRepository {

    private final EntityManager entityManager;

    public ReservationRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Reservation saveReservationDetails(final Reservation reservation) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            int id = reservation.getCarID();
            entityManager.persist(reservation);
            Car car = entityManager.find(Car.class, id);
            car.setAvailability(false);
            entityManager.merge(car);
            transaction.commit();
            return reservation;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
            e.printStackTrace();
            return null;
        }
    }

    public Reservation deleteReservationDetails(final Reservation reservation) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.remove(reservation);
            transaction.commit();
            return reservation;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    public Reservation changeReservationStatus(final Reservation reservation) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            String reservationStatus = reservation.getReservationStatus();
            entityManager.persist(reservation);
            Reservation reservation1 = entityManager.find(Reservation.class, reservationStatus);
            entityManager.merge(reservation);
            reservation1.setReservationStatus("Completed ");
            transaction.commit();
            return reservation;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
            e.printStackTrace();
            return null;

        }
    }

    public Reservation rentingCostCalculation(final Reservation reservation) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            int rentingPrice = reservation.getRentingDaysRequested();
            entityManager.persist(reservation);
            Car car = entityManager.find(Car.class, rentingPrice);
            entityManager.createQuery("Select((rentingPrice from Car)*(rentingDaysRequested from Reservation)");
            transaction.commit();
            return reservation;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
            e.printStackTrace();
            return null;
        }
    }
}

