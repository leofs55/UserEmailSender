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
import dev.lest.user.producer.UserProducer;
import dev.lest.user.service.UserService;
import dev.lest.user.util.mapper.CreateUserMapper;
import dev.lest.user.util.mapper.DeleteUserMapper;
import dev.lest.user.util.mapper.UpdateUserMapper;
import dev.lest.user.util.mapper.UserMapper;
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
    private final CreateUserMapper createMapper;
    private final UserMapper mapper;
    private final UpdateUserMapper updateMapper;
    private final DeleteUserMapper deleteMapper;

    //Instancia de service:
    private final UserService service;
    private final UserProducer producer;



    @PostMapping("create/")
    public ResponseEntity<Map<String, Object>> createUserEndPoint(@RequestBody CreateUserRequest createUserRequest) {

        UserEntity entity = createMapper.createUserRequestToUserEntity(createUserRequest);
        CreateUserResponse response = createMapper.userEntityToCreateUserResponse(service.create(entity));
        Map<String, Object> resultMap = Map.of(
                "User: ", response,
                "result: ", "The user was created successfully."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @GetMapping("find/")
    public ResponseEntity<Map<String, Object>> findUserEndPoint(@RequestBody UserRequest userRequest) {

        UserEntity entity = mapper.userRequestToUserEntity(userRequest);
        UserResponse response = mapper.userEntityToUserResponse(service.find(entity));
        Map<String, Object> resultMap = Map.of(
                "User: ", response,
                "result: ","The user was successfully found."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @PatchMapping("update/")
    public ResponseEntity<Map<String, Object>> updateUserEndPoint(@RequestBody UpdateUserRequest updateUserRequest) {

        UserEntity entity = updateMapper.updateUserRequestToUserEntity(updateUserRequest);
        UpdateUserResponse response = updateMapper.userEntityToUpdateUserResponse(service.update(entity));
        Map<String, Object> resultMap = Map.of(
                "User: ", response,
                "result: ","The user has been successfully changed."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @DeleteMapping("delete/")
    public ResponseEntity<Map<String, Object>> deleteUserEndPoint(@RequestBody DeleteUserRequest deleteUserRequest){

        UserEntity entity = deleteMapper.deleteUserRequestToUserEntity(deleteUserRequest);
        DeleteUserResponse response = deleteMapper.userEntityToDeleteUserResponse(service.delete(entity));
        Map<String, Object> resultMap = Map.of(
                "User: ", response,
                "result: ","The user was successfully deleted."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @GetMapping("send/{message}")
    public String sendMessage(@PathVariable String message){
        return producer.send(message);
    }
}
