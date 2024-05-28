package app.services;

import app.domain.MusicProduct;
import app.repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class ProductServices {
    private String appName;

    private RepositoryProduct repository;

    public ProductServices(RepositoryProduct repository) {
        this.repository = repository;
    }

    public MusicProduct getById(Long id) {
        return repository.getById(id);
    }
}
