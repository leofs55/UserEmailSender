package dev.lest.mail.dto.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public record DeleteMailRespose(UUID emailId) {
}
