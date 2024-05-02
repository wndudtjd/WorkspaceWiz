package wokrspacewiz.workspacewiz.service.purchase;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;
import wokrspacewiz.workspacewiz.domain.MemberDTO;
import wokrspacewiz.workspacewiz.domain.OrderListDTO;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;
import wokrspacewiz.workspacewiz.mapper.PurchaseMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderProcessListService {

    private final MemberMapper memberMapper;
    private final PurchaseMapper purchaseMapper;

    public void execute(Model model, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
        MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserNum());
        List<OrderListDTO> list = purchaseMapper.orderList(memDto.getMemberNum());
        model.addAttribute("list", list);
    }
}
