package wokrspacewiz.workspacewiz.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wokrspacewiz.workspacewiz.command.OfficeCommand;
import wokrspacewiz.workspacewiz.service.office.OfficeInsertService;
import wokrspacewiz.workspacewiz.service.office.OfficeListService;
import wokrspacewiz.workspacewiz.service.room.RoomListService;

@Controller
@RequestMapping("office")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeInsertService officeInsertService;
    private final OfficeListService officeListService;
    private final RoomListService roomListService;

    @GetMapping("officeList")
    public String officeList(Model model) {
        officeListService.execute(model);
        return "thymeleaf/office/officeList";
    }
    @GetMapping("officeRegist")
    public String officeRegist(Model model) {
        return "thymeleaf/office/officeRegist";
    }
    @PostMapping("officeRegist")
    public String officeRegist(OfficeCommand officeCommand, Model model, HttpSession session) {
        officeInsertService.execute(officeCommand, session);
        return "redirect:/office/officeList";
    }
    @GetMapping("officeDetail/{officeNum}")
    public String officeDetail(@PathVariable("officeNum") String officeNum, Model model) {
        model.addAttribute("officeNum", officeNum);
        roomListService.execute(officeNum, model);
        return "thymeleaf/office/officeDetail";
    }
}
