package dev.lest.mail.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {

    @RabbitListener(queues = "mail-queue")
    public void listenMailQueue(@Payload Object string) {
        System.out.println(string);
    }

}
