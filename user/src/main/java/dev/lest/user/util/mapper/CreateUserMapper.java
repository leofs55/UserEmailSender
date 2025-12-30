package dev.lest.user.util.mapper;

import dev.lest.user.dto.request.CreateUserRequest;
import dev.lest.user.dto.response.CreateUserResponse;
import dev.lest.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring")
public interface CreateUserMapper {

    UserEntity map(CreateUserRequest createUserRequest);
    CreateUserResponse map(UserEntity userEntity);

}
