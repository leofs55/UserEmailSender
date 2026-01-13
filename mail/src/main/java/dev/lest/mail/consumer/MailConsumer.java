package dev.lest.mail.consumer;

import dev.lest.mail.util.classes.UserEntity;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {

    @RabbitListener(queues = "mail-queue")
    public void listenMailStringQueue(@Payload UserEntity user) {
        System.out.println(user);
    }



}
