package services;

import domain.Car;
import repository.RepositoryJDBC;

import java.util.List;

public class ServiceJDBC {
    private RepositoryJDBC repository = new RepositoryJDBC();

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