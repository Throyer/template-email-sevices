package com.github.throyer.sender.domain.email.services;

import com.github.throyer.sender.domain.rabbitmq.dtos.SendEmailQueueData;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SendEmailService {
  private final JavaMailSender sender;

  private static final Boolean CONTENT_IS_HTML = true;
  private static final Boolean IS_MULTIPART_FILE = true;
  
    public void send(SendEmailQueueData queueData) {
      try {
        var message = sender.createMimeMessage();
        var helper = new MimeMessageHelper(message, IS_MULTIPART_FILE);

        var html = queueData.getHtml();
        var destinations = queueData.getDestinations().toArray(new String[]{});
        var subject = queueData.getSubject();
                        
        helper.setTo(destinations);
        helper.setSubject(subject);
        helper.setText(html, CONTENT_IS_HTML);
        
        sender.send(message);
        log.info("email send successfully");
      } catch (MessagingException exception) {
        throw new RuntimeException(exception);
      }
    }
}
