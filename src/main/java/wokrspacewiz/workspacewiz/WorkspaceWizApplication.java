package wokrspacewiz.workspacewiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication

public class WorkspaceWizApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkspaceWizApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "thymeleaf/index";
    }
}
