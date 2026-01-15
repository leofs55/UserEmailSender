package dev.lest.mail.service;

import dev.lest.mail.entity.MailEntity;
import dev.lest.mail.repository.MailRepository;
import dev.lest.mail.util.enums.MailStatus;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class MailService {

    @Value("${EMAIL_FROM}")
    private String emailFrom;

    private final MailRepository repository;
    private final JavaMailSender mailSender;

    @Transactional
    public MailEntity create(MailEntity mail){
        return repository.save(mail);
    }

    public MailEntity find(MailEntity mail){
        return repository.findById(mail.getEmailId()).get();
    }

    @Transactional
    public MailEntity update(MailEntity mail){
        return repository.save(mail);
    }

    @Transactional
    public MailEntity delete(MailEntity mail){
        repository.delete(mail);
        return mail;
    }

    public List<MailEntity> findByUserId(UUID userId) {
        return repository.findAllByUserId(userId);
    }

    @Transactional
    public void sendMail(MailEntity mailEntity) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(mailEntity.getEmailTo());
            message.setSubject(mailEntity.getEmailSubject());
            message.setText(mailEntity.getBody());
            mailSender.send(message);
            mailEntity.setStatusEmail(MailStatus.SENT);
            mailEntity.setSendDateEmail(LocalDateTime.now());
        } catch (Exception e) {
            mailEntity.setStatusEmail(MailStatus.SENT);
            System.out.println("Erro ao enviar email de: "+mailEntity.getUserId());
        }
        create(mailEntity);
    }
}
