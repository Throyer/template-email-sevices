package com.github.throyer.manager.domain.template.email.controllers;

import com.github.throyer.manager.domain.template.email.services.PreviewEmailTemplateService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
@Tag(name = "Email Templates")
@RequestMapping("/email-templates")
public class PreviewEmailTemplateController {
  private final PreviewEmailTemplateService service;

  @ApiResponse(
    responseCode = "200",
    description = "when template creation occurs with invalid fields.",
    content = {@Content(schema = @Schema(example = """
      <html>
        <h1>Hello!</h1>
      </html>
      """))}
  )
  @PostMapping(value = "/preview/{template_id}", produces = "text/html;charset=UTF-8")
  public String show(
    @PathVariable("template_id") String id,
    @RequestBody @Schema(type = "object", example = "{ \"message\": \"Hello!\" }") Map<String, ?> properties
  ) {
    return service.preview(id, properties);
  }
}
