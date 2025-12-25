package dev.lest.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
public class UserControllerAPI {

    Object createUserEndPoint(Object createUserRequest) {
        return new Object();
    }

    Object findUserEndPoint(Object userRequest) {
        return new Object();
    }

    Object deleteUserEndPoint(Object deleteUserRequest){
        return new Object();
    }

    Object updateUserEndPoint(Object updateUserRequest) {
        return new Object();
    }
}
