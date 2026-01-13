package dev.lest.user.dto.request;

import java.util.UUID;

public record UserRequest(
        @org.hibernate.validator.constraints.UUID UUID userId) {
}