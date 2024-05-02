package wokrspacewiz.workspacewiz.service.purchase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.domain.PurchaseDTO;
import wokrspacewiz.workspacewiz.domain.PurchaseListDTO;
import wokrspacewiz.workspacewiz.mapper.PurchaseMapper;

@Service
@RequiredArgsConstructor
public class ReservationCheckService {

    private final PurchaseMapper purchaseMapper;

    public int execute(String purchaseNum) {
        PurchaseListDTO dto = purchaseMapper.purchaseListSelectOne(purchaseNum);
        int i = purchaseMapper.reservationCheckSelect(dto); // 있을때 : null, 없을때 : 1
        return i;
    }
}
