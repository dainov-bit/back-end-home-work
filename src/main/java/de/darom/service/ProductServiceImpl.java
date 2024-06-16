package de.darom.service;

import de.darom.domain.dto.ProductDTO;
import de.darom.domain.entity.Product;
import de.darom.exception.ProductNotFoundException;
import de.darom.repository.interfaces.ProductRepository;
import de.darom.service.interfaces.ProductService;
import de.darom.service.mapping.ProductMappingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository repository;
    private ProductMappingService mappingService;

    public ProductServiceImpl(ProductRepository repository, ProductMappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }
@Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = repository.findAll();
        List<ProductDTO> productDTOs = products.stream()
                .filter(Product::getActive)
                .map(mappingService::mapEntityToDto)
                .collect(Collectors.toList());
        return productDTOs;
    }
@Override
    public ProductDTO save(ProductDTO productDTO) {
        Product entity = mappingService.mapDtoToEntity(productDTO);
        repository.save(entity);
        return mappingService.mapEntityToDto(entity);
    }
@Override
    public ProductDTO update(ProductDTO productDTO) {
        Optional<Product> optional = repository.findById(productDTO.getId());
        Product dbProduct = optional.orElseThrow(() -> new ProductNotFoundException("not product"));
        dbProduct.setTitle(productDTO.getTitle());
        dbProduct.setPrice(productDTO.getPrice());
        return mappingService.mapEntityToDto(repository.save(dbProduct));

    }
@Override
    public ProductDTO product(Long id) {
        Optional<Product> opt = repository.findById(id);
        Product p = opt.orElseThrow(() -> new ProductNotFoundException("Not found product"));

        return mappingService.mapEntityToDto(p);
    }
@Override
    public void delete(Long id) {
        Optional<Product> opt = repository.findById(id);
        Product p = opt.orElseThrow(() -> new ProductNotFoundException("Продукт не найден"));
        repository.delete(p);
    }

}
