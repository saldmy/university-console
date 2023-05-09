package saldmy.university.command.impl;

import saldmy.university.command.AbstractDepartmentCommand;
import saldmy.university.service.DepartmentService;

public class EmployeeCountCommand extends AbstractDepartmentCommand {

    public EmployeeCountCommand(DepartmentService departmentService, String departmentName) {
        super(departmentService, departmentName);
    }

    @Override
    public String execute() {
        return departmentService.getEmployeeCount(departmentName)
                .map(String::valueOf)
                .orElseGet(() -> DEPARTMENT_NOT_FOUND_TEMPLATE.formatted(departmentName));
    }

}
