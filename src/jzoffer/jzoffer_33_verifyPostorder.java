package jzoffer;

import java.util.Stack;

public class jzoffer_33_verifyPostorder {
    public boolean verifyPostorderA(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }
    private boolean verify(int[] postorder, int left, int right) {
        if (left >= right) return true;
        // 后序遍历的最后一个元素是根节点，比最后一个元素大的是右子树，小的是左子树
        // 找到右子树的范围
        int mid = left;
        while (postorder[mid] < postorder[right]) {
            mid++;
        }
        // 确保右子树范围内的所有数都大于根节点
        for (int i = mid; i < right; i++) {
            if (postorder[i] <= postorder[right])
                return false;
        }
        return verify(postorder, left, mid - 1) && verify(postorder, mid, right - 1);
    }

    public boolean verifyPostorderB(int[] postorder) {
        Stack<Integer> st = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!st.isEmpty() && postorder[i] < st.peek()) {
                root = st.pop();
            }
            st.push(postorder[i]);
        }
        return true;
    }
}
