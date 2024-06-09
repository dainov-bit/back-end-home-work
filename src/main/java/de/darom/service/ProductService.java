package de.darom.service;

import de.darom.domain.dto.ProductDTO;
import de.darom.domain.entity.Product;
import de.darom.exception.ProductNotFoundException;
import de.darom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, ProductDTO productDTO) {
        Optional<Product> optional = repository.findById(id);
        Product dbProduct = optional.orElseThrow(() -> new ProductNotFoundException("not product"));
        dbProduct.setTitle(productDTO.getTitle());
        dbProduct.setPrice(productDTO.getPrice());
        return repository.save(dbProduct);
    }

    public Product product(Long id) {
        Optional<Product> opt = repository.findById(id);
        Product p = opt.orElseThrow(() -> new ProductNotFoundException("Not found product"));
        return p;
    }

    public void delete(Long id) {
        Optional<Product> opt = repository.findById(id);
        Product p = opt.orElseThrow(() -> new ProductNotFoundException("Продукт не найден"));
        repository.delete(p);
    }

}
