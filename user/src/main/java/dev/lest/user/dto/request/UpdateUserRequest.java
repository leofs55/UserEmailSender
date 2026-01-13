package dev.lest.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UpdateUserRequest(
        @org.hibernate.validator.constraints.UUID UUID userId,
        @NotBlank String name,
        @Email String email) {
}