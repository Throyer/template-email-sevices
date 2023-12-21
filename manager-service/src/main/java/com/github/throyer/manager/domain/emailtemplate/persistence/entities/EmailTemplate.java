package com.github.throyer.manager.domain.emailtemplate.persistence.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Getter
@Setter
@Document("email-template")
@NoArgsConstructor
public class EmailTemplate {
  @Id()
  private String id;

  @Schema(example = "Hello", requiredMode = REQUIRED)
  private String name;

  @Schema(example = "<h1>Hello! {{name}} </h1>", requiredMode = REQUIRED)
  private String content;

  public EmailTemplate(String name, String content) {
    this.name = name;
    this.content = content;
  }
}
