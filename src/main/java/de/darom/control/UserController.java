package de.darom.control;

import de.darom.domain.dto.UserDTO;
import de.darom.domain.entity.User;
import de.darom.service.UserServiceImpl;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")

public class UserController {
    private UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return service.user(id);
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return service.update(userDTO);
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO userDTO) {
        {
            return service.save(userDTO);
        }
    }
    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }

}