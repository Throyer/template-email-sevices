package com.github.throyer.manager.domain.emailtemplate.services;

import com.github.throyer.manager.domain.emailtemplate.persistence.entities.EmailTemplate;
import com.github.throyer.manager.domain.emailtemplate.persistence.repositories.EmailTemplateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.github.throyer.manager.shared.rest.Responses.notFound;

@Slf4j
@Service
@AllArgsConstructor
public class DeleteEmailTemplateService {
  private final EmailTemplateRepository repository;
  
  public void destroy(String id) {
    if (!repository.existsById(id)) {
      throw notFound("Email template not found");
    }
    
    repository.deleteById(id);
  }
}
