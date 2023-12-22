package com.github.throyer.manager.domain.rabbitmq.producers;

import com.github.throyer.manager.domain.rabbitmq.dtos.SendEmailQueueData;
import com.github.throyer.manager.infra.environments.rabbitmq.Communication;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SendEmailProducer {
  private final Communication communication;
  private final RabbitTemplate rabbitmq;
  
  public void send(SendEmailQueueData queueData) {
    var queue = communication.getEmail();    
    rabbitmq.convertAndSend(queue.getExchangeName(), queue.getRoutingKey(), queueData);
  }
}
