package repository;

import domain.Car;

import java.util.List;

/**
 * Интерфейс, который содержит будущие методы для управления объектами из таблицы
 */
public interface CarRepositoryImpl {
    Car getById(Long id); // Вызываем объект по id

    Car update(Car car);  // Изменяем объект по id

    Car insertInto(Car car); // Вставляем объект в таблицу
     void delete(Car car);  // удаляем объект по id

    List getAll();  // вызываем все объекты таблицы

}
