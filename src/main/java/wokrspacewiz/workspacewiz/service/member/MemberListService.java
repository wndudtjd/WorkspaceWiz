package wokrspacewiz.workspacewiz.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.domain.MemberDTO;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberListService {

    private final MemberMapper memberMapper;

    public void execute(Model model) {
        List<MemberDTO> list = memberMapper.memberSelectList();
        model.addAttribute("list", list);
    }
}
