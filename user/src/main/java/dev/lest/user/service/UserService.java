package dev.lest.user.service;


import dev.lest.user.repository.UserRepository;

import java.util.UUID;

public class UserService {

    private UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    Object createUser(Object user) {
        return new Object();
    }

    Object findUser(UUID userId) {
        return new Object();
    }

    Object updateUser(Object user) {
        return new Object();
    }

    Object deleteUser() {
        return new Object();
    }
}
