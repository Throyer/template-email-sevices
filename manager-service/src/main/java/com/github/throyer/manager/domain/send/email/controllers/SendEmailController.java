package com.github.throyer.manager.domain.send.email.controllers;

import com.github.throyer.manager.domain.send.email.dtos.SendEmailData;
import com.github.throyer.manager.domain.send.email.services.SendEmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("send-email")
@AllArgsConstructor
public class SendEmailController {
  private final SendEmailService service;
  
  @ResponseStatus(NO_CONTENT)
  @PostMapping
  public void send(@RequestBody SendEmailData emailData) {
    service.send(emailData);
  }
}
