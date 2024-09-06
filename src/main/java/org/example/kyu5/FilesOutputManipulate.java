package org.example.kyu5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FilesOutputManipulate {
    public static void main(String[] args) {

        List<Person> peoples= List.of(
                new Person("Christopher Nolan", "California", 54),
                new Person("Steven Spielberg", "Denver", 54),
                new Person("James Cameroun", "New York", 54),
                new Person("Michael Bay", "Las Vegas", 54)
        );

        try(FileOutputStream fos= new FileOutputStream("D:/files/people.bin");
            PersonOutPutStream pos= new PersonOutPutStream(fos);){

            pos.writeFields(peoples);
        }catch (IOException e){
            throw new RuntimeException("error to write in the file..!");
        }
        System.out.println("Done!");
    }
}
