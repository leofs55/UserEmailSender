package dev.lest.user.dto.response;

import java.util.UUID;

public record DeleteUserResponse(UUID userId,
                                 String email) {
}