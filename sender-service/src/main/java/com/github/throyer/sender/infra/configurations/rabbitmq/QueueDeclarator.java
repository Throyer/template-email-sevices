package com.github.throyer.sender.infra.configurations.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitAdmin;

public interface QueueDeclarator {
  void declare(RabbitAdmin admin);
}