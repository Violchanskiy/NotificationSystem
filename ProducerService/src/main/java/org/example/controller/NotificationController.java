package org.example.controller;

import org.example.model.Email;
import org.example.service.NotificationProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

  private final NotificationProducerService eventService;

  public NotificationController(NotificationProducerService eventService) {
    this.eventService = eventService;
  }

  @PostMapping("/createNotification")
  public void createEvent(@RequestBody Email event) {
    eventService.sendEvent(event);
  }

  @PostMapping("/test")
  public void testEvent() {
    eventService.generateAndSendEvent();
  }
}
