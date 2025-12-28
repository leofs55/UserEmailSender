package dev.lest.mail.dto.request;

import java.util.UUID;

public record DeleteMailRequest(UUID emailId,
                                UUID userId) {
}
