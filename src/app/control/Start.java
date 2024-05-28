package app.control;

import app.domain.MusicProduct;
import app.services.ProductServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.ini")
public class Start {
    @Value("${app.name}") private String appName;

    private ProductServices service;

    public Start(ProductServices service) {
        this.service = service;
    }

    public MusicProduct getById(Long id) {
        return service.getById(id);
    }
    public String getShop() {
        return appName;
    }
}
