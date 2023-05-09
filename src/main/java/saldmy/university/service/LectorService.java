package saldmy.university.service;

import org.springframework.stereotype.Service;
import saldmy.university.entity.Lector;

import java.util.List;

@Service
public interface LectorService {

    List<Lector> findByTemplate(String template);

}
