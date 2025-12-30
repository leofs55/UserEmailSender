package dev.lest.user.presentation;

import dev.lest.user.dto.request.CreateUserRequest;
import dev.lest.user.dto.request.DeleteUserRequest;
import dev.lest.user.dto.request.UpdateUserRequest;
import dev.lest.user.dto.request.UserRequest;
import dev.lest.user.dto.response.CreateUserResponse;
import dev.lest.user.dto.response.DeleteUserResponse;
import dev.lest.user.dto.response.UpdateUserResponse;
import dev.lest.user.dto.response.UserResponse;
import dev.lest.user.entity.UserEntity;
import dev.lest.user.service.UserService;
import dev.lest.user.util.mapper.CreateUserMapper;
import dev.lest.user.util.mapper.DeleteUserMapper;
import dev.lest.user.util.mapper.UpdateUserMapper;
import dev.lest.user.util.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserControllerAPI {

    //Instancia dos Mapper`s:
    private CreateUserMapper createMapper;
    private UserMapper mapper;
    private UpdateUserMapper updateMapper;
    private DeleteUserMapper deleteMapper;

    //Instancia de service:
    private UserService service;

    public UserControllerAPI(CreateUserMapper createMapper, UserMapper mapper, UpdateUserMapper updateMapper, DeleteUserMapper deleteMapper, UserService service) {
        this.createMapper = createMapper;
        this.mapper = mapper;
        this.updateMapper = updateMapper;
        this.deleteMapper = deleteMapper;
        this.service = service;
    }

    @PostMapping("create/")
    ResponseEntity<Map<CreateUserResponse, String>> createUserEndPoint(@RequestBody CreateUserRequest createUserRequest) {

        UserEntity entity = createMapper.map(createUserRequest);
        CreateUserResponse response = createMapper.map(service.create(entity));
        Map<CreateUserResponse, String> resultMap = Map.of(
                response,
                "The user was created successfully."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @GetMapping("find/")
    ResponseEntity<Map<UserResponse, String>> findUserEndPoint(@RequestBody UserRequest userRequest) {

        UserEntity entity = mapper.map(userRequest);
        UserResponse response = mapper.map(service.find(entity));
        Map<UserResponse, String> resultMap = Map.of(
                response,
                "The user was successfully found."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @PatchMapping("update/")
    ResponseEntity<Map<UpdateUserResponse, String>> updateUserEndPoint(@RequestBody UpdateUserRequest updateUserRequest) {

        UserEntity entity = updateMapper.map(updateUserRequest);
        UpdateUserResponse response = updateMapper.map(service.update(entity));
        Map<UpdateUserResponse, String> resultMap = Map.of(
                response,
                "The user has been successfully changed."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @DeleteMapping("delete/")
    ResponseEntity<Map<DeleteUserResponse, String>> deleteUserEndPoint(@RequestBody DeleteUserRequest deleteUserRequest){

        UserEntity entity = deleteMapper.map(deleteUserRequest);
        DeleteUserResponse response = deleteMapper.map(service.delete(entity));
        Map<DeleteUserResponse, String> resultMap = Map.of(
                response,
                "The user was successfully deleted."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }
}
