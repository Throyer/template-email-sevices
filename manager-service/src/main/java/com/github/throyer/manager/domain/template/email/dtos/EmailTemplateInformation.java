package com.github.throyer.manager.domain.template.email.dtos;

import com.github.throyer.manager.domain.template.email.persistence.entities.EmailTemplate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Getter
public class EmailTemplateInformation {
    @Schema(example = "613a17b0d62a5e0001606a42", requiredMode = REQUIRED)
    private final String id;

    @Schema(example = "Hello", requiredMode = REQUIRED)
    private final String name;

    @Schema(example = "<h1>Hello! {{name}} </h1>", requiredMode = REQUIRED)
    private final String content;

    public EmailTemplateInformation(EmailTemplate email) {
        this.id = email.getId();
        this.name = email.getName();
        this.content = email.getContent();
    }
}
