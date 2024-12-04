package group.hotelreservation.service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;



@Slf4j
@RequiredArgsConstructor
@Service


public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(String to,String subject,String body){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body,true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("E-mail göndərilə bilmədi",e);
        }
    }


}
