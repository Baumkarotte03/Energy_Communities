package org.example.usageservice;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String ENERGY_QUEUE = "energy.queue";
    public static final String UPDATE_QUEUE  = "update.queue";

    @Bean
    public Queue energyQueue() {
        return new Queue(ENERGY_QUEUE, true);
    }

    @Bean
    public Queue updateQueue() {
        return new Queue(UPDATE_QUEUE, true);
    }

    @Bean
    public JacksonJsonMessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }
}
