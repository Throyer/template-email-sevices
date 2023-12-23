package com.github.throyer.manager.domain.template.email.services;

import com.samskivert.mustache.MustacheException;
import in.wilsonl.minifyhtml.Configuration;
import org.springframework.stereotype.Service;

import static com.github.throyer.manager.shared.rest.Responses.badRequest;
import static com.samskivert.mustache.Mustache.compiler;
import static in.wilsonl.minifyhtml.MinifyHtml.minify;

@Service
public class RenderTemplateService {
  public String render(String content, Object properties) {
    try {
      var html = compiler()
        .compile(content)
          .execute(properties);

      var configuration = new Configuration.Builder()
        .setEnsureSpecCompliantUnquotedAttributeValues(true)
        .setKeepClosingTags(true)
        .setMinifyJs(true)
        .setMinifyCss(true)
        .build();
      
      return minify(html, configuration);
    } catch (MustacheException exception) {
      throw badRequest(exception.getMessage());
    }
  }
}
