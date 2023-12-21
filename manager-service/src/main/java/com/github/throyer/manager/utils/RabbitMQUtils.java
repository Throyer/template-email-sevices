package com.github.throyer.manager.utils;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;
import static org.springframework.amqp.core.AcknowledgeMode.MANUAL;

public class RabbitMQUtils {
  private RabbitMQUtils() { }

  private static final String DEFAULT_ALGORITHM = "TLSv1.2";
  private static final String DEATH_COUNT_KEY_NAME = "count";

  public static Long extractDeathCount(Map<String, ?> properties) {
    if (nonNull(properties) && !properties.isEmpty()) {
      return (Long) properties.get(DEATH_COUNT_KEY_NAME);
    }
    return 0L;
  }

  public static CachingConnectionFactory createConnection(
    String host,
    int port,
    String username,
    String password,
    String virtualHost,
    Boolean sslEnabled,
    String sslAlgorithm
  ) throws NoSuchAlgorithmException, KeyManagementException {
    var factory = new CachingConnectionFactory();

    factory.setHost(host);
    factory.setPort(port);
    factory.setUsername(username);
    factory.setPassword(password);
    factory.setVirtualHost(virtualHost);

    if (sslEnabled) {
      factory.getRabbitConnectionFactory()
        .useSslProtocol(ofNullable(sslAlgorithm)
          .orElse(DEFAULT_ALGORITHM));
    }

    return factory;
  }

  public static SimpleRabbitListenerContainerFactory createListenerContainerAcknowledgeModeManual(ConnectionFactory connection) {
    var listenerContainer = new SimpleRabbitListenerContainerFactory();

    listenerContainer.setMessageConverter(new Jackson2JsonMessageConverter());
    listenerContainer.setConnectionFactory(connection);
    listenerContainer.setDefaultRequeueRejected(false);
    listenerContainer.setAcknowledgeMode(MANUAL);

    listenerContainer.setAfterReceivePostProcessors(JSON::setContentTypeJson);

    return listenerContainer;
  }

  public static RabbitTemplate createTemplate(ConnectionFactory connection) {
    final var template = new RabbitTemplate(connection);

    template.setMessageConverter(new Jackson2JsonMessageConverter());

    return template;
  }
}
