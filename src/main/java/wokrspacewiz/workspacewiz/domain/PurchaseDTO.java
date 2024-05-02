package wokrspacewiz.workspacewiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("purchase")
public class PurchaseDTO {
    private String purchaseNum;
    private String memberNum;
    private Date purchaseDate;
    private Integer purchasePrice;
    private String reservationName;
    private String reservationPhone;
    private String purchaseStatus;
    private String purchaseName;
}
