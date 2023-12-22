package com.github.throyer.sender.shared.rabbitmq;

import com.github.throyer.sender.shared.exceptions.UnretryableFailureException;
import com.github.throyer.sender.shared.rabbitmq.models.RetryManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static java.lang.String.format;

@Slf4j
public class RetryListener {
  private static final String NOT_RETRYABLE_EXCEPTION_MESSAGE_TEMPLATE = "falha não re-tentável. %s";
  public static final String MAX_ATTEMPTS_EXCEEDED_MESSAGE = "limite de tentativas excedido";

  public void processRetryableMessage(
    RetryManager manager,
    Runnable tryProcessMessage,
    Consumer<Exception> beforeRejectMessage,
    BiConsumer<Long, Exception> beforeRetry
  ) throws IOException {
    try {

      tryProcessMessage.run();
      manager.doAck();

    } catch (UnretryableFailureException exception) {

      log.info(format(NOT_RETRYABLE_EXCEPTION_MESSAGE_TEMPLATE, exception.getMessage()));
      beforeRejectMessage.accept(exception);
      manager.doAck();

    } catch (Exception exception) {

      if (manager.alreadyReachedMaxOfAttempts()) {

        log.info(MAX_ATTEMPTS_EXCEEDED_MESSAGE);
        beforeRejectMessage.accept(exception);
        manager.doAck();

      } else {
        beforeRetry.accept(manager.getDeathCount(), exception);
        manager.doReject();
      }
    }
  }
}
