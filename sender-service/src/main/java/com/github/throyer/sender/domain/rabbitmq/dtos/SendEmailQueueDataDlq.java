package com.github.throyer.sender.domain.rabbitmq.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SendEmailQueueDataDlq {
  private String error;
  private String createdAt;
  private SendEmailQueueData message;

  public SendEmailQueueDataDlq(String error, LocalDateTime createdAt, SendEmailQueueData message) {
    this.error = error;
    this.createdAt = createdAt.format(ISO_DATE_TIME);
    this.message = message;
  }
}
