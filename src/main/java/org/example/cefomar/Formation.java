package org.example.cefomar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Formation {
    private String name;
    private String ref;
    private Integer duration;
    private Long coast;
    private List<Student> students= new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formation formation)) return false;
        return Objects.equals(name, formation.name) && Objects.equals(ref, formation.ref) && Objects.equals(duration, formation.duration) && Objects.equals(coast, formation.coast) && Objects.equals(students, formation.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ref, duration, coast, students);
    }

}
