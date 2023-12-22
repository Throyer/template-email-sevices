package com.github.throyer.manager.domain.rabbitmq.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SendEmailQueueData {
  private String subject;
  private List<String> destinations;
  private String html;

  public SendEmailQueueData(String subject, List<String> destinations, String html) {
    this.subject = subject;
    this.destinations = destinations;
    this.html = html;
  }
}
