package com.github.throyer.manager.domain.template.email.controllers;

import com.github.throyer.manager.domain.template.email.services.DeleteEmailTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@Slf4j
@RestController
@AllArgsConstructor
@Tag(name = "Email Templates")
@RequestMapping("/email-templates")
public class DeleteEmailTemplatesController {
  private final DeleteEmailTemplateService service;
  
  @DeleteMapping("/{template_id}")
  @ResponseStatus(NO_CONTENT)
  @Operation(summary = "Delete user")
  public void destroy(@PathVariable("template_id") String id) {
    service.destroy(id);
  }
}
