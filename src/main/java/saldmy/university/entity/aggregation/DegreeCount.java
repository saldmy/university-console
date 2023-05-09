package saldmy.university.entity.aggregation;

import org.springframework.stereotype.Component;
import saldmy.university.entity.Degree;

@Component
public interface DegreeCount {

    Degree getDegree();

    Long getDegreeCount();

}
