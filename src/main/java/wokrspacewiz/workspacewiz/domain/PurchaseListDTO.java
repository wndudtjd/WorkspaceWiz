package wokrspacewiz.workspacewiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("purchaseList")
public class PurchaseListDTO {
    private String roomsNum;
    private String purchaseNum;
    private String officeNum;
    private Integer purchaseQty;
    private Integer totalPrice;
    private Date reservationStartDate;
    private Date reservationEndDate;
}
