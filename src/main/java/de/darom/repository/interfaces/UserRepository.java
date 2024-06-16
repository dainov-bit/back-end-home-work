package de.darom.repository.interfaces;

import de.darom.domain.dto.UserDTO;
import de.darom.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
