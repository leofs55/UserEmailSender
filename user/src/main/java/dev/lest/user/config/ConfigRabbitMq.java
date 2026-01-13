package dev.lest.user.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.lest.user.entity.UserEntity;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbitMq {

    private final String queueName = "mail-queue";
    private final String userQueue = "users-queue";

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    public JacksonJsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new JacksonJsonMessageConverter(String.valueOf(objectMapper));
    }
}
