package org.example.binary;

import java.util.Objects;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree(){
        this.root= null;
    }
    public void insert(int value){
        root= insertRec(root, value);
    }
    public TreeNode insertRec(TreeNode node, int value){
        if(Objects.isNull(this.root)){
            this.root= new TreeNode(value);
            return root;
        }
        return root;
    }
}
