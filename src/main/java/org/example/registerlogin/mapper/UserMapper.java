package org.example.registerlogin.mapper;

import org.example.registerlogin.dto.RegisterDTO;
import org.example.registerlogin.entity.UserEntity;
import org.mapstruct.Mapper;

// cần chạy  mvn clean install. để ide load lại annotation processor
@Mapper(componentModel = "spring")
public interface UserMapper {

    RegisterDTO toDto(UserEntity entity);

    UserEntity toEntity(RegisterDTO dto);
}


