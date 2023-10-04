package CarRentalCompanyApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Optional;

public class CustomerRepository {

    private final EntityManager entityManager;

    public CustomerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Customer saveCustomerDetails(final Customer customer) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.persist(customer);
            transaction.commit();
            return customer;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    public Customer deleteCustomerDetails(final Customer customer) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.remove(customer);
            transaction.commit();
            return customer;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }
}

