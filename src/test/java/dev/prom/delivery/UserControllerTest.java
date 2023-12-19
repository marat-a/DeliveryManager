package dev.prom.delivery;

import dev.prom.delivery.controllers.UserController;
import dev.prom.delivery.dto.UserDto;
import dev.prom.delivery.dto.UserOutputDto;
import dev.prom.delivery.enums.ERole;
import dev.prom.delivery.mappers.UserMapper;
import dev.prom.delivery.models.Role;
import dev.prom.delivery.models.User;
import dev.prom.delivery.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User("John Doe", "1234567890", new HashSet<>(Arrays.asList(
                new Role(ERole.USER)))));
        users.add(new User("Jane Smith", "0987654321", new HashSet<>(Arrays.asList(
                new Role(ERole.USER)))));

        List<UserOutputDto> userOutputDtos = new ArrayList<>();
        userOutputDtos.add(new UserOutputDto("John Doe", "1234567890", ERole.USER));
        userOutputDtos.add(new UserOutputDto("Jane Smith", "0987654321", ERole.ADMIN));

        when(userService.getAllUsers()).thenReturn(users);
        when(userMapper.usersToUserOutputDtos(users)).thenReturn(userOutputDtos);

        // Act
        ResponseEntity<List<UserOutputDto>> response = userController.getAllUsers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userOutputDtos, response.getBody());
        verify(userService, times(1)).getAllUsers();
        verify(userMapper, times(1)).usersToUserOutputDtos(users);
    }

    @Test
    void testGetUserById() {
        // Arrange
        Long userId = 1L;
        User user = new User("John Doe", "1234567890", new HashSet<>(Arrays.asList(
                new Role(ERole.USER))));
        UserOutputDto userOutputDto = new UserOutputDto("John Doe", "1234567890", ERole.USER);

        when(userService.getUserById(userId)).thenReturn(user);
        when(userMapper.userToUserOutputDto(user)).thenReturn(userOutputDto);

        // Act
        ResponseEntity<UserOutputDto> response = userController.getUserById(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userOutputDto, response.getBody());
        verify(userService, times(1)).getUserById(userId);
        verify(userMapper, times(1)).userToUserOutputDto(user);
    }

    @Test
    void testCreateUser() {
        // Arrange
        UserDto userDto = new UserDto("John Doe", "1234567890", ERole.USER);
        User user = new User("John Doe", "1234567890", new HashSet<>(Arrays.asList(
                new Role(ERole.USER))));
        UserOutputDto createdUserOutputDto = new UserOutputDto("John Doe", "1234567890", ERole.USER);

        when(userMapper.userDtoToUser(userDto)).thenReturn(user);
        when(userService.createUser(user)).thenReturn(user);
        when(userMapper.userToUserOutputDto(user)).thenReturn(createdUserOutputDto);

        // Act
        ResponseEntity<UserOutputDto> response = userController.createUser(userDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdUserOutputDto, response.getBody());
        verify(userMapper, times(1)).userDtoToUser(userDto);
        verify(userService, times(1)).createUser(user);
        verify(userMapper, times(1)).userToUserOutputDto(user);
    }

    @Test
    void testUpdateUser() {
        // Arrange
        Long userId = 1L;
        UserDto userDto = new UserDto("John Doe", "1234567890", ERole.USER);
        User user = new User("John Doe", "1234567890", new HashSet<>(Arrays.asList(
                new Role(ERole.USER))));
        UserOutputDto userOutputDto = new UserOutputDto("John Doe", "1234567890", ERole.USER);

        when(userMapper.userDtoToUser(userDto)).thenReturn(user);
        when(userService.updateUser(userId, user)).thenReturn(user);
        when(userMapper.userToUserOutputDto(user)).thenReturn(userOutputDto);

        // Act
        ResponseEntity<UserOutputDto> response = userController.updateUser(userId, userDto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userOutputDto, response.getBody());
        verify(userMapper, times(1)).userDtoToUser(userDto);
        verify(userService, times(1)).updateUser(userId, user);
        verify(userMapper, times(1)).userToUserOutputDto(user);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        Long userId = 1L;

        // Act
        ResponseEntity<Void> response = userController.deleteUser(userId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService, times(1)).deleteUser(userId);
    }
}