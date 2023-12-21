package com.github.throyer.manager.domain.emailtemplate.services;

import org.springframework.stereotype.Service;

import java.util.Map;

import static com.samskivert.mustache.Mustache.compiler;

@Service
public class RenderTemplateService {
  public String render(String content, Map<String,?> properties) {
    return compiler()
      .compile(content)
        .execute(properties);
  }
}
