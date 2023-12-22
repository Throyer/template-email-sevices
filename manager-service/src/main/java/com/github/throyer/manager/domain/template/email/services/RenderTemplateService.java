package com.github.throyer.manager.domain.template.email.services;

import com.samskivert.mustache.MustacheException;
import org.springframework.stereotype.Service;

import static com.github.throyer.manager.shared.rest.Responses.badRequest;
import static com.samskivert.mustache.Mustache.compiler;

@Service
public class RenderTemplateService {
  public String render(String content, Object properties) {
    try {
      return compiler()
        .compile(content)
          .execute(properties);
    } catch (MustacheException exception) {
      throw badRequest(exception.getMessage());
    }
  }
}
