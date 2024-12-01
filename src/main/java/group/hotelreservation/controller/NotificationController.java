package group.hotelreservation.controller;

import group.hotelreservation.service.EmailVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor

public class NotificationController {


    private final EmailVerificationService emailVerificationService;

    @PostMapping("/send-notification")
    public ResponseEntity<String> sendNotification() {
        emailVerificationService.notifyCustomers();
        return ResponseEntity.ok("Bildiriisler gonderildi");
    }
}