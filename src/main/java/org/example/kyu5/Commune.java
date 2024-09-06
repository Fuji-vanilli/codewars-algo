package org.example.kyu5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commune {
    private String name;
    private String codePostal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commune commune)) return false;
        return name.equals(commune.name) && codePostal.equals(commune.codePostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, codePostal);
    }
}
