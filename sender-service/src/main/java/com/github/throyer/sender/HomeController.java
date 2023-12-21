package com.github.throyer.sender;

import com.github.throyer.sender.domain.email.services.SendEmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {
    private final SendEmailService service;

    @GetMapping
    public Object index() {
        return service.email();
    }
}
