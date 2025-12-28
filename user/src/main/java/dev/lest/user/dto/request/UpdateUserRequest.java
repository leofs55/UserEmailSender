package dev.lest.user.dto.request;

import java.util.UUID;

public record UpdateUserRequest(UUID userId,
                                String name,
                                String email) {
}