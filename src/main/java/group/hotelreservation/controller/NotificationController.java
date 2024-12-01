package group.hotelreservation.controller;
import group.hotelreservation.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor

public class NotificationController {


    private final EmailService emailService;

    @GetMapping("/send-notification")
    public String sendNotification() {

        LocalDateTime start = LocalDateTime.now(); // Bu anın vaxtı
        LocalDateTime end = start.plusHours(2); // 30 dəqiqə sonra bitəcək

        // Email göndəririk
        emailService.sendNotification("hafizbedirov11@gmail.com", start, end);

        return "Notification email sent successfully!";
    }



}
