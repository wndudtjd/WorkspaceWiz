package wokrspacewiz.workspacewiz.mapper;

import org.apache.ibatis.annotations.Mapper;
import wokrspacewiz.workspacewiz.domain.EmployeeDTO;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    void employeeInsert(EmployeeDTO dto);

    List<EmployeeDTO> employeeSelectList();

    EmployeeDTO employeeSelectOne(String empNum);

    void employeeUpdate(EmployeeDTO dto);

    void employeeDelete(String empNum);
}
