package de.darom.control;

import de.darom.domain.dto.ProductDTO;
import de.darom.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductServiceImpl service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("{id}")
    public ProductDTO getProduct(@PathVariable Long id) {
        return service.product(id);
    }

    @PutMapping
    public ProductDTO update(@RequestBody ProductDTO productDTO) {
        return service.update(productDTO);
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        return service.save(productDTO);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }

}