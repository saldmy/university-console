package saldmy.university.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saldmy.university.entity.Degree;
import saldmy.university.entity.Department;
import saldmy.university.entity.Lector;
import saldmy.university.entity.aggregation.DegreeCount;
import saldmy.university.repository.DepartmentRepository;

import java.util.*;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toUnmodifiableMap;

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements saldmy.university.service.DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Lector> getDepartmentHead(String departmentName) {
        return repository.findHeadByName(departmentName);
    }

    @Override
    public Optional<Map<Degree, Integer>> getDepartmentStatistics(String departmentName) {
        if (!repository.existsByNameIgnoreCase(departmentName)) {
            return Optional.empty();
        }

        List<DegreeCount> degreeCounts = repository.showDegreeCount(departmentName);

//        return departmentStatistics.stream()
//                .collect(toMap(
//                        DegreeCount::getDegree,
//                        DegreeCount::getDegreeCount,
//                        Long::sum));
        System.out.println(degreeCounts);
        System.out.println(degreeCounts.get(0).getDegree());


        return Optional.of(new HashMap<>());
    }

    @Override
    public Optional<Integer> getAverageSalary(String departmentName) {
        return repository.getAvgSalary(departmentName);
    }

    @Override
    public Optional<Long> getEmployeeCount(String departmentName) {
        return repository.getEmployeeCount(departmentName);
    }

    @Override
    public List<Department> searchByTemplate(String templateName) {
        return repository.findAllByNameContainingIgnoreCase(templateName);
    }

}
