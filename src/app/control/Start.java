package app.control;

import app.domain.MusicProduct;
import app.services.ProductServices;
import org.springframework.stereotype.Component;

@Component
public class Start {
    private ProductServices service;

    public Start(ProductServices service) {
        this.service = service;
    }

    public MusicProduct getById(Long id) {
        return service.getById(id);
    }
}
