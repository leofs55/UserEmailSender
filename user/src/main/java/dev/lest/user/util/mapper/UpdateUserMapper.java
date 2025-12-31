package dev.lest.user.util.mapper;

import dev.lest.user.dto.request.UpdateUserRequest;
import dev.lest.user.dto.response.UpdateUserResponse;
import dev.lest.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateUserMapper {

    UserEntity updateUserRequestToUserEntity(UpdateUserRequest updateUserRequest);
    UpdateUserResponse userEntityToUpdateUserResponse(UserEntity userEntity);
}
