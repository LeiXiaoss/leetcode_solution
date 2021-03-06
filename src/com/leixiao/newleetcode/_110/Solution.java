package com.leixiao.newleetcode._110;

import com.leixiao.newleetcode.utils.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        if (Math.abs(level(root.left) - level(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int level(TreeNode node) {
        if (node == null) return 0;
        return Math.max(level(node.left), level(node.right)) + 1;
    }

    //每次记录子节点是否平衡，优化时间复杂度
    public boolean isBalanced2(TreeNode root) {
        if (maxDepth(root) == -1) return false;
        return true;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
