package com.ata2.art22;

import com.ata2.art22.entity.User;
import com.ata2.art22.entity.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User entity);

    User toEntity(UserDTO dto);
}
