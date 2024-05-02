package wokrspacewiz.workspacewiz.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wokrspacewiz.workspacewiz.command.LoginCommand;
import wokrspacewiz.workspacewiz.service.login.UserLoginService;

@Controller
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {

    private final UserLoginService userLoginService;

    @PostMapping("login")
    public String login(@Validated LoginCommand loginCommand, BindingResult result, Model model, HttpSession session, HttpServletResponse response) {
        userLoginService.execute(loginCommand, result, session, response);
        return "redirect:/";
    }
    @GetMapping("logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        session.invalidate();
        return "redirect:/";
    }
}
