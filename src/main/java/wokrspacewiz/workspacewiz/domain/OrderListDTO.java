package wokrspacewiz.workspacewiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("orderList")
public class OrderListDTO {
    PurchaseDTO purchaseDTO;
    PaymentDTO paymentDTO;
    PurchaseListDTO purchaseListDTO;
    OfficeDTO officeDTO;
    RoomDTO roomDTO;
}
