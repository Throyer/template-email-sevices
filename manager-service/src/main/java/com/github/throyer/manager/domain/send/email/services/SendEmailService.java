package com.github.throyer.manager.domain.send.email.services;

import com.github.throyer.manager.domain.rabbitmq.dtos.SendEmailQueueData;
import com.github.throyer.manager.domain.rabbitmq.producers.SendEmailProducer;
import com.github.throyer.manager.domain.send.email.dtos.SendEmailData;
import com.github.throyer.manager.domain.template.email.persistence.repositories.EmailTemplateRepository;
import com.github.throyer.manager.domain.template.email.services.RenderTemplateService;
import com.github.throyer.manager.infra.errors.ApiError;
import com.samskivert.mustache.MustacheException;
import com.samskivert.mustache.MustacheParseException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.github.throyer.manager.shared.rest.Responses.badRequest;
import static com.github.throyer.manager.shared.rest.Responses.notFound;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@Slf4j
@AllArgsConstructor
public class SendEmailService {
  private final EmailTemplateRepository repository;
  private final RenderTemplateService service;
  
  private final SendEmailProducer producer;
    
  public void send(SendEmailData emailData) {
    var properties = emailData.getTemplate();
    
    var template = repository.findById(properties.getId())
      .orElseThrow(() -> notFound("Email template not found"));
    
    var html = service.render(template.getContent(), properties.getProperties());
    
    producer.send(new SendEmailQueueData(
      emailData.getSubject(),
      emailData.getDestinations(),
      html
    ));      
  }
}
