package com.github.throyer.sender.domain.rabbitmq.consumers;

import com.github.throyer.sender.domain.email.services.SendEmailService;
import com.github.throyer.sender.domain.rabbitmq.dtos.SendEmailQueueData;
import com.github.throyer.sender.domain.rabbitmq.dtos.SendEmailQueueDataDlq;
import com.github.throyer.sender.domain.rabbitmq.producers.SendEmailDlqProducer;
import com.github.throyer.sender.infra.environments.rabbitmq.Communication;
import com.github.throyer.sender.shared.rabbitmq.RetryListener;
import com.github.throyer.sender.shared.rabbitmq.models.RetryManager;
import com.rabbitmq.client.Channel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

import static java.lang.String.format;
import static java.time.LocalDateTime.now;
import static org.springframework.amqp.support.AmqpHeaders.DELIVERY_TAG;

@Slf4j
@Service
@AllArgsConstructor
public class SendEmailListener extends RetryListener {
  private final Communication communication;
  private final SendEmailService service;
  private final SendEmailDlqProducer deadLetterQueue;

  @RabbitListener(queues = "${communication.email.queue-name}", containerFactory = "container")
  public void receive(
    Channel channel,
    @Payload SendEmailQueueData message,
    @Header(DELIVERY_TAG) long tag,
    @Header(required = false, name = "x-death") Map<String, ?> deathHeader
  ) throws IOException {
    var queue = communication.getEmail();

    if (!queue.isEnabled()) {
      return;
    }
    
    var manager = RetryManager.of(
      channel,
      tag,
      deathHeader,
      queue.getMaxRetryAttempts()
    );

    super.processRetryableMessage(
      manager,
      () -> service.send(message),
      exception -> deadLetterQueue.publish(new SendEmailQueueDataDlq(
        exception.getMessage(),
        now(),
        message
      )),
      (deathCount, exception) -> log.info(format(
        "erro ao processar mensagem. [%s], tentativa: %s",
        exception.getMessage(),
        deathCount
      ))
    );
  }
}
