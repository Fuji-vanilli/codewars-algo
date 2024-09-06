package org.example.BinaryTree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Node {
    private String keyWord;
    private List<Page> pages= new ArrayList<>();
    private Node left;
    private Node right;

    public Node(String keyWord, Page page) {
        this.keyWord= keyWord;
        this.pages.add(page);

    }
}
