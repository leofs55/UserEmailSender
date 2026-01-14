package dev.lest.mail.repository;

import dev.lest.mail.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MailRepository extends JpaRepository<MailEntity, UUID> {

    // O Spring cria o SQL: SELECT * FROM mail_entity WHERE user_id = ?
    List<MailEntity> findAllByUserId(UUID userId);
}
