package saldmy.university.command;

import saldmy.university.service.DepartmentService;

public abstract class AbstractDepartmentCommand implements Command {

    protected static final String DEPARTMENT_NOT_FOUND_TEMPLATE = "Department with name %s does not exist.";

    protected final DepartmentService departmentService;
    protected final String departmentName;

    protected AbstractDepartmentCommand(DepartmentService departmentService, String departmentName) {
        this.departmentService = departmentService;
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "service=" + departmentService +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

}
