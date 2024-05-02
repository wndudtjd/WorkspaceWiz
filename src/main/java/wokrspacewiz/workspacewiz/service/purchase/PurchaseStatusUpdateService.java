package wokrspacewiz.workspacewiz.service.purchase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.domain.PurchaseDTO;
import wokrspacewiz.workspacewiz.mapper.PurchaseMapper;

@Service
@RequiredArgsConstructor
public class PurchaseStatusUpdateService {

    private final PurchaseMapper purchaseMapper;

    public void execute(String purchaseNum) {
        PurchaseDTO dto = new PurchaseDTO();
        dto.setPurchaseNum(purchaseNum);
        dto.setPurchaseStatus("예약확정");
        purchaseMapper.purchaseStatusUpdate(dto);
    }
}
