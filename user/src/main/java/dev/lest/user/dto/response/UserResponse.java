package dev.lest.user.dto.response;

import java.util.UUID;

public record UserResponse(UUID userId,
                           String name,
                           String email) {
}