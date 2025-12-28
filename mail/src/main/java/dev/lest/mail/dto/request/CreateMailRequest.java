package dev.lest.mail.dto.request;

import dev.lest.mail.enums.MailStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateMailRequest(UUID userId,
                                String emailFrom,
                                String emailTo,
                                String emailSubject,
                                String body,
                                LocalDateTime sendDateEmail,
                                MailStatus statusEmail) {
}
