package com.github.throyer.manager.domain.template.email.services;

import com.github.throyer.manager.domain.template.email.dtos.CreateEmailTemplateData;
import com.github.throyer.manager.domain.template.email.persistence.entities.EmailTemplate;
import com.github.throyer.manager.domain.template.email.persistence.repositories.EmailTemplateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.github.throyer.manager.shared.rest.Responses.conflict;

@Slf4j
@Service
@AllArgsConstructor
public class CreateEmailTemplateService {
  private final EmailTemplateRepository repository;
  
  public EmailTemplate create(CreateEmailTemplateData data) {

    if (repository.existsByName(data.getName())) {
      log.warn("could not create email template, e-mail is unavailable.");
      throw conflict("template name is unavailable.");
    }

    var template = new EmailTemplate(
      data.getName(),
      data.getContent()
    );

    repository.save(template);

    log.info("new template successfully created.");

    return template;
  }
}
