package dev.lest.user.dto.response;

import java.util.UUID;

public record UpdateUserResponse(UUID userId,
                                 String name,
                                 String email) {
}