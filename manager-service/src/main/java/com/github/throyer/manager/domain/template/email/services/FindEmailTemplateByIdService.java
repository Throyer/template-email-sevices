package com.github.throyer.manager.domain.template.email.services;

import com.github.throyer.manager.domain.template.email.persistence.entities.EmailTemplate;
import com.github.throyer.manager.domain.template.email.persistence.repositories.EmailTemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.github.throyer.manager.shared.rest.Responses.notFound;

@Service
@AllArgsConstructor
public class FindEmailTemplateByIdService {
  private final EmailTemplateRepository repository;
  
  public EmailTemplate show(String id) {
    return repository.findById(id)
      .orElseThrow(() -> notFound("Template not found"));
  }
}
