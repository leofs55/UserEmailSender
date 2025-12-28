package dev.lest.mail.dto.response;

import dev.lest.mail.util.enums.MailStatus;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record CreateMailRespose(UUID emailId,
                                UUID userId,
                                String emailFrom,
                                String emailTo,
                                String emailSubject,
                                String body,
                                LocalDateTime sendDateEmail,
                                MailStatus statusEmail) {
}
