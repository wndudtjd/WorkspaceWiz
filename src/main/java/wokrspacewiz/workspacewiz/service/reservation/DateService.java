package wokrspacewiz.workspacewiz.service.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.command.ScheduleCommand;

import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class DateService {
    public void execute(ScheduleCommand scheduleCommand, Model model) {
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
        model.addAttribute("nYear", nYear);
        model.addAttribute("nMonth", nMonth);
        model.addAttribute("dayNum", dayNum);
        model.addAttribute("maxDay", maxDay);
    }
}
