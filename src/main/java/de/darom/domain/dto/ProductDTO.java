package de.darom.domain.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private boolean active;
    public ProductDTO() {

    }
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void  setTitle(String title) {
        this.title = title;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this==o) { return true;}
        if (getClass()!=o.getClass() || o==null) { return false;}
        ProductDTO p = (ProductDTO) o;
        return id==p.getId() && Objects.equals(title,p.getTitle()) && Objects.equals(price,p.getPrice());
    }
    @Override
    public int hashCode() {
        return Objects.hash(id,title,price);
    }
}
