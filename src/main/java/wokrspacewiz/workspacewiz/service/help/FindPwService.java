package wokrspacewiz.workspacewiz.service.help;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;
import wokrspacewiz.workspacewiz.domain.UserChangePwDTO;
import wokrspacewiz.workspacewiz.mapper.FindMapper;
import wokrspacewiz.workspacewiz.mapper.LoginMapper;
import wokrspacewiz.workspacewiz.service.module.EmailSendService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindPwService {

    private final LoginMapper loginMapper;
    private final FindMapper findMapper;
    private final EmailSendService emailSendService;

    public boolean execute(String userId, String userEmail, Model model) {
        String newPw = UUID.randomUUID().toString().substring(0, 8);
        UserChangePwDTO dto = new UserChangePwDTO();
        dto.setUserId(userId);
        dto.setUserEmail(userEmail);
        dto.setUserPw(newPw);

        AuthInfoDTO auth = loginMapper.loginSelect(userId);
        if(auth != null) {
            dto.setGrade(auth.getGrade());
            int i = findMapper.pwUpdate(dto);
            model.addAttribute("auth", auth);
            if(i > 0) {
                String html = "<html><body>";
                html+= auth.getUserName()+"님의 임시 비밀번호는 "+newPw+"입니다.";
                html+=  "</body></html>";
                String subject = auth.getUserName() + "님의 임시비밀번호입니다.";
                String fromEmail = "yju55848@gmail.com";
                String toEmail = dto.getUserEmail();
                emailSendService.mailsend(html, subject, fromEmail, toEmail);
            }
            return true;
        }else {
            return false;
        }
    }
}
