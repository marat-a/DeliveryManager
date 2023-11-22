package dev.prom.delivery.service;

import dev.prom.delivery.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    void deleteUser(Long id);

    User updateUser(Long id, User user);

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
