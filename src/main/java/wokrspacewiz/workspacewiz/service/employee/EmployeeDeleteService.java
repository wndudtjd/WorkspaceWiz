package wokrspacewiz.workspacewiz.service.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.mapper.EmployeeMapper;

@Service
@RequiredArgsConstructor
public class EmployeeDeleteService {

    private final EmployeeMapper employeeMapper;

    public void execute(String empNum) {
        employeeMapper.employeeDelete(empNum);
    }
}
