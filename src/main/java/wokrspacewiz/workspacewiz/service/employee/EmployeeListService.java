package wokrspacewiz.workspacewiz.service.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.domain.EmployeeDTO;
import wokrspacewiz.workspacewiz.mapper.EmployeeMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeListService {

    private final EmployeeMapper employeeMapper;

    public void execute(Model model) {
        List<EmployeeDTO> list = employeeMapper.employeeSelectList();
        model.addAttribute("list", list);
    }
}
