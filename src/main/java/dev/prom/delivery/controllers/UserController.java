package dev.prom.delivery.controllers;


import dev.prom.delivery.dto.UserDto;
import dev.prom.delivery.dto.UserOutputDto;
import dev.prom.delivery.mappers.UserMapper;
import dev.prom.delivery.models.User;
import dev.prom.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserOutputDto>> getAllUsers() {
        List<UserOutputDto> userDtos = mapper.usersToUserOutputDtos(userService.getAllUsers());
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutputDto> getUserById(@PathVariable Long id) {
        UserOutputDto userOutputDto = mapper.userToUserOutputDto(userService.getUserById(id));
        return ResponseEntity.ok(userOutputDto);
    }

    @PostMapping
    public ResponseEntity<UserOutputDto> createUser(@RequestBody UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);
        User createdUser = userService.createUser(user);
        UserOutputDto createdUserOutputDto = mapper.userToUserOutputDto(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserOutputDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserOutputDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);
        User updatedUser = userService.updateUser(id, user);
        UserOutputDto userOutputDto = mapper.userToUserOutputDto(updatedUser);
        return ResponseEntity.ok(userOutputDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}