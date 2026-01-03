package dev.lest.mail.entity;

import dev.lest.mail.util.enums.MailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "TB_MAIL")
public class MailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private UUID userId;
    private String emailFrom;
    private String emailTo;
    private String emailSubject;
    @Column(columnDefinition = "BODY")
    private String body;
    private LocalDateTime sendDateEmail;
    @Enumerated(EnumType.STRING)
    @Column(name = "email_status", columnDefinition = "status_email")
    private MailStatus emailStatus;

    //Getter's
    public UUID getEmailId() {
        return emailId;
    }
    public UUID getUserId() {
        return userId;
    }
    public String getEmailFrom() {
        return emailFrom;
    }
    public String getEmailTo() {
        return emailTo;
    }
    public String getEmailSubject() {
        return emailSubject;
    }
    public String getBody() {
        return body;
    }
    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }
    public MailStatus getStatusEmail() {
        return emailStatus;
    }

    //Setter's
    public void setEmailId(UUID emailId) {
        this.emailId = emailId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }
    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }
    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }
    public void setStatusEmail(MailStatus statusEmail) {
        this.emailStatus = statusEmail;
    }
}