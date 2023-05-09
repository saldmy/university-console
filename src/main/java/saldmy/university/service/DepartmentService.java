package saldmy.university.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saldmy.university.entity.Department;
import saldmy.university.entity.Lector;
import saldmy.university.entity.aggregation.DegreeCount;
import saldmy.university.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Optional<Lector> getDepartmentHead(String departmentName) {
        return repository.findHeadByName(departmentName);
    }

    public List<DegreeCount> getDepartmentStatistics(String departmentName) {
        return repository.showDegreeCount(departmentName);
    }

    public Optional<Integer> getAverageSalary(String departmentName) {
        return repository.getAvgSalary(departmentName);
    }

    public Optional<Integer> getEmployeeCount(String departmentName) {
        return repository.getEmployeeCount(departmentName);
    }

    public List<Department> searchByTemplate(String templateName) {
        return repository.findAllByNameContaining(templateName);
    }

}
