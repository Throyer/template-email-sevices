package com.github.throyer.manager.domain.emailtemplate.controllers;

import com.github.throyer.manager.domain.emailtemplate.dtos.EmailTemplateSimplified;
import com.github.throyer.manager.domain.emailtemplate.services.FindAllEmailTemplatesService;
import com.github.throyer.manager.infra.handlers.BadRequestResponse;
import com.github.throyer.manager.shared.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.github.throyer.manager.shared.rest.Responses.ok;

@Slf4j
@Tag(name = "Email Templates")
@RestController
@RequestMapping("/email-templates")
@AllArgsConstructor
public class FindEmailTemplatesController {
  private final FindAllEmailTemplatesService service;

  @GetMapping
  @Operation(summary = "Returns a list of email templates")
  @ApiResponse(responseCode = "400", description = "Bad Request", content = {
    @Content(schema = @Schema(implementation = BadRequestResponse.class))
  })
  public ResponseEntity<Page<EmailTemplateSimplified>> index(
    @Parameter(example = "0")
    @RequestParam(name = "page", required = false)
    Integer page,

    @Parameter(example = "10")
    @RequestParam(name = "size", required = false)
    Integer size
  ) {
    log.info("listing templates.");
    var response = service.find(page, size);
    return ok(response.map(EmailTemplateSimplified::new));
  }
}
