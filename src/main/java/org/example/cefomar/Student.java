package org.example.cefomar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Student {
    private String name;
    private Date dateOfBirth;
    private String number;
    private String formation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(name, student.name) && Objects.equals(dateOfBirth, student.dateOfBirth) && Objects.equals(number, student.number) && Objects.equals(formation, student.formation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, number, formation);
    }
}
