package com.github.throyer.sender.infra.configurations.rabbitmq;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import static com.github.throyer.sender.utils.RabbitMQUtils.*;

@Configuration
public class RabbitMQConfiguration {
  @Bean("connection")
  CachingConnectionFactory connection(
    @Value("${spring.rabbitmq.host}") String host,
    @Value("${spring.rabbitmq.port}") int port,
    @Value("${spring.rabbitmq.username}") String username,
    @Value("${spring.rabbitmq.password}") String password,
    @Value("${spring.rabbitmq.virtual-host}") String virtualHost,
    @Value("${spring.rabbitmq.ssl.enabled}") Boolean sslEnabled,
    @Value("${spring.rabbitmq.ssl.algorithm}") String sslAlgorithm
  ) throws NoSuchAlgorithmException, KeyManagementException {
    return createConnection(host, port, username, password, virtualHost, sslEnabled, sslAlgorithm);
  }

  @Bean(name = "container")
  SimpleRabbitListenerContainerFactory container(
    @Qualifier("connection")
    ConnectionFactory connection
  ) {
    return createListenerContainerAcknowledgeModeManual(connection);
  }

  @Bean(name = "template")
  RabbitTemplate rabbitMQTemplate(
    @Qualifier("connection")
    ConnectionFactory connection
  ) {
    return createTemplate(connection);
  }

  @Bean(name = "admin")
  RabbitAdmin admin(
    @Qualifier("connection")
    ConnectionFactory connection
  ) {
    return new RabbitAdmin(connection);
  }
}
