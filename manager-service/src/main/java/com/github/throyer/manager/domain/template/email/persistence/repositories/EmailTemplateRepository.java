package com.github.throyer.manager.domain.template.email.persistence.repositories;

import com.github.throyer.manager.domain.template.email.persistence.entities.EmailTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailTemplateRepository extends MongoRepository<EmailTemplate, String> {
  Boolean existsByName(String email);
}
