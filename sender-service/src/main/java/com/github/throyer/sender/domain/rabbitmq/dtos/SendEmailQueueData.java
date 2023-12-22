package com.github.throyer.sender.domain.rabbitmq.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SendEmailQueueData {
  private String subject;
  private List<String> destinations;
  private String html;
}