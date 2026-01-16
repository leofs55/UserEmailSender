package dev.lest.mail.consumer;

import dev.lest.mail.entity.MailEntity;
import dev.lest.mail.service.MailService;
import dev.lest.mail.util.classes.UserEntity;
import dev.lest.mail.util.enums.MailStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bem-vindo(a)!</title>
    <style>
        /* Note os %% aqui para escapar a porcentagem */
        body, table, td, p, a, li, blockquote { -webkit-text-size-adjust: 100%%; -ms-text-size-adjust: 100%%; }
        table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; }
        img { -ms-interpolation-mode: bicubic; border: 0; height: auto; line-height: 100%%; outline: none; text-decoration: none; }
        
        body { margin: 0; padding: 0; background-color: #f4f4f4; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; font-size: 16px; line-height: 1.6; color: #333333; }
        .email-container { max-width: 600px; margin: 0 auto; background-color: #ffffff; }
        
        .header { background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%); padding: 40px 20px; text-align: center; }
        .header h1 { color: #ffffff; font-size: 28px; font-weight: 600; margin: 0; text-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        .logo { width: 80px; height: 80px; background-color: #ffffff; border-radius: 50%%; margin: 0 auto 20px; display: flex; align-items: center; justify-content: center; font-size: 32px; color: #667eea; font-weight: bold; }
        
        .content { padding: 40px 30px; text-align: center; }
        .welcome-text { font-size: 18px; color: #333333; margin-bottom: 20px; line-height: 1.6; }
        .message-text { font-size: 16px; color: #666666; margin-bottom: 30px; line-height: 1.6; }
        
        .button-container { margin: 40px 0; }
        .confirm-button { display: inline-block; background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%); color: #ffffff; text-decoration: none; padding: 16px 32px; border-radius: 50px; font-size: 18px; font-weight: 600; text-align: center; box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3); transition: all 0.3s ease; }
        .confirm-button:hover { transform: translateY(-2px); box-shadow: 0 6px 20px rgba(102, 126, 234, 0.4); }
        
        .fallback-button { background-color: #667eea; color: #ffffff; padding: 16px 32px; border-radius: 50px; }

        .footer { background-color: #f8f9fa; padding: 30px 20px; text-align: center; border-top: 1px solid #e9ecef; }
        .footer p { color: #666666; font-size: 14px; margin: 5px 0; }
        
        @media only screen and (max-width: 600px) {
            .email-container { width: 100%% !important; }
            .header { padding: 30px 15px; }
            .header h1 { font-size: 24px; }
            .content { padding: 30px 20px; }
            .confirm-button { padding: 14px 28px; font-size: 16px; }
        }
    </style>
</head>
<body>
    <table role="presentation" cellspacing="0" cellpadding="0" border="0" width="100%%">
        <tr>
            <td align="center" style="background-color: #f4f4f4; padding: 20px 0;">
                <table role="presentation" cellspacing="0" cellpadding="0" border="0" width="600" class="email-container">
                    <tr>
                        <td class="header">
                            <div class="logo">CM</div>
                            <h1>Bem-vindo(a), %s!</h1> </td>
                    </tr>
                    <tr>
                        <td class="content">
                            <p class="welcome-text">
                                Estamos muito felizes em ter você conosco.
                            </p>
                            <p class="message-text">
                                Seu cadastro foi realizado com sucesso utilizando o e-mail: <strong>%s</strong>.<br>
                                Para ativar sua conta e começar a usar nossos serviços, clique no botão abaixo.
                            </p>
                            <div class="button-container">
                                <a href="https://seusite.com/confirmar?email=%s" class="confirm-button fallback-button">
                                    Confirmar Cadastro
                                </a>
                            </div>
                            <p class="message-text" style="font-size: 14px; margin-top: 30px;">
                                Se o botão não funcionar, copie o link abaixo no seu navegador:<br>
                                <span style="color: #667eea; font-size: 12px;">https://seusite.com/confirmar?email=%s</span>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td class="footer">
                            <p>Se você não realizou este cadastro, por favor ignore este email.</p>
                            <p style="margin-top: 20px; font-size: 12px; color: #999999;">
                                © 2024 Sua Empresa. Todos os direitos reservados.
                            </p>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>
</html>
""".formatted(user.name(), user.email(), user.email(), user.email());

        service.sendMail(MailEntity.builder()
                .userId(user.userId())
                .emailTo(user.email())
                .emailSubject("Email de confirmação de criação de usuário!")
                .body(emailBody)
                .build());
    }



}
