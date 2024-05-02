package wokrspacewiz.workspacewiz.service.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.command.EmployeeCommand;
import wokrspacewiz.workspacewiz.domain.EmployeeDTO;
import wokrspacewiz.workspacewiz.mapper.AutoNumMapper;
import wokrspacewiz.workspacewiz.mapper.EmployeeMapper;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeInsertService {

    private final AutoNumMapper autoNumMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeMapper employeeMapper;

    public void execute(EmployeeCommand employeeCommand) {
        Map<String, String> map = new HashMap<>();
        map.put("tableName", "employees");
        map.put("columnName", "emp_num");
        map.put("sep", "emp");
        String empNum = autoNumMapper.autoNumSelect(map);
        String newPw = passwordEncoder.encode(employeeCommand.getEmpPw());

        EmployeeDTO dto = EmployeeDTO.builder()
                .empId(employeeCommand.getEmpId())
                .empPw(newPw)
                .empName(employeeCommand.getEmpName())
                .empPost(employeeCommand.getEmpPost())
                .empPhone(employeeCommand.getEmpPhone())
                .empEmail(employeeCommand.getEmpEmail())
                .empAddr(employeeCommand.getEmpAddr())
                .empJumin(employeeCommand.getEmpJumin())
                .empAddrDetail(employeeCommand.getEmpAddrDetail())
                .empNum(empNum)
                .build();
        employeeMapper.employeeInsert(dto);
    }
}
