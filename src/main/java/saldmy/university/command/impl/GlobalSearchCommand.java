package saldmy.university.command.impl;

import saldmy.university.command.Command;
import saldmy.university.entity.Department;
import saldmy.university.entity.Lector;
import saldmy.university.service.DepartmentService;
import saldmy.university.service.LectorService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GlobalSearchCommand implements Command {

    private static final String NOTHING_FOUND = "Unfortunately, nothing was found with '%s'.";

    private final LectorService lectorService;
    private final DepartmentService departmentService;
    private final String template;

    public GlobalSearchCommand(LectorService lectorService, DepartmentService departmentService, String template) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
        this.template = template;
    }

    @Override
    public String execute() {
        List<Lector> lectors = lectorService.findByTemplate(template);
        List<Department> departments = departmentService.searchByTemplate(template);

        String result =  Stream.concat(
                lectors.stream().map(lector -> lector.getFirstname() + " " + lector.getLastname()),
                departments.stream().map(Department::getName)
        ).collect(Collectors.joining(", "));

        return !result.isEmpty() ? result : NOTHING_FOUND.formatted(template);
    }

    @Override
    public String toString() {
        return "GlobalSearchCommand{" +
                "lectorService=" + lectorService +
                ", departmentService=" + departmentService +
                ", template='" + template + '\'' +
                '}';
    }

}
