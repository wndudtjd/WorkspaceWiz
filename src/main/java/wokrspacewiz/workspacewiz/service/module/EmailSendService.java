package wokrspacewiz.workspacewiz.service.module;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendService {
    private final JavaMailSender mailSender;
    public void mailsend(String html, String subject, String fromEmail, String toEmail) {
        MimeMessage msg = mailSender.createMimeMessage();
        try {
            msg.setHeader("content-Type", "text/html; charset=UTF-8");
            msg.setContent(html, "text/html; charset=UTF-8");//내용
            msg.setSubject(subject); //
            msg.setFrom(new InternetAddress(fromEmail)); // 보내는 사람
            msg.setRecipient(MimeMessage.RecipientType.TO , new InternetAddress(toEmail)); // 받는 사람
            mailSender.send(msg);
        }catch(Exception e) {e.printStackTrace();}
    }
}
