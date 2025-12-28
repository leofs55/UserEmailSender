package dev.lest.mail.dto.request;

import java.util.UUID;

public record MailRequest(UUID emailId,
                          UUID userId) {
}
