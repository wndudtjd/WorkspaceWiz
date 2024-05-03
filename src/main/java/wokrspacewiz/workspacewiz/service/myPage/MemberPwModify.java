package wokrspacewiz.workspacewiz.service.myPage;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;

@Service
@RequiredArgsConstructor
public class MemberPwModify {

    private final PasswordEncoder passwordEncoder;

    public int execute(String memberPw, HttpSession session) {
        int i = 0;
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        if(passwordEncoder.matches(memberPw, auth.getUserPw())) i = 1;
        return i;
    }
}
