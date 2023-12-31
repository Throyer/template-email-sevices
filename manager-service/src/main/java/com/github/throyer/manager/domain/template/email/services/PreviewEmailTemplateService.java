package com.github.throyer.manager.domain.template.email.services;

import com.github.throyer.manager.domain.template.email.persistence.repositories.EmailTemplateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.github.throyer.manager.shared.rest.Responses.notFound;

@Service
@Slf4j
@AllArgsConstructor
public class PreviewEmailTemplateService {
  private final EmailTemplateRepository repository;
  private final RenderTemplateService service;
  
  public String preview(String id, Object properties) {
    var template = repository.findById(id)
      .orElseThrow(() -> notFound("Email template not found"));
    
    return service.render(template.getContent(), properties);
  }
}
