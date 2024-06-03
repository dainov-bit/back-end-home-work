package domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {
    private Long id;
    private String brand;
    private int year;
    private BigDecimal price;

    public Car(String brand, BigDecimal price, int year) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public Car(Long id, String brand,  BigDecimal price,int year) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car c = (Car) o;
        return id == c.id && year == c.year && Objects.equals(brand, c.brand) && Objects.equals(price, c.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, year, price);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

