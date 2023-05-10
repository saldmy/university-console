package saldmy.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import saldmy.university.entity.Department;
import saldmy.university.entity.Lector;
import saldmy.university.entity.aggregation.DegreeCount;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    boolean existsByNameIgnoreCase(String name);

    List<Department> findAllByNameContainingIgnoreCase(String name);

    @Query( "select d.head " +
            "from Department d " +
            "where lower(d.name) = lower(:name) ")
    Optional<Lector> findHeadByName(String name);

    @Query( "select new saldmy.university.entity.aggregation.DegreeCount(l.degree, count(l.degree)) " +
            "from LectorDepartment ld " +
            "join ld.lector l " +
            "join ld.department d " +
            "where lower(d.name) = lower(:name) " +
            "group by l.degree ")
    List<DegreeCount> showDegreeCount(String name);

    @Query( "select avg(ld.lector.salary) " +
            "from LectorDepartment ld " +
            "where lower(ld.department.name) = lower(:name) ")
    Optional<Integer> getAvgSalary(String name);

    @Query( "select count(ld) " +
            "from LectorDepartment ld " +
            "where lower(ld.department.name) = lower(:name) ")
    Optional<Long> getEmployeeCount(String name);

}
