package de.darom.control;

import de.darom.domain.dto.ProductDTO;
import de.darom.domain.entity.Product;
import de.darom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/product")
    public Product getProduct(@RequestParam Long id) {
        return service.product(id);
    }

    @PutMapping("/product")
    public Product update(@RequestParam Long id, @RequestBody ProductDTO productDTO) {
        return service.update(id, productDTO);
    }

    @PostMapping("/new")
    public Product create(@RequestBody ProductDTO productDTO) {
        Product p = new Product(productDTO.getTitle(), productDTO.getPrice(), productDTO.getActive());
        return service.save(p);
    }
@DeleteMapping("/product")
    public void delete(@RequestParam Long id) {
        service.delete(id);
}

}