package saldmy.university.command.impl;

import saldmy.university.command.AbstractDepartmentCommand;
import saldmy.university.service.DepartmentService;

public class HeadOfDepartmentCommand extends AbstractDepartmentCommand {

    private static final String ANSWER_TEMPLATE = "Head of %s department is %s %s.";

    public HeadOfDepartmentCommand(DepartmentService departmentService, String departmentName) {
        super(departmentService, departmentName);
    }

    @Override
    public String execute() {
        return departmentService.getDepartmentHead(departmentName)
                .map(lector -> ANSWER_TEMPLATE.formatted(departmentName, lector.getFirstname(), lector.getLastname()))
                .orElseGet(() -> DEPARTMENT_NOT_FOUND_TEMPLATE.formatted(departmentName));
    }

}
