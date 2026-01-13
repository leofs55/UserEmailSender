package dev.lest.mail.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import dev.lest.mail.dto.request.CreateMailRequest;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigRabbitMq {

    private final String queueName = "mail-queue";

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

//    @Bean
//    public JacksonJsonMessageConverter messageConverter() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return new JacksonJsonMessageConverter(String.valueOf(objectMapper));
//    }

    @Bean
    public MessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public JacksonJsonMessageConverter jsonMessageConverter() {
        JacksonJsonMessageConverter jsonConverter = new JacksonJsonMessageConverter();
        jsonConverter.setClassMapper(classMapper());
        return jsonConverter;
    }

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("createMailRequest", CreateMailRequest.class);
        classMapper.setIdClassMapping(idClassMapping);
        return classMapper;
    }
}
