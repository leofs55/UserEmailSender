package dev.lest.user.service;


import dev.lest.user.entity.UserEntity;
import dev.lest.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public UserEntity create(UserEntity user) {
        return repository.save(user);
    }

    public UserEntity find(UserEntity user) {
        return repository.findById(user.getUserId()).get();
    }

    public  UserEntity update(UserEntity user) {
        return repository.save(user);
    }

    public UserEntity delete(UserEntity user) {
        repository.delete(user);
        return user;
    }
}
