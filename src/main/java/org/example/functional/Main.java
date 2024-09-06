package org.example.functional;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        MyBook book1= new MyBook("java core 1st edition", 751, "Steven Agarthe", 87.5);
        MyBook book7= new MyBook("java core 1st edition", 755, "Steven Agarthe", 87.5);
        MyBook book2= new MyBook("La décade prodigieuse", 357, "Ellery Queen", 17.3);
        MyBook book3= new MyBook("Data structure and Algorithms in java 6th edition", 789, "Tamasso", 98.2);
        MyBook book4= new MyBook("C++ advanced", 584, "Mickael Shanon", 92.1);
        MyBook book5= new MyBook("Philosophie antique", 251, "Armando Steve", 24.2);
        MyBook book6= new MyBook("C++ advanced", 487, "Mickael Shanon", 92.1);


        Function<MyBook, String> getTitle= MyBook::getTitle;
        Function<MyBook, String> getAuthor= MyBook::getAuthor;
        Function<MyBook, Integer> getPages= MyBook::getPages;

        List<MyBook> bookList= List.of(book1, book2, book3, book4, book5, book6, book7);



    }
}
