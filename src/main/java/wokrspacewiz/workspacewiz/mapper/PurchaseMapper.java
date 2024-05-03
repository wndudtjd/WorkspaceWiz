package wokrspacewiz.workspacewiz.mapper;

import org.apache.ibatis.annotations.Mapper;
import wokrspacewiz.workspacewiz.domain.OrderListDTO;
import wokrspacewiz.workspacewiz.domain.PaymentDTO;
import wokrspacewiz.workspacewiz.domain.PurchaseDTO;
import wokrspacewiz.workspacewiz.domain.PurchaseListDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface PurchaseMapper {
    void purchaseInsert(PurchaseDTO pDto);

    void purchaseListInsert(PurchaseListDTO plDto);

    PurchaseDTO purchaseSelect(String purchaseNum);

    int paymentInsert(PaymentDTO dto);

    void purchaseStatusUpdate(PurchaseDTO dpto);

    List<OrderListDTO> orderList(String memberNum);

    void purchaseDelete(Map<String, String> map);

    PurchaseListDTO purchaseListSelectOne(String purchaseNum);

    int reservationCheckSelect(PurchaseListDTO dto);

    List<PurchaseListDTO> purchaseListSelectList(Map<String, String> map);
}
