package com.github.throyer.sender.domain.rabbitmq.producers;

import com.github.throyer.sender.domain.rabbitmq.dtos.SendEmailQueueDataDlq;
import com.github.throyer.sender.infra.environments.rabbitmq.Communication;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Slf4j
@Service
@AllArgsConstructor
public class SendEmailDlqProducer {
  private final RabbitTemplate rabbitmq;
  private final Communication communication;


  public void publish(SendEmailQueueDataDlq message) {
    var properties = communication.getEmail();

    try {
      rabbitmq.convertAndSend(properties.getExchangeName(), properties.getRoutingKeyDlq(), message);
    } catch (Exception exception) {
      log.error(format("erro ao enviar mensagem para dlq, error: %s", exception.getMessage()));
    }
  }
}
