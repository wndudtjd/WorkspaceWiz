package wokrspacewiz.workspacewiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wokrspacewiz.workspacewiz.service.help.FindIdService;
import wokrspacewiz.workspacewiz.service.help.FindPwService;

@Controller
@RequiredArgsConstructor
@RequestMapping("help")
public class HelpController {

    private final FindIdService findIdService;
    private final FindPwService findPwService;

    @GetMapping("findId")
    public String findId(Model model) {
        return "thymeleaf/help/findId";
    }
    @PostMapping("findId")
    public String findId(String userPhone, String userEmail, Model model) {
        if(findIdService.execute(userPhone, userEmail, model)) {
            return "thymeleaf/help/findIdOk";
        }else {
            model.addAttribute("errUser", "존재하지않는 회원입니다.");
            return "thymeleaf/help/findId";
        }
    }
    @GetMapping("findPw")
    public String findPw(Model model) {
        return "thymeleaf/help/findPw";
    }
    @PostMapping("findPw")
    public String findPassword(String userId, String userEmail, Model model) {
        if(findPwService.execute(userId, userEmail, model)){
            return "thymeleaf/help/findPwOk";
        }else {
            model.addAttribute("errUser", "존재하지 않는 아이디 또는 이메일 입니다.");
            return "thymeleaf/help/findPw";
        }
    }
}
