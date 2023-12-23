package com.github.throyer.manager.domain.template.email.controllers;

import com.github.throyer.manager.domain.template.email.persistence.entities.EmailTemplate;
import com.github.throyer.manager.domain.template.email.services.FindEmailTemplateByIdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.throyer.manager.shared.rest.Responses.ok;

@Slf4j
@RestController
@AllArgsConstructor
@Tag(name = "Email Templates")
@RequestMapping("/email-templates")
public class FindEmailTemplateByIdController {
  private final FindEmailTemplateByIdService service;
  
  @GetMapping("/{template_id}")
  public ResponseEntity<EmailTemplate> show(@PathVariable("template_id") String id) {
    return ok(service.show(id));
  }
}
