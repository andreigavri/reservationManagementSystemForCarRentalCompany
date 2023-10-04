package CarRentalCompanyApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CarRepository {

    private final EntityManager entityManager;

    public CarRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Car saveCarDetails(final Car car) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.persist(car);
            transaction.commit();
            return car;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    public Car deleteCarDetails(final Car car) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.remove(car);
            transaction.commit();
            return car;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    }








