package saldmy.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import saldmy.university.entity.Department;
import saldmy.university.entity.Lector;
import saldmy.university.entity.aggregation.DegreeCount;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    List<Department> findAllByNameContaining(String name);

    @Query( "select d.head" +
            "from Department d" +
            "where d.name = :name")
    Optional<Lector> findHeadByName(String name);

    @Query( "select ld.lector.degree, count(ld.lector.degree) " +
            "from LectorDepartment ld " +
            "where ld.department.name = :name " +
            "group by ld.lector.degree")
    List<DegreeCount> showDegreeCount(String name);

    @Query( "select avg(ld.lector.salary)" +
            "from LectorDepartment ld" +
            "where ld.department.name = :name")
    Optional<Integer> getAvgSalary(String name);

    @Query( "select count(ld)" +
            "from LectorDepartment ld" +
            "where ld.department = :name")
    Optional<Integer> getEmployeeCount(String name);

}
