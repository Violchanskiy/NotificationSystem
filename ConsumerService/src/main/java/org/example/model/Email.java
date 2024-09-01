package org.example.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Email {
  private String recipientEmail;
  private String subject;
  private String text;

  public Email() {}
}
