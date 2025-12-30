package dev.lest.user.util.mapper;

import dev.lest.user.dto.request.UpdateUserRequest;
import dev.lest.user.dto.response.UpdateUserResponse;
import dev.lest.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UpdateUserMapper {

    UserEntity map(UpdateUserRequest updateUserRequest);
    UpdateUserResponse map(UserEntity userEntity);

}
