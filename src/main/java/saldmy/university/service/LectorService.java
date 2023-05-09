package saldmy.university.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saldmy.university.entity.Lector;
import saldmy.university.repository.LectorRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LectorService {

    private final LectorRepository repository;

    public LectorService(LectorRepository repository) {
        this.repository = repository;
    }

    List<Lector> findAllByTemplate(String template) {
        return repository.findAllByFirstNameOrLastnameContaining(template);
    }

}
