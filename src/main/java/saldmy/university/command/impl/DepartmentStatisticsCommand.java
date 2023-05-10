package saldmy.university.command.impl;

import saldmy.university.command.AbstractDepartmentCommand;
import saldmy.university.entity.Degree;
import saldmy.university.service.DepartmentService;

public class DepartmentStatisticsCommand extends AbstractDepartmentCommand {

    private static final String ANSWER_TEMPLATE = """
            Assistants - %d;
            Associate professors - %d;
            Professors - %d;""";

    public DepartmentStatisticsCommand(DepartmentService departmentService, String departmentName) {
        super(departmentService, departmentName);
    }

    @Override
    public String execute() {
        return departmentService.getDepartmentStatistics(departmentName)
                .map(degreeCountMap -> ANSWER_TEMPLATE.formatted(
                        degreeCountMap.getOrDefault(Degree.ASSISTANT, 0L),
                        degreeCountMap.getOrDefault(Degree.ASSOCIATE_PROFESSOR, 0L),
                        degreeCountMap.getOrDefault(Degree.PROFESSOR, 0L)))
                .orElseGet(() -> DEPARTMENT_NOT_FOUND_TEMPLATE.formatted(departmentName));
    }

}
