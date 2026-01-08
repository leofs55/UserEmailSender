package dev.lest.mail.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configRabbitMq {

    private final String queueName = "mail-queue";

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
