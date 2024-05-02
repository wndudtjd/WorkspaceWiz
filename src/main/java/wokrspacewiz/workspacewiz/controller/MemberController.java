package wokrspacewiz.workspacewiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wokrspacewiz.workspacewiz.command.MemberCommand;
import wokrspacewiz.workspacewiz.service.member.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberInsertService memberInsertService;
    private final MemberListService memberListService;
    private final MemberDetailService memberDetailService;
    private final MemberUpdateService memberUpdateService;
    private final MemberDeleteService memberDeleteService;

    @GetMapping("memberList")
    public String memberList(Model model) {
        memberListService.execute(model);
        return "thymeleaf/member/memberList";
    }
    @GetMapping("memberRegist")
    public String memberRegist(Model model) {
        return "thymeleaf/member/memberRegist";
    }
    @PostMapping("memberRegist")
    public String memberRegist(MemberCommand memberCommand, Model model) {
        memberInsertService.execute(memberCommand);
        return "redirect:/member/memberList";
    }
    @GetMapping("memberDetail/{memberNum}")
    public String memberDetail(@PathVariable String memberNum, Model model) {
        memberDetailService.execute(memberNum, model);
        return "thymeleaf/member/memberDetail";
    }
    @GetMapping("memberUpdate/{memberNum}")
    public String memberUpdate(@PathVariable String memberNum, Model model) {
        memberDetailService.execute(memberNum, model);
        return "thymeleaf/member/memberUpdate";
    }
    @PostMapping("memberUpdate/{memberNum}")
    public String memberUpdate(@PathVariable String memberNum, MemberCommand memberCommand, Model model) {
        memberUpdateService.execute(memberNum, memberCommand);
        return "redirect:/member/memberDetail/" + memberNum;
    }
    @GetMapping("memberDelete/{memberNum}")
    public String memberDelete(@PathVariable String memberNum, Model model) {
        memberDeleteService.execute(memberNum);
        return "redirect:/member/memberList";
    }
}
