package de.darom.service.mapping;

import de.darom.domain.dto.ProductDTO;
import de.darom.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active",constant = "true")
    Product mapDtoToEntity(ProductDTO dto);


    ProductDTO mapEntityToDto(Product entity);
}
