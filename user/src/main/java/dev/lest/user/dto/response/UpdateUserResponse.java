package dev.lest.user.dto.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public record UpdateUserResponse(UUID userId,
                                 String name,
                                 String email) {
}