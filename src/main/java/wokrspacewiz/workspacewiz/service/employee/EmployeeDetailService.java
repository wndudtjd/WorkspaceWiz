package wokrspacewiz.workspacewiz.service.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.domain.EmployeeDTO;
import wokrspacewiz.workspacewiz.mapper.EmployeeMapper;

@Service
@RequiredArgsConstructor
public class EmployeeDetailService {

    private final EmployeeMapper employeeMapper;

    public void execute(String empNum, Model model) {
        EmployeeDTO dto = employeeMapper.employeeSelectOne(empNum);
        model.addAttribute("employeeCommand", dto);
    }
}
