package dev.lest.user.util.mapper;

import dev.lest.user.dto.request.DeleteUserRequest;
import dev.lest.user.dto.response.DeleteUserResponse;
import dev.lest.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring")
public interface DeleteUserMapper {

    UserEntity map(DeleteUserRequest deleteUserRequest);
    DeleteUserResponse map(UserEntity userEntity);

}
