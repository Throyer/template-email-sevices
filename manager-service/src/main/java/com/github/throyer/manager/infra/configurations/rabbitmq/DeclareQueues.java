package com.github.throyer.manager.infra.configurations.rabbitmq;

import com.github.throyer.manager.infra.environments.rabbitmq.Communication;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DeclareQueues {
  private final RabbitAdmin admin;
  private final Communication communication;

  public DeclareQueues(
    @Qualifier("admin") RabbitAdmin admin,
    Communication communication
  ) {
    this.communication = communication;
    this.admin = admin;
  }
  
  @PostConstruct
  public void declare() {
    this.communication.declare(this.admin);
  }
}
