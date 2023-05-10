package saldmy.university.entity.aggregation;

import saldmy.university.entity.Degree;

import java.util.Objects;

public class DegreeCount {

    private Degree degree;
    private Long count;

    public DegreeCount() {}

    public DegreeCount(Degree degree, Long count) {
        this.degree = degree;
        this.count = count;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DegreeCount that)) return false;

        if (degree != that.degree) return false;
        return Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        int result = degree != null ? degree.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DegreeCount{" +
                "degree=" + degree +
                ", count=" + count +
                '}';
    }

}
