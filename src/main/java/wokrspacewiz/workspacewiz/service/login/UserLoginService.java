package wokrspacewiz.workspacewiz.service.login;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import wokrspacewiz.workspacewiz.command.LoginCommand;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;
import wokrspacewiz.workspacewiz.mapper.LoginMapper;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final PasswordEncoder passwordEncoder;
    private final LoginMapper loginMapper;

    public void execute(LoginCommand loginCommand, BindingResult result, HttpSession session, HttpServletResponse response) {
        String userId = loginCommand.getUserId();
        String password = loginCommand.getUserPw();
        AuthInfoDTO auth = loginMapper.loginSelect(userId);
        if (auth != null) { // 로그인 정보가 있을때
            if(passwordEncoder.matches(password, auth.getUserPw())) { // 비밀번호가 일치할때
                session.setAttribute("auth", auth);
            }else { // 비밀번호가 일치하지 않을때
                result.rejectValue("userPw", "loginCommand.userPw","비밀번호가 틀렸습니다.");
            }
        }else { // 로그인 정보가 없을때
            result.rejectValue("userId", "loginCommand.userId","아이디가 존재하지 않습니다.");
        }
    }
}
