package com.github.throyer.manager.domain.template.email.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public interface CreateEmailTemplateConflictResponse {
    @Schema(example = "e-mail unavailable", requiredMode = REQUIRED)
    String getMessage();

    @Schema(example = "409", requiredMode = REQUIRED)
    Integer getStatus();
}
