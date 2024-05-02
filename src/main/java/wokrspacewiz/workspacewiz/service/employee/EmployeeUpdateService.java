package wokrspacewiz.workspacewiz.service.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.command.EmployeeCommand;
import wokrspacewiz.workspacewiz.domain.EmployeeDTO;
import wokrspacewiz.workspacewiz.mapper.EmployeeMapper;

@Service
@RequiredArgsConstructor
public class EmployeeUpdateService {

    private final EmployeeMapper employeeMapper;

    public void execute(EmployeeCommand employeeCommand) {
        EmployeeDTO dto = new EmployeeDTO();
        BeanUtils.copyProperties(employeeCommand, dto);
        employeeMapper.employeeUpdate(dto);
    }
}
