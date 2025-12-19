package dev.lest.mail.repository;

import dev.lest.mail.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MailRepository extends JpaRepository<MailEntity, UUID> {
}
