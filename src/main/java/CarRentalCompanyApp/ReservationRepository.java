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
    public Reservation changeReservationStatus(final Reservation inputReservation) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            Reservation reservation = entityManager.find(Reservation.class, inputReservation.getId());

            if (reservation != null) {
                reservation.setReservationStatus("Completed");
                entityManager.merge(reservation);
                transaction.commit();
                return reservation;
            } else {
                return null;
            }
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public int rentingCostCalculation(final Reservation reservation) {
        EntityTransaction transaction = null;
        int totalCost = 0;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Car car = entityManager.find(Car.class, reservation.getCarID());
            if (car != null) {
                //Calculate the renting cost based on car's renting price and days requested
                int rentingPrice = car.getRentingPrice();
                int rentingDaysRequested = reservation.getRentingDaysRequested();
                totalCost = rentingPrice * rentingDaysRequested;

                //set the calculated cost in the reservation entity
                reservation.setTotalCost(totalCost);
                entityManager.merge(reservation);
                transaction.commit();
            }
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return totalCost;
    }
}



