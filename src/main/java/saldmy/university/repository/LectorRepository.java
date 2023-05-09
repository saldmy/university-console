package saldmy.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import saldmy.university.entity.Lector;

import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Query ("select l " +
            "from Lector l " +
            "where lower(l.firstname) like lower(:template) " +
            "   or lower(l.lastname) like lower(:template) " +
            "order by l.firstname, l.lastname ")
    List<Lector> findByTemplate(String template);

}
