package org.example.sorted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@AllArgsConstructor
public class Book {
    private String title;
    private Integer pages;
    private String author;
    private Double cost;
}
