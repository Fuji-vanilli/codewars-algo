package org.example.kyu5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FilesInputManipulate {
    public static void main(String[] args) {
        try(FileInputStream fis= new FileInputStream("D:/files/people.bin");
            PersonInputStream pis= new PersonInputStream(fis);) {
                        pis.readFields().forEach(person -> {
                System.out.println("name: "+person.getName()+" - age: "+person.getAge()+" - city: "+person.getCity());
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
