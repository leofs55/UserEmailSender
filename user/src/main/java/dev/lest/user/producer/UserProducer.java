package dev.lest.user.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProducer {

    private final RabbitTemplate template;

    private final Queue queue;

    public String send(String value) {
        template.convertAndSend("",queue.getName(), value);
        return " [x] Sent '" + value + "'";
    }

}
