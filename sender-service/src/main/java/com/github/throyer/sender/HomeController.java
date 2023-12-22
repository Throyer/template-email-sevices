package com.github.throyer.sender;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
  public interface Hello {
    String getMessage();
  }

  @Operation(hidden = true)
  @GetMapping
  public Hello index() {
    return () -> "Say “hello” to my little friend! - Scarface";
  }
}
