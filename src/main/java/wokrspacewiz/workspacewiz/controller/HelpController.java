package wokrspacewiz.workspacewiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wokrspacewiz.workspacewiz.service.help.FindIdService;

@Controller
@RequiredArgsConstructor
@RequestMapping("help")
public class HelpController {

    private final FindIdService findIdService;

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
}
