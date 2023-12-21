package com.github.throyer.manager.domain.emailtemplate.services;

import com.github.throyer.manager.domain.emailtemplate.persistence.entities.EmailTemplate;
import com.github.throyer.manager.domain.emailtemplate.persistence.repositories.EmailTemplateRepository;
import com.github.throyer.manager.shared.pagination.Page;
import com.github.throyer.manager.shared.pagination.Pagination;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

@Service
@Slf4j
@AllArgsConstructor
public class FindAllEmailTemplatesService {
  private final EmailTemplateRepository repository;
  
  public Page<EmailTemplate> find(Integer page, Integer size) {
    var pageable = Pagination.of(ofNullable(page), ofNullable(size));

    log.info(format("find users. [page: %s, size: %s]", pageable.getPageNumber(), pageable.getPageSize()));

    var result = repository.findAll(pageable);

    log.info("user search performed successfully.");

    return Page.of(result);
  }
}
