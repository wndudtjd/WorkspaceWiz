package wokrspacewiz.workspacewiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("payment")
public class PaymentDTO {
    private String purchaseNum;
    private String confirmnumber;
    private String cardnum;
    private String tid;
    private String totalprice;
    private String resultmessage;
    private String paymethod;
    private String appldate;
    private String appltime;
    private String purchasename;
}
