package dev.lest.user.service;


import dev.lest.user.entity.UserEntity;
import dev.lest.user.producer.UserProducer;
import dev.lest.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final UserProducer producer;

    @Transactional
    public UserEntity create(UserEntity user) {
        UserEntity userEntity = repository.save(user);
        producer.sendUser(user);
        return userEntity;
    }

    public UserEntity find(UserEntity user) {
        return repository.findById(user.getUserId()).get();
    }

    @Transactional
    public  UserEntity update(UserEntity user) {
        return repository.save(user);
    }

    @Transactional
    public UserEntity delete(UserEntity user) {
        repository.delete(user);
        return user;
    }
}
