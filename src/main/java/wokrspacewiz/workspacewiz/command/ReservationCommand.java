package wokrspacewiz.workspacewiz.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationCommand {
    private String roomsNum;
    private String officeNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reservationStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reservationEndDate;
}
