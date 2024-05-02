package wokrspacewiz.workspacewiz.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.command.MemberCommand;
import wokrspacewiz.workspacewiz.domain.MemberDTO;
import wokrspacewiz.workspacewiz.domain.MemberEnum;
import wokrspacewiz.workspacewiz.mapper.AutoNumMapper;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;
import wokrspacewiz.workspacewiz.service.module.EmailSendService;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberSignInService {

    private final EmailSendService emailSendService;
    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;
    private final AutoNumMapper autoNumMapper;

    public void execute(MemberCommand memberCommand, Model model) {
        MemberDTO memberDto = new MemberDTO();
        BeanUtils.copyProperties(memberCommand, memberDto);
        Map<String, String> map = new HashMap<>();
        map.put("tableName", "members");
        map.put("columnName", "member_num");
        map.put("sep","mem");
        String memberNum = autoNumMapper.autoNumSelect(map);
        String newPw = passwordEncoder.encode(memberCommand.getMemberPw());
        memberDto.setMemberPw(newPw);
        memberDto.setMemberNum(memberNum);
        memberDto.setMemberType(MemberEnum.MT01);
        int i = memberMapper.memberSignInInsert(memberDto);

        if(i > 0) {
            String html = "<html><body>";
            html+= memberDto.getMemberName() + "님의 회원 가입을 축하합니다. <br />";
            html+= "가입을 완료하시려면 ";
            html+= "<a href='http://localhost:8080/userConfirm?chk="
                    + memberDto.getMemberEmail()
                    + "'>여기</a>를 클릭하세요.";
            html+= "</body></html>";
            String subject = "환영 인사입니다.";
            String fromEmail = "yju55848@gmail.com";
            String toEmail = memberDto.getMemberEmail();
            emailSendService.mailsend(html, subject, fromEmail, toEmail);
        }
    }
}
