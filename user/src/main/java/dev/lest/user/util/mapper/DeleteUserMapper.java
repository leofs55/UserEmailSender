package dev.lest.user.util.mapper;

import dev.lest.user.dto.request.DeleteUserRequest;
import dev.lest.user.dto.response.DeleteUserResponse;
import dev.lest.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeleteUserMapper {

    UserEntity deleteUserRequestToUserEntity(DeleteUserRequest deleteUserRequest);
    DeleteUserResponse userEntityToDeleteUserResponse(UserEntity userEntity);

}
