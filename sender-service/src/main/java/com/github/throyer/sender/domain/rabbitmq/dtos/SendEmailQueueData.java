package com.github.throyer.sender.domain.rabbitmq.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendEmailQueueData {
  private String subject;
  private String[] destinations;
  private String html;
}