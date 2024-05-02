package wokrspacewiz.workspacewiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wokrspacewiz.workspacewiz.command.RoomCommand;
import wokrspacewiz.workspacewiz.service.room.RoomDeleteService;
import wokrspacewiz.workspacewiz.service.room.RoomDetailService;
import wokrspacewiz.workspacewiz.service.room.RoomInsertService;
import wokrspacewiz.workspacewiz.service.room.RoomUpdateService;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("room")
public class RoomController {

    private final RoomInsertService roomInsertService;
    private final RoomDetailService roomDetailService;
    private final RoomUpdateService roomUpdateService;
    private final RoomDeleteService roomDeleteService;

    @GetMapping("roomRegist/{officeNum}")
    public String roomRegist(@PathVariable String officeNum, Model model) {
        model.addAttribute("officeNum", officeNum);
        return "thymeleaf/room/roomRegist";
    }
    @PostMapping("roomRegist")
    public String roomRegist(RoomCommand roomCommand) throws IOException {
        roomInsertService.execute(roomCommand);
        return "redirect:/office/officeDetail/" + roomCommand.getOfficeNum();
    }
    @GetMapping("roomDetail")
    public String roomDetail(String roomsNum, String officeNum, Model model) {
        roomDetailService.execute(roomsNum,officeNum,model);
        return "thymeleaf/room/roomDetail";
    }
    @GetMapping("roomUpdate")
    public String roomUpdate(String roomsNum, String officeNum, Model model) {
        roomDetailService.execute(roomsNum,officeNum,model);
        return "thymeleaf/room/roomUpdate";
    }
    @PostMapping("roomUpdate")
    public String roomUpdate(RoomCommand roomCommand) {
        roomUpdateService.execute(roomCommand);
        return "redirect:/room/roomDetail?roomsNum=" + roomCommand.getRoomsNum()+ "&officeNum=" + roomCommand.getOfficeNum();
    }
    @GetMapping("roomDelete")
    public String roomDelete(String roomsNum, String officeNum, Model model) {
        roomDeleteService.execute(roomsNum, officeNum);
        model.addAttribute("roomsNum", roomsNum);
        model.addAttribute("officeNum", officeNum);
        return "redirect:/office/officeDetail/" + officeNum;
    }
}
