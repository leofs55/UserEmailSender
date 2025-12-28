package dev.lest.user.dto.request;

import java.util.UUID;

public record UserRequest(UUID userId,
                          String name,
                          String email) {
}