package dev.lest.user.presentation;

import dev.lest.user.dto.request.CreateUserRequest;
import dev.lest.user.dto.request.DeleteUserRequest;
import dev.lest.user.dto.request.UpdateUserRequest;
import dev.lest.user.dto.request.UserRequest;
import dev.lest.user.dto.response.CreateUserResponse;
import dev.lest.user.dto.response.DeleteUserResponse;
import dev.lest.user.dto.response.UpdateUserResponse;
import dev.lest.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
public class UserControllerAPI {

    CreateUserResponse createUserEndPoint(CreateUserRequest createUserRequest) {
        return new CreateUserResponse();
    }

    UserResponse findUserEndPoint(UserRequest userRequest) {
        return new UserResponse();
    }

    DeleteUserResponse deleteUserEndPoint(DeleteUserRequest deleteUserRequest){
        return new DeleteUserResponse();
    }

    UpdateUserResponse updateUserEndPoint(UpdateUserRequest updateUserRequest) {
        return new UpdateUserResponse();
    }
}
