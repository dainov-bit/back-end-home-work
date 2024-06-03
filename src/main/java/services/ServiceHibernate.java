package services;

import repository.RepositoryHibernate;

import java.util.List;
import domain.Car;
public class ServiceHibernate {
    private RepositoryHibernate repository = new RepositoryHibernate();

    public Car save(Car car) {
        return repository.insertInto(car);
    }

    public Car getById(Long id) {
        return repository.getById(id);
    }

    public Car updateById(Car car) {
        return repository.update(car);
    }

    public void delete(Car car) {
        repository.delete(car);
    }

    public List getAll() {
        return repository.getAll();
    }

}
