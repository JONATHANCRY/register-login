package org.example.registerlogin.mapper;

import org.example.registerlogin.dto.RegisterDTO;
import org.example.registerlogin.entity.UserEntity;
import org.mapstruct.Mapper;

// mapping UserEntity <-> RegisterDTO
@Mapper(componentModel = "spring")
public interface UserMapper {

    // mapping từ RegisterDTO -> UserEntity
    UserEntity toEntity(RegisterDTO dto);

    // mapping từ UserEntity -> RegisterDTO
    RegisterDTO toDTO(UserEntity user);
}
