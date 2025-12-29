package dev.lest.user.util.mapper;

import dev.lest.user.dto.request.UserRequest;
import dev.lest.user.dto.response.UserResponse;
import dev.lest.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserEntity map(UserRequest userRequest);
    UserResponse map(UserEntity userEntity);
}
