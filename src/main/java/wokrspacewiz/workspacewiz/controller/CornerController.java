package wokrspacewiz.workspacewiz.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wokrspacewiz.workspacewiz.command.PurchaseCommand;
import wokrspacewiz.workspacewiz.command.ReservationCommand;
import wokrspacewiz.workspacewiz.command.ScheduleCommand;
import wokrspacewiz.workspacewiz.service.IniPayReqService;
import wokrspacewiz.workspacewiz.service.purchase.IniPayReturnService;
import wokrspacewiz.workspacewiz.service.purchase.OrderProcessListService;
import wokrspacewiz.workspacewiz.service.purchase.RoomsBuyService;
import wokrspacewiz.workspacewiz.service.purchase.RoomsOrderService;
import wokrspacewiz.workspacewiz.service.reservation.DateService;

@Controller
@RequiredArgsConstructor
@RequestMapping("corner")
public class CornerController {

    private final DateService dateService;
    private final RoomsBuyService roomsBuyService;
    private final RoomsOrderService roomsOrderService;
    private final IniPayReqService iniPayReqService;
    private final IniPayReturnService iniPayReturnService;
    private final OrderProcessListService orderProcessListService;

    @GetMapping("reservation")
    public String reservation(ScheduleCommand scheduleCommand,String roomsNum, String officeNum, Model model) {
        dateService.execute(scheduleCommand,model);
        model.addAttribute("roomsNum", roomsNum);
        model.addAttribute("officeNum", officeNum);
        return "thymeleaf/corner/reservation";
    }
    @PostMapping("reservation")
    public String reservation(ReservationCommand reservationCommand, Model model, HttpSession session) {
        roomsBuyService.execute(reservationCommand, session, model);
        return "thymeleaf/purchase/roomsOrder";
    }
    @PostMapping("roomsOrder")
    public String roomsOrder(PurchaseCommand purchaseCommand, HttpSession session) {
        String purchaseNum = roomsOrderService.execute(purchaseCommand, session);
        return "redirect:paymentOk?purchaseNum=" + purchaseNum;
    }
    @GetMapping("paymentOk")
    public String paymentOk(String purchaseNum, Model model, HttpSession session) throws Exception {
        iniPayReqService.execute(purchaseNum, model, session);
        return "thymeleaf/purchase/payment";
    }
    @GetMapping("INIstdpay_pc_return")
    public String INIstdpayPcReturn(HttpServletRequest request) {
        iniPayReturnService.execute(request);
        return "thyemleaf/purchase/buyfinished";
    }
    @GetMapping("orderList")
    public String orderList(Model model, HttpSession session) {
        orderProcessListService.execute(model, session);
        return "thymeleaf/purchase/orderList";
    }
}
