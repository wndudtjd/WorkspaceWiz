package wokrspacewiz.workspacewiz.service.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.command.ScheduleCommand;
import wokrspacewiz.workspacewiz.domain.PurchaseListDTO;
import wokrspacewiz.workspacewiz.mapper.PurchaseMapper;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DateService {

    private final PurchaseMapper purchaseMapper;

    public void execute(ScheduleCommand scheduleCommand, Model model, String roomsNum, String officeNum) {
        String nYear = scheduleCommand.getNYear();
        String nMonth = scheduleCommand.getNMonth();
        String nDay = scheduleCommand.getNDay();
        String action = scheduleCommand.getAction(); // 현재달, 이전달, 다음달
        Calendar cal = Calendar.getInstance();

        if(action == null) {
            //삼각형 버튼을 누르지 않고 맨 처음 페이지를 열었을 때
            cal.set(cal.get(Calendar.YEAR),  cal.get(Calendar.MONTH), 1);
        }else if(action.equals("previous")){
            cal.set(Integer.parseInt(nYear), Integer.parseInt(nMonth)-2, 1);
        }else if(action.equals("next")){
            cal.set(Integer.parseInt(nYear), Integer.parseInt(nMonth), 1);
        }
        if(nDay != null) {
            cal.set(Integer.parseInt(nYear), Integer.parseInt(nMonth)-1, 1);
        }
        nYear = String.valueOf(cal.get(Calendar.YEAR));
        nMonth = String.valueOf(cal.get(Calendar.MONTH)+1);
        int dayNum = cal.get(Calendar.DAY_OF_WEEK) ; // 1일에 해당하는 요일
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당달의 마지막 날

        Map<String, String> map = new HashMap<>();
        map.put("roomsNum", roomsNum);
        map.put("officeNum", officeNum);
        List<PurchaseListDTO> list = purchaseMapper.purchaseListSelectList(map);
        List<Date> allDates = new ArrayList<>();
        int i = 0;
        for (PurchaseListDTO purchase : list) {
            List<Date> datesForPurchase = getDatesBetween(purchase.getReservationStartDate(), purchase.getReservationEndDate());
            allDates.addAll(datesForPurchase); // 모든 예약 날짜 추가
        }
        // System.out.println(" allDates : " + allDates);

        model.addAttribute("allDates", allDates);

        model.addAttribute("nYear", nYear);
        model.addAttribute("nMonth", nMonth);
        model.addAttribute("dayNum", dayNum);
        model.addAttribute("maxDay", maxDay);
    }

    private List<Date> getDatesBetween(Date startDate, Date endDate) {
        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        while (calendar.getTime().before(endDate)) {
            Date result = calendar.getTime();
            datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        datesInRange.add(endDate);  // endDate를 포함시키기 위해 추가
        return datesInRange;
    }
}
