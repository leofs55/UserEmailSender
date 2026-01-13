package dev.lest.mail.util.classes;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class UserEntity {
    private UUID userId;
    private String name;
    private String email;
}
