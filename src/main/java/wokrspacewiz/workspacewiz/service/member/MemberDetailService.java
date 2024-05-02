package wokrspacewiz.workspacewiz.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.domain.MemberDTO;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;

@Service
@RequiredArgsConstructor
public class MemberDetailService {

    private final MemberMapper memberMapper;

    public void execute(String memberNum, Model model) {
        MemberDTO dto = memberMapper.memberSelectOne(memberNum);
        model.addAttribute("memberCommand", dto);
    }
}
