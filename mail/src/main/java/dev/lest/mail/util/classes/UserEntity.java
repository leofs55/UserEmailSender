package dev.lest.mail.util.classes;

import lombok.experimental.UtilityClass;

import java.io.Serializable;
import java.util.UUID;

public record UserEntity(UUID userId, String name, String email) implements Serializable {}
