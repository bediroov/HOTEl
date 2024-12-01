package group.hotelreservation.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Slf4j
@RequiredArgsConstructor
@Service


public class EmailService {


    private final JavaMailSender mailSender;

    public void sendNotification(String toEmail, LocalDateTime start, LocalDateTime end) {

      // 30 dəqiqə sonra bitəcək

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Start və end tarixlərini formatlayırıq
        String startFormatted = start.format(formatter);
        String endFormatted = end.format(formatter);

        String subject = "Rezervasiya Bildirişi";
        String message = String.format(" rezervasiyanız aşağıdakı vaxtlarda olacaq:\nBaşlanğıc: %s\nSon: %s", startFormatted, endFormatted);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail); // Məqsədli email ünvanı
        mailMessage.setSubject(subject); // Email başlığı
        mailMessage.setText(message); // Email məzmunu


        // Email göndəririk
        mailSender.send(mailMessage);



    }
}
