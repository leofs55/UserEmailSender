package dev.lest.user.dto.request;

import java.util.UUID;

public record DeleteUserRequest(UUID userId,
                                String email) {
}