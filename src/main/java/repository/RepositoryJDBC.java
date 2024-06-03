package repository;

import static constants.Constants.*;

import domain.Car;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RepositoryJDBC implements CarRepositoryImpl {
    /**
     * Метод для подключения
     */
    private Connection getConnect() {
        try {
            Class.forName(DB_DRIVER);
            String url = String.format("%s%s?user=%s&password=%s", DB_ADRESS, DB_NAME, DB_LOGIN, DB_PASSWORD);
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод добавляет запись в таблицу
     */
    @Override
    public Car insertInto(Car car) {
        try (Connection connect = getConnect()) {
            String query = String.format("INSERT INTO car (brand,price,year) VALUES ('%s', %s, %d);", car.getBrand(), car.getPrice(), car.getYear());
            Statement statement = connect.createStatement();
            statement.execute(query, statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            car.setId(id);
            return car;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Car getById(Long id) {
        try (Connection connect = getConnect()) {
            String query = String.format("SELECT * FROM car WHERE id=%d;", id);
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            String brand = resultSet.getString("brand");
            BigDecimal price = resultSet.getBigDecimal("price");
            int year = resultSet.getInt("year");
            return new Car(id, brand, price, year);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car update(Car car) {
        String query = String.format("UPDATE car SET brand='%s', year=%d, price=%s WHERE id=%d", car.getBrand(), car.getYear(), car.getPrice(), car.getId());
        try (Connection connect = getConnect()) {
            Statement statement = connect.createStatement();
            int result = statement.executeUpdate(query);
            return car;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Car car) {
        try (Connection connect = getConnect()) {
          String query = String.format("DELETE FROM car WHERE id=%d",car.getId());
          Statement statement = connect.createStatement();
          int result = statement.executeUpdate(query);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }


@Override
    public List getAll() {
try (Connection connect = getConnect()) {
    List<Car> arr = new ArrayList<>();
    String query = "SELECT * FROM car";
    Statement statement = connect.createStatement();
    ResultSet result = statement.executeQuery(query);
    while (result.next()) {
        arr.add(new Car(result.getLong("id"),result.getString("brand"),result.getBigDecimal("price"),result.getInt("year")));
    }
    return arr;
} catch(Exception e) {
    throw new RuntimeException(e);
}

}


}
