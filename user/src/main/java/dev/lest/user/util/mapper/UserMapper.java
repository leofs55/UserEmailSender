package dev.lest.user.util.mapper;

import dev.lest.user.dto.request.UserRequest;
import dev.lest.user.dto.response.UserResponse;
import dev.lest.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userRequestToUserEntity(UserRequest userRequest);
    UserResponse userEntityToUserResponse(UserEntity userEntity);
}
