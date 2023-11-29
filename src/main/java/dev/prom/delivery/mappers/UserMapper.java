package dev.prom.delivery.mappers;

import dev.prom.delivery.dto.UserDto;
import dev.prom.delivery.models.User;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    List<UserDto> usersToUserDtos(List<User> users);
}