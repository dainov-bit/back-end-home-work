package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import domain.Car;
import jakarta.persistence.Query;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RepositoryHibernate implements CarRepositoryImpl {
    private EntityManager entityManager;

    public RepositoryHibernate() {
        entityManager = new Configuration()
                .configure("hibernate/postgres.cfg.xml")
                .buildSessionFactory()
                .createEntityManager();

    }


    @Override
    public Car insertInto(Car car) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(car);
            transaction.commit();
            return car;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Transaction cancelled", e);
        }
    }

    @Override
    public Car getById(Long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public Car update(Car car) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(car);
            transaction.commit();
            return car;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Transaction cancelled");
        }
    }

    @Override
    public void delete(Car car) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(car);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("transaction cancelled");
        }
    }

    @Override
    public List<Car> getAll() {
        Query query = entityManager.createQuery("FROM car", Car.class);
        return query.getResultList();
    }
}
