package wokrspacewiz.workspacewiz.service.myPage;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.command.UserPwCommand;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserPwConfirmService {

    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;

    public boolean execute(UserPwCommand userPwCommand, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        if(passwordEncoder.matches(userPwCommand.getOldPw(), auth.getUserPw())) {
            String newPw = passwordEncoder.encode(userPwCommand.getNewPw());
            Map<String, String> map = new HashMap<>();
            map.put("memberPw", newPw);
            map.put("memberId", auth.getUserId());
            memberMapper.memberPwUpdate(map);
            auth.setUserPw(newPw);
            return true;
        }else {
            return false;
        }
    }
}
