package wokrspacewiz.workspacewiz.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseCommand {
    private Integer totalPaymentPrice;
    private String purchaseName;
    private String roomsNum;
    private String officeNum;
    private String reservationName;
    private String reservationPhone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reservationStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reservationEndDate;
    private Integer days;
}
