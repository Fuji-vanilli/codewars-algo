package org.example.mergeTwoBinary;

import java.util.Objects;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (Objects.isNull(t1))
            return t2;
        if (Objects.isNull(t2))
            return t1;

        t1.value+= t2.value;

        t1.left= mergeTrees(t1.left, t2.left);
        t1.right= mergeTrees(t1.right, t2.right);

        return t1;
    }
}
