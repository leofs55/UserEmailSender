package dev.lest.mail.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import dev.lest.mail.dto.request.CreateMailRequest;
import dev.lest.mail.util.classes.UserEntity;
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
        classMapper.setTrustedPackages("dev.lest.user.entity.*");
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("UserEntity", UserEntity.class);
        classMapper.setIdClassMapping(idClassMapping);
        return classMapper;
    }
}
