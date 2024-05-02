package wokrspacewiz.workspacewiz.service.office;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.domain.OfficeDTO;
import wokrspacewiz.workspacewiz.mapper.OfficeMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficeListService {

    private final OfficeMapper officeMapper;

    public void execute(Model model) {
        List<OfficeDTO> list = officeMapper.officeSelectList();
        model.addAttribute("list", list);
    }
}
