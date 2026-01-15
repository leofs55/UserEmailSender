package dev.lest.mail.consumer;

import dev.lest.mail.entity.MailEntity;
import dev.lest.mail.service.MailService;
import dev.lest.mail.util.classes.UserEntity;
import dev.lest.mail.util.enums.MailStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MailConsumer {

    private final MailService service;

    @RabbitListener(queues = "mail-queue")
    public void listenMailStringQueue(@Payload UserEntity user) {
        String emailBody =String.format(
                "Olá, %s!\n\n" +
                        "Obrigado por se cadastrar.\n" +
                        "Confirmamos o registro do e-mail: %s\n\n" +
                        "Acesse o link para confirmar: https://seusite.com/confirmar?email=%s\n\n" +
                        "Atenciosamente,\nEquipe de Suporte",
                user.name(), user.email(), user.email()
        );

        service.create(MailEntity
                .builder()
                .emailTo(user.email())
                .emailSubject("")
                .body(emailBody)
                .emailStatus(MailStatus.SENT)
                .build()
        );
    }



}
