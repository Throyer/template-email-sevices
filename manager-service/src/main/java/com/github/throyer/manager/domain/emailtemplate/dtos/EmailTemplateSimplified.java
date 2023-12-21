package com.github.throyer.manager.domain.emailtemplate.dtos;

import com.github.throyer.manager.domain.emailtemplate.persistence.entities.EmailTemplate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Getter
public class EmailTemplateSimplified {
  @Schema(example = "613a17b0d62a5e0001606a42", requiredMode = REQUIRED)
  private final String id;

  @Schema(example = "Hello", requiredMode = REQUIRED)
  private final String name;

  public EmailTemplateSimplified(EmailTemplate template) {
    this.id = template.getId();
    this.name = template.getName();
  }
}
