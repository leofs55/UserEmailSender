package dev.lest.user.dto.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public record DeleteUserResponse(UUID userId,
                                 String email) {
}