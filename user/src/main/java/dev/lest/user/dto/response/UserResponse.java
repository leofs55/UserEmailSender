package dev.lest.user.dto.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public record UserResponse(UUID userId,
                           String name,
                           String email) {
}