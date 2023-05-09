package saldmy.university.command.impl;

import saldmy.university.command.AbstractDepartmentCommand;
import saldmy.university.service.DepartmentService;

public class AverageSalaryCommand extends AbstractDepartmentCommand {

    private static final String ANSWER_TEMPLATE = "The average salary of %s is %d.";

    public AverageSalaryCommand(DepartmentService departmentService, String departmentName) {
        super(departmentService, departmentName);
    }

    @Override
    public String execute() {
        return departmentService.getAverageSalary(departmentName)
                .map(salary -> ANSWER_TEMPLATE.formatted(departmentName, salary))
                .orElseGet(() -> DEPARTMENT_NOT_FOUND_TEMPLATE.formatted(departmentName));
    }

}
