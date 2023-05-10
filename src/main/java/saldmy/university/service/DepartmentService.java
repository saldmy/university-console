package saldmy.university.service;

import org.springframework.stereotype.Service;
import saldmy.university.entity.Degree;
import saldmy.university.entity.Department;
import saldmy.university.entity.Lector;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface DepartmentService {

    Optional<Lector> getDepartmentHead(String departmentName);

    Optional<Map<Degree, Long>> getDepartmentStatistics(String departmentName);

    Optional<Integer> getAverageSalary(String departmentName);

    Optional<Long> getEmployeeCount(String departmentName);

    List<Department> searchByTemplate(String templateName);

}
