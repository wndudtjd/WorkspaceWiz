package wokrspacewiz.workspacewiz.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wokrspacewiz.workspacewiz.command.PurchaseCommand;
import wokrspacewiz.workspacewiz.command.ReservationCommand;
import wokrspacewiz.workspacewiz.command.ScheduleCommand;
import wokrspacewiz.workspacewiz.service.IniPayReqService;
import wokrspacewiz.workspacewiz.service.purchase.*;
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
    private final PaymentDeleteService paymentDeleteService;
    private final PurchaseListService purchaseListService;
    private final PurchaseStatusUpdateService purchaseStatusUpdateService;
    private final ReservationCheckService reservationCheckService;

    @GetMapping("reservation")
    public String reservation(ScheduleCommand scheduleCommand, String roomsNum, String officeNum, Model model) {
        dateService.execute(scheduleCommand, model, roomsNum, officeNum);
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
        return "redirect:paymentOk?purchaseNum=" + purchaseNum + "&roomsNum=" + purchaseCommand.getRoomsNum();
    }
    @GetMapping("paymentOk")
    public String paymentOk(String purchaseNum, Model model, HttpSession session) throws Exception {
        int i = reservationCheckService.execute(purchaseNum);
        if(i > 0) { // 예약 불가 처리
            paymentDeleteService.execute(purchaseNum, session);
            return "thymeleaf/purchase/reorder";
        }else { // 예약 가능 처리
            iniPayReqService.execute(purchaseNum, model, session);
            return "thymeleaf/purchase/payment";
        }
    }
    @PostMapping("INIstdpay_pc_return")
    public String INIstdpayPcReturn(HttpServletRequest request) {
        iniPayReturnService.execute(request);
        return "thymeleaf/purchase/buyfinished";
    }
    @GetMapping("orderList")
    public String orderList(Model model, HttpSession session) {
        orderProcessListService.execute(model, session);
        return "thymeleaf/purchase/orderList";
    }
    @GetMapping("paymentDel")
    public String paymentDel(String purchaseNum, Model model, HttpSession session) {
        paymentDeleteService.execute(purchaseNum, session);
        return "redirect:orderList";
    }
    @GetMapping("purchaseList")
    public String purchaseList(Model model) {
        purchaseListService.execute(model);
        return "thymeleaf/purchase/purchaseList";
    }
    @GetMapping("purchaseStatus")
    public String purchaseStatus(String purchaseNum, Model model) {
        purchaseStatusUpdateService.execute(purchaseNum);
        return "redirect:purchaseList";
    }
}
