package com.github.throyer.manager.domain.emailtemplate.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Getter
@Setter
public class CreateEmailTemplateData {
    @NotNull
    @Size(max = 120)
    @Schema(example = "Hello", requiredMode = REQUIRED)
    private String name;

    @Size(max = 100000)
    @Schema(
      example = """
        <html>
          <h1>{{message}}</h1>
        </html>
      """,
      requiredMode = REQUIRED
    )
    private String content;
}
