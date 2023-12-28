package dev.prom.delivery.service;

import dev.prom.delivery.exceptions.NotFoundException;
import dev.prom.delivery.models.Role;
import dev.prom.delivery.models.User;
import dev.prom.delivery.repository.RoleRepository;
import dev.prom.delivery.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder encoder;
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else throw new NotFoundException("User not found");
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
        } else throw new NotFoundException("User not found");
        if (user.getPassword()!=null || !user.getPassword().isEmpty()){
            String encodedPass = encoder.encode(user.getPassword());
            user.setPassword(encodedPass);
        }
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User createUser(User user) {
        String encodedPass = encoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        Set<Role> existingRoles = new HashSet<>();
        for (Role role : user.getRoles()) {
            existingRoles.add(roleRepository.findByName(role.getName()).orElseThrow(() -> new NotFoundException("Role not found")));
        }
        user.setRoles(existingRoles);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getByLogin(@NonNull String login) {
        return userRepository.findByLogin(login);
    }
}
