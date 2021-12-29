package jzoffer;

import sun.reflect.generics.tree.Tree;
import tree.TreeNode;
import java.util.Arrays;
import java.util.HashMap;

public class jzoffer_07_buildTree {
    // 数组拷贝
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder.length == 0 || inorder.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[0]);
//        for (int i = 0; i < inorder.length; i++) {
//            if (preorder[i] == inorder[0]) {
//                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
//                root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
//            }
//        }
//        return root;
//    }


    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 存放inorder的元素以及对应的下标
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return build(preorder, 0, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[pre_root]);
        int i = dic.get(preorder[pre_root]);
        // 左子树的根的索引为先序中的 根节点 + 1
        // 递归左子树的左边界为原来的中序左边界
        // 递归左子树的右边界为中序中的 根节点索引 - 1
        rootNode.left = build(preorder, pre_root + 1, in_left, i - 1);
        // 右子树的根的索引为先序中的 当前根位置 + 左子树的长度 + 1
        // 递归右子树的左边界为中序中 当前根节点 + 1
        // 递归右子树的右边界为中序中原来右子树的边界
        rootNode.right = build(preorder, i - in_left + pre_root + 1, i + 1, in_right);
        return rootNode;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3,9,2,1,7};
        int[] in = new int[]{9,3,1,2,7};
        System.out.println(new jzoffer_07_buildTree().buildTree(pre, in));
    }
}
