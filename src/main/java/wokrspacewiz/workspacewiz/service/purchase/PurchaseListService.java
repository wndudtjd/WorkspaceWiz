package wokrspacewiz.workspacewiz.service.purchase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.domain.OrderListDTO;
import wokrspacewiz.workspacewiz.mapper.PurchaseMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseListService {
    private final PurchaseMapper purchaseMapper;
    public void execute(Model model) {
        List<OrderListDTO> list = purchaseMapper.orderList(null);
        model.addAttribute("list", list);
    }
}
