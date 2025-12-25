package dev.lest.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("front/v1/user/")
@RequiredArgsConstructor
class UserController {

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
