package wokrspacewiz.workspacewiz.service.purchase;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;
import wokrspacewiz.workspacewiz.domain.MemberDTO;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;
import wokrspacewiz.workspacewiz.mapper.PurchaseMapper;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentDeleteService {

    private final MemberMapper memberMapper;
    private final PurchaseMapper purchaseMapper;

    public void execute(String purchaseNum, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserNum());
        Map<String, String> map = new HashMap<>();
        map.put("purchaseNum", purchaseNum);
        map.put("memberNum", memDto.getMemberNum());
        purchaseMapper.purchaseDelete(map);
    }
}
