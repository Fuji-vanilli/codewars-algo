package org.example.kyu5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Person implements Serializable {
    private String name;
    private String city;
    private int age;
}
