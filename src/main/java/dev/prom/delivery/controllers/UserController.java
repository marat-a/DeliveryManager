package dev.prom.delivery.controllers;


import dev.prom.delivery.dto.UserDto;
import dev.prom.delivery.mappers.UserMapper;
import dev.prom.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UserDto> getAllUsers() {
        return mapper.usersToUserDtos(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return mapper.userToUserDto(userService.getUserById(id));
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return mapper.userToUserDto(userService.createUser(mapper.userDtoToUser(userDto)));
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return mapper.userToUserDto(userService.updateUser(id, mapper.userDtoToUser(userDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}