package de.darom.service.interfaces;

import de.darom.domain.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void delete(Long id);
    ProductDTO save(ProductDTO productDTO);
ProductDTO update(ProductDTO productDTO);
ProductDTO product(Long id);
List<ProductDTO> getAllProducts();

}
