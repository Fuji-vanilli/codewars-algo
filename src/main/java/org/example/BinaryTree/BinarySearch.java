package org.example.BinaryTree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor @NoArgsConstructor
public class BinarySearch {
    private Node root;

    public void add(String key, Page page) {
        if (Objects.isNull(root)) {
            this.root= new Node(key, page);
        } else {
            Node newNode= new Node(key, page);
            insert(this.root, newNode);
        }
    }

    private void insert(Node parent, Node newNode) {
        if (newNode.getKeyWord().compareTo(parent.getKeyWord())< 0) {
            if (Objects.isNull(parent.getLeft())) {
                parent.setLeft(newNode);
            } else {
                insert(parent.getLeft(), newNode);
            }
        } else {
            if (newNode.getKeyWord().compareTo(parent.getKeyWord())> 0) {
                if (Objects.isNull(parent.getRight())) {
                    parent.setRight(newNode);
                } else {
                    insert(parent.getRight(), newNode);
                }
            }
        }
    }

    public Node search(String keyword) {
        return search(root, keyword);
    }

    private Node search(Node node, String keyword) {
        if (node.getKeyWord().equals(keyword)) {
            return node;
        } else {
            if (node.getKeyWord().compareTo(keyword)< 0) {
                return search(node.getLeft(), keyword);
            } else if (node.getKeyWord().compareTo(keyword)> 0) {
                return search(node.getRight(), keyword);
            }
        }
        return null;
    }
}
