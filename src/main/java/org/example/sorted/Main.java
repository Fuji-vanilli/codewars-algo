package org.example.sorted;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1= new Book("java core 1st edition", 751, "Steven Agarthe", 87.5);
        Book book2= new Book("La décade prodigieuse", 357, "Ellery Queen", 17.3);
        Book book3= new Book("Data structure and Algorithms in java 6th edition", 789, "Tamasso", 98.2);
        Book book4= new Book("C++ advanced", 584, "Mickael Shanon", 92.1);
        Book book6= new Book("C++ advanced", 487, "Mickael Shanon", 92.1);
        Book book5= new Book("Philosophie antique", 251, "Armando Steve", 24.2);

        List<Book> bookList= List.of(book1, book2, book3, book4, book6, book5);

        Comparator<Book> compareByTitle= (b1, b2)-> b1.getTitle().compareToIgnoreCase(b2.getTitle());
        Comparator<Book> compareByPage= (b1, b2)-> b1.getPages().compareTo(b2.getPages());
        Comparator<Book> compareByCost= (b1, b2)-> b1.getCost().compareTo(b2.getCost());
        Comparator<Book> compareByAuthor= (b1, b2)-> b1.getAuthor().compareToIgnoreCase(b2.getAuthor());

        bookList.stream()
                .sorted(compareByTitle
                                .thenComparing(compareByPage)
                                .thenComparing(compareByCost)
                                .thenComparing(compareByAuthor))
                .forEach(book-> System.out.println(book.toString()));
    }
}
