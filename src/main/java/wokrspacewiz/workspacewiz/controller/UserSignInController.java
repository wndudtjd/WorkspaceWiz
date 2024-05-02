package wokrspacewiz.workspacewiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wokrspacewiz.workspacewiz.command.MemberCommand;
import wokrspacewiz.workspacewiz.service.member.MemberSignInService;

@Controller
@RequiredArgsConstructor
@RequestMapping("register")
public class UserSignInController {

    private final MemberSignInService memberSignInService;

    @GetMapping("signIn")
    public String signIn() {
        return "thymeleaf/signIn/userAgree";
    }
    @PostMapping("userWrite")
    public String userWrite(@RequestParam(value="agree", defaultValue = "false") boolean agree) {
        if(agree == false) {
            return "thymeleaf/signIn/userAgree";
        }
        return "thymeleaf/signIn/userWrite";
    }
    @PostMapping("userRegist")
    public String userRegist(MemberCommand memberCommand, Model model) {
        memberSignInService.execute(memberCommand, model);
        return "thymeleaf/signIn/welcome";
    }
}
