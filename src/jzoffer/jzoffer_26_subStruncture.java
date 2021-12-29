package jzoffer;

import tree.TreeNode;

public class jzoffer_26_subStruncture {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean dfs(TreeNode A, TreeNode B) {
        // 此处要先判断B是否为空，因为只要B为空，无论A是否空都已经完成匹配了
        if(B == null) return true;
        if(A == null) return false;
        if (A.val != B.val) return false;
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
