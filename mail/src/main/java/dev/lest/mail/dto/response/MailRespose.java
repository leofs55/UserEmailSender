package dev.lest.mail.dto.response;

import dev.lest.mail.enums.MailStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record MailRespose(UUID emailId,
                          UUID userId,
                          String emailFrom,
                          String emailTo,
                          String emailSubject,
                          String body,
                          LocalDateTime sendDateEmail,
                          MailStatus statusEmail) {
}
