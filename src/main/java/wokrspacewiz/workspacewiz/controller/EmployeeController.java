package wokrspacewiz.workspacewiz.controller;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wokrspacewiz.workspacewiz.command.EmployeeCommand;
import wokrspacewiz.workspacewiz.service.employee.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeInsertService employeeInsertService;
    private final EmployeeListService employeeListService;
    private final EmployeeDetailService employeeDetailService;
    private final EmployeeUpdateService employeeUpdateService;
    private final EmployeeDeleteService employeeDeleteService;

    @GetMapping("employeeList")
    public String employeeList(Model model) {
        employeeListService.execute(model);
        return "thymeleaf/employee/employeeList";
    }
    @GetMapping("employeeRegist")
    public String employeeRegist(Model model) {
        return "thymeleaf/employee/employeeRegist";
    }
    @PostMapping("employeeRegist")
    public String employeeRegist(EmployeeCommand employeeCommand, Model model) {
        employeeInsertService.execute(employeeCommand);
        return "redirect:/employee/employeeList";
    }
    @GetMapping("employeeDetail/{empNum}")
    public String employeeDetail(@PathVariable String empNum, Model model) {
        employeeDetailService.execute(empNum, model);
        return "thymeleaf/employee/employeeDetail";
    }
    @GetMapping("employeeDetail/employeeUpdate")
    public String employeeUpdate(String empNum,Model model) {
        employeeDetailService.execute(empNum, model);
        return "thymeleaf/employee/employeeUpdate";
    }
    @PostMapping("employeeDetail/employeeUpdate")
    public String employeeUpdate(EmployeeCommand employeeCommand) {
        employeeUpdateService.execute(employeeCommand);
        return "redirect:/employee/employeeList";
    }
    @GetMapping("employeeDetail/employeeDelete")
    public String employeeDelete(String empNum, Model model) {
        employeeDeleteService.execute(empNum);
        return "redirect:/employee/employeeList";
    }
}
