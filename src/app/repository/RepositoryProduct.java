package app.repository;

import app.domain.MusicProduct;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RepositoryProduct {
    private final List<MusicProduct> database = new ArrayList<>();
    public RepositoryProduct() {
        database.add(new MusicProduct(1L,"Лепс","Рюмка",new BigDecimal(8.99)));
        database.add(new MusicProduct(2L,"Шнур","Олень",new BigDecimal(7.99)));
        database.add(new MusicProduct(3L,"Национальные песни","Гимн Германии",new BigDecimal(5.99)));
    }
    public MusicProduct getById(Long id) {
        for (MusicProduct product : database) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }



}
