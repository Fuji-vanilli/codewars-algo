package org.example.kyu5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    private String name;
    private String codePostal;
    private List<Commune> communes= new ArrayList<>();

    public Departement(String name, String codePostal){
        this.name= name;
        this.codePostal= codePostal;
    }
    public void addCommune(Commune commune){
        communes.add(commune);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departement that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(codePostal, that.codePostal) && Objects.equals(communes, that.communes);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, codePostal, communes);
    }
    @Override
    public String toString() {
        return "Departement{" +
                "name='" + name + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", communes=" + communes +
                '}';
    }
}
