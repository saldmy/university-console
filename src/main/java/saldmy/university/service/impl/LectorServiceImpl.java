package saldmy.university.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saldmy.university.entity.Lector;
import saldmy.university.repository.LectorRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LectorServiceImpl implements saldmy.university.service.LectorService {

    private final LectorRepository repository;

    public LectorServiceImpl(LectorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Lector> findByTemplate(String template) {
        template = "%" + template + "%";
        return repository.findByTemplate(template);
    }

}
