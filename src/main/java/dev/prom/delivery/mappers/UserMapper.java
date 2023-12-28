package dev.prom.delivery.mappers;

import dev.prom.delivery.dto.UserDto;
import dev.prom.delivery.dto.UserOutputDto;
import dev.prom.delivery.models.User;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserOutputDto userToUserOutputDto(User user);

    User userDtoToUser(UserDto userDto);

    List<UserOutputDto> usersToUserOutputDtos(List<User> users);
}