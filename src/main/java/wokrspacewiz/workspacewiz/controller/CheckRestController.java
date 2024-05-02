package wokrspacewiz.workspacewiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wokrspacewiz.workspacewiz.service.module.EmailSendService;
import wokrspacewiz.workspacewiz.service.module.UserEmailCheckService;

@RestController
@RequiredArgsConstructor
public class CheckRestController {

    private final EmailSendService emailSendService;
    private final UserEmailCheckService userEmailCheckService;

    @GetMapping("userConfirm")
    public String userConfirm(String chk) {
        int i = userEmailCheckService.execute(chk);
        if(i > 0) {
            return "인증되었습니다.";
        }
        return "이미 인증되었습니다.";
    }
}
