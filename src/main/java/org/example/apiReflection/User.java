package org.example.apiReflection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {
    public String name;
    public int age;
    private double size;

    public User(String n, int a){
        this.name= n;
        this.age= a;
    }
}
