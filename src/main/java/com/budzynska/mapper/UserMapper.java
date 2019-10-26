package com.budzynska.mapper;

import com.budzynska.domain.User;
import com.budzynska.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract UserDTO toUserDTO(User user);

    public abstract User toUser(UserDTO userDTO);

    public abstract List<UserDTO> toUserDTOs(List<User> userList);
}
