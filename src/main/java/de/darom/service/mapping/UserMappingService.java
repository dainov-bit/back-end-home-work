package de.darom.service.mapping;

import de.darom.domain.dto.UserDTO;
import de.darom.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserMappingService {

    @Mapping(target = "id", ignore = true)
    User mapDtoToEntity(UserDTO dto);


    UserDTO mapEntityToDto(User entity);
}
