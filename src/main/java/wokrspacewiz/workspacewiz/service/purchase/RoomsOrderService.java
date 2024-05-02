package wokrspacewiz.workspacewiz.service.purchase;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.command.PurchaseCommand;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;
import wokrspacewiz.workspacewiz.domain.MemberDTO;
import wokrspacewiz.workspacewiz.domain.PurchaseDTO;
import wokrspacewiz.workspacewiz.domain.PurchaseListDTO;
import wokrspacewiz.workspacewiz.mapper.AutoNumMapper;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;
import wokrspacewiz.workspacewiz.mapper.PurchaseMapper;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class RoomsOrderService {

    private final AutoNumMapper autoNumMapper;
    private final MemberMapper memberMapper;
    private final PurchaseMapper purchaseMapper;

    public String execute(PurchaseCommand purchaseCommand, HttpSession session) {
        Map<String, String> map = new HashMap<>();
        map.put("tableName", "purchase");
        map.put("columnName", "purchase_num");
        map.put("sep", "pur");
        String purchaseNum = autoNumMapper.autoNumSelect(map);

        AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
        MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserNum());

        PurchaseDTO pDto = new PurchaseDTO();
        BeanUtils.copyProperties(purchaseCommand, pDto);
        pDto.setPurchaseNum(purchaseNum);
        pDto.setPurchasePrice(purchaseCommand.getTotalPaymentPrice());
        pDto.setMemberNum(memDto.getMemberNum());
        pDto.setPurchaseStatus("입금대기중");
        purchaseMapper.purchaseInsert(pDto);

        PurchaseListDTO plDto = new PurchaseListDTO();
        BeanUtils.copyProperties(purchaseCommand, plDto);
        plDto.setPurchaseNum(purchaseNum);
        plDto.setPurchaseQty(purchaseCommand.getDays());
        plDto.setTotalPrice(purchaseCommand.getTotalPaymentPrice());
        purchaseMapper.purchaseListInsert(plDto);

        return purchaseNum;
    }
}
