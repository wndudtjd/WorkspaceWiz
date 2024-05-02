package wokrspacewiz.workspacewiz.service.purchase;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.command.ReservationCommand;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;
import wokrspacewiz.workspacewiz.domain.MemberDTO;
import wokrspacewiz.workspacewiz.domain.OfficeDTO;
import wokrspacewiz.workspacewiz.domain.RoomDTO;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;
import wokrspacewiz.workspacewiz.mapper.OfficeMapper;
import wokrspacewiz.workspacewiz.mapper.RoomMapper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@RequiredArgsConstructor
public class RoomsBuyService {

    private final MemberMapper memberMapper;
    private final RoomMapper roomMapper;
    private final OfficeMapper officeMapper;

    public void execute(ReservationCommand reservationCommand, HttpSession session, Model model) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserNum());

        Map<String, String> rmap = new HashMap<>();
        rmap.put("roomsNum", reservationCommand.getRoomsNum());
        rmap.put("officeNum", reservationCommand.getOfficeNum());
        RoomDTO roomDto = roomMapper.roomSelectOne(rmap);

        OfficeDTO officeDto = officeMapper.officeSelectOne(reservationCommand.getOfficeNum());

        LocalDate startDate = reservationCommand.getReservationStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = reservationCommand.getReservationEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Long days = DAYS.between(startDate, endDate);
        System.out.println("days: " + days);
        Integer sumPrice = 0;
        sumPrice += days.intValue() * roomDto.getRoomsPrice();
        System.out.println("sumPrice: " + sumPrice);

        model.addAttribute("sumPrice", sumPrice);
        model.addAttribute("days", days);
        model.addAttribute("officeCommand", officeDto);
        model.addAttribute("roomCommand", roomDto);
        model.addAttribute("memberCommand", memDto);
        model.addAttribute("reservationCommand", reservationCommand);
    }
}
