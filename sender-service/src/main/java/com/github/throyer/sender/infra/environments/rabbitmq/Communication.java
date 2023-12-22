package com.github.throyer.sender.infra.environments.rabbitmq;

import com.github.throyer.sender.infra.configurations.rabbitmq.QueueDeclarator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.NONE;
import static org.springframework.amqp.core.BindingBuilder.bind;
import static org.springframework.amqp.core.ExchangeBuilder.directExchange;
import static org.springframework.amqp.core.QueueBuilder.durable;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "communication")
public class Communication implements QueueDeclarator {
  @NestedConfigurationProperty
  private EmailQueueProperties email;

  @Getter
  @Setter
  public static class EmailQueueProperties {
    @Getter(NONE)
    private Boolean enabled;
    private String exchangeName;
    private String queueName;
    private String queueNameRetry;
    private String queueNameDlq;
    private String routingKey;
    private String routingKeyRetry;
    private String routingKeyDlq;
    private Long retryDelayInMilliseconds;
    private Long maxRetryAttempts;

    public Boolean isEnabled() {
      return this.enabled;
    }
  }

  @Override
  public void declare(RabbitAdmin admin) {
    var properties = this.email;

    Exchange exchange = directExchange(properties.getExchangeName())
      .build();

    var queue = durable(properties.getQueueName())
      .withArgument("x-dead-letter-exchange", properties.getExchangeName())
      .withArgument("x-dead-letter-routing-key", properties.getRoutingKeyRetry())
      .build();

    var queueRetry = durable(properties.getQueueNameRetry())
      .withArgument("x-dead-letter-exchange", properties.getExchangeName())
      .withArgument("x-dead-letter-routing-key", properties.getRoutingKey())
      .withArgument("x-message-ttl", properties.getRetryDelayInMilliseconds())
      .build();

    var queueDlq = durable(properties.getQueueNameDlq())
      .build();

    admin.declareExchange(exchange);

    admin.declareQueue(queue);
    admin.declareQueue(queueRetry);
    admin.declareQueue(queueDlq);

    admin.declareBinding(bind(queue).to(exchange).with(properties.getRoutingKey()).noargs());
    admin.declareBinding(bind(queueRetry).to(exchange).with(properties.getRoutingKeyRetry()).noargs());
    admin.declareBinding(bind(queueDlq).to(exchange).with(properties.getRoutingKeyDlq()).noargs());
  }
}
