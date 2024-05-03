package wokrspacewiz.workspacewiz.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wokrspacewiz.workspacewiz.command.MemberCommand;
import wokrspacewiz.workspacewiz.command.UserPwCommand;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;
import wokrspacewiz.workspacewiz.domain.MemberDTO;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;
import wokrspacewiz.workspacewiz.service.member.MemberDetailService;
import wokrspacewiz.workspacewiz.service.member.MemberUpdateService;
import wokrspacewiz.workspacewiz.service.myPage.MemberPwModify;
import wokrspacewiz.workspacewiz.service.myPage.UserPwConfirmService;

@Controller
@RequiredArgsConstructor
@RequestMapping("myPage")
public class MyPageController {

    private final MemberMapper memberMapper;
    private final MemberDetailService memberDetailService;
    private final MemberUpdateService memberUpdateService;
    private final MemberPwModify memberPwModify;
    private final UserPwConfirmService userPwConfirmService;

    @GetMapping("memberMyPage")
    public String memberMyPage(Model model, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserNum());
        memberDetailService.execute(memDto.getMemberNum(), model);
        return "thymeleaf/myPage/memberMyPage";
    }
    @GetMapping("memberUpdate")
    public String memberModify(Model model, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserNum());
        memberDetailService.execute(memDto.getMemberNum(), model);
        return "thymeleaf/myPage/myUpdate";
    }
    @PostMapping("myUpdate")
    public String myUpdate(MemberCommand memberCommand, Model model, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserNum());
        memberUpdateService.execute(memDto.getMemberNum(), memberCommand);
        return "redirect:/myPage/memberMyPage";
    }
    @GetMapping("userPwModify")
    public String userPwModify() {
        return "thymeleaf/myPage/myPwCon";
    }
    @PostMapping("memberPwModify")
    public String memberPwModify(@RequestParam String  memberPw, Model model, HttpSession session) {
        int i = memberPwModify.execute(memberPw, session);
        if(i == 1) return "thymeleaf/myPage/myNewPw";
        else {
            model.addAttribute("errPw", "비밀번호가 일치하지 않습니다.");
            return "thymeleaf/myPage/myPwCon";
        }
    }
    @PostMapping("myPwUpdate")
    public String myPwUpdate(UserPwCommand userPwCommand, Model model, HttpSession session) {
        if(userPwCommand.isMemberPwEqualsMemberPwCon()) {
            if(userPwConfirmService.execute(userPwCommand, session)) {
                return "redirect:/";
            }else {
                model.addAttribute("errOldPw", "현 비밀번호가 일치하지 않습니다.");
                return "thymeleaf/myPage/myNewPw";
            }
        }else {
            model.addAttribute("errPw", "비밀번호 확인이 일치히지 않습니다.");
            return "thymeleaf/myPage/myNewPw";
        }
    }
}
