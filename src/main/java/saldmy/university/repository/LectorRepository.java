package saldmy.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saldmy.university.entity.Lector;

import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Long> {

    List<Lector> findAllByFirstNameOrLastnameContaining(String template);

}
