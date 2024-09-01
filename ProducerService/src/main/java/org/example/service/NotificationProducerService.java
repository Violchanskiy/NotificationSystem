package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Email;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationProducerService {

  private static final String TOPIC = "send_email";
  private final KafkaTemplate<String, Email> kafkaTemplate;

  public void sendEvent(Email email) {
    kafkaTemplate
        .send(TOPIC, email)
        .addCallback(
            success -> System.out.println("Message sent successfully: " + email),
            failure ->
                System.err.println(
                    "Failed to send message: " + email + ", error: " + failure.getMessage()));
  }

  public void generateAndSendEvent() {
    String mail = "violchanskye@gmail.com";
    String subject = "default_test";
    String text = "text";
    sendEvent(new Email(mail, subject, text));
  }
}
