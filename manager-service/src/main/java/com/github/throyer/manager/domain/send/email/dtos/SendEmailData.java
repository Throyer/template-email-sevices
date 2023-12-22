package com.github.throyer.manager.domain.send.email.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Getter
@Setter
public class SendEmailData {
  @Schema(example = "Hello!", requiredMode = REQUIRED)
  @NotEmpty
  private String subject;
  
  @Schema(example = "[\"sample@email.com\", \"other.sample@email.com\"]", requiredMode = REQUIRED)
  @NotEmpty
  private List<@Valid @Email String> destinations;
  
  @NotNull
  private SendEmailTemplateData template;
  
  @Getter
  @Setter
  public static class SendEmailTemplateData {
    @Schema(example = "613a17b0d62a5e0001606a42", requiredMode = REQUIRED)
    @NotEmpty
    private String id;
    
    @Schema(type = "object", example = "{ \"message\": \"Hello!\" }", requiredMode = REQUIRED)
    private Object properties;
  }
  
}
