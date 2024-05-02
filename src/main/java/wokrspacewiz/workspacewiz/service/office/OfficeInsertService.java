package wokrspacewiz.workspacewiz.service.office;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.command.OfficeCommand;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;
import wokrspacewiz.workspacewiz.domain.OfficeDTO;
import wokrspacewiz.workspacewiz.mapper.AutoNumMapper;
import wokrspacewiz.workspacewiz.mapper.OfficeMapper;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OfficeInsertService {

    private final OfficeMapper officeMapper;
    private final AutoNumMapper autoNumMapper;

    public void execute(OfficeCommand officeCommand, HttpSession session) {
        OfficeDTO dto = new OfficeDTO();
        BeanUtils.copyProperties(officeCommand, dto);
        AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");

        String empNum = auth.getUserNum();
        // System.out.println("@@@@@@@@@@@@@@ : " + dto.getOfficePost());
        dto.setEmpNum(empNum);

        Map<String, String> map = new HashMap<>();
        map.put("tableName", "office");
        map.put("columnName", "office_num");
        map.put("sep", "ofc");
        String officeNum = autoNumMapper.autoNumSelect(map);
        dto.setOfficeNum(officeNum);

        officeMapper.officeInsert(dto);
    }
}
