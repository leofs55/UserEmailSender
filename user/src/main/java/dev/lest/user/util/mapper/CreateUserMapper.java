package dev.lest.user.util.mapper;

import dev.lest.user.dto.request.CreateUserRequest;
import dev.lest.user.dto.response.CreateUserResponse;
import dev.lest.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateUserMapper {

    CreateUserMapper instance = Mappers.getMapper(CreateUserMapper.class);

    UserEntity createUserRequestToUserEntity(CreateUserRequest createUserRequest);
    CreateUserResponse userEntityToCreateUserResponse(UserEntity userEntity);

}
