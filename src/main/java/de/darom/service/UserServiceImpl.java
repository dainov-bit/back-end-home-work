package de.darom.service;

import de.darom.domain.dto.UserDTO;
import de.darom.domain.entity.User;
import de.darom.exception.UserNotFoundException;
import de.darom.repository.interfaces.UserRepository;
import de.darom.service.interfaces.UserService;
import de.darom.service.mapping.UserMappingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    private UserMappingService mappingService;

    public UserServiceImpl(UserRepository repository, UserMappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }
@Override
    public List<UserDTO> getAllUsers() {
List<User> users = repository.findAll();
if (users.isEmpty()) {
throw new UserNotFoundException("Not user");
}
return users.stream()
        .map(mappingService::mapEntityToDto)
        .collect(Collectors.toList());
    }
@Override
    public UserDTO update(UserDTO userDTO) {
        Optional<User> optional = repository.findById(userDTO.getId());
        User dbUser = optional.orElseThrow(() -> new UserNotFoundException("not user"));

        dbUser.setLogin(userDTO.getLogin());
        dbUser.setEmail(userDTO.getEmail());
        return mappingService.mapEntityToDto(repository.save(dbUser));

    }
@Override
    public UserDTO user(Long id) {
        Optional<User> opt = repository.findById(id);
        User u = opt.orElseThrow(() -> new UserNotFoundException("Not found user"));

        return mappingService.mapEntityToDto(u);
    }
@Override
    public void delete(Long id) {
        Optional<User> opt = repository.findById(id);
        User u = opt.orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
        repository.delete(u);
    }
@Override
    public UserDTO save(UserDTO userDTO) {
        User entity = mappingService.mapDtoToEntity(userDTO);
        repository.save(entity);
        return mappingService.mapEntityToDto(entity);
}

}
