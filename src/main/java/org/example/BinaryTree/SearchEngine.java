package org.example.BinaryTree;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class SearchEngine {
    private Node root;

    public SearchEngine() {
        this.root= null;
    }

    public void addPage(String keyword, Page page) {
        if (Objects.isNull(root)) {
            this.root= new Node(keyword, page);
        } else {
            addPage(root, keyword, page);
        }
    }

    private void addPage(Node node, String keyword, Page page) {
        if (keyword.compareTo(node.getKeyWord())< 0) {
            if (Objects.isNull(node.getLeft())) {
                node.setLeft(new Node(keyword, page));

            } else {
                addPage(node.getLeft(), keyword, page);
            }
        } else if (keyword.compareTo(node.getKeyWord())> 0) {
            if (Objects.isNull(node.getRight())) {
                node.setRight(new Node(keyword, page));
            } else {
                addPage(node.getRight(), keyword, page);
            }
        } else {
            node.getPages().add(page);
        }
    }

    public List<Page> search(String keyword) {
        List<Page> results= new ArrayList<>();
        search(this.root, keyword, results);

        return results;
    }

    private void search(Node node, String keyword, List<Page> results) {
        if (Objects.isNull(node)) {
            return;
        }
        if (keyword.compareTo(node.getKeyWord())== 0) {
            results.addAll(node.getPages());
        } else if (keyword.compareTo(node.getKeyWord())< 0) {
            search(node.getLeft(), keyword, results);
        } else {
            search(node.getRight(), keyword, results);
        }
    }

    public void deepFirst() {
        deepFirst(root);
    }

    private void deepFirst(Node node) {
        if (Objects.isNull(node ))
            return;
        System.out.println(node.getPages()+" ");
        deepFirst(node.getLeft());
        deepFirst(node.getRight());
    }
}
