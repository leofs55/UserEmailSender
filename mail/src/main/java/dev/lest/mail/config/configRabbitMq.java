package dev.lest.mail.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configRabbitMq {

    private final String queueName = "mail-queue";

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

//    @Bean
//    public Jackson2JsonMessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
//            ConnectionFactory connectionFactory,
//            Jackson2JsonMessageConverter jsonMessageConverter) {
//
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setMessageConverter(jsonMessageConverter);
//
//        // Use DefaultAmqpHeaderMapper which is generally more stable than SimpleAmqpHeaderMapper
//        DefaultAmqpHeaderMapper headerMapper = DefaultAmqpHeaderMapper.inboundMapper();
//        // You can also tell it to ignore certain headers if they continue to cause issues
//        // headerMapper.setInboundHeaderNames("!priority", "*");
//
//        return factory;
//    }
}
