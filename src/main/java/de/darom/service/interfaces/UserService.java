package de.darom.service.interfaces;

import de.darom.domain.dto.UserDTO;

import java.util.List;
public interface UserService {
    void delete(Long id);
    UserDTO save(UserDTO userDTO);
UserDTO update(UserDTO productDTO);
UserDTO user(Long id);
List<UserDTO> getAllUsers();

}
