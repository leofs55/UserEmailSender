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
        String emailBody = """
        <div style="font-family: Arial, sans-serif; color: #333; max-width: 600px; margin: auto; border: 1px solid #ddd; padding: 20px; border-radius: 8px;">
            <h2 style="color: #0056b3;">Bem-vindo(a), %s!</h2>
            <p>Estamos muito felizes em ter você conosco.</p>
            <p>Seu cadastro foi realizado com sucesso utilizando o e-mail: <strong>%s</strong>.</p>
            <p>Para ativar sua conta e começar a usar nossos serviços, clique no botão abaixo:</p>
            
            <div style="text-align: center; margin: 30px 0;">
                <a href="https://seusite.com/confirmar?email=%s" 
                   style="background-color: #28a745; color: white; padding: 12px 24px; text-decoration: none; border-radius: 5px; font-weight: bold;">
                   Confirmar Cadastro
                </a>
            </div>
            
            <p style="font-size: 12px; color: #777;">Se você não realizou este cadastro, por favor ignore este e-mail.</p>
            <hr style="border: 0; border-top: 1px solid #eee;">
            <p style="font-size: 12px; text-align: center;">&copy; 2024 Sua Empresa</p>
        </div>
    """.formatted(user.name(), user.email(), user.email());

        service.sendMail(MailEntity.builder()
                .userId(user.userId())
                .emailFrom(user.email())
                .emailSubject("Email de confirmação de criação de usuário!")
                .body(emailBody)
                .build());
    }



}
