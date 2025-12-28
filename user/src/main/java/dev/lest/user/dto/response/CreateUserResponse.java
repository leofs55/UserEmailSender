package dev.lest.user.dto.response;

import java.util.UUID;

public record CreateUserResponse(UUID userId,
                                 String name,
                                 String email) {
}