package dev.lest.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record DeleteUserRequest(
        @NotBlank UUID userId,
        @Email String email) {
}