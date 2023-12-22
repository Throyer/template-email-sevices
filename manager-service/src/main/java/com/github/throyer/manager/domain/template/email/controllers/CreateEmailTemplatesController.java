package com.github.throyer.manager.domain.template.email.controllers;

import com.github.throyer.manager.domain.template.email.dtos.CreateEmailTemplateData;
import com.github.throyer.manager.domain.template.email.dtos.EmailTemplateInformation;
import com.github.throyer.manager.domain.template.email.services.CreateEmailTemplateService;
import com.github.throyer.manager.domain.template.email.swagger.CreateEmailTemplateConflictResponse;
import com.github.throyer.manager.infra.handlers.BadRequestResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.github.throyer.manager.shared.rest.Responses.created;
import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@Tag(name = "Email Templates")
@RestController
@RequestMapping("/email-templates")
@AllArgsConstructor
public class CreateEmailTemplatesController {
    private final CreateEmailTemplateService service;

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiResponse(
        responseCode = "400",
        description = "when email template creation occurs with invalid fields.",
        content = {@Content(schema = @Schema(implementation = BadRequestResponse.class))}
    )
    @ApiResponse(
        responseCode = "409",
        description = "name unavailable",
        content = {@Content(schema = @Schema(implementation = CreateEmailTemplateConflictResponse.class))}
    )
    @Operation(
      summary = "Register a new email template",
      description = "Creates a new email template",
      externalDocs = @ExternalDocumentation(
        description = "Mustache documentation",
        url = "https://github.com/janl/mustache.js?tab=readme-ov-file#mustachejs---logic-less-mustache-templates-with-javascript"
      )
    )
    public ResponseEntity<EmailTemplateInformation> create(@RequestBody @Valid CreateEmailTemplateData props) {
        log.info("creating a new email template.");
        var template = service.create(props);

        log.info("email template successfully created.");
        return created(new EmailTemplateInformation(template));
    }
}
