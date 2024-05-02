package wokrspacewiz.workspacewiz.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleCommand {
    String nYear;
    String nMonth;
    String nDay;
    String action;
    String scheduleSubject;
    String scheduleContent;
}
